package no.uka.aas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import no.uka.aas.ui.theme.Balgin
import no.uka.aas.ui.theme.DmSans
import no.uka.aas.ui.theme.NeutralCream
import no.uka.aas.ui.theme.UKAOrangeLight
import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

@Composable
fun CountdownView(
    // TODO: sett riktig startdato/tid for UKA her
    // Eksempel: 2026-09-20 10:00 i Oslo
    target: ZonedDateTime = ZonedDateTime.of(
        2026, 9, 20,
        10, 0, 0, 0,
        ZoneId.of("Europe/Oslo")
    )
) {
    var remainingMs by remember { mutableLongStateOf(0L) }

    LaunchedEffect(target) {
        while (true) {
            val now = Instant.now()
            val targetInstant = target.toInstant()
            val diff = Duration.between(now, targetInstant).toMillis()
            remainingMs = diff.coerceAtLeast(0L)
            delay(1000)
        }
    }

    val totalSeconds = remainingMs / 1000
    val days = totalSeconds / 86400
    val hours = (totalSeconds % 86400) / 3600
    val minutes = (totalSeconds % 3600) / 60
    val seconds = totalSeconds % 60

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(UKAOrangeLight)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(90.dp))

        Text(
            text = "UKA i ÅS",
            color = NeutralCream,
            fontSize = 64.sp,
            fontFamily = Balgin,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "2026",
            color = NeutralCream,
            fontSize = 46.sp,
            fontFamily = Balgin,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "Starter om ...",
            color = NeutralCream,
            fontSize = 20.sp,
            fontFamily = DmSans,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(26.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CountdownNumber(days)
            Spacer(modifier = Modifier.width(28.dp))
            CountdownNumber(hours)
            Spacer(modifier = Modifier.width(28.dp))
            CountdownNumber(minutes)
            Spacer(modifier = Modifier.width(28.dp))
            CountdownNumber(seconds)
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Presentert av",
            color = NeutralCream,
            fontSize = 18.sp,
            fontFamily = DmSans,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Image(
            painter = painterResource(id = R.drawable.samfunnet_logo),
            contentDescription = "Samfunnet i Ås",
            modifier = Modifier.height(56.dp)
        )

        Spacer(modifier = Modifier.height(34.dp))
    }
}

@Composable
private fun CountdownNumber(value: Long) {
    Text(
        text = value.toString(),
        color = NeutralCream,
        fontSize = 44.sp,
        fontFamily = Balgin,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun CountdownViewPreview() {
    CountdownView()
}

