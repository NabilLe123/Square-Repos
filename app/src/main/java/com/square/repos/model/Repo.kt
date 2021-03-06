package com.square.repos.model

import com.google.gson.annotations.SerializedName


class Repo {
    @SerializedName("id")
    val id: Int? = null

    @SerializedName("name")
    val name: String? = null

    @SerializedName("full_name")
    val fullName: String? = null

    @SerializedName("private")
    val privateOrNot: Boolean? = null

    @SerializedName("html_url")
    val htmlUrl: String? = null

    @SerializedName("description")
    val description: String? = null

    @SerializedName("language")
    val language: String? = null

    @SerializedName("stargazers_count")
    val starCount: Int? = null

    @SerializedName("open_issues_count")
    val openIssuesCount: Int? = null
}