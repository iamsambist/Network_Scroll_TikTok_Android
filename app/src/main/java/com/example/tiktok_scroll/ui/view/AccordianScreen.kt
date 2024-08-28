package com.example.tiktok_scroll.ui.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn


import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp

@Composable
fun ScreenAccordianView(){
    var expanded by remember { mutableStateOf(false)}
    val listItems = listOf("one","two","three","four")
    AccordionHeader(
        title = "Occupation",
        hasChild = true,
        isExpandable = expanded) {
        expanded = !expanded
    }
    AnimatedVisibility(visible = expanded) {
        Surface(
            color = White,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            LazyColumn {
                items(listItems){item ->
                    AccordionRow(item = item)
                    Divider(color = Color.DarkGray, thickness = 1.dp)
                }

            }
        }
        
    }

}

@Composable
fun AccordionRow(item: String) {
    Row(modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically){
        Text(text = "$item")
    }

}

@Composable
fun AccordionHeader(
    title  : String = "Occupation",
    isExpandable : Boolean = true,
    hasChild : Boolean = true,
    onTaped : (() -> Unit)
){
    val degrees = if (isExpandable) 180f else 0f
    Row(modifier = Modifier
        .padding(10.dp)
        .clickable { onTaped() },
        verticalAlignment = Alignment.CenterVertically){
        Text(text = title)
        Surface(color = White.copy(alpha = 0.6f)) {
            Icon(
                Icons.Outlined.ArrowDropDown,
                contentDescription = "arrow-down",
                modifier = Modifier.rotate(degrees),
                tint = Black
            )
        }
    }

}