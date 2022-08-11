package components

import common.Area
import csstype.px
import modules.ScreensContext
import mui.material.Typography
import mui.system.Box
import mui.system.sx
import react.FC
import react.Props
import react.create
import react.dom.html.ReactHTML.main
import react.router.Outlet
import react.router.Route
import react.router.Routes
import react.useContext

private val DEFAULT_PADDING = 30.px

val Content = FC<Props> {
    val screens = useContext(ScreensContext)

    Routes {
        Route {
            path = "/"
            element = Box.create {
                component = main
                sx {
                    gridArea = Area.Content
                    padding = DEFAULT_PADDING
                }

                Outlet()
            }

            screens.forEachIndexed { i, (key, _, Component) ->
                Route {
                    index = i == 0
                    path = key
                    element = Component.create()
                }
            }

            Route {
                path = "*"
                element = Typography.create { +"404 Page Not Found" }
            }
        }
    }
}
