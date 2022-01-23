package com.coooldoggy.thignsflowissue.framework.api

import com.coooldoggy.thignsflowissue.framework.model.IssueData
import retrofit2.Response

object ApiManager {
    private val TAG = ApiManager::class.java.simpleName
    private val githubIssueService by lazy { GithubIssueService.createService(GithubIssueService::class.java) }

    suspend fun queryIssues(owner: String, org: String): Response<IssueData>{
        return githubIssueService.queryIssues(owner = owner, org= org)
    }

}