package com.umutcansahin.feature.character

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.umutcansahin.feature.base.BaseFragment
import com.umutcansahin.feature.databinding.FragmentCharacterBinding
import com.umutcansahin.feature.util.collectFlow
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment :
    BaseFragment<FragmentCharacterBinding>(FragmentCharacterBinding::inflate) {

    private val viewModel by viewModels<CharacterViewModel>()
    private val characterAdapter = CharacterAdapter(::itemSetClick)

    override fun initView() {
        binding.recyclerView.adapter = characterAdapter

        characterAdapter.addLoadStateListener {
            binding.recyclerView.isVisible = it.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = it.refresh is LoadState.Loading
            binding.buttonRetry.isVisible = it.refresh is LoadState.Error
        }
        binding.buttonRetry.setOnClickListener {
            characterAdapter.retry()
        }
    }

    override fun observeData() {
        this.collectFlow(viewModel.allCharacter) {
            characterAdapter.submitData(it)
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