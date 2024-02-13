package com.example.hom2workjjva2.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.hom2workjjva2.R
import com.example.hom2workjjva2.ui.model.prefernce.SharedPreference
import com.example.hom2workjjva2.ui.model.viewModel.MainModel

class MainActivity : AppCompatActivity() {
    private val preferensHelper: SharedPreference by lazy {
        SharedPreference(this)
    }
    private lateinit var mainModel: MainModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigation(savedInstanceState)

    }

    private fun setUpNavigation(savedInstanceState: Bundle?) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_main_actcivity) as NavHostFragment
        val navController = navHostFragment.navController
        if (savedInstanceState == null) {
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

            if (!preferensHelper.isShowRegister){
                navGraph.setStartDestination(R.id.registrationFragment)
                navController.graph = navGraph
            }
        }
    }
}