package org.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BreachListScreen(viewModel: BreachViewModel) {
    val breaches = viewModel.breachList.collectAsState()

    Scaffold (
        topBar =
            {Box(modifier = Modifier.padding(2.dp).fillMaxWidth()
                .background(Color.Red.copy(0.3f))){
                TopAppBar {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center){
                  Text(text = " Breach", fontSize = 28.sp, fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(top = 8.dp))
                }}
            }}
            ){  innerPadding->
        Column(modifier = Modifier.padding(innerPadding)){

    if (breaches.value.isEmpty()) {
        Column(modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
        }
    } else {

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(breaches.value) { breach ->
                BreachItem(breach)
            }
        }
    }
}}}
@Composable
fun BreachItem(breach: Breach,modifier : Modifier = Modifier) {
    Card(modifier = Modifier.fillMaxWidth().padding(12.dp),
        backgroundColor = Color.Red.copy(0.2f)
    ){
        Column(modifier = modifier.padding( 12.dp)){

            Text("Name: ${breach.Name}", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)
            Spacer(modifier= modifier.padding(bottom = 6.dp))
            Text("Domain :${breach.Domain}",
                fontSize = 16.sp)
            Spacer(modifier= modifier.padding(bottom = 6.dp))
            Text("Breach Date: ${breach.BreachDate}",
                fontSize = 16.sp)
            Spacer(modifier= modifier.padding(bottom = 6.dp))
            Text("Description: ${breach.Description}", maxLines = 4,
                fontSize = 16.sp)

            //First Commit

    }}
}
