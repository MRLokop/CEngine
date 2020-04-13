package engine.utils

import engine.CEngine
import engine.utils.module.CModule

abstract class CClass {
    protected val eng: CEngine
            get() = engine.eng;

    inline fun <reified module: CModule> getModule() : module {
        return engine.eng.getModule();
    }
}
