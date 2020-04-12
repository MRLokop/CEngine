package engine

import engine.dom.Div
import engine.utils.CEngineConfigurator
import engine.utils.DIContainer
import engine.utils.dom.CBuilder
import engine.utils.module.CModule
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLStyleElement
import kotlin.browser.document
import kotlin.dom.clear

public lateinit var eng: CEngine
private var loaded: Boolean = false;

external fun require(module: String): dynamic;

class CEngine() {

    public var di = DIContainer<Any>();
    public var modules = DIContainer<CModule>();
    public var config = CEngineConfigurator(this);
    public lateinit var root: Div;
    public var style: HTMLStyleElement = document.createElement("style") as HTMLStyleElement;

    init {
        if (loaded) {
            throw IllegalStateException("CEngine already created")
        }
        eng = this;
        Div(document.createElement("div")) {
            root = this;

            if (document.body == null) {
                val body = document.createElement("body");
                document.appendChild(body);
                document.body = body as HTMLElement;
            }
            document.body!!.appendChild(style)
            document.body!!.appendChild(root.element)
            loaded = true;
        }.render();
    }

    inline fun <reified T : CModule> getModuleSecure(): T? {
        return modules.getSecure<T>()
    }

    inline fun <reified T : CModule> getModule(): T {
        return modules.get()
    }

    fun render(cb: CBuilder<*>.() -> CBuilder<*>) {
        val comp = cb(root)
        comp.rerender();
        root.element.clear();
        root.element.appendChild(comp.element)
        console.log("RenderedComponent", comp);
    }
}

public inline fun <reified T : CModule> getModule(): T {
    return eng.getModule()
}
