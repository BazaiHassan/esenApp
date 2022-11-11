package ir.esen.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.WindowInsets
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.awesomedialog.*
import ir.esen.myapplication.R
import ir.esen.myapplication.databinding.ActivityFullscreenBinding
import ir.esen.myapplication.utils.Constants

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class FullscreenActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen)
        if (isOnline(this)){
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            },Constants.SPLASH_TIME)
        }else{

            AwesomeDialog.build(this)
                .title(
                    "اشکال در شبکه",
                    titleColor = ContextCompat.getColor(this, R.color.myRed)
                )
                .body(
                    "لطفا از اتصال داشتن اینترنت خود مطمئن شوید و دوباره تلاش کنید.",
                    color = ContextCompat.getColor(this, R.color.myRed)
                )
                .icon(R.drawable.ic_wifi_off)
                .background(R.color.white)
        }

    }


    // Check internet connection
    @RequiresApi(Build.VERSION_CODES.M)
    private fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {

                return true
            }
        }
        return false
    }

}