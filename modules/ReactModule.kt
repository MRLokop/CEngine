package engine.modules

import engine.utils.module.CModule
import org.w3c.dom.Element
import react.RBuilder
import kotlin.browser.document

class ReactModule : CModule() {
    private var handler: RBuilder.() -> Unit = {};
    fun setRenderer(cb: RBuilder.() -> Unit): ReactModule {
        handler = cb;
        return this
    }

    private var first = true;


    var root: Element = document.getElementById("root")!!


    fun render() {
        react.dom.render(root) {
            handler()
        }
    }
}