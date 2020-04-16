package engine.modules

import engine.CEngine
import engine.utils.module.CModule
import org.w3c.dom.set
import kotlin.browser.document
import kotlin.browser.window

/**
 * UI Module
 * @repository https://github.com/TheMRLokopOff/UI
 */
class CUIModule : CModule() {

    var theme: String
        get() {
            return document.body!!.getAttribute("theme")!!
        }
        set(value) {
            document.body!!.setAttribute("theme", value)
            window.localStorage.set("theme", value);
        }
}