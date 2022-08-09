package modules

import hooks.useScreens
import navigation.screens.Screens
import react.FC
import react.PropsWithChildren
import react.createContext

val ScreensContext = createContext<Screens>()

val ScreensModule = FC<PropsWithChildren> { props ->
    val screens = useScreens()

    ScreensContext(screens) {
        +props.children
    }
}