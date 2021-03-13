/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

class NavHostActivity : AppCompatActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                NavHostApp()
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun NavHostApp() {

    val navController = rememberNavController()
    val screens = listOf(
        BottomNavScreens.HomeTab,
        BottomNavScreens.FavoritesTab,
        BottomNavScreens.ProfileTab,
        BottomNavScreens.CartTab
    )

    Scaffold(
        bottomBar = { BottomNavBar(navController = navController, items = screens) }
    ) {
        MainScreenNavigationConfigurations(navController = navController)
    }
}

@Composable
fun BottomNavBar(
    navController: NavHostController,
    items: List<BottomNavScreens>
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
        items.forEach { screens ->
            val title = screens.title
            val icon = screens.icon

            BottomNavigationItem(
                label = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onPrimary
                    )
                },
                selected = currentRoute == screens.route,
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onPrimary
                    )
                },
                alwaysShowLabel = true,
                onClick = {
                    // This if check gives us a "singleTop" behavior where we do not create a
                    // second instance of the composable if we are already on that destination
                    if (currentRoute != screens.route) {
                        navController.navigate(screens.route)
                    }
                }
            )
        }
    }
}

@ExperimentalAnimationApi
@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomNavScreens.HomeTab.route) {
        composable(BottomNavScreens.HomeTab.route) {
            HomeScreen()
        }
        composable(BottomNavScreens.FavoritesTab.route) {
            FavouritesScreen()
        }
        composable(BottomNavScreens.ProfileTab.route) {
            ProfileScreen()
        }
        composable(BottomNavScreens.CartTab.route) {
            CartScreen()
        }
    }
}
