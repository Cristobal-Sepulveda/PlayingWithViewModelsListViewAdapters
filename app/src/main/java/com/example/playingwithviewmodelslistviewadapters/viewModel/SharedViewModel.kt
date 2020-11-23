package com.example.playingwithviewmodelslistviewadapters.viewModel

import android.util.Log
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.playingwithviewmodelslistviewadapters.objects.User
lateinit var a :EditText
class SharedViewModel: ViewModel() {

    private val totalUsers = mutableListOf(User("cris","12"))
    private val _listOfUsers = MutableLiveData(totalUsers)
    val listOfUsers: LiveData<MutableList<User>>
        get()=_listOfUsers
    init{
        Log.i("test", "viewModel created")

    }

    override fun onCleared() {
        super.onCleared()
        Log.i("test", "ViewModel Destroyed")
    }
    fun addItem(userName:String, userPassword:String) {
        val user = User(userName, userPassword)
        totalUsers.add(user)
        }
}
