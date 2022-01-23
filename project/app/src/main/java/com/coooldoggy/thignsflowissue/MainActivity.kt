package com.coooldoggy.thignsflowissue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.coooldoggy.thignsflowissue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }

    private var binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val innerBinding = ActivityMainBinding.inflate(layoutInflater)
        binding = innerBinding
        setContentView(innerBinding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(innerBinding.navHostFragment.id) as? NavHostFragment
    }
}