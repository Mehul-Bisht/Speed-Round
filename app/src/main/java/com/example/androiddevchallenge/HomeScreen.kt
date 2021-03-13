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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@ExperimentalAnimationApi
@Composable
fun HomeScreen() {

    Column {
        var search: String by remember { mutableStateOf("") }
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                value = search,
                onValueChange = {
                    search = it
                },
                label = {
                    Text(text = "Search")
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colors.onPrimary,
                    focusedLabelColor = MaterialTheme.colors.onPrimary,
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onPrimary
                    )
                }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .padding(start = 16.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            Text(
                text = "Browse Themes",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = getBg(isSystemInDarkTheme()))
                .padding(start = 16.dp, top = 8.dp, end = 16.dp),
            content = {
                items(Constants.rowList) { item ->
                    RowItem(
                        item.id,
                        item.name
                    )
                }
            }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Design your home garden",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary
            )
            Icon(
                imageVector = Icons.Filled.FilterList,
                contentDescription = null,
                tint = MaterialTheme.colors.onPrimary
            )
        }

        LazyColumn(
            modifier = Modifier
                .background(color = MaterialTheme.colors.background)
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 64.dp),
            content = {
                items(Constants.columnList) { item ->
                    ColumnItem(
                        item.isLast,
                        item.id,
                        item.name
                    )
                }
            }
        )
    }
}

@Composable
fun RowItem(
    id: Int,
    name: String
) {
    Card(
        modifier = Modifier
            .height(136.dp)
            .width(155.dp)
            .padding(top = 4.dp, bottom = 4.dp, end = 4.dp, start = 4.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = id),
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
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
                    modifier = Modifier.padding(start = 10.dp, top = 4.dp),
                    text = name,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun ColumnItem(
    isLast: Boolean,
    id: Int,
    name: String
) {
    Row(
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
    ) {
        var isChecked: Boolean by remember { mutableStateOf(false) }

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (
                image, spacerStart, title, description, checkbox, divider
            ) = createRefs()

            Image(
                painter = painterResource(id = id),
                contentDescription = null,
                modifier = Modifier
                    .width(64.dp)
                    .height(64.dp)
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }
                    .clip(shape = RoundedCornerShape(8.dp)),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )

            Spacer(
                modifier = Modifier
                    .width(8.dp)
                    .constrainAs(spacerStart) {
                        start.linkTo(image.end)
                        top.linkTo(parent.top)
                    }
            )

            Row(
                modifier = Modifier
                    .height(24.dp)
                    .constrainAs(title) {
                        top.linkTo(parent.top)
                        start.linkTo(spacerStart.end)
                    },
                verticalAlignment = Alignment.Bottom,
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onPrimary
                )
            }

            Text(
                text = "This is a description",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.constrainAs(description) {
                    top.linkTo(title.bottom)
                    start.linkTo(spacerStart.end)
                },
            )

            Checkbox(
                modifier = Modifier
                    .constrainAs(checkbox) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                colors = CheckboxDefaults.colors(
                    checkmarkColor = MaterialTheme.colors.background,
                    checkedColor = getCheckMarkColor(isSystemInDarkTheme()),
                    uncheckedColor = MaterialTheme.colors.onPrimary,
                ),
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                }
            )
            Row(
                modifier = Modifier
                    .constrainAs(divider) {
                        start.linkTo(image.end)
                        end.linkTo(checkbox.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(start = 56.dp, end = 20.dp)
            ) {
                AnimatedVisibility(visible = !isLast) {
                    Divider(
                        thickness = 1.dp,
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
        }
    }
}

fun getCheckMarkColor(isDark: Boolean): Color {
    if (isDark) return Color(0xFFB8C9B8)
    return Color(0xFF232323)
}

fun getCardColor(isDark: Boolean): Color {
    if (isDark) return Color(0xFF4E4E4E)
    return Color(0xFFFFFFFF)
}

fun getBg(isDark: Boolean): Color {
    if (isDark) return Color(0xFF232323)
    return Color(0xFFFFFFFF)
}
