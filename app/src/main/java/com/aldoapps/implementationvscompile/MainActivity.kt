package com.aldoapps.implementationvscompile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.aldoapps.myandroidlibrary.MyAndroidComponent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            loadComponentToTextView()
        }
    }

    private fun loadComponentToTextView() {
        val component = MyAndroidComponent.getComponent()
        tv_result.text = component
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
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(STACK_OVERFLOW_LINK))
        startActivity(intent)
        return true
    }

    companion object {
        private const val STACK_OVERFLOW_LINK = "https://stackoverflow.com/a/48388463/1760984"
    }
}
