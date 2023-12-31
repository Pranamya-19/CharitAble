package com.example.charitable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class HistoryFragment_donor : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history_donor, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HistoryFragment_donor().apply {
                arguments = Bundle().apply {}
                }
            }
    }
