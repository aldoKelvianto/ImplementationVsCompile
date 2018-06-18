package com.aldoapps.implementationvscompile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            // TODO: Fetch data from library
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> openGithub()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun openGithub(): Boolean {
        val url = Uri.parse("https://stackoverflow.com/a/48388463/1760984")
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = url
        startActivity(intent)
        return true
    }
}
