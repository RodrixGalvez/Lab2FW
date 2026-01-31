package com.example.labno1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import com.example.labno1.ui.theme.LabNo1Theme
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.material3.Button

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                LabNo1Theme {
                    Scaffold(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        innerPadding -> CharacterSheetScreen(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }

@Composable
fun CharacterSheetScreen(modifier: Modifier = Modifier){
   var vit by remember { mutableIntStateOf(10)}
   var dex by remember { mutableIntStateOf(10)}
   var wis by remember { mutableIntStateOf(10)}
   val total = vit + dex + wis

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "RPG Character Sheet",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        StatRow(name = "VITALITY", value = vit, onRoll = {vit = (1..20).random()})
        StatRow(name = "DEXTERITY", value = dex, onRoll = {dex = (1..20).random()})
        StatRow(name = "WISDOM", value = wis, onRoll = {wis = (1..20).random()})

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Total Score: $total",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                val (msg,color) = when {
                    total < 30 -> "Re-roll recommended!" to Color.Red
                    total >= 50 -> "Godlike!" to Color(0xFFFFD700)
                    else -> "" to Color.Unspecified
                }

                if(msg.isNotBlank()){
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = msg,
                        color = color,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Composable
fun StatRow(
    name: String,
    value: Int,
    onRoll: () -> Unit
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = value.toString(),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Button(onClick = onRoll){
                Text("Roll")
            }
        }
    }
}