package edu.quinnipiac.ser210.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.quinnipiac.ser210.assignment2.ui.theme.Assignment2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MovieInfoCard("Knives Out", "2:10", "Eng", "9.2", "45+",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MovieInfoCard(title: String,length: String,language: String,rating: String,review: String, modifier: Modifier){
    BigPosterSection()
    Column (Modifier.padding(top = 400.dp, bottom = 50.dp)){
        MainSection(title)
        InfoSection(length, language, rating, review, modifier)
    }
}

@Composable
fun BigPosterSection() {
    Image(
        painter = painterResource(R.drawable.knives_out),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxWidth()
            .height(500.dp)
            .clip(RoundedCornerShape(25.dp))
    )
}

@Composable
fun MainSection(title: String) {
    Row (modifier = Modifier.padding(bottom = 40.dp, start = 40.dp, end = 40.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
        Image(
            painter = painterResource(R.drawable.knives_out),
            contentDescription = null,
            //contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(200.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Column (verticalArrangement = Arrangement.Bottom, modifier = Modifier.height(200.dp)){
            Text(
                text = title,
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 20.dp)
            )
            Row {
                Icon(Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
                Icon(Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
                Icon(Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
                Icon(Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
                Icon(Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            }
        }
    }
}

@Composable
fun InfoSection(length: String,language: String,rating: String,review: String,modifier: Modifier) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Length", fontWeight = FontWeight.Light)
            Text(length, fontWeight = FontWeight.Bold)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Language", fontWeight = FontWeight.Light)
            Text(language, fontWeight = FontWeight.Bold)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Rating", fontWeight = FontWeight.Light)
            Text(rating, fontWeight = FontWeight.Bold)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Review", fontWeight = FontWeight.Light)
            Text(review, fontWeight = FontWeight.Bold)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MovieInfoCardPreview() {
    Assignment2Theme {
        MovieInfoCard("Knives Out", "2:10", "Eng", "9.2", "45+", Modifier)
    }
}