import common.Area
import common.Sizes
import components.Content
import components.Header
import components.Menu
import components.Sidebar
import csstype.Auto
import csstype.Display
import csstype.GridTemplateAreas
import csstype.array
import hooks.useScreens
import kotlinx.browser.document
import modules.ScreensModule
import modules.ThemeModule
import mui.material.Box
import mui.material.useMediaQuery
import mui.system.sx
import navigation.screens.Screen
import react.FC
import react.Props
import react.create
import react.dom.client.createRoot
import react.router.dom.HashRouter
import react.router.useLocation

import react.router.useNavigate
import react.useState


fun main() {
    createRoot(document.createElement("div").also { document.body!!.appendChild(it) })
        .render(App.create())
}

private val App = FC<Props> {
    val mobileMode = useMediaQuery("(max-width:960px)")

    HashRouter {

        ScreensModule {

            ThemeModule {

                Box {
                    sx {
                        display = Display.grid
                        gridTemplateRows = array(
                            Sizes.Header.Height,
                            Auto.auto,
                        )
                        gridTemplateColumns = array(
                            Sizes.Sidebar.Width, Auto.auto,
                        )
                        gridTemplateAreas = GridTemplateAreas(
                            arrayOf(Area.Header, Area.Header),
                            if (mobileMode)
                                arrayOf(Area.Content, Area.Content)
                            else
                                arrayOf(Area.Sidebar, Area.Content),
                        )
                    }

                    Header()
                    if (mobileMode) Menu() else Sidebar()
                    Content()
                }
            }
        }
    }
}


