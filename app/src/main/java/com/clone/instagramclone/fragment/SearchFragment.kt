package com.clone.instagramclone.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.clone.instagramclone.R
import com.clone.instagramclone.adapter.SearchAdapter
import com.clone.instagramclone.model.User

/**
 * In Search Fragment, all registered users can be found by searching keyboard and followed
 */

class SearchFragment : BaseFragment() {
    val TAG = SearchFragment::class.java.simpleName
    lateinit var rv_search: RecyclerView
    var items = ArrayList<User>()
    var users = ArrayList<User>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        rv_search = view.findViewById(R.id.rv_search)
        rv_search.layoutManager = GridLayoutManager(activity, 1)
        val et_search = view.findViewById<EditText>(R.id.et_search)
        et_search.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val keyboard = s.toString().trim()
                usersByKeyboard(keyboard)
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        loadUsers()
        refreshAdapter(items)
    }

    private fun refreshAdapter(items: ArrayList<User>){
        val adapter = SearchAdapter(this, items)
        rv_search.adapter =  adapter
    }

    fun usersByKeyboard(keyboard: String){
        if (keyboard.isEmpty())
            refreshAdapter(items)

        users.clear()
        for (user in items)
            if (user.fullname.toLowerCase().startsWith(keyboard.toLowerCase()))
                users.add(user)

        refreshAdapter(users)
    }

    private fun loadUsers(): ArrayList<User>{
        items = ArrayList()
        items.add(User("xurshid", "shamsun.com@gmail.com"))
        items.add(User("begzod", "shamsun.com@gmail.com"))
        items.add(User("sherzod", "shamsun.com@gmail.com"))
        items.add(User("firdavs", "shamsun.com@gmail.com"))
        items.add(User("xurshid", "shamsun.com@gmail.com"))
        items.add(User("begzod", "shamsun.com@gmail.com"))
        items.add(User("sherzod", "shamsun.com@gmail.com"))
        items.add(User("firdavs", "shamsun.com@gmail.com"))
        return items
    }

}