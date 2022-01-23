package com.coooldoggy.thignsflowissue.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.coooldoggy.thignsflowissue.framework.api.ApiManager
import com.coooldoggy.thignsflowissue.framework.model.IssueData
import com.coooldoggy.thignsflowissue.ui.adapter.MainIssueAdapter
import kotlinx.coroutines.launch

class MainIssueViewModel(application: Application) :AndroidViewModel(application) {
    private val TAG = MainIssueViewModel::class.java.simpleName
    val issueAdapter by lazy { MainIssueAdapter() }
    val ownerName = MutableLiveData("google")
    val slash = MutableLiveData("/")
    val repoName = MutableLiveData("dagger")
    val issueList = MutableLiveData<List<IssueData>>()

    init {
        getIssues()
    }

    private fun getIssues(){
        viewModelScope.launch {
            ApiManager.queryIssues(owner = "google", org = "dagger").let { response ->
                Log.d(TAG, "issueData $response")
                if (response.isSuccessful){
                    response.body()?.let {
                        issueList.value = it
                    }
                }
            }
        }
    }

}