package com.example.labno2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.labno2.ui.theme.LabNo2Theme
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabNo2Theme {
                    TrafficLight()
                }
            }
        }
    }

enum class Light{Red, Yellow, Green}
@Composable
fun TrafficLight(){
    var state by remember { mutableStateOf(Light.Red)}

    LaunchedEffect(Unit) {
        while(true){
            state = Light.Red
            delay(2000)
            state = Light.Green
            delay(2000)
            state = Light.Yellow
            delay(1000)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .width(140.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xFF2C2C2C))
                .padding(vertical = 18.dp, horizontal = 16.dp)
        ){
            Column(
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                LightCircle(isOn = state == Light.Red, onColor = Color.Red)
                Spacer(modifier = Modifier.height(16.dp))
                LightCircle(isOn = state == Light.Yellow, onColor = Color.Yellow)
                Spacer(modifier = Modifier.height(16.dp))
                LightCircle(isOn = state == Light.Green, onColor = Color.Green)
            }
        }
    }
}

@Composable
fun LightCircle(isOn: Boolean, onColor: Color) {
    val color = if(isOn) onColor else Color.Gray

    Box(
        modifier = Modifier
            .size(90.dp)
            .clip(CircleShape)
            .background(color)
    )
}