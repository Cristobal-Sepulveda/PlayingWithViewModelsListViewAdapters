package com.example.playingwithviewmodelslistviewadapters.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.playingwithviewmodelslistviewadapters.R
import com.example.playingwithviewmodelslistviewadapters.databinding.FragmentItemmakerBinding
import com.example.playingwithviewmodelslistviewadapters.viewModel.SharedViewModel

class ItemMakerFragment: Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentItemmakerBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_itemmaker, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        binding.button2.setOnClickListener{

            if (binding.itemMakerUserNameEditText.text.isEmpty() ||
                binding.itemMakerUserPasswordEditText.text.isEmpty()){

                Toast.makeText(this@ItemMakerFragment.context,
                    "you must fill all boxes", Toast.LENGTH_SHORT).show()
            }else{

                viewModel.addItem(binding.itemMakerUserNameEditText.text.toString(),
                    binding.itemMakerUserPasswordEditText.text.toString())
                Log.i("test","${viewModel.listOfUsers.value}")
                it.findNavController().navigate(R.id.action_itemMakerFragment_to_listViewFragment)
            }


        }
        return binding.root
    }
}