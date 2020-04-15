package engine.utils

import react.RProps

external interface RouterProps : RProps {
    var match: RouterMatched;
    var location: RouterLocation;
    var history: RouterHistory;
}
external interface RouterMatched {
    var isExact: Boolean;
    var params: dynamic;
    var path: String;
    var url: String;
}
external interface RouterLocation {
    var hash: String;
    var key: String;
    var pathname: String;
    var search: String;
    var state: dynamic
}
external interface RouterHistory {
    var action: String
    var block: (prompt: dynamic) -> Unit;
    fun createHref(location: dynamic);
    fun go(n: dynamic);
    fun goBack();
    fun goForward()
    var length: Number
    fun listen(listener: dynamic);
    var location: RouterLocation
    fun push(path: dynamic, state: dynamic);
    fun replace(path: dynamic, state: dynamic)
}