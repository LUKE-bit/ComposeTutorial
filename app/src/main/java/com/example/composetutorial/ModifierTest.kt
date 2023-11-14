package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ModifierTest : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }

    }

    @Composable
    fun IconImage(modifier: Modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.studio),
            contentDescription = "Icon Image",
            modifier = Modifier
                .wrapContentSize()
                .background(Color.Gray)
                .padding(18.dp)
                .border(5.dp, Color.Magenta, CircleShape)
                .clip(CircleShape)
        )
    }
    @Preview(name = "Light Mode")
    @Composable
    fun PreviewModifier() {
        Column {
            IconImage(Modifier.align(Alignment.CenterHorizontally))
        }
    }
}
