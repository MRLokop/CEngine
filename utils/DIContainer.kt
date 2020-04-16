package engine.utils

import kotlinx.coroutines.InternalCoroutinesApi
import kotlin.reflect.KClass

class DIContainer<FOR> {

    val container = mutableMapOf<String, FOR>()

    inline fun <reified T : FOR> getSecure(): T? =
            container[T::class.simpleName] as T?;

    inline fun <reified T : FOR> get(): T =
            getSecure<T>() ?: throw NullPointerException("Failed get modules \"" + T::class.simpleName + "\"")

    inline fun <reified T : FOR> get(module: String): T {
        try {
            return container[module] as T
        } catch (e: Throwable) {
            throw IllegalStateException("Failed get module \"$module\" as ${T::class.simpleName}")
        }
    }


    inline fun <reified T : FOR> put(module: T): T {
        container[T::class.simpleName as String] = module
        return module
    }

    inline fun <reified T : FOR> has(): Boolean {
        return has(T::class)
    }

    fun has(module: String): Boolean {
        return container.containsKey(module)
    }

    fun has(module: KClass<*>): Boolean {
        return container.containsKey(module.simpleName!!)
    }

    @Deprecated("For internal use only")
    fun __ForcePut(key: String, module: dynamic) {
        container[key] = module;
    }
}
