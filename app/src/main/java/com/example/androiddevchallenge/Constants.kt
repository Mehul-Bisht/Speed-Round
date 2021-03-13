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

object Constants {

    private val row1 = RowItem("Desert Chic", R.drawable.desert_chic)
    private val row2 = RowItem("Tiny terrariums", R.drawable.tiny_terrarium)
    private val row3 = RowItem("Jungle Vibes", R.drawable.jungle_vibes)
    private val row4 = RowItem("Easy Care", R.drawable.easy_to_take_care)
    private val row5 = RowItem("House Plant", R.drawable.houseplant)

    private val column1 = ColumnItem("Monstera", R.drawable.monstera, false)
    private val column2 = ColumnItem("Aglaonema", R.drawable.aglaonema, false)
    private val column3 = ColumnItem("Peace Lily", R.drawable.peace_lily, false)
    private val column4 = ColumnItem("Fiddle Leaf Tree", R.drawable.fiddle_leaf_tree, false)
    private val column5 = ColumnItem("Bamboo", R.drawable.bamboo, false)
    private val column6 = ColumnItem("Money Plant", R.drawable.money_plant, false)
    private val column7 = ColumnItem("Aloe Vera", R.drawable.aloe_vera, true)

    val rowList = listOf(row1, row2, row3, row4, row5)
    val columnList = listOf(column1, column2, column3, column4, column5, column6, column7)
    val favList = listOf(row2, row4)
}
