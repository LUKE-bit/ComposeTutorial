package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.foundation.lazy.items

class SecondActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ComposeTutorialTheme {
                MyApp2(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
@Composable
fun MyApp2(modifier : Modifier = Modifier){
    var shouldShowOnboarding by remember { mutableStateOf(true) }
    Surface(modifier) {
        if (shouldShowOnboarding){
            OnboardingScreen(onContinueClicked = {shouldShowOnboarding = false})
        }else{
            Greetings()
        }
    }
}
@Composable
fun OnboardingScreen(onContinueClicked:() -> Unit,modifier:Modifier = Modifier){
    Column(modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome to ComposeTutorial")
        Button(modifier = Modifier.padding(vertical = 24.dp),onClick = onContinueClicked) {
            Text(text = "Continue")
        }
    }
}
@Composable
private fun Greetings(
    modifier:Modifier = Modifier,
    names: List<String> = List(1000){"$it"}
){
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items=names){name->
            Greeting(name = name)
        }
    }
}
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    ComposeTutorialTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview2() {
    ComposeTutorialTheme {
        Greetings()
    }
}

@Preview
@Composable
fun MyAppPreview() {
    ComposeTutorialTheme {
        MyApp2(Modifier.fillMaxSize())
    }
}