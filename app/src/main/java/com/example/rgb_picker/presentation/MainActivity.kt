package com.example.rgb_picker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rgb_picker.presentation.Color_Detail.ColorDetailViewModel
import com.example.rgb_picker.presentation.theme.RGB_PickerTheme
import org.koin.androidx.compose.inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RGB_PickerTheme {
                Surface(color = MaterialTheme.colors.onBackground) {
                    ColorDetailScreen()
                }
            }
        }
    }
}

@Composable
fun ColorDetailScreen() {
    val viewModel by inject<ColorDetailViewModel>()
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        state.colorDetail?.let { color ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${color.name.toString()}",
                            fontSize = 20.sp,
                            modifier = Modifier.weight(8f),
                            fontWeight = FontWeight.Bold,
                            color = Color.Red
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = color.rgb.toString(),
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Team members",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}