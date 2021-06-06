package com.square.repos

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.square.repos.adapter.RepoAdapter
import com.square.repos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var repoAdapter: RepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val mainActivityVM = ViewModelProvider(this).get(MainActivityVM::class.java)
        activityMainBinding.mainActivityVM = mainActivityVM

        setRecyclerViewRepo(activityMainBinding.rvRepo)
        mainActivityVM.loadRepos()

        mainActivityVM.repos.observe(this, {
            repoAdapter.addData(it)
        })

        mainActivityVM.errorData.observe(this, {
            Toast.makeText(
                this,
                "Something went wrong...Please try later!",
                Toast.LENGTH_SHORT
            ).show()

        })
    }

    private fun setRecyclerViewRepo(recyclerView: RecyclerView) {
        repoAdapter = RepoAdapter(ArrayList())
        recyclerView.adapter = repoAdapter
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to exit the app?")
            .setPositiveButton("Yes") { _: DialogInterface?, _: Int -> finishAffinity() }
            .setNegativeButton("No", null)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }
}