package engine.utils

import engine.CEngine

class CEngineConfigurator(private val eng: CEngine) {
    fun installRouter() : RouterUtils {
        val router = RouterUtils();
        eng.modules.put(router);
        return router;
    }

}
