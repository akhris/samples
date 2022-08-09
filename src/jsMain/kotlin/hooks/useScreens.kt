package hooks

import navigation.screens.*
import react.useMemo

fun useScreens(): Screens =
    useMemo {
        setOf(
            screenSamples,
            screenPersons,
            screenPlaces,
            screenMoves,
            screenOperations
        )
    }