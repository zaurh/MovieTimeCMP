package com.zaurh.movietimenew.presentation.search.component.bottomsheet

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zaurh.movietimenew.presentation.search.SearchAction
import com.zaurh.movietimenew.presentation.search.SearchFilterSortType
import com.zaurh.movietimenew.presentation.search.SearchFilterType
import com.zaurh.movietimenew.presentation.search.SearchUIState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchFilterBottomSheet(
    uiState: SearchUIState,
    onAction: (SearchAction) -> Unit = {}
) {
    if (uiState.searchFilterBottomSheetEnabled) {
        ModalBottomSheet(
            onDismissRequest = {
                onAction(SearchAction.OnFilterBSDismissed)
            },
            content = {
                Column {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = "Content",
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 8.dp)
                    ) {
                        items(SearchFilterType.entries) {
                            Button(
                                modifier = Modifier.padding(horizontal = 4.dp),
                                onClick = {
                                    onAction(SearchAction.OnFilterTypeChanged(it))
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (it == uiState.searchFilterType)
                                        MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.background,
                                )
                            ) {
                                Text(
                                    text = it.displayName,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                    AnimatedVisibility(uiState.searchFilterType != SearchFilterType.PERSON) {
                        Column {
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                modifier = Modifier.padding(start = 16.dp),
                                text = "Sort by",
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            var expanded by remember { mutableStateOf(false) }

                            ExposedDropdownMenuBox(
                                expanded = expanded,
                                onExpandedChange = {
                                    expanded = !expanded
                                }
                            ) {
                                TextField(
                                    modifier = Modifier
                                        .menuAnchor(MenuAnchorType.PrimaryEditable, enabled = true)
                                        .fillMaxWidth()
                                        .padding(horizontal = 8.dp)
                                        .clip(RoundedCornerShape(10.dp)),
                                    readOnly = true,
                                    value = uiState.searchFilterSortType.displayName,
                                    onValueChange = { },
                                    trailingIcon = {
                                        ExposedDropdownMenuDefaults.TrailingIcon(
                                            expanded = expanded
                                        )
                                    },
                                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                                        focusedContainerColor = MaterialTheme.colorScheme.background,
                                        unfocusedContainerColor = MaterialTheme.colorScheme.background,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent
                                    )
                                )
                                ExposedDropdownMenu(
                                    expanded = expanded,
                                    onDismissRequest = {
                                        expanded = false
                                    }
                                ) {
                                    SearchFilterSortType.entries.forEach { selectionOption ->
                                        DropdownMenuItem(
                                            onClick = {
                                                onAction(
                                                    SearchAction.OnFilterSortTypeChanged(
                                                        selectionOption
                                                    )
                                                )
                                                expanded = false
                                            },
                                            text = {
                                                Text(
                                                    text = selectionOption.displayName
                                                )
                                            }
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                modifier = Modifier.padding(start = 16.dp),
                                text = "Preferences",
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        onAction(SearchAction.OnToggleShowReleaseDate)
                                    }
                                    .padding(horizontal = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                    text = "Show release date",
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Switch(checked = uiState.releaseDateShown, onCheckedChange = {
                                    onAction(SearchAction.OnToggleShowReleaseDate)
                                })
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        )
    }
}

@Preview
@Composable
private fun SearchFilterBSPreview() {
//    MovieAppIntern2Theme(darkTheme = true) {
//        SearchFilterBottomSheet(
//            uiState = SearchUIState(
//                searchFilterBottomSheetEnabled = true
//            )
//        )
//    }
}