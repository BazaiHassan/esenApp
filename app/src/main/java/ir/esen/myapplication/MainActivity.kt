package ir.esen.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ir.esen.myapplication.animations.AnimationFragment
import ir.esen.myapplication.profile.LoginFragment
import ir.esen.myapplication.profile.ProfileFragment
import ir.esen.myapplication.videoStory.VideoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragments(VideoFragment())

        bottom_navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.video -> replaceFragments(VideoFragment())
                R.id.audio -> replaceFragments((AnimationFragment()))
                R.id.profile -> replaceFragments((LoginFragment()))
            }
            true
        }

    }


    private fun replaceFragments(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commit()
    }

}