package com.example.android.myrecipe

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial

class HomeActivity : AppCompatActivity() {

    //  INTENT_PARCELABLE
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //  set screen layout to PORTRAIT
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        //  Dark Mode use Switch
        val switchMaterial = findViewById<SwitchMaterial>(R.id.switchMode)
        switchMaterial.setOnCheckedChangeListener { buttonView, isChacked ->
            if (isChacked)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        //  change page
        var buttonJabar = findViewById<Button>(R.id.masakanTradisional)
        buttonJabar.setOnClickListener() {
            val intent = Intent(this, ResepMakananTradisional::class.java)
            startActivity(intent);
        }

        //  change page
        var buttonJateng = findViewById<Button>(R.id.kuihTradisional)
        buttonJateng.setOnClickListener() {
            val intent = Intent(this, ResepKuihTradisional::class.java)
            startActivity(intent);
        }

        //  change page
        var buttonJatim = findViewById<Button>(R.id.masakanCinaIndia)
        buttonJatim.setOnClickListener() {
            val intent = Intent(this, ResepMasakanCinaIndia::class.java)
            startActivity(intent);
        }
    }
}