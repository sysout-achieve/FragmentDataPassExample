package com.gunt.fragmentdatapassexample.pass.passbundle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.gunt.fragmentdatapassexample.R
import com.gunt.fragmentdatapassexample.databinding.FragmentPassABinding


class PassBundleAFragment : Fragment() {
    private lateinit var binding: FragmentPassABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_pass_a, container, false)
        binding.lifecycleOwner = this

        setFragmentResultListener("fromB") { requestKey, bundle ->
            val result = bundle.getString("passed")
            binding.textView.text = result
        }

        binding.btnSend.setOnClickListener {
            val result = binding.etText.text.toString()
            setFragmentResult("fromA", bundleOf("passed" to result))
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_bundle, PassBundleBFragment())
                .commit()
        }

        return binding.root
    }
}
//        val bundle = Bundle()
//        bundle.putString("key", "value")
//
//        PassBundleBFragment().arguments = bundle
//        parentFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container_bundle, PassBundleBFragment())
//            .commit()
//
//        var result = arguments?.getString("key")
