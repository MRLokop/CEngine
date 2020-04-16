package engine.modules

import engine.utils.module.CModule
import kotlinx.html.HtmlBlockTag
import kotlinx.html.id
import react.dom.RDOMBuilder
import kotlin.browser.document
import kotlin.random.Random

class FormModule : CModule() {
    @OptIn(ExperimentalStdlibApi::class)
    fun RDOMBuilder<HtmlBlockTag>.newForm() {
        val formID: String = attrs.id ?: Random.nextBytes(12).decodeToString();
        attrs.id = formID;
        FormObject(this, formID)
    }
}

class FormObject(val root: RDOMBuilder<HtmlBlockTag>, val id: String) {
    init {

    }


    fun get() {
        val data = mutableMapOf<String, Any>()
        val rootEl = document.getElementById(id) ?: throw NullPointerException("Failed to find form '$id'");


    }
}