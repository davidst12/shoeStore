package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        setSupportActionBar(findViewById(R.id.toolbar))

        //Setting up the navController with the toolbar and an AppBarConfiguration
        val navController = this.findNavController(R.id.myNavFragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    //Enable navigateUp (back arrow on the top-left)
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavFragment)
        return navController.navigateUp()
    }

    override fun onDestroy() {
        Log.i("MainActivity", "Activity destroyed")
        super.onDestroy()
    }
}
