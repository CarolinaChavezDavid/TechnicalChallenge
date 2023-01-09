package com.example.android.networkconnect.presentation.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.android.networkconnect.R
import com.example.android.networkconnect.data.RickAndMortyModels
import com.example.android.networkconnect.databinding.CharacterActivityBinding
import com.example.android.networkconnect.presentation.viewmodel.RickAndMortyViewModel

class CharacterActivity : AppCompatActivity() {

    companion object {
        const val TAG_CHARACTERS_LIST_FRAGMENT = "CharactersListFragment"
    }

    private lateinit var binding: CharacterActivityBinding
    private val viewModel: RickAndMortyViewModel by lazy {
        ViewModelProvider(this)[RickAndMortyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CharacterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
    }

    private fun goToCharacterListFragment(rickAndMortyModels: RickAndMortyModels) {
        supportFragmentManager.beginTransaction().add(
            R.id.fragmentContainerLinearLayout,
            CharactersListFragment(rickAndMortyModels),
            TAG_CHARACTERS_LIST_FRAGMENT
        ).addToBackStack(
            TAG_CHARACTERS_LIST_FRAGMENT
        ).commit()
    }

    private fun getFetchData() {
        viewModel.loadInfo()
        updateToolbar()
        viewModel.charactersLiveData.observe(this) { response ->
            if (response == null) {
                Toast.makeText(
                    this,
                    resources.getString(R.string.network_error),
                    Toast.LENGTH_SHORT
                ).show()
                return@observe
            }

            goToCharacterListFragment(response)
        }
    }

    private fun setToolbar() {
        binding.materialToolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.fetch_action -> {
                    getFetchData()
                    true
                }

                else -> {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.clear_toast),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    true
                }
            }
        }
    }

    private fun updateToolbar() {
        val toolbar = binding.materialToolbar
        toolbar.menu.clear()
        toolbar.title = resources.getString(R.string.fragment_title)
    }
}
