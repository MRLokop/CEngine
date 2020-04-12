package engine.pages

import engine.modules.render.CRouter
import engine.utils.CBaseProps
import engine.utils.dom.CBuilder
import org.w3c.dom.Element
import kotlin.browser.document


/**
 *
 *  COMPONENT: Router
 *  -> BASE: div
 *  -> File: Router.kt
 *  -> Generated at: 2020-04-12, вс, 20:23
 *  @author mrlokop
 *
 */
class Router(me: Element, private val cb: Router_RenderCB) : CBuilder<RouterProps>(me) {

    init {
        init(RouterProps(this)) // Props init
    }

    var notFound = listOf<CBuilder<*>>()

    override fun render() {
        cb() // Render cb call
        props.router.update {
            if (it != null) {
                console.log("Routed to", it)
                +listOf(it)
            } else {
                + notFound
            }
        }
    }

}
typealias Router_RenderCB = Router.() -> Unit; // RENDER CB TYPE

class RouterProps(el: Router) : CBaseProps(el) {
    val router = CRouter(el)
}

fun CBuilder<*>.router(cb: Router_RenderCB): CBuilder<RouterProps> {
    val element = this.mkEl("div") // New element
    val d = Router(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}
