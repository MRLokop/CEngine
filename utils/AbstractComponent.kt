package engine.utils

import react.RComponent
import react.RProps
import react.RState

abstract class AbstractComponent<P : react.RProps, S : react.RState> : RComponent<P, S>() {
}