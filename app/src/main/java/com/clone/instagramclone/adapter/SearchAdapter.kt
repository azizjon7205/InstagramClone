package com.clone.instagramclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.clone.instagramclone.R
import com.clone.instagramclone.fragment.SearchFragment
import com.clone.instagramclone.model.User
import com.google.android.material.imageview.ShapeableImageView

class SearchAdapter(var fragment: SearchFragment, var items: ArrayList<User>): BaseAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_search, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = items[position]
        if (holder is UserViewHolder){
            holder.tv_fullname.text = user.fullname
            holder.tv_email.text = user.email
            Glide.with(fragment).load(user.userImg).placeholder(R.drawable.ic_person).error(R.drawable.ic_person).into(holder.iv_profile)
        }
    }

    override fun getItemCount() = items.size

    inner class UserViewHolder(var view: View): RecyclerView.ViewHolder(view){
        var iv_profile: ShapeableImageView
        var tv_fullname: TextView
        var tv_email: TextView
        var tv_follow: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
            tv_email = view.findViewById(R.id.tv_email)
            tv_follow = view.findViewById(R.id.tv_follow)
        }
    }
}