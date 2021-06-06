package com.square.repos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.square.repos.R
import com.square.repos.databinding.AdapterRepoBinding
import com.square.repos.model.Repo

class RepoAdapter internal constructor(private var repos: List<Repo>) :
    RecyclerView.Adapter<RepoAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val adapterRepoBinding: AdapterRepoBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.adapter_repo,
            parent, false
        )
        return MyViewHolder(adapterRepoBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    fun addData(repos1: List<Repo>) {
        repos = repos1
        notifyDataSetChanged()
    }

    class MyViewHolder internal constructor(
        private val adapterRepoBinding: AdapterRepoBinding,
    ) :
        RecyclerView.ViewHolder(adapterRepoBinding.itemRepo) {

        fun bind(repo: Repo) {
            if (adapterRepoBinding.repoAdapterVM == null) {
                adapterRepoBinding.repoAdapterVM = RepoAdapterVM(repo)
            } else {
                adapterRepoBinding.repoAdapterVM?.setRepo(repo)
            }
        }
    }
}