package ir.esen.myapplication.videoStory


import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.annotation.RequiresApi
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import ir.esen.myapplication.R
import kotlinx.android.synthetic.main.activity_video_player.*


class VideoPlayerActivity : AppCompatActivity(), Player.Listener {

    var player: ExoPlayer? = null
    var isPipMode: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        hideSystemUi()

        exo_player.setOnClickListener {
            Handler().postDelayed({
                hideSystemUi()
            }, 2000)
        }

    }

    override fun onStart() {
        super.onStart()
        initializePlayer()
    }

    override fun onStop() {
        super.onStop()
        player?.release()
    }

    override fun onResume() {
        super.onResume()
        if (player!!.isPlaying) {
            isPipMode = false
        }
    }


    private fun initializePlayer() {
        player = ExoPlayer.Builder(applicationContext).build()
        exo_player.player = player
        exo_player.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
        val mediaItem: MediaItem = MediaItem.fromUri(intent.getStringExtra("videoLink").toString())
        player!!.setMediaItem(mediaItem)
        player!!.prepare()
        player!!.play()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBackPressed() {

        if (!isPipMode!!) {
            enterPictureInPictureMode()
            isPipMode = true
        } else {
            super.onBackPressed()
        }

    }

    private fun hideSystemUi() {
        window.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE
        )
    }


}