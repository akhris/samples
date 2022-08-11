package components

import common.Area
import common.Themes
import csstype.integer
import csstype.number
import hooks.useScreens
import modules.ThemeContext
import mui.icons.material.Brightness4
import mui.icons.material.Brightness7
import mui.material.*
import mui.material.styles.TypographyVariant
import mui.system.sx
import react.*
import react.dom.aria.ariaLabel
import react.dom.html.ReactHTML
import react.router.useLocation



val Header = FC<Props> {
    var theme by useContext(ThemeContext)
    val lastPathname = useLocation().pathname.substringAfterLast("/")

    val screens = useScreens()  // is it ok?
    val currentScreen = screens.find { it.key==lastPathname }

    AppBar {
        position = AppBarPosition.fixed
        sx {
            gridArea = Area.Header
            zIndex = integer(1_500)
        }

        Toolbar {
            Typography {
                sx { flexGrow = number(1.0) }
                variant = TypographyVariant.h6
                noWrap = true
                component = ReactHTML.div

                +(currentScreen?.name?:"")

            }

            Tooltip {
                title = ReactNode("Theme")

                Switch {
                    icon = Brightness7.create()
                    checkedIcon = Brightness4.create()
                    checked = theme == Themes.Dark
                    ariaLabel = "theme"

                    onChange = { _, checked ->
                        theme = if (checked) Themes.Dark else Themes.Light
                    }
                }
            }

        }
    }
}
