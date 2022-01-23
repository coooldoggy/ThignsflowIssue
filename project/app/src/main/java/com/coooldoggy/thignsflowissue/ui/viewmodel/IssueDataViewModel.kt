package com.coooldoggy.thignsflowissue.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class IssueDataViewModel(application: Application): AndroidViewModel(application) {
    companion object{
        private val TAG = IssueDataViewModel::class.java.simpleName
    }
}