// MainActivity.kt

package com.example.motivationalquotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteofthedayapp.ui.theme.MotivationalQuotesTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the Compose content
        setContent {
            MotivationalQuotesTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFE3F2FD)), // Light blue background
                    contentAlignment = Alignment.Center
                ) {
                    QuoteDisplay()
                }
            }
        }
    }
}

@Composable
fun QuoteDisplay() {
    // List of motivational quotes
    val quotes = listOf(
        "Believe you can and you're halfway there. – Theodore Roosevelt",
        "The only way to do great work is to love what you do. – Steve Jobs",
        "You miss 100% of the shots you don’t take. – Wayne Gretzky",
        "The future belongs to those who believe in the beauty of their dreams. – Eleanor Roosevelt",
        "Don't watch the clock; do what it does. Keep going. – Sam Levenson",
        "Act as if what you do makes a difference. It does. – William James",
        "Success is not final, failure is not fatal: It is the courage to continue that counts. – Winston Churchill",
        "Hardships often prepare ordinary people for an extraordinary destiny. – C.S. Lewis",
        "Believe in yourself and all that you are. – Christian D. Larson",
        "The best time to plant a tree was 20 years ago. The second best time is now. – Chinese Proverb"
    )

    // Remember the current quote index
    var currentQuote by remember { mutableStateOf(getRandomIndex(quotes.size)) }

    // Column to arrange Text and Button vertically
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        // Display the quote
        Text(
            text = quotes[currentQuote],
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0D47A1), // Dark blue color
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        // Button to change the quote
        Button(
            onClick = {
                var newIndex = getRandomIndex(quotes.size)
                // Ensure a different quote is selected
                while (newIndex == currentQuote && quotes.size > 1) {
                    newIndex = getRandomIndex(quotes.size)
                }
                currentQuote = newIndex
            },
            modifier = Modifier
                .height(50.dp)
                .width(200.dp)
        ) {
            Text(
                text = "New Quote",
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}

// Helper function to get a random index
fun getRandomIndex(size: Int): Int {
    return Random.nextInt(size)
}

