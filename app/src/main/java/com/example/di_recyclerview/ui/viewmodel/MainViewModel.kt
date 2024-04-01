package com.example.di_recyclerview.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.di_recyclerview.data.model.User
import com.example.di_recyclerview.data.repository.MainRepository
import com.example.di_recyclerview.utils.NetworkHelper
import com.example.di_recyclerview.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>>
        get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                try {
                    mainRepository.getUsers().let {
                        if (it.isSuccessful) {
                            _users.value = Resource.success(it.body())
                        } else {
                            _users.value = Resource.error(it.errorBody().toString(), null)
                        }
                    }
                } catch (e: Exception) {
                    Log.i("Exception", "fetchUsers: ${e.message}")
                }
            } else{
                _users.value = Resource.error("No internet connection", null)
            }
        }
    }
}