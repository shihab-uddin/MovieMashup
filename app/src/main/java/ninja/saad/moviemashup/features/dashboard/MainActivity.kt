package ninja.saad.moviemashup.features.dashboard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.multidex.MultiDex
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.facebook.common.activitylistener.BaseActivityListener
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import ninja.saad.moviemashup.di.*
import ninja.saad.moviemashup.util.Navigator
import kotlinx.android.synthetic.main.activity_main.*
import ninja.saad.moviemashup.App
import ninja.saad.moviemashup.R
import ninja.saad.moviemashup.core.BaseActivity
import ninja.saad.moviemashup.databinding.FragmentMainBinding
import ninja.saad.moviemashup.features.discover.DiscoverMoviesActivity
import ninja.saad.moviemashup.features.discover.MovieListAdapter
import ninja.saad.moviemashup.features.discover.MovieListViewModel
import ninja.saad.moviemashup.util.Constant
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity(), GridRecyclerAdapter.RecyclerAdapterOnClickHandler {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MultiDex.install(this)

        setContentView(R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
            WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED)
        initViews()
        /*val sectionsPagerAdapter =
            SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)*/
        /*val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
    }
    private fun initViews() {

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = "Movie Mashup"
        setupRecyclerCardGrid()
    }

    private fun setupRecyclerCardGrid() {
        val mainView = findViewById<RecyclerView>(R.id.dashboard_rv)
        mainView.setHasFixedSize(true)
        mainView.layoutManager = GridLayoutManager(this, 2)
        mainView.adapter = GridRecyclerAdapter(this, DashboardFeatureList.getFeatureListOfDashboard(applicationContext))
    }


    override fun onClick(target: String) {
        val i = Intent()

        if (target === applicationContext.resources.getString(R.string.feature01)) {
            i.setClass(this@MainActivity, DiscoverMoviesActivity::class.java)
            startActivity(i)
        } else if (target === applicationContext.resources.getString(R.string.feature02)) {
            i.setClass(this@MainActivity, DiscoverMoviesActivity::class.java)
            startActivity(i)
        } else if (target === applicationContext.resources.getString(R.string.feature03)) {
            i.setClass(this@MainActivity,DiscoverMoviesActivity::class.java)
            startActivity(i)
        } else if (target === applicationContext.resources.getString(R.string.feature04)) {
            i.setClass(this@MainActivity, DiscoverMoviesActivity::class.java)
            startActivity(i)
        } else if (target === applicationContext.resources.getString(R.string.feature05)) {
            showLongToast("To be implemented")
        } else if (target === applicationContext.resources.getString(R.string.feature06)) {
            showLongToast("To be implemented")
        } else {
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            AlertDialog.Builder(this)
                .setTitle("Exit Confirmation")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(
                    android.R.string.no, null
                )
                .setPositiveButton(
                    android.R.string.yes

                ) { _, _ -> super.onBackPressed() }
                .create().show()
        }
    }

}