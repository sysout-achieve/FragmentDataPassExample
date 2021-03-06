package com.gunt.fragmentdatapassexample.pass.passbundle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.gunt.fragmentdatapassexample.R
import com.gunt.fragmentdatapassexample.databinding.FragmentPassBBinding

class PassBundleBFragment : Fragment() {
    private lateinit var binding: FragmentPassBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_pass_b, container, false)
        binding.lifecycleOwner = this

        setFragmentResultListener("fromA") { requestKey, bundle ->
            val result = bundle.getString("passed")
            binding.textView.text = result
        }

        binding.btnSend.setOnClickListener {
            val result = binding.etText.text.toString()
            setFragmentResult("fromB", bundleOf("passed" to result))
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_bundle, PassBundleAFragment())
                .commit()

        }

        return binding.root
    }

}