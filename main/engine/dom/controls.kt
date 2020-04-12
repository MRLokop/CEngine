package engine.dom

import engine.utils.CBaseProps
import engine.utils.dom.CBuilder
import org.w3c.dom.Element
import org.w3c.dom.HTMLImageElement


/**
 *
 *  COMPONENT: Button
 *  -> BASE: button
 *  -> File: controls.kt
 *  -> Generated at: 2020-04-12, вс, 16:24
 *  @author mrlokop
 *
 */
class Button(me: Element, private val cb: Button_RenderCB) : CBuilder<ButtonProps>(me) {

    init {
        init(ButtonProps(this)) // Props init
    }

    override fun render() {
        cb() // Render cb call
    }

}
typealias Button_RenderCB = Button.() -> Unit; // RENDER CB TYPE

class ButtonProps(el: Button) : CBaseProps(el) { /* Add something if need */ }

fun CBuilder<*>.button(cb: Button_RenderCB): CBuilder<ButtonProps> {
    val element = this.mkEl("button") // New element
    val d = Button(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}


/**
 *
 *  COMPONENT: Input
 *  -> BASE: input
 *  -> File: controls.kt
 *  -> Generated at: 2020-04-12, вс, 16:25
 *  @author mrlokop
 *
 */
class Input(me: Element, private val cb: Input_RenderCB) : CBuilder<InputProps>(me) {

    init {
        init(InputProps(this)) // Props init
    }

    override fun render() {
        cb() // Render cb call
    }

}
typealias Input_RenderCB = Input.() -> Unit; // RENDER CB TYPE

class InputProps(el: Input) : CBaseProps(el) { /* Add something if need */ }

fun CBuilder<*>.input(cb: Input_RenderCB): CBuilder<InputProps> {
    val element = this.mkEl("input") // New element
    val d = Input(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}


/**
 *
 *  COMPONENT: Img
 *  -> BASE: img
 *  -> File: controls.kt
 *  -> Generated at: 2020-04-12, вс, 19:12
 *  @author mrlokop
 *
 */
class Img(me: Element, private val cb: Img_RenderCB) : CBuilder<ImgProps>(me) {

    init {
        init(ImgProps(this)) // Props init
    }

    override fun render() {
        cb() // Render cb call
    }

}
typealias Img_RenderCB = Img.() -> Unit; // RENDER CB TYPE

class ImgProps(el: Img) : CBaseProps(el) {
    var src: String
        get() {
            return (el.element as HTMLImageElement).src;
        }
        set(value) {
            (el.element as HTMLImageElement).src = value;
        }
}

fun CBuilder<*>.img(cb: Img_RenderCB): CBuilder<ImgProps> {
    val element = this.mkEl("img") // New element
    val d = Img(element, cb)       // New RBuilder
    childs.add(d);                 // Add RBuilder as child
    return d;                      // Return result
}
