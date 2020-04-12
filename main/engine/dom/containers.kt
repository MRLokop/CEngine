package engine.dom;

import engine.utils.CBaseProps
import engine.utils.dom.CBuilder
import org.w3c.dom.Element


/**
 *
 *  COMPONENT: Div
 *  -> BASE: div
 *  -> File: containers.kt
 *  -> Generated at: 2020-04-12, вс, 16:25
 *  @author mrlokop
 *
 */
class Div(me: Element, private val cb: Div_RenderCB) : CBuilder<DivProps>(me) {

    init {
        init(DivProps(this)) // Props init
    }

    override fun render() {
        cb() // Render cb call
    }

}
typealias Div_RenderCB = Div.() -> Unit; // RENDER CB TYPE

class DivProps(el: Div) : CBaseProps(el) { /* Add something if need */ }

fun CBuilder<*>.div(cb: Div_RenderCB): CBuilder<DivProps> {
    val element = this.mkEl("div") // New element
    val d = Div(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}

/**
 *
 *  COMPONENT: Span
 *  -> BASE: span
 *  -> File: containers.kt
 *  -> Generated at: 2020-04-12, вс, 16:25
 *  @author mrlokop
 *
 */
class Span(me: Element, private val cb: Span_RenderCB) : CBuilder<SpanProps>(me) {

    init {
        init(SpanProps(this)) // Props init
    }

    override fun render() {
        cb() // Render cb call
    }

}
typealias Span_RenderCB = Span.() -> Unit; // RENDER CB TYPE

class SpanProps(el: Span) : CBaseProps(el) { /* Add something if need */ }

fun CBuilder<*>.span(cb: Span_RenderCB): CBuilder<SpanProps> {
    val element = this.mkEl("span") // New element
    val d = Span(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}

