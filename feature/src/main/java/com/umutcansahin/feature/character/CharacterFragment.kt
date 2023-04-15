package com.umutcansahin.feature.character

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.umutcansahin.common.viewBinding
import com.umutcansahin.feature.R
import com.umutcansahin.feature.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterFragment : Fragment(R.layout.fragment_character) {
    private val binding by viewBinding(FragmentCharacterBinding::bind)
    private val viewModel by viewModels<CharacterViewModel>()
    private val characterAdapter = CharacterAdapter(::itemSetClick)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    private fun initView() {
        binding.recyclerView.adapter = characterAdapter
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.allCharacter.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
                Lifecycle.State.STARTED
            ).collect {
                when (it) {
                    is CharacterUiState.Loading -> {}
                    is CharacterUiState.Error -> {}
                    is CharacterUiState.Success -> {
                        characterAdapter.submitData(it.data)
                    }
                }
            }
        }
    }

    private fun itemSetClick(characterId: Int) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(
                characterId = characterId
            )
        )
    }
}