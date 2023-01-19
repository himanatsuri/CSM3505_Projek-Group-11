package com.example.android.myrecipe

import android.content.pm.ActivityInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class fullscreenYoutubeActivity : AppCompatActivity() {

    companion object{
        const val youtubeId = "ApXoWvfEYVU"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen_youtube)

        //  hide Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //  set screen layout kpd LANDSCAPE
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

        //  Variabel utk menampung Intent send melalui object INTENT_PARCELABLE
        val idVideo = intent.getStringExtra(youtubeId)

        //  initialize ID youtube_player_view
        val youTubePlayerView = findViewById<YouTubePlayerView>(R.id.youtube_player_view)
        // tambah object ID youtube_player_view ke lifecycle
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {

            //  tambah ID Video Youtube ke object video youtube
            override fun onReady(youTubePlayer: YouTubePlayer) {
                if (idVideo != null) {
                    youTubePlayer.cueVideo(idVideo,0f)
                }
                //  view video to Fullscreen
                youTubePlayerView.enterFullScreen();
            }
        })

        // set color System Navigation Bottom to BLACK
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black))
        }
    }
}