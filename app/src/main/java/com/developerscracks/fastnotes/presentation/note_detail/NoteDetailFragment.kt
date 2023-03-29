package com.developerscracks.fastnotes.presentation.note_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.developerscracks.fastnotes.R
import com.developerscracks.fastnotes.databinding.FragmentNoteDetailBinding
import com.developerscracks.fastnotes.databinding.FragmentNoteListBinding
import com.developerscracks.fastnotes.presentation.note_list.NoteListViewModel
import com.developerscracks.fastnotes.presentation.utils.showKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class NoteDetailFragment : Fragment() {

    private var _binding: FragmentNoteDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NoteDetailViewModel by navGraphViewModels(R.id.note_detail_graph) {
        defaultViewModelProviderFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editTextNoteContent.showKeyboard()

        binding.ivNoteColor.setOnClickListener {
            val action =
                NoteDetailFragmentDirections.actionNoteDetailFragmentToBottomSheetColorSelectorFragment()
            findNavController().navigate(action)
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.selectedColor.collect { selectedColor ->
                binding.noteContainer.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        selectedColor
                    )
                )

                binding.lyBottomTools.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        selectedColor
                    )
                )

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}