package com.example.utsproject.ui.screen

import android.service.carrier.MessagePdu
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.utsproject.Greeting
import kotlinx.coroutines.launch
import com.example.utsproject.data.model.Book
import com.example.utsproject.data.model.Genre
import com.example.utsproject.ui.theme.UTSProjectTheme
import com.example.utsproject.ui.viewmodel.BookViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown



@Composable
fun AddBookScreen(
    // viewModel: BookViewModel,
    // onBookAdded: () -> Unit,
    modifier: Modifier = Modifier
) {
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var publicationYear by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf(Genre.ROMANCE) }
    var summary by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp,80.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text= "Insert Book",
            style = TextStyle(
                fontSize = 40.sp,
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") }
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = author,
            onValueChange = { author = it },
            label = { Text("Author") }
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = publicationYear,
            onValueChange = { publicationYear = it },
            label = { Text("Publication Year") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        DropdownMenuGenreSelector(selectedGenre = genre, onGenreSelected = { genre = it })

        TextField(
            modifier = Modifier.height(150.dp).fillMaxWidth(),
            value = summary,
            onValueChange = { summary = it },
            label = { Text("Summary") },
        )

        Button(
            onClick = {
                // if (title.isNotBlank() && author.isNotBlank()) {
                //     val book = Book(
                //         id = 0,
                //         title = title,
                //         author = author,
                //         publicationYear = publicationYear.toIntOrNull(),
                //         genre = genre,
                //         summary = summary
                //     )
                //     viewModel.addBook(book)
                //     onBookAdded()
                // }
            },
            modifier = Modifier.align(Alignment.End).fillMaxWidth()
        ) {
            Text("Add Book")
        }
    }


}

@Composable
fun DropdownMenuGenreSelector(
    selectedGenre: Genre,
    onGenreSelected: (Genre) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .background(Color(0xffe2e2ec))
            .fillMaxWidth()
            .border(1.dp,Color(0xffadacb4))

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = selectedGenre.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) { expanded = true }
                    .padding(16.dp)
            )

            Icon(Icons.Filled.ArrowDropDown, contentDescription = "Arrow Drop Down")

        }


        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(0.85f)
        ) {
            Genre.values().forEach { genre ->
                DropdownMenuItem(
                    text = { Text(text = genre.name) },
                    onClick = {
                        onGenreSelected(genre)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddBookScreenPreview() {
    UTSProjectTheme {
        AddBookScreen()
    }
}

