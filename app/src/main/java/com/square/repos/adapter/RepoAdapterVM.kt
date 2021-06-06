package com.square.repos.adapter

import androidx.databinding.BaseObservable
import com.square.repos.model.Repo

class RepoAdapterVM(private var repo: Repo) : BaseObservable() {

    fun tvName(): String? {
        return repo.name
    }

    fun tvDescription(): String? {
        return repo.description
    }

    fun setRepo(repo1: Repo) {
        repo = repo1
        notifyChange()
    }
}
