package common

import csstype.NamedColor
import kotlinx.js.jso
import mui.material.PaletteMode.dark
import mui.material.PaletteMode.light
import mui.material.styles.PaletteOptions
import mui.material.styles.ThemeOptions
import mui.material.styles.createPalette
import mui.material.styles.createTheme

object Themes {

    private const val colorPrimary = "#206c2f"
    private const val colorSecondary = "#8e34ae"

    val Light = createTheme(
        jso {
            palette = jso {
                primary = jso {
                    main = colorPrimary
                }
                secondary = jso {
                    main = colorSecondary
                }
                mode = light
            }
        }
    )


    val Dark = createTheme(
        jso {
            palette = jso {
                primary = jso {
                    main = colorPrimary
                }
                secondary = jso {
                    main = colorSecondary
                }
                mode = dark
            }
        }
    )
}
