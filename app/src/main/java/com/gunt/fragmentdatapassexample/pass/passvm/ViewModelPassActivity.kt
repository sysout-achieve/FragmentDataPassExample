package com.gunt.fragmentdatapassexample.pass.passvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.gunt.fragmentdatapassexample.BR
import com.gunt.fragmentdatapassexample.R
import com.gunt.fragmentdatapassexample.databinding.ActivityViewModelPassBinding

class ViewModelPassActivity : AppCompatActivity() {

    private val viewModel : PassingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityViewModelPassBinding>(this, R.layout.activity_view_model_pass)
        setContentView(binding.root)
        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()
        binding.lifecycleOwner = this

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, PassAFragment())
            .commit()
    }


}
