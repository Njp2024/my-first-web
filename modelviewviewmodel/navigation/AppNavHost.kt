package com.example.modelviewviewmodel.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.modelviewviewmodel.ui.theme.screens.about.AboutScreen
import com.example.modelviewviewmodel.ui.theme.screens.home.Homescreen
import com.example.modelviewviewmodel.ui.theme.screens.login.LoginScreen
import com.example.modelviewviewmodel.ui.theme.screens.products.AddProductsScreen
import com.example.modelviewviewmodel.ui.theme.screens.products.UpdateProductsScreen
import com.example.modelviewviewmodel.ui.theme.screens.products.ViewProductsScreen
import com.example.modelviewviewmodel.ui.theme.screens.register.RegisterScreen


@Composable
fun <NavHostController> AppNavHost(modifier: Modifier = Modifier, navController: androidx.navigation.NavHostController =rememberNavController(), startDestination: String = ROUTE_HOME){
    NavHost(navController = navController, modifier = Modifier, startDestination = startDestination){
        composable(ROUTE_HOME){
            Homescreen(navController)
        }
        composable(ROUTE_ABOUT) {
            AboutScreen(navController)

        }
        composable(ROUTE_REGISTER){
    RegisterScreen(navController)
}

        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_ADD_PRODUCT){
            AddProductsScreen(navController)
        }
        composable(ROUTE_UPDATE_PRODUCT+"/{id}"){passedData ->
            UpdateProductsScreen(navController,passedData.arguments?.getString("id")!!)

        }
        composable(ROUTE_VIEW_PRODUCT) {
            ViewProductsScreen(navController)
        }
    }
}






