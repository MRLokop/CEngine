package engine.utils
private class MAPS {
    companion object {

        fun toMap(container: dynamic): Map<Any, Any> {
            val m = HashMap<Any, Any>()
            val cb = { key: dynamic, value: dynamic ->
                m[key as Any] = value as Any
            }
            val toMap = this::toMap

            eval(""" 
            for (const a in container) { 
                if (a.startsWith("$$"))
                    continue;
                const value = container[a];
                    if (typeof value !== "object" && !Array.isArray(value)) {
                        cb(a, value)
                    } else {
                        cb(a, toMap(value))
                    }
            }
    """.trimIndent())

            fun processArrays(map: Map<*, *>) : MutableMap<Any, Any>{
                val result = mutableMapOf<Any, Any>()
                map.forEach {
                    if (it.value != null) {
                        if (it.value is Map<*, *>) {
                            if ((it.value as Map<*, *>).isNotEmpty()) {
                                var isArray: Boolean? = undefined;

                                (it.value as Map<*, *>).forEach {
                                    if (it.value != null) {
                                        val key = it.key.toString().toIntOrNull()
                                        if (key == null) {
                                            isArray = false;
                                        } else {
                                            if (isArray == undefined) {
                                                isArray = true;
                                            }
                                        }
                                    }
                                }

                                if (isArray == false) {
                                    result.put(it.key.toString(), processArrays(it.value as Map<*, *>));
                                } else if (isArray == true){
                                    val l = mutableListOf<Any>()
                                    (it.value as Map<*, *>).forEach {
                                        if (it.value != null) {
                                            l.add(it.value!!);
                                        }
                                    }
                                    result.put(it.key.toString(), l);
                                }
                            }
                        } else {
                            result.put(it.key.toString(), it.value!!)
                        }
                    }
                }
                return result;
            }
            return processArrays(m)
        }

    }
}
private val keys = js("Object.keys")
fun toMap(container: dynamic): Map<Any, Any> {
    return MAPS.toMap(container)
}

fun Map<*, *>.encode(cPath: String = ""): MutableMap<String, Any> {
    val r = mutableMapOf<String, Any>()

    this.forEach {
        val p = if (cPath.isEmpty()) it.key.toString() else "$cPath.${it.key}"

        if (it.value is Map<*, *>) {
            r.putAll((it.value as Map<*, *>).encode(p))
        } else {
            r[p] = it.value!!
        }
    }

    return r
}

fun Map<*, *>.decode(): MutableMap<String, Any> {
    val r = mutableMapOf<String, Any>()

    this.forEach {
        var c: MutableMap<String, Any> = r
        val splited = it.key.toString().split(".")
        var cId = 0
        splited.forEach { chunk ->
            val isLast = cId == splited.size - 1
            if (isLast) {
                c[splited.last()] = it.value!!
            } else {
                if (!c.containsKey(chunk))
                    c[chunk] = mutableMapOf<String, Any>()

                c = c[chunk] as MutableMap<String, Any>
            }
            cId++
        }
    }
    fun processArrays(map: Map<*, *>) : MutableMap<String, Any>{
        val result = mutableMapOf<String, Any>()
        map.forEach {
            if (it.value != null) {
                if (it.value is Map<*, *>) {
                    if ((it.value as Map<*, *>).isNotEmpty()) {
                        var isArray: Boolean? = undefined;

                        (it.value as Map<*, *>).forEach {
                            if (it.value != null) {
                                val key = it.key.toString().toIntOrNull()
                                if (key == null) {
                                    isArray = false;
                                } else {
                                    if (isArray == undefined) {
                                        isArray = true;
                                    }
                                }
                            }
                        }

                        if (isArray == false) {
                            result.put(it.key.toString(), processArrays(it.value as Map<*, *>));
                        } else if (isArray == true){
                            val l = mutableListOf<Any>()
                            (it.value as Map<*, *>).forEach {
                                if (it.value != null) {
                                    l.add(it.value!!);
                                }
                            }
                            result.put(it.key.toString(), l);
                        }
                    }
                } else {
                    result.put(it.key.toString(), it.value!!)
                }
            }
        }
        return result;
    }
    return processArrays(r);
}
