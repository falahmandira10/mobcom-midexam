import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CheckboxDefaults.colors
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavController
import com.example.utsproject.data.model.Book

@Composable
fun CardBook(book: Book, modifier: Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .width(screenWidth * 0.4f)
    ) {
        Row (
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp, 15.dp),
            horizontalArrangement = Arrangement.End
        ) {
            OutlinedButton(
                onClick = {
                    // navController.navigate("book_edit")
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent
                ),
                modifier = modifier
                    .height(28.dp),
            ) {
                Text(
                    text = "Edit",
                    style = TextStyle(
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
        Column(
            modifier = modifier
                .fillMaxHeight()
                .padding(20.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {

            Text(
                text = "${book.title}",
                modifier = modifier,
                style = TextStyle(
                    fontSize = 14.sp,
                    textAlign = TextAlign.Left,
                )
            )
            Text(
                text = "${book.author}",
                modifier = modifier,
                style = TextStyle(
                    fontSize = 10.sp,
                    textAlign = TextAlign.Left,
                    color = Color(0xff546e7a)
                )
            )


        }
    }
}
