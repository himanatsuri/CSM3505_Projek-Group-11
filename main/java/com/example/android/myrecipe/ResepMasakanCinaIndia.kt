package com.example.android.myrecipe

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ResepMasakanCinaIndia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resep_masakan_cina_india)

        //  set screen layout to PORTRAIT
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        //  add Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val recyclerView = findViewById<RecyclerView>(R.id.rv_resep)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        //  insert Item RecyclerView
        recyclerView.adapter = ResepAdapter(this, KumpulanResep.resepMasakanCinaIndia){
            //  move page by bring Intent to Resep when clicked
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