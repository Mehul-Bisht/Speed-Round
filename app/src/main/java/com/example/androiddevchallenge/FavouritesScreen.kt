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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun FavouritesScreen() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .padding(start = 16.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            Text(
                text = "Favourites",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary
            )
        }

        LazyColumn(
            modifier = Modifier
                .background(color = MaterialTheme.colors.background)
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 64.dp),
            content = {
                items(Constants.favList) { item ->
                    FavouriteItem(
                        item.id,
                        item.name
                    )
                }
            }
        )
    }
}

@Composable
fun FavouriteItem(
    id: Int,
    name: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 16.dp, end = 16.dp, start = 16.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = id),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .height(46.dp)
                    .fillMaxWidth()
                    .background(color = getCardColor(isSystemInDarkTheme()))
            ) {
                Text(
                    modifier = Modifier.padding(start = 10.dp, top = 6.dp),
                    text = name,
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}
