package com.gunt.fragmentdatapassexample.pass.passvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.gunt.fragmentdatapassexample.R
import com.gunt.fragmentdatapassexample.databinding.FragmentPassBBinding

class PassBFragment : Fragment() {
    private lateinit var binding: FragmentPassBBinding
    private val viewModel: PassingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_pass_b, container, false)

        binding.lifecycleOwner = this
        binding.textView.text = viewModel.passDataB

        binding.btnSend.setOnClickListener {
            viewModel.passDataA = binding.etText.text.toString()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PassAFragment())
                .commit()
        }

        return binding.root
    }

}