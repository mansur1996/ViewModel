package com.example.viewmodellivedate.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodellivedate.databinding.ItemUserBinding
import com.example.viewmodellivedate.model.User

class UserAdapter(var list: List<User>) : RecyclerView.Adapter<UserAdapter.VH>() {

    inner class VH(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun onBind(user: User){
            binding.tvName.text = "${user.name} ${user.username}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}