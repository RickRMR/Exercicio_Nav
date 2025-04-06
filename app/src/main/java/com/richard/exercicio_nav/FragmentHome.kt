package com.richard.exercicio_nav

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.richard.exercicio_nav.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("LifeCycle","onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        editText = binding.editTextText2
        if (savedInstanceState?.containsKey("editTextValue")== true){
            val value = savedInstanceState.getString("editTextValue")
            editText.setText(value)
        }

        Log.d("LifeCycle","onCreateView")

        binding.StartActivityButton.setOnClickListener {
            val action = FragmentHomeDirections.actionFragmentHomeToNavGame()
            findNavController().navigate(action)
        }

        lifecycle.addObserver(CustomObserver())
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("editTextValue", editText.text.toString())
    }

    override fun onResume() {
        super.onResume()

        Log.d("LifeCycle","onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle","onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("LifeCycle","onDetach")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("LifeCycle","onAttach")
    }
}


