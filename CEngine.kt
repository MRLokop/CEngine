package engine

import engine.modules.ReflectionModule
import engine.utils.CEngineConfigurator
import engine.utils.DIContainer
import engine.utils.module.CModule
import org.w3c.dom.HTMLStyleElement
import kotlin.browser.document
import kotlin.reflect.KClass

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
        eng.modules.put(ReflectionModule()) // Install reflection module
    }

    inline fun <reified T : CModule> getModuleSecure(): T? {
        return modules.getSecure<T>()
    }

    inline fun <reified T : CModule> getModule(): T {
        if (modules.has<T>()) {
            return modules.get()
        } else {
            val M = modules.get<ReflectionModule>(ReflectionModule::class.simpleName as String).construct(T::class.js)
            modules.put(M)
            return M;
        }
    }

    inline fun <reified T : CModule> installModule(): T {
        if (!modules.has<T>()) {
            val M = getModule<ReflectionModule>().construct(T::class.js)
            modules.put(M)
            return M;
        } else
            return modules.get()
    }

    inline fun <reified T : CModule> installModule(module: T) {
        modules.put(module)
    }

    fun installModules(vararg klasses: KClass<out CModule> = arrayOf()) {
        klasses.forEach {
            if (!this.modules.has(it)) {
                val module = getModule<ReflectionModule>().construct(it.js)
                this.modules.__ForcePut(it.simpleName as String, module)
            }
        }
    }

    fun <T> requireAppModule(module: String): T {
        return require("../../../src/${config.appPacckage}/$module") as T;
    }
}

public inline fun <reified T : CModule> getModule(): T {
    return eng.getModule()
}
