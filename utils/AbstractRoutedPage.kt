package engine.utils

import engine.eng
import engine.getModule
import engine.modules.RouterUtils

abstract class AbstractRoutedPage<P : RouterProps, S : react.RState> : AbstractComponent<P, S>() {

    override fun componentDidMount() {
        if (eng.modules.has(RouterUtils::class)) {
            getModule<RouterUtils>().history = props.history
        }
    }
}