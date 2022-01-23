package com.coooldoggy.thignsflowissue.framework.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class IssueData(
    @SerializedName("id")
    val id: Long,

    @SerializedName("node_id")
    val nodeId: String? = null,

    @SerializedName("url")
    val url: String? = null,

    @SerializedName("repository_url")
    val repositoryUrl: String? = null,

    @SerializedName("timeline_url")
    val timelineUrl: String? = null,

    @SerializedName("labels_url")
    val labelsUrl: String? = null,

    @SerializedName("comments_url")
    val commentsUrl: String? = null,

    @SerializedName("events_url")
    val eventsUrl: String? = null,

    @SerializedName("html_url")
    val htmlUrl: String? = null,

    @SerializedName("number")
    val number: Int,

    @SerializedName("state")
    val state: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("body")
    val body: String? = null,

    @SerializedName("user")
    val user: UserData? = null,

    @SerializedName("labels")
    val labels: List<LabelData>? = null,

    @SerializedName("assignee")
    val assignee: UserData? = null,

    @SerializedName("assignees")
    val assignees: List<UserData>? = null,

    @SerializedName("milestone")
    val milestone: MileStoneData? = null,

    @SerializedName("locked")
    val locked: Boolean? = null,

    @SerializedName("active_lock_reason")
    val activeLockReason: String? = null,

    @SerializedName("comments")
    val comments: Int,

    @SerializedName("pull_request")
    val pullRequest: PullRequestData? = null,

    @SerializedName("closed_at")
    val closedAt: String? = null,

    @SerializedName("created_at")
    val createdAt: String? = null,

    @SerializedName("updated_at")
    val updatedAt: String? = null,

    @SerializedName("repository")
    val repository: RepositoryData? = null,

    @SerializedName("author_association")
    val authorAssociation: String? = null,

    @SerializedName("performed_via_github_app")
    val performedViaGithubApp: Boolean? = null,

    @SerializedName("draft")
    val draft: Boolean

    ) : Serializable