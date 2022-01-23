package com.coooldoggy.thignsflowissue.framework.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LabelData(
    @SerializedName("id")
    val id: Int,

    @SerializedName("node_id")
    val nodeId: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("color")
    val color: String,

    @SerializedName("default")
    val default: Boolean
):Serializable
