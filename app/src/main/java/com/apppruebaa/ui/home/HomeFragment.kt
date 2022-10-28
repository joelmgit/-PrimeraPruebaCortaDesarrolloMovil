package com.apppruebaa.ui.home

import com.apppruebaa.viewmodel.CapituloViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.apppruebaa.adapter.CapituloAdapter
import com.apppruebaa.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var capituloViewModel: CapituloViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        capituloViewModel = ViewModelProvider(this).get(CapituloViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val capituloAdapter = CapituloAdapter()
        val recycler = binding.recycler
        recycler.adapter = capituloAdapter
        recycler.layoutManager = LinearLayoutManager(requireContext())

        capituloViewModel.getCapitulos.observe(viewLifecycleOwner){
                capitulos -> capituloAdapter.setCapitulos(capitulos)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}