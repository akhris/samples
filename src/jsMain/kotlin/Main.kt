import csstype.ClassName
import kotlinx.browser.document
import react.Fragment
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.h2


fun main() {
    val root = createRoot(document.getElementById("root") ?: error("Couldn't find root container!"))

    root.render(Fragment.create {
        h1 {
            +"Hello, React+Kotlin/JS!"
        }

        div{
            className = ClassName("mdc-card")
            div{
                className = ClassName("mdc-card__primary-action")

                div{
                    className = ClassName("mdc-card__media mdc-card__media--square")

                    div{
                        className = ClassName("mdc-card__media-content")
                        +"Title"
                    }
                }

            }

            div{
                className = ClassName("mdc-card__ripple")
            }
        }


    })
}


