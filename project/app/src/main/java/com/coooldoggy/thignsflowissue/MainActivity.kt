package com.coooldoggy.thignsflowissue

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.coooldoggy.thignsflowissue.databinding.ActivityMainBinding
import com.coooldoggy.thignsflowissue.ui.viewmodel.IssueDataViewModel

class MainActivity : AppCompatActivity() {
    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }

    private var binding : ActivityMainBinding? = null
    private val issueDataViewModel by viewModels<IssueDataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        issueDataViewModel.title.value = "ThignsFlowIssue"
    }

    fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }
}