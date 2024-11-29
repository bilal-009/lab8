package com.example.androidmenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MenuGrid(){
    Column(modifier=Modifier.verticalScroll(rememberScrollState())) {
        repeat(10){
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                GridCell()
            }
        }
    }
}

@Composable
fun GridCell() {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(8.dp)
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp)
                .background(Color(0XFFFFFFFF))
        )
        {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp), // Card elevation to give depth
                modifier = Modifier.padding(8.dp) // Padding around the card
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth() // Make the row take full width of the card
                        .background(Color(0xFFFFFFFF)) // Background color for the row
                        .padding(8.dp), // Padding inside the row
                    verticalAlignment = Alignment.CenterVertically // Vertically align items at the center
                ) {
                    // Column containing the text content
                    Column(
                        modifier = Modifier
                            .weight(1f) // This makes the column take up all remaining space in the row
                            .padding(end = 8.dp) // Padding at the end of the column
                    ) {
                        // Item name with larger font and bold weight
                        Text(
                            text = "Greek Salad",
                            fontSize = 20.sp, // Font size for the title
                            fontWeight = FontWeight.Bold, // Bold font for emphasis
                            modifier = Modifier.padding(bottom = 4.dp) // Space below the title
                        )
                        // Item description with smaller font and gray color
                        Text(
                            text = "A traditional Greek salad consists of sliced cucumbers, tomatoes, green bell pepper, red onion, olives, and feta cheese.",
                            fontSize = 14.sp, // Smaller font for description
                            color = Color.Gray, // Gray color for the description text
                            modifier = Modifier.padding(bottom = 8.dp) // Space below the description
                        )
                        // Item price with bold font and black color
                        Text(
                            text = "$12.5", // Price of the dish
                            fontSize = 16.sp, // Font size for the price
                            fontWeight = FontWeight.Bold, // Bold font for price
                            color = Color.Black // Black color for the price text
                        )
                    }
                    // Image of the dish with fixed size and rounded corners
                    Image(
                        painter = painterResource(id = R.drawable.greeksalad), // Image source for Greek salad
                        contentDescription = "Greek Salad Image", // Accessibility description for the image
                        modifier = Modifier
                            .size(80.dp) // Set size of the image
                            .clip(RoundedCornerShape(8.dp)) // Apply rounded corners to the image
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun GridCellPreview(){
    MenuGrid()
}
