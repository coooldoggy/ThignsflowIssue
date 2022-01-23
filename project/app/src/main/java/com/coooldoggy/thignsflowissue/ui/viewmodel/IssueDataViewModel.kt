package com.coooldoggy.thignsflowissue.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class IssueDataViewModel(application: Application): AndroidViewModel(application) {
    companion object{
        private val TAG = IssueDataViewModel::class.java.simpleName
    }

    val profileImg = MutableLiveData("")
    val userName = MutableLiveData("")
    val body = MutableLiveData("")
    val title = MutableLiveData("")


    fun setData(profileImg: String, userName: String, body: String){
        this.profileImg.value = profileImg
        this.userName.value = userName
        this.body.value = body
    }
}