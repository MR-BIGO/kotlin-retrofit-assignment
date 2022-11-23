package com.example.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.retrofitapp.repository.RetrofitInstance

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val id = intent.getIntExtra("id", 1)
        val firstNameTV: TextView = findViewById(R.id.detailsFirstNameTV)
        val lastNameTV: TextView = findViewById(R.id.detailsLastNameTV)
        val emailTV: TextView = findViewById(R.id.detailsEmailTV)
        val idTV: TextView = findViewById(R.id.detailsIdTV)
        val img: ImageView = findViewById(R.id.detailsImageView)



        lifecycleScope.launchWhenCreated {
            val response = RetrofitInstance.retrofit.getUser(id)
            if (response.isSuccessful && response.body() != null){
                firstNameTV.text = response.body()!!.data.firstName
                lastNameTV.text = response.body()!!.data.lastName
                emailTV.text = response.body()!!.data.email
                idTV.text = response.body()!!.data.id.toString()
                Glide.with(this@DetailsActivity).load(response.body()!!.data.img).into(img)
            }
        }

    }
}