package com.sample.catapp

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sample.catapp.catdetails.presentation.view.CatDetails
import com.sample.catapp.catdetails.presentation.view.CatList
import com.sample.catapp.catdetails.presentation.view.ProfileScreen
import com.sample.catapp.catdetails.presentation.viewmodel.CatDetailViewModel
import com.sample.catapp.catdetails.presentation.viewmodel.CatListViewModel

@Composable
fun CatAppEntryScreenApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = CatsDestinations.CatsList.route
    ) {
        composable(CatsDestinations.CatsList.route) {
            val viewModel: CatListViewModel = hiltViewModel()
            CatList(navController, viewModel)
        }
        composable(CatsDestinations.CatDetail.route) {
            val viewModel: CatDetailViewModel = hiltViewModel()
            CatDetails(navController, viewModel)
        }
        composable(CatsDestinations.Profile.route) {
            ProfileScreen(navController)
        }
    }
}
