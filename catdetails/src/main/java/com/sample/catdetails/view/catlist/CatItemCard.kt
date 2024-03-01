package com.sample.catdetails.view.catlist

import android.content.res.Resources.Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.sample.catdetails.CatItem
import com.sample.catdetails.view.common.CommonImage

@Composable
fun CatItemCard(catItem: CatItem, onItemClick: (CatItem) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onItemClick(catItem) }
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box {
            // Image with gradient overlay
            Column {
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    CommonImage(
                        url = catItem.image?.url,
                        contentDescription = catItem.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(Color.Transparent, Color.Black),
                                    startY = 300f, // Adjust gradient start
                                )
                            )
                    ) {
                        Text(
                            text = catItem.name,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                }

            }
        }
    }
}
