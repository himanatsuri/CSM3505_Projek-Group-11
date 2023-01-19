package com.example.android.myrecipe

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ResepKuihTradisional : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resep_kuih_tradisional)

        //  set screen layout to PORTRAIT
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        //  tambah Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val recyclerView = findViewById<RecyclerView>(R.id.rv_resep)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        //  insert Item RecyclerView
        recyclerView.adapter = ResepAdapter(this, KumpulanResep.resepKuihTradisional){
            //  move page with Intent Resep by click it
            val intent = Intent (this, DetailResepActivity::class.java)
            intent.putExtra(HomeActivity.INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }

    //  function back to previous page
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}