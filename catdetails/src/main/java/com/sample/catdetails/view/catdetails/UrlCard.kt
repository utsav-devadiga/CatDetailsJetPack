package com.sample.catdetails.view.catdetails

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UrlCard(url: String, title: String, modifier: Modifier) {
    val context = LocalContext.current

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(url)
                }
                try {
                    context.startActivity(intent)
                } catch (e: Exception) {
                    // Handle the exception, e.g., show a toast or a snackbar
                }
            },
        elevation = CardDefaults.elevatedCardElevation()

    ) {
        Box(
            modifier = Modifier
                .height(80.dp)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Icon(
                Icons.Outlined.ArrowForward,
                contentDescription = "open link",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .graphicsLayer {
                        rotationZ = -45f
                    }
            )
            Text(
                text = title,
                modifier = Modifier.align(Alignment.BottomStart)
            )
        }
    }
}


@Preview
@Composable
private fun UrlCardPreview() {

    UrlCard("URL", "Open this", modifier = Modifier)

}