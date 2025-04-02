package com.richard.exercicio_nav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


