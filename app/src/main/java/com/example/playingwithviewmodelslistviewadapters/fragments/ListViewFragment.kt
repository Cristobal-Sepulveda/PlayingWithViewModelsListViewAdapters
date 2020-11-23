package com.example.playingwithviewmodelslistviewadapters.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.playingwithviewmodelslistviewadapters.Adapter
import com.example.playingwithviewmodelslistviewadapters.R
import com.example.playingwithviewmodelslistviewadapters.databinding.FragmentListviewBinding
import com.example.playingwithviewmodelslistviewadapters.objects.User
import com.example.playingwithviewmodelslistviewadapters.viewModel.SharedViewModel

class ListViewFragment: Fragment() {

    private lateinit var viewModel: SharedViewModel
    lateinit var listOfView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentListviewBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_listview, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        binding.lifecycleOwner = requireActivity()

        Log.i("test", viewModel.listOfUsers.value.toString())

        viewModel.listOfUsers.observe(viewLifecycleOwner, Observer {

            listOfView = binding.pruebaListView
            val listItems = arrayOfNulls<User>(it.size)
            for (i in it.indices) {
                val shoe = it[i]
                listItems[i] = shoe
            }
            val adapter = this@ListViewFragment.context?.let { it1 -> Adapter(it1, listItems) }
            listOfView.adapter = adapter
        })

        binding.button1.setOnClickListener{
            it.findNavController().navigate(R.id.action_listViewFragment_to_itemMakerFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        Log.i("test", "fragmento destruido")
        super.onDestroyView()
    }
}

/*
var listData = arrayListOf<String>()

var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listData)
listView.adapter = adapter*/
