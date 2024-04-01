package com.example.di_recyclerview.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.di_recyclerview.callback.RootCallback
import com.example.di_recyclerview.data.model.User
import com.example.di_recyclerview.databinding.ActivityMainBinding
import com.example.di_recyclerview.ui.adapter.UserListAdapter
import com.example.di_recyclerview.ui.viewmodel.MainViewModel
import com.example.di_recyclerview.utils.Status
import com.example.di_recyclerview.utils.toastError
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() , RootCallback<Any> {

    private val mainViewModel : MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        setupObserver()
    }

    private fun setupUI() {

        adapter = UserListAdapter(arrayListOf())
        binding.rvUserList.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.users.observe(this) {
            with(binding) {
                when (it.status) {
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        it.data?.let {
                                users -> renderList(users)
                        }
                        rvUserList.visibility = View.VISIBLE
                    }

                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        rvUserList.visibility = View.GONE
                    }

                    Status.ERROR -> {
                        //Handle Error
                        progressBar.visibility = View.GONE
                        toastError(it.message.toString())
                    }
                }
            }

        }
    }
    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }
}