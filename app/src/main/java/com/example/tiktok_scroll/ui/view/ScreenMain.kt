package com.example.tiktok_scroll.ui.view

import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiktok_scroll.ui.theme.TikTok_SCROLLTheme

@Composable
fun ScreenMainView(){
    var value by remember { mutableStateOf(0)}
    var userDragAmount by remember { mutableStateOf(0f)}
    val dragThreshold = 200f
    val modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectVerticalDragGestures { change, dragAmount ->
                change.consume() // Consumes the event to prevent further propagation

                userDragAmount += dragAmount
                // Accumulate the dragAmount
                if (userDragAmount > dragThreshold) {
                    // Scroll Down
                    value -= 1
                    userDragAmount = 0f // reset the dragAmount
                } else if (userDragAmount < -dragThreshold) {
                    // Scroll Down

                    value += 1
                    userDragAmount = 0f // reset the drag Amount
                }
            }
        }
    Box(modifier = modifier.padding(WindowInsets.statusBars.asPaddingValues()),
        contentAlignment = Alignment.Center){
        ScreenCelebDetailView()
    }

}
@Composable
fun ScreenCelebDetailView(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        Text(text = "michael jordan",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(text = "Net Worth = 2200000000")
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(text = "Gender = Male")
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(text = "Nationality = US")
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(text = "Height = 1.98m")
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(text = "Birthday = 1963-02-17")
        Spacer(modifier = Modifier.padding(top = 10.dp))
        ScreenAccordianView()


        
    }
    
}
@Preview(showBackground = true)
@Composable
fun ScreeMainViewPreview(){
    TikTok_SCROLLTheme {
        ScreenCelebDetailView()
    }
}