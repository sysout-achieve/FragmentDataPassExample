package com.gunt.fragmentdatapassexample.pass.passargs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.gunt.fragmentdatapassexample.R
import com.gunt.fragmentdatapassexample.databinding.FragmentPassBBinding

class PassArgsBFragment : Fragment() {
    private lateinit var binding: FragmentPassBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_pass_b, container, false)
        binding.lifecycleOwner = this

        val args: PassArgsBFragmentArgs by navArgs()
        binding.textView.text = args.argsString

        binding.btnSend.setOnClickListener {
            val action = PassArgsBFragmentDirections.passBToA(binding.etText.text.toString())
            findNavController().navigate(action)
        }

        return binding.root
    }
}