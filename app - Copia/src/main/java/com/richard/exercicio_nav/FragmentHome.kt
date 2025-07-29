package com.richard.exercicio_nav

import android.content.Context
import android.os.Bundle
import android.provider.DocumentsContract.Root
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.richard.exercicio_nav.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.StartActivityButton.setOnClickListener {
            val action = FragmentHomeDirections.actionFragmentHomeToNavGame()
            findNavController().navigate(action)
        }
        return binding.root
    }
}
