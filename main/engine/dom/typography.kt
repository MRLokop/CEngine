package engine.dom

import engine.utils.CBaseProps
import engine.utils.dom.CBuilder
import org.w3c.dom.Element


/**
 *
 *  COMPONENT: H1
 *  -> BASE: h1
 *  -> File: typography.kt
 *  -> Generated at: 2020-04-12, вс, 16:29
 *  @author mrlokop
 *
 */
class H1(me: Element, private val cb: H1_RenderCB) : CBuilder<H1Props>(me) {

    init {
        init(H1Props(this)) // Props init
    }

    override fun render() {
        cb() // Render cb call
    }

}
typealias H1_RenderCB = H1.() -> Unit; // RENDER CB TYPE

class H1Props(el: H1) : CBaseProps(el) { /* Add something if need */ }

fun CBuilder<*>.h1(cb: H1_RenderCB): CBuilder<H1Props> {
    val element = this.mkEl("h1") // New element
    val d = H1(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}

/**
 *
 *  COMPONENT: H2
 *  -> BASE: h2
 *  -> File: typography.kt
 *  -> Generated at: 2020-04-12, вс, 16:29
 *  @author mrlokop
 *
 */
class H2(me: Element, private val cb: H2_RenderCB) : CBuilder<H2Props>(me) {

    init {
        init(H2Props(this)) // Props init
    }

    override fun render() {
        cb() // Render cb call
    }

}
typealias H2_RenderCB = H2.() -> Unit; // RENDER CB TYPE

class H2Props(el: H2) : CBaseProps(el) { /* Add something if need */ }

fun CBuilder<*>.h2(cb: H2_RenderCB): CBuilder<H2Props> {
    val element = this.mkEl("h2") // New element
    val d = H2(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}

/**
 *
 *  COMPONENT: H3
 *  -> BASE: h3
 *  -> File: typography.kt
 *  -> Generated at: 2020-04-12, вс, 16:29
 *  @author mrlokop
 *
 */
class H3(me: Element, private val cb: H3_RenderCB) : CBuilder<H3Props>(me) {

    init {
        init(H3Props(this)) // Props init
    }

    override fun render() {
        cb() // Render cb call
    }

}
typealias H3_RenderCB = H3.() -> Unit; // RENDER CB TYPE

class H3Props(el: H3) : CBaseProps(el) { /* Add something if need */ }

fun CBuilder<*>.h3(cb: H3_RenderCB): CBuilder<H3Props> {
    val element = this.mkEl("h3") // New element
    val d = H3(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}

/**
 *
 *  COMPONENT: H4
 *  -> BASE: h4
 *  -> File: typography.kt
 *  -> Generated at: 2020-04-12, вс, 16:29
 *  @author mrlokop
 *
 */
class H4(me: Element, private val cb: H4_RenderCB) : CBuilder<H4Props>(me) {

    init {
        init(H4Props(this)) // Props init
    }

    override fun render() {
        cb() // Render cb call
    }

}
typealias H4_RenderCB = H4.() -> Unit; // RENDER CB TYPE

class H4Props(el: H4) : CBaseProps(el) { /* Add something if need */ }

fun CBuilder<*>.h4(cb: H4_RenderCB): CBuilder<H4Props> {
    val element = this.mkEl("h4") // New element
    val d = H4(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}

/**
 *
 *  COMPONENT: H5
 *  -> BASE: h5
 *  -> File: typography.kt
 *  -> Generated at: 2020-04-12, вс, 16:29
 *  @author mrlokop
 *
 */
class H5(me: Element, private val cb: H5_RenderCB) : CBuilder<H5Props>(me) {

    init {
        init(H5Props(this)) // Props init
    }

    override fun render() {
        cb() // Render cb call
    }

}
typealias H5_RenderCB = H5.() -> Unit; // RENDER CB TYPE

class H5Props(el: H5) : CBaseProps(el) { /* Add something if need */ }

fun CBuilder<*>.h5(cb: H5_RenderCB): CBuilder<H5Props> {
    val element = this.mkEl("h5") // New element
    val d = H5(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}

/**
 *
 *  COMPONENT: H6
 *  -> BASE: h6
 *  -> File: typography.kt
 *  -> Generated at: 2020-04-12, вс, 16:29
 *  @author mrlokop
 *
 */
class H6(me: Element, private val cb: H6_RenderCB) : CBuilder<H6Props>(me) {

    init {
        init(H6Props(this)) // Props init
    }

    override fun render() {
        cb() // Render cb call
    }

}
typealias H6_RenderCB = H6.() -> Unit; // RENDER CB TYPE

class H6Props(el: H6) : CBaseProps(el) { /* Add something if need */ }

fun CBuilder<*>.h6(cb: H6_RenderCB): CBuilder<H6Props> {
    val element = this.mkEl("h6") // New element
    val d = H6(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}

/**
 *
 *  COMPONENT: P
 *  -> BASE: p
 *  -> File: typography.kt
 *  -> Generated at: 2020-04-12, вс, 16:29
 *  @author mrlokop
 *
 */
class P(me: Element, private val cb: P_RenderCB) : CBuilder<PProps>(me) {

    init {
        init(PProps(this)) // Props init
    }

    override fun render() {
        cb() // Render cb call
    }

}
typealias P_RenderCB = P.() -> Unit; // RENDER CB TYPE

class PProps(el: P) : CBaseProps(el) { /* Add something if need */ }

fun CBuilder<*>.p(cb: P_RenderCB): CBuilder<PProps> {
    val element = this.mkEl("p") // New element
    val d = P(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}

/**
 *
 *  COMPONENT: Code
 *  -> BASE: code
 *  -> File: typography.kt
 *  -> Generated at: 2020-04-12, вс, 16:29
 *  @author mrlokop
 *
 */
class Code(me: Element, private val cb: Code_RenderCB) : CBuilder<CodeProps>(me) {

    init {
        init(CodeProps(this)) // Props init
    }

    override fun render() {
        cb() // Render cb call
    }

}
typealias Code_RenderCB = Code.() -> Unit; // RENDER CB TYPE

class CodeProps(el: Code) : CBaseProps(el) { /* Add something if need */ }

fun CBuilder<*>.code(cb: Code_RenderCB): CBuilder<CodeProps> {
    val element = this.mkEl("code") // New element
    val d = Code(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}

/**
 *
 *  COMPONENT: pre
 *  -> BASE: pre
 *  -> File: typography.kt
 *  -> Generated at: 2020-04-12, вс, 16:29
 *  @author mrlokop
 *
 */
class pre(me: Element, private val cb: pre_RenderCB) : CBuilder<preProps>(me) {

    init {
        init(preProps(this)) // Props init
    }

    override fun render() {
        cb() // Render cb call
    }

}
typealias pre_RenderCB = pre.() -> Unit; // RENDER CB TYPE

class preProps(el: pre) : CBaseProps(el) { /* Add something if need */ }

fun CBuilder<*>.pre(cb: pre_RenderCB): CBuilder<preProps> {
    val element = this.mkEl("pre") // New element
    val d = pre(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}
