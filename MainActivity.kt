package edu.quinnipiac.ser210.assignment2_part2

import Country
import CountryList
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.quinnipiac.ser210.assignment2_part2.ui.theme.Assignment2_Part2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2_Part2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CountryColumn(
                        countries = CountryList,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CountryCard(name: String, currency: String, flag: Int, modifier: Modifier = Modifier) {
    Column (Modifier.fillMaxWidth()){
        Row {
            Image(
                painter = painterResource(flag),
                contentDescription = null,
                Modifier.size(50.dp)
            )
            Spacer(Modifier.width(10.dp))
            Column {
                Text(
                    text = "Country: $name",
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Currency: $currency",
                    fontSize = 10.sp,

                )
            }
        }
        //Spacer(modifier = Modifier.height(5.dp))
        HorizontalDivider(thickness = 2.dp)
    }
}

@Composable
fun CountryColumn(countries: List<Country>, modifier: Modifier){
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(countries){ country ->
            CountryCard(country.name, country.currency, country.flag)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CountryListPreview() {
    Assignment2_Part2Theme {
        CountryColumn(CountryList, Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun CountryCardPreview() {
    Assignment2_Part2Theme {
        CountryCard("India", "Indian Rupe", R.drawable.india)
    }
}