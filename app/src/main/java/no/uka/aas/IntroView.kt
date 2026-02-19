package no.uka.aas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import no.uka.aas.ui.theme.Balgin
import no.uka.aas.ui.theme.DmSans
import no.uka.aas.ui.theme.NeutralCream
import no.uka.aas.ui.theme.UKAOrangeLight

@Composable
fun IntroView(
    onNext: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {

        // Fullskjerms bakgrunn
        Image(
            painter = painterResource(id = R.drawable.intro_view),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Innhold oppå bakgrunn
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Flytt teksten litt ned fra toppen (juster denne!)
            Spacer(modifier = Modifier.height(100.dp))

            Text(
                text = "UKA i ÅS",
                color = NeutralCream,
                fontSize = 75.sp,
                fontFamily = Balgin,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "2026",
                color = NeutralCream,
                fontSize = 50.sp,
                fontFamily = Balgin,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onNext,
                shape = RoundedCornerShape(999.dp),
                colors = ButtonDefaults.buttonColors(containerColor = NeutralCream),
                modifier = Modifier
                    .shadow(12.dp, RoundedCornerShape(999.dp), clip = false)
                    .height(72.dp)
                    .widthIn(min = 260.dp)
            ) {
                Text(
                    text = "Neste side",
                    color = UKAOrangeLight,
                    fontSize = 32.sp,
                    fontFamily = DmSans,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.weight(0.5f))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(bottom = 30.dp)
            ) {
                Text(
                    text = "Presentert av",
                    color = NeutralCream,
                    fontSize = 16.sp,
                    fontFamily = DmSans
                )

                Spacer(modifier = Modifier.height(8.dp))

                Image(
                    painter = painterResource(id = R.drawable.samfunnet_logo),
                    contentDescription = "Samfunnet i Ås",
                    modifier = Modifier.height(34.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IntroViewPreview() {
    IntroView()
}