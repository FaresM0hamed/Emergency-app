package com.example.emergencyapp.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.emergencyapp.R

class Information_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.information)
        val contact:CardView=findViewById(R.id.contact_us)
        val Rate:CardView=findViewById(R.id.rate_us)
        val share:CardView=findViewById(R.id.share)
        contact.setOnClickListener {
           val emailIntent =Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","faresmohamed123321@gmail.com",null))
        startActivity(Intent.createChooser(emailIntent,"Send By..."))

        }
        share.setOnClickListener {
            Toast.makeText(this, R.string.share, Toast.LENGTH_SHORT).show()


        }
        Rate.setOnClickListener {
            Toast.makeText(this, R.string.rate, Toast.LENGTH_SHORT).show()


        }
    }
}