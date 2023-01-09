package com.example.android.networkconnect.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.networkconnect.data.RickAndMortyModels
import com.example.android.networkconnect.databinding.CharactersFragmentBinding
import com.example.android.networkconnect.presentation.adapters.CharacterListAdapter

class CharactersListFragment(
    private val models: RickAndMortyModels
) : Fragment() {

    private lateinit var binding: CharactersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CharactersFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.characterListRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = CharacterListAdapter(models)
        }
    }
}
