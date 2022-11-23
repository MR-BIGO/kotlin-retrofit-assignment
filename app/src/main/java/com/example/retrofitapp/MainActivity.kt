package com.example.retrofitapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.repository.RetrofitInstance



class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lifecycleScope.launchWhenCreated {
            val response = RetrofitInstance.retrofit.getData()
            if (response.isSuccessful && response.body() != null){
                recyclerView = findViewById(R.id.mainRV)
                adapter = UserAdapter(response.body()!!.data)
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.adapter = adapter

                adapter.onItemClick = {
                    val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                    intent.putExtra("id", it.id)
                    startActivity(intent)
                }
            }


        }





    }
}