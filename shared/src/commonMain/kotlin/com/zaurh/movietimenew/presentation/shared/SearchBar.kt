package com.zaurh.movietimenew.presentation.shared

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    label: String,
    query: String,
    onQueryChanged: (String) -> Unit,
    onClearClicked: () -> Unit
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        value = query,
        onValueChange = { onQueryChanged(it) },
        placeholder = {
            Text(
                text = label
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.background,
            focusedContainerColor = MaterialTheme.colorScheme.background,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        leadingIcon = {
//            Icon(
//                imageVector = Icons.Default.Search,
//                contentDescription = ""
//            )
        },
        singleLine = true,
        trailingIcon = {
            if (query.isNotEmpty()){
                IconButton(onClick = {
                    onClearClicked()
                }) {
//                    Icon(
//                        imageVector = Icons.Default.Clear,
//                        contentDescription = ""
//                    )
                }
            }
        }
    )
}