import csstype.ClassName
import kotlinx.browser.document
import mui.material.Box
import mui.material.Card
import mui.material.CardHeader
import mui.material.Typography
import mui.system.sx
import react.FC
import react.Fragment
import react.Props
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.h2
import react.router.dom.HashRouter


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
       CardsShowcase
//    }
}


