package com.mandar.fitnesstracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mandar.fitnesstracker.ui.theme.FitnessTrackerTheme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyFirstCode(
                        modifier = Modifier.padding(innerPadding)
                        )
                }
            }
        }
    }
}

@Composable
fun MyFirstCode(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    var cur_count by remember { mutableStateOf(0) }
    var input by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        TextField(value = input, onValueChange = {
            input = it
        },
            label = {
                Text("Enter the value")
            }
        )

        val number = input.toIntOrNull() ?: 0

        Text(
            text = "Current count = $cur_count"
        )

        Button(onClick = {
            cur_count = count
            count += number
        }) { Text("Increse") }

        Button(onClick = {
            cur_count = count
            count -= number
        }) { Text("Decrease") }

        Text(
            text = "current count = $count",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CodePreview() {
    FitnessTrackerTheme {
        MyFirstCode()
    }
}