package engine.filters

import engine.utils.dom.CBuilder

abstract class AbstractFilter {
    abstract fun doFilter(path: String, data: Map<*, *>) : FilterStatus
    class FilterStatus(val ok: Boolean) {
        var redirectTo: CBuilder<*>? = undefined;

        companion object {
            val OK = FilterStatus(true)
        }
    }
}
