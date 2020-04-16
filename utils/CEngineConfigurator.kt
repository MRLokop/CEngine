package engine.utils

import engine.CEngine
import engine.modules.CUIModule
import engine.modules.FormModule
import engine.modules.RouterUtils

class CEngineConfigurator(private val eng: CEngine) {
    var appPacckage: String = "app";

    fun installRouterUtils() = eng.getModule<RouterUtils>()
    fun installFrom() = eng.getModule<FormModule>()
    fun installCUI() = eng.getModule<CUIModule>()
}
