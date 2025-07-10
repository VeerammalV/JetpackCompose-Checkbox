package com.example.learncheckboxjc

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learncheckboxjc.ui.theme.LearnCheckboxJcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnCheckboxJcTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    LearnCheckBoxes()
                }
            }
        }
    }
}

@Composable
fun LearnCheckBoxes() {
    val todoList: List<String> = listOf("Buy Groceries", "Go Shopping", "Study", "Sleep", "Read a Book", "Play Games")
    val context = LocalContext.current.applicationContext

    Column(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(start = 40.dp, top = 180.dp)) {
            todoList.forEach {
                todoItem ->
                var checkedItem by remember {
                    mutableStateOf(false)
                }

                Row {
                    Checkbox(checked = checkedItem, onCheckedChange = {
                        checkStatus -> checkedItem = checkStatus
                        Toast.makeText(context, "$todoItem is $checkedItem", Toast.LENGTH_SHORT).show()
                    })

                    Text(text = todoItem, fontSize = 22.sp)
                }
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun  CheckboxPreview() {
    LearnCheckboxJcTheme {
        LearnCheckBoxes()
    }
}