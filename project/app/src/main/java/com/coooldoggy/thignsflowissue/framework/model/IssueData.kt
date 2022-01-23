package com.coooldoggy.thignsflowissue.framework.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class IssueData(
    @SerializedName("id")
    val id: Int,

    @SerializedName("node_id")
    val nodeId: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("repository_url")
    val repositoryUrl: String,

    @SerializedName("labels_url")
    val labelsUrl: String,

    @SerializedName("comments_url")
    val commentsUrl: String,

    @SerializedName("events_url")
    val eventsUrl: String,

    @SerializedName("html_url")
    val htmlUrl: String,

    @SerializedName("number")
    val number: Int,

    @SerializedName("state")
    val state: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String,

    @SerializedName("user")
    val user: UserData,

    @SerializedName("labels")
    val labels: List<LabelData>,

    @SerializedName("assignee")
    val assignee: UserData,

    @SerializedName("assignees")
    val assignees: List<UserData>,

    @SerializedName("milestone")
    val milestone: MileStoneData,

    @SerializedName("locked")
    val locked: Boolean,

    @SerializedName("active_lock_reason")
    val activeLockReason: String,

    @SerializedName("comments")
    val comments: Int,

    @SerializedName("pull_request")
    val pullRequest: PullRequestData,

    @SerializedName("closed_at")
    val closedAt: String? = null,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("updated_at")
    val updatedAt: String,

    @SerializedName("repository")
    val repository: RepositoryData,

    @SerializedName("author_association")
    val authorAssociation: String

    ) : Serializable