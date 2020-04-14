package engine.utils

import engine.require
import kotlin.js.Console

val __data = toMap(require("./kotlinApp")).encode()

class ClassNotFoundException(message: String?) : Exception(message)

fun getClass(pack: String): ReflectionClass {
    if (!__data.containsKey(pack))
        throw ClassNotFoundException("Class '$pack' not found!")
    return ReflectionClass(__data[pack])
}

fun timeout(time: Number, cb: () -> Unit?) {
    setTimeout(cb, time)
}

external fun setTimeout(cb: () -> Unit?, time: Number)
fun Try(dump: Boolean = false, callback: () -> dynamic) {
    try {
        callback()
    } catch (e: Throwable) {
        if (dump) {
            console.error(e)
        }
    }
}


fun <K, V> Map<K, V>.asObject(): dynamic {
    val obj = js("{}")
    this.forEach {
        if (it.value is Map<*, *>) {
            obj[it.key] = (it.value as Map<*, *>).asObject()
        } else if (it.value is List<*>) {
            obj[it.key] = (it.value as List<*>).asObject()
        } else {
            obj[it.key] = it.value
        }
    }
    return obj
}


fun <V> List<V>.asObject(): dynamic {
    val obj = js("[]")
    this.forEach {
        if (it is Map<*, *>) {
            obj.push((it as Map<*, *>).asObject())
        } else if (it is List<*>) {
            obj.push((it as List<*>).asObject())
        } else {
            obj.push(it)
        }
    }
    return obj
}

inline fun jsObject(init: dynamic.() -> Unit): dynamic {
    val o = js("{}")
    init(o)
    return o
}


class ReflectionClass(val data: dynamic) {
    fun new(vararg args: dynamic): dynamic {
        val a = data
        val b = args
        return eval("new a(...b)")
    }

    fun metadata(): dynamic {
        return data.asDynamic().`$metadata$`
    }
}

val String.black: String
    get() = this.asDynamic().black ?: this

val String.bgBlack: String
    get() = this.asDynamic().bgBlack ?: this

val String.red: String
    get() = this.asDynamic().red ?: this

val String.bgRed: String
    get() = this.asDynamic().bgRed ?: this

val String.green: String
    get() = this.asDynamic().green ?: this

val String.bgGreen: String
    get() = this.asDynamic().bgGreen ?: this

val String.yellow: String
    get() = this.asDynamic().yellow ?: this

val String.bgYellow: String
    get() = this.asDynamic().bgYellow ?: this

val String.blue: String
    get() = this.asDynamic().blue ?: this

val String.bgBlue: String
    get() = this.asDynamic().bgBlue ?: this

val String.magenta: String
    get() = this.asDynamic().magenta ?: this

val String.bgMagenta: String
    get() = this.asDynamic().bgMagenta ?: this

val String.cyan: String
    get() = this.asDynamic().cyan ?: this

val String.bgCyan: String
    get() = this.asDynamic().bgCyan ?: this

val String.lightGray: String
    get() = this.asDynamic().lightGray ?: this

val String.bgLightGray: String
    get() = this.asDynamic().bgLightGray ?: this

val String.default: String
    get() = this.asDynamic().default ?: this

val String.bgDefault: String
    get() = this.asDynamic().bgDefault ?: this

val String.darkGray: String
    get() = this.asDynamic().darkGray ?: this

val String.bgDarkGray: String
    get() = this.asDynamic().bgDarkGray ?: this

val String.lightRed: String
    get() = this.asDynamic().lightRed ?: this

val String.bgLightRed: String
    get() = this.asDynamic().bgLightRed ?: this

val String.lightGreen: String
    get() = this.asDynamic().lightGreen ?: this

val String.bgLightGreen: String
    get() = this.asDynamic().bgLightGreen ?: this

val String.lightYellow: String
    get() = this.asDynamic().lightYellow ?: this

val String.bgLightYellow: String
    get() = this.asDynamic().bgLightYellow ?: this

val String.lightBlue: String
    get() = this.asDynamic().lightBlue ?: this

val String.bgLightBlue: String
    get() = this.asDynamic().bgLightBlue ?: this

val String.lightMagenta: String
    get() = this.asDynamic().lightMagenta ?: this

val String.bgLightMagenta: String
    get() = this.asDynamic().bgLightMagenta ?: this

val String.lightCyan: String
    get() = this.asDynamic().lightCyan ?: this

val String.bgLightCyan: String
    get() = this.asDynamic().bgLightCyan ?: this

val String.white: String
    get() = this.asDynamic().white ?: this

val String.bgWhite: String
    get() = this.asDynamic().bgWhite ?: this

val String.bgBrightRed: String
    get() = this.asDynamic().bgBrightRed ?: this

val String.bgBrightGreen: String
    get() = this.asDynamic().bgBrightGreen ?: this

val String.bgBrightYellow: String
    get() = this.asDynamic().bgBrightYellow ?: this

val String.bgBrightBlue: String
    get() = this.asDynamic().bgBrightBlue ?: this

val String.bgBrightMagenta: String
    get() = this.asDynamic().bgBrightMagenta ?: this

val String.bgBrightCyan: String
    get() = this.asDynamic().bgBrightCyan ?: this

val String.bright: String
    get() = this.asDynamic().bright ?: this

val String.dim: String
    get() = this.asDynamic().dim ?: this

val String.italic: String
    get() = this.asDynamic().italic ?: this

val String.underline: String
    get() = this.asDynamic().underline ?: this

val String.inverse: String
    get() = this.asDynamic().inverse ?: this

fun Console.log(vararg a: dynamic) {
    console.log(*a);
}

fun CharSequence.maxLength(maxSize: Int = 46, add: CharSequence = "..."): String {
    if (this.length > maxSize)
        return substring(0, maxSize) + add
    else
        return this.toString();

}
