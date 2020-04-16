package engine.modules

import engine.utils.module.CModule

class ReflectionModule : CModule() {
    fun <T : Any> construct(jsClass: JsClass<T>, vararg options: dynamic): T {
        return eval("new jsClass(...options)") as T
    }
}