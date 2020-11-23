package com.example.playingwithviewmodelslistviewadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.playingwithviewmodelslistviewadapters.objects.User

class Adapter(private val context: Context, private val dataSource: Array<User?>): BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource!!.size
    }

    override fun getItem(position: Int): User? {
        return dataSource!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.user_item, parent, false)
        val userName = rowView.findViewById<TextView>(R.id.userItemUserName_TextView)
        val userPassword = rowView.findViewById<TextView>(R.id.userItemUserPassword_TextView)

        val user = getItem(position) as User
        userName.text = user.userName
        userPassword.text = user.userPassword

        return rowView
    }
}