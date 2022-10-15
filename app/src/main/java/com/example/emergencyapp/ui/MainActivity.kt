package com.example.emergencyapp.ui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.recyclerview.widget.RecyclerView
import com.example.emergencyapp.R
import com.example.emergencyapp.adapter.EmergencyAdapter
import com.example.emergencyapp.data.ElementsSource
import com.permissionx.guolindev.PermissionX
import org.intellij.lang.annotations.Language
import java.util.*
import java.util.Locale.ENGLISH


var backPressedTime = 0L


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv: RecyclerView = findViewById(R.id.rv)
        val list = ElementsSource().obtain(this)
        val adapter = EmergencyAdapter(this, list)
        rv.adapter = adapter


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.menuInformation) {
            val x = Intent(this, Information_Page::class.java)
            startActivity(x)
            true
        } else
            return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (backPressedTime + 1500 > System.currentTimeMillis()) {
            super.onBackPressed()
            return
        } else {
            Toast.makeText(this, R.string.exit, Toast.LENGTH_SHORT).show()
        }
        backPressedTime = System.currentTimeMillis()
    }

}




