package navigation.screens

import react.FC
import react.Props

data class Screen(
    val key: String,
    val name: String,
    val content: FC<Props>
)


val screenPersons = Screen(key = "persons", name = "Сотрудники", content = personsContent)
val screenPlaces = Screen(key = "places", name = "Места", content = placesContent)
val screenOperations = Screen(key = "operations", name = "Операции", content = operationsContent)
val screenMoves = Screen(key = "moves", name = "Перемещения", content = movesContent)
val screenSamples = Screen(key = "samples", name = "Образцы", content = samplesContent)


typealias Screens = Iterable<Screen>
