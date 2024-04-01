package com.example.di_recyclerview.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.di_recyclerview.callback.CallbackType
import com.example.di_recyclerview.callback.RootCallback
import com.example.di_recyclerview.data.model.User
import com.example.di_recyclerview.databinding.AdapterItemUserBinding
import com.example.di_recyclerview.utils.GlideUtils

class UserListAdapter(
    private val users: ArrayList<User>?
) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val binding =
            AdapterItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        users?.get(position)?.let { holder.bind(it, position) }
    }

    override fun getItemCount(): Int {
        return users?.size ?: 0
    }


    inner class ViewHolder(private val binding: AdapterItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("RestrictedApi")
        fun bind(data: User, position: Int) {


            with(binding){
                GlideUtils.loadImage(imageViewAvatar, data.avatar)
                tvUserName.text = data.name.orEmpty()
                textViewUserEmail.text = data.email.orEmpty()
                clUserList.setOnClickListener {
                    callback?.onRootCallback(
                        position,
                        data,
                        CallbackType.SELECT_USER
                    )

                }
            }



        }
    }

    private var callback: RootCallback<Any>? = null
    fun setCallback(callback: RootCallback<Any>?) {
        this.callback = callback
    }

    fun addData(list: List<User>) {
        users?.addAll(list)
    }
}