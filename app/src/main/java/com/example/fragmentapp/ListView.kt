package com.example.fragmentapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_list_view.*


class ListView :Fragment() {
    var description = arrayListOf<String>("Description for button 1","Description for button 2","Description for button 3")

    private val viewModel: ViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDtail1.setOnClickListener {
            viewModel.selectItem(description[0])
        }
        showDtail2.setOnClickListener {
            viewModel.selectItem(description[1])
        }

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return LayoutInflater.from(container?.context).inflate(R.layout.fragment_list_view, container, false)
    }



}