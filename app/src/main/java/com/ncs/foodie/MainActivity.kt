package com.ncs.foodie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ncs.foodie.ui.theme.ActionBarContent
import com.ncs.foodie.ui.theme.FoodieTheme
import com.ncs.foodie.ui.theme.HomeScreen
import com.ncs.foodie.ui.theme.OrderScreen
import com.ncs.foodie.ui.theme.actionBar
import com.ncs.foodie.ui.theme.headerImage
import com.ncs.foodie.ui.theme.primary

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box {
                val navController= rememberNavController()
                Box(modifier = Modifier) {
                    actionBar(items = listOf(ActionBarContent(R.drawable.profile,"Profile"),ActionBarContent(R.drawable.home,"Home"),ActionBarContent(R.drawable.cart,"Order"),ActionBarContent(R.drawable.ham,"Ham")),
                    navController = navController, onItemClick = {
                        navController.navigate(it.route)
                        })
                    headerImage()
                    Box(modifier = Modifier.padding(top=220.dp)){
                        com.ncs.foodie.Navigation(navController = navController)

                    }
                }
            }
        }
    }
}
@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = "order" ){
        composable("Home"){
            HomeScreen()
        }
        composable("Order"){
            OrderScreen()
        }
        composable("Profile"){

        }
        composable("Ham"){

        }
    }
}




