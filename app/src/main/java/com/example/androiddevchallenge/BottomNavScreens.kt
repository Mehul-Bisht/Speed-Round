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

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object HomeTab : BottomNavScreens("Home", "Home", Icons.Filled.Home)
    object FavoritesTab : BottomNavScreens("Favourites", "Favourites", Icons.Outlined.Favorite)
    object ProfileTab : BottomNavScreens("Profile", "Profile", Icons.Filled.AccountCircle)
    object CartTab : BottomNavScreens("Cart", "Cart", Icons.Filled.ShoppingCart)
}
