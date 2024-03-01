package com.sample.catdetails.view.catdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.sample.catdetails.CatItem
import com.sample.catdetails.view.common.AppTopBar
import com.sample.catdetails.view.common.CommonImage

@Composable
fun DetailsOfCat(catItem: CatItem, onBackClicked: () -> Unit, onProfileClicked: () -> Unit) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        AppTopBar(
            isBackButtonRequired = true,
            text = catItem.name,
            onBackClicked = {
                onBackClicked()
            },
            onProfileIconClicked = {
                onProfileClicked()
            })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)

            ) {
                val imageModifier = Modifier
                    .padding(start = 0.dp, top = 10.dp, end = 0.dp, bottom = 0.dp)
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(8.dp))

                CommonImage(
                    url = catItem.image?.url,
                    contentDescription = catItem.name + " Details",
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .height(210.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Gray),
                                startY = 50f,
                            )
                        )
                        .padding(8.dp)
                ) {
                    AssistChip(
                        onClick = { },
                        label = { Text(catItem.origin, color = Color.White) },
                        border = AssistChipDefaults.assistChipBorder(Color.White),
                        modifier = Modifier.align(Alignment.BottomStart),
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.LocationOn,
                                contentDescription = "Localized description",
                                Modifier
                                    .size(AssistChipDefaults.IconSize),
                                tint = Color.White,

                                )
                        }
                    )

                    AssistChip(
                        onClick = { },
                        label = { Text("${catItem.lifeSpan} years", color = Color.White) },
                        border = AssistChipDefaults.assistChipBorder(Color.White),
                        modifier = Modifier.align(Alignment.BottomEnd),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = com.google.android.material.R.drawable.ic_clock_black_24dp),
                                contentDescription = "Localized description",
                                Modifier
                                    .size(AssistChipDefaults.IconSize),
                                tint = Color.White,

                                )
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                UrlCard(
                    url = "${catItem.vcahospitalsUrl}",
                    title = "VCA",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(0.dp, 8.dp, 8.dp, 8.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                UrlCard(
                    url = "${catItem.vetstreetUrl}",
                    title = "Vetstreet",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(8.dp, 8.dp, 6.dp, 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    CustomText("Temperament:", MaterialTheme.typography.titleMedium)
                    CustomText(catItem.temperament, MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(12.dp))
                    CustomText("Description:", MaterialTheme.typography.titleMedium)
                    CustomText(catItem.description, MaterialTheme.typography.bodyLarge)
                }

            }


        }
    }
}


@Composable
fun CustomText(text: String, style: TextStyle) {
    Text(
        text = text,
        style = style
    )
}