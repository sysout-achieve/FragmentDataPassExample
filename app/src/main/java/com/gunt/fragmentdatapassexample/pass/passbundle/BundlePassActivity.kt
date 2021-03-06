package com.gunt.fragmentdatapassexample.pass.passbundle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gunt.fragmentdatapassexample.R
import com.gunt.fragmentdatapassexample.pass.passvm.PassAFragment

class BundlePassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bundle_pass)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_bundle, PassBundleAFragment())
            .commit()
    }
}