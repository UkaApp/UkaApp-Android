package no.uka.aas.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import no.uka.aas.R

// Kun DM Sans Regular
val DmSans = FontFamily(
    Font(
        resId = R.font.dmsans_regular,
        weight = FontWeight.Normal
    ),
Font(
resId = R.font.dmsans_bold,
weight = FontWeight.Bold
)
)


// Balgin Bold Italic (kun til logo / spesielle titler)
val Balgin = FontFamily(
    Font(
        resId = R.font.balgintext_bolditalic,
        weight = FontWeight.Bold
    )
)
val AppTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = DmSans,              // <- her bruker vi DM Sans
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)
