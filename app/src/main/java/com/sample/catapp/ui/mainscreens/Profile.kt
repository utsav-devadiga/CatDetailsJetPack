package com.sample.catapp.ui.mainscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sample.catapp.R
import com.sample.catapp.ui.mainscreens.components.UrlCard
import com.sample.catdetails.view.common.AppTopBar

@Composable
fun Profile(onBackClicked: () -> Unit) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)

    ) {
        AppTopBar(
            isBackButtonRequired = true,
            text = "Profile",
            onBackClicked = onBackClicked,
            onProfileIconClicked = {}
        )
        Column(modifier = Modifier.padding(16.dp)) {
            ProfileScreen()
            ProfileScreenUI()
        }


    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_me),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape), // Clip image to be circular
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Utsav Devadiga",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )

        Text(
            text = "Android Engineer",
            fontWeight = FontWeight.Light,
            fontSize = 18.sp,
            color = Color.Gray
        )

        AssistChip(
            onClick = { },
            label = { Text("Made with Jetpack Compose") },
            leadingIcon = {
                Icon(
                    Icons.Outlined.CheckCircle,
                    contentDescription = "Localized description",
                    Modifier
                        .size(AssistChipDefaults.IconSize),

                    )
            }
        )
    }
}

@Composable
fun ProfileScreenUI(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier

            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            UrlCard(
                url = "https://utsav-dev.in/",
                title = "My Website",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(0.dp, 16.dp, 8.dp, 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            UrlCard(
                url = "",
                title = "3.7 Yrs of Experience",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(8.dp, 16.dp, 6.dp, 16.dp)
            )
        }
        ProfileSummary()
    }
}

@Composable
fun ProfileSummary() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Card() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    "Work Experience",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "Android Developer at MyBenfits360",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    "Feb 2022 - Present",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "- Lead a team of four and created five apps that are used for employee benefits enrollment," +
                            " with a total of over 1000 daily active users.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "- Conducted penetration testing on both iOS and Android apps and" +
                            " resolved issues involving the backend.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "- Used JAVA, KOLTIN, REST API's, C# (for server side)",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Application Developer Newlit Technologies",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    "Jul 2020 - Feb 2022",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "- Developed a health-related app that had a total of 5,000 users with " +
                            "premium subscriptions. The app synced with Wear OS health data to generate a monthly health report for users.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "- Used JAVA, FIREBASE",
                    style = MaterialTheme.typography.bodyLarge
                )


            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Card() {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    "Education",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "B.Sc. in Information Technology - Mumbai University",
                    style = MaterialTheme.typography.bodyLarge
                )

            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Profile(onBackClicked = {})
}