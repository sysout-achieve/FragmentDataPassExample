package com.gunt.fragmentdatapassexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.gunt.fragmentdatapassexample.databinding.ActivityMainBinding
import com.gunt.fragmentdatapassexample.pass.passbundle.BundlePassActivity
import com.gunt.fragmentdatapassexample.pass.passargs.NavArgsPassActivity
import com.gunt.fragmentdatapassexample.pass.passvm.ViewModelPassActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setContentView(binding.root)

        binding.btnBundle.setOnClickListener { startActivity(Intent(this, BundlePassActivity::class.java)) }
        binding.btnViewmodel.setOnClickListener { startActivity(Intent(this, ViewModelPassActivity::class.java)) }
        binding.btnArgs.setOnClickListener { startActivity(Intent(this, NavArgsPassActivity::class.java)) }
    }
}