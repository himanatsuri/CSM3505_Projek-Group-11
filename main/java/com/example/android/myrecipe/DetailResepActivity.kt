package com.example.android.myrecipe

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class DetailResepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_resep)

        // tambah Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //  set screen display PORTRAIT
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        //  Variabel menampung Intent hantar melalui object INTENT_PARCELABLE
        val resep = intent.getParcelableExtra<Resep>(HomeActivity.INTENT_PARCELABLE)

        //  Initialization ID pada file activity_detail_resep.xml
        val gambarMasakan = findViewById<ImageView>(R.id._imageDetail)
        val namaMasakan = findViewById<TextView>(R.id._imageTitle)
        val asalDaerah = findViewById<TextView>(R.id._foodFrom)
        val deskripsiMasakan = findViewById<TextView>(R.id._descRecipe)
        val bahanMasakan = findViewById<TextView>(R.id._ingredients)
        val langkahPembuatan = findViewById<TextView>(R.id._how_to_make)

        //  Masukkan data object ke id pada widget
        gambarMasakan.setImageResource(resep?.gambarMasakan!!)
        namaMasakan.text = resep.namaMasakan
        asalDaerah.text = resep.asalDaerah
        deskripsiMasakan.text = resep.deskripsiMasakan
        bahanMasakan.text = resep.bahanMasakan
        langkahPembuatan.text = resep.langkahPembuatan
        val videoId = resep.videoId

        // tambah Title Action Bar
        supportActionBar?.title = "Detail Resepi " + resep.namaMasakan

        // initialization ID youtube_player_view
        val youTubePlayerView = findViewById<YouTubePlayerView>(R.id.youtube_player_view)

        // tambah object ID youtube_player_view ke lifecycle
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {

            //  tambah ID Video Youtube ke object video youtube
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = resep.videoId
                if (videoId != null) {
                    youTubePlayer.cueVideo(videoId,0f)
                }
            }
        })

        //  move activity dengan membawa Intent ID Video Youtube utk set Video Fullscreen
        var fullscreen_button = findViewById<Button>(R.id.fullscreen_button)
        fullscreen_button.setOnClickListener() {
            val intent = Intent(this, fullscreenYoutubeActivity::class.java)
            intent.putExtra(fullscreenYoutubeActivity.youtubeId, videoId)
            startActivity(intent);
        }
    }

    //  fucntion back kpd halaman sebelum
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}