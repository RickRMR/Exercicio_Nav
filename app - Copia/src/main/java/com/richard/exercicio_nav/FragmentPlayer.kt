package com.richard.exercicio_nav

import android.content.Context
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.richard.exercicio_nav.databinding.FragmentPlayerBinding

class  FragmentPlayer: Fragment()  {
    lateinit var root: View
    lateinit var selectPlay: Spinner
    private lateinit var onItemSelectedListener: AdapterView.OnItemSelectedListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onItemSelectedListener = context as AdapterView.OnItemSelectedListener
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPlayerBinding.inflate(inflater, container, false)
        root = binding.root
        selectPlay = binding.spinner

        setupSelectPlaySpinner()
        setHasOptionsMenu(true)

        return root
    }

    private fun setupSelectPlaySpinner(){
        val adapter =
            ArrayAdapter.createFromResource(
            requireContext(),
            R.array.available_plays_array,
            android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        selectPlay.adapter = adapter
        selectPlay.onItemSelectedListener= onItemSelectedListener

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.second_screen_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController())
    }
}
