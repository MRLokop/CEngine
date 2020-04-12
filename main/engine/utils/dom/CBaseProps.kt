package engine.utils

import engine.utils.dom.CBuilder
import engine.utils.dom.CProps

open class CBaseProps(protected val el: CBuilder<*>) : CProps() {
    var className: String
        get() {
            return el.element.className;
        }
        set(value) {
            el.element.className = value;
        }
}
