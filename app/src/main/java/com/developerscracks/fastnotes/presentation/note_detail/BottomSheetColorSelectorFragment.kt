package com.developerscracks.fastnotes.presentation.note_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.developerscracks.fastnotes.R
import com.developerscracks.fastnotes.databinding.FragmentBottomSheetColorSelectorBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetColorSelectorFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetColorSelectorBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomSheetColorSelectorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}