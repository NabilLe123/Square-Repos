package com.square.repos.adapter

import androidx.databinding.BaseObservable
import com.square.repos.model.Repo

class RepoAdapterVM(private var repo: Repo) : BaseObservable() {

    fun tvName(): String? {
        return repo.name
    }

    fun tvDescription(): String {
        return repo.description ?: "-nil-"
    }

    fun tvStarCount(): String {
        return repo.starCount.toString()
    }

    fun tvOpenIssues(): String {
        return repo.openIssuesCount.toString()
    }

    fun tvLanguage(): String {
        return repo.language ?: "-nil-"
    }

    fun setRepo(repo1: Repo) {
        repo = repo1
        notifyChange()
    }
}
