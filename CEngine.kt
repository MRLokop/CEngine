package engine

import engine.utils.CEngineConfigurator
import engine.utils.DIContainer
import engine.utils.module.CModule
import org.w3c.dom.HTMLStyleElement
import kotlin.browser.document

public lateinit var eng: CEngine
private var loaded: Boolean = false;

external fun require(module: String): dynamic;

class CEngine() {

    public var di = DIContainer<Any>();
    public var modules = DIContainer<CModule>();
    public var config = CEngineConfigurator(this);
    public var style: HTMLStyleElement = document.createElement("style") as HTMLStyleElement;

    init {
        if (loaded) {
            throw IllegalStateException("CEngine already created")
        }
        eng = this;
    }

    inline fun <reified T : CModule> getModuleSecure(): T? {
        return modules.getSecure<T>()
    }

    inline fun <reified T : CModule> getModule(): T {
        return modules.get()
    }

}

public inline fun <reified T : CModule> getModule(): T {
    return eng.getModule()
}
