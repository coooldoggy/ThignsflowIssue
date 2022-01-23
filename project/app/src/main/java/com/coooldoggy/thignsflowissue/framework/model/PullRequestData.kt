package com.coooldoggy.thignsflowissue.framework.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PullRequestData(
    @SerializedName("url")
    val url: String,

    @SerializedName("html_url")
    val htmlUrl: String,

    @SerializedName("diff_url")
    val diffUrl: String,

    @SerializedName("patch_url")
    val patchUrl: String,
):Serializable
