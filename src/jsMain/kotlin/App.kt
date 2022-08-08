import kotlinx.browser.document
import mui.material.*
import mui.material.styles.TypographyVariant
import react.FC
import react.Props
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML.div


fun main() {
    createRoot(document.createElement("div").also { document.body!!.appendChild(it) })
        .render(App.create())
//    val root = createRoot(document.getElementById("root") ?: error("Couldn't find root container!"))
//    root.render(App.create())

//    root.render(Fragment.create {
//        h1 {
//            +"Hello, React+Kotlin/JS!"
//        }
//
//
//
//    })
}

private val App = FC<Props>{
//    HashRouter{
//       CardsShowcase
//    }

    Card {
        CardContent {
            Typography {
                // TODO: Unable set color legally [MUI]
                asDynamic().color = "text.secondary"
                gutterBottom = true
                +"Word of the Day"
            }
            Typography {
                component = div
                variant = TypographyVariant.h5

                +"be"
//                Bull()
                +"nev"
//                Bull()
                +"o"
//                Bull()
                +"lent"
            }
        }
        CardActions {
            Button {
                size = Size.small
                +"Learn More"
            }
        }
    }
}


