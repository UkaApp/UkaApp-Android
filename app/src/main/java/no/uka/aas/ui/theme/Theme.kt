package no.uka.aas.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = UKAOrangeLight,
    secondary = UKAGreenDark,
    tertiary = UKAPurpleLight,

    background = NeutralInk,
    surface = NeutralInk,

    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onTertiary = Color.Black,

    onBackground = NeutralCream,
    onSurface = NeutralCream,
)
private val LightColorScheme = lightColorScheme(
    primary = UKAOrange,
    secondary = UKAGreen,
    tertiary = UKAPurpleDark,

    background = NeutralCream,
    surface = NeutralCream,

    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,

    onBackground = NeutralInk,
    onSurface = NeutralInk,
)





@Composable
fun UKAÅsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme


    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}