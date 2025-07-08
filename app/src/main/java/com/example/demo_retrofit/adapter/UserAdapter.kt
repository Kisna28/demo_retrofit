package com.example.demo_retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo_retrofit.databinding.ItemUserBinding
import com.example.demo_retrofit.model.User
import com.squareup.picasso.Picasso

class UserAdapter(private val users: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    inner class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        val user = users[position]
        holder.binding.userName.text = user.firstName
        Picasso.get().load(user.image).into(holder.binding.userImage)
    }

    override fun getItemCount() = users.size

}