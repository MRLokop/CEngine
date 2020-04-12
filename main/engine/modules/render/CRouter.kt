package engine.modules.render

import engine.filters.AbstractFilter
import engine.pages.AbstractPage
import engine.pages.Router
import engine.utils.dom.CBuilder
import engine.utils.getClass
import engine.utils.module.CModule
import kotlin.browser.window

class CRouter(val comp: Router) : CModule() {

    private val pageByStatus = mutableMapOf<String, Route>()
    private val pageByInt = mutableMapOf<Number, MutableMap<String, Route>>()
    private val pageByPath = mutableMapOf<String, Route>()

    fun registerPath(_p: String, route: Route) {
        var path = _p
        if (path.startsWith("/")) {
            path = path.substring(1)
        }
        if (path.endsWith("/")) {
            path = path.substringBeforeLast("/")
        }
        if (path.contains("{{") && path.contains("}}")) {
            val i = path.split("/").size
            if (!pageByInt.containsKey(i))
                pageByInt[i] = mutableMapOf()
            pageByInt[i]!![path] = route
        } else {
            console.log("Register page [type : path], ", path, route)
            pageByPath[path] = route
        }
    }

    fun update(cb: (comp: CBuilder<*>?) -> Unit) {
        update(window.location.href.replace(window.location.origin, ""), cb)
    }

    fun update(_p: String, cb: (comp: CBuilder<*>?) -> Unit) {
        try {
            var path = _p
            if (path.startsWith("/")) {
                path = path.substring(1)
            }
            if (path.endsWith("/")) {
                path = path.substringBeforeLast("/")
            }
            console.log("CheckPath", path)
            if (pageByPath.containsKey(path)) {
                cb(pageByPath[path]!!.process(path, mutableMapOf()))
            } else {
                val i = path.split("/").size
                if (pageByInt.containsKey(i)) {
                    var o = false
                    val sp = path.split("/")
                    pageByInt[i]!!.forEach {
                        if (!o) {

                            var id = 0
                            var ok = true
                            val args = mutableMapOf<String, String>()
                            it.key.split("/").forEach {
                                if (!ok)
                                    return@forEach

                                if (it.startsWith("{{") && it.endsWith("}}")) {
                                    args[it.substring(2, it.length - 2)] = sp[id];
                                } else {
                                    if (it != sp[id]) {
                                        ok = false
                                    }
                                }
                                id++
                            }

                            if (ok) {
                                cb(it.value.process(path, args))
                                o = true
                            } else {
                                throw Exception("Failed route");
                            }
                        }

                    }

                    if (!o) {
                        processNotFound(path)
                        cb(null)
                    }
                } else {
                    processNotFound(path)
                    cb(null)
                }
            }
        } catch (e: Throwable) {
            throw Error(e.asDynamic().stack as String);
        }
    }

    fun processStatus(path: String, status: String) {
        console.log("Status", status)
        if (pageByStatus.containsKey(status)) {
            pageByStatus[status]!!.process(path, mutableMapOf("status" to status))
        } else {
            console.error("Failed to route page")
        }
    }

    fun processNotFound(path: String) {
        processStatus(path, "router.error.pageNotFound")
    }

    fun navigate(to: String) {
        var path = to;
        if (path.startsWith("/")) {
            path = path.substring(1)
        }
        if (path.endsWith("/")) {
            path = path.substringBeforeLast("/")
        }
        window.history.pushState(
            path,
            "??? - Cosmic",
            (if (window.location.origin.endsWith("/")) window.location.origin else window.location.origin + "/") + to
        )
        comp.rerender()
    }

    class Route(/* private val data: Map<*, *> */ val page: AbstractPage,
                                                  val filters: List<AbstractFilter> = listOf(),
                                                  val data: MutableMap<*, *> = mutableMapOf<String, String>()
    ) {

        fun process(path: String, args: Map<String, String>): CBuilder<*>? {
            var s = true
            filters.forEach {
                if (!s)
                    return@forEach;
                val res = it.doFilter(path, data)
                if (!res.ok) {
                    return res.redirectTo;
                } else {
                    return undefined;
                }
            }

            if (s) {
                try {
                    return page.component
                } catch (t: Throwable) {
                    console.error(t)
                }
            } else {
                return undefined;
            }
            return undefined;
        }
    }
}
