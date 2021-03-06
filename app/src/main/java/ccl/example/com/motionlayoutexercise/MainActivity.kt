package ccl.example.com.motionlayoutexercise

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var fragment : Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            fragment = BaseMotionFragment.newInstance().also {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, it)
                    .commitNow()
            }
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.nav_base -> {
                // Handle the camera action
                fragment = BaseMotionFragment.newInstance()
            }
            R.id.nav_custom_attr -> {
                fragment = CustomAttributeFragment.newInstance()
            }
            R.id.nav_key_position -> {
                fragment = KeyPositionFragment.newInstance()
            }
            R.id.nav_key_attr -> {
                fragment = KeyAttributeFragment.newInstance()
            }
            R.id.nav_key_cycle -> {
                fragment = KeyCycleFragment.newInstance()
            }
            R.id.nav_coordinator -> {
                fragment = CoordinatorLayoutFragment.newInstance()
            }
            R.id.nav_drawer -> {
                val intent = Intent(this, DrawerActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_view_pager -> {
                fragment = ViewPagerFragment.newInstance()
            }
            R.id.nav_lottie -> {
                fragment = LottieFragment.newInstance()
            }
            R.id.nav_image_change -> {
                fragment = ReplaceImageFragment.newInstance()
            }
        }
        if (item.itemId != R.id.nav_drawer) {
            transaction.replace(R.id.container, fragment).commitAllowingStateLoss()
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
