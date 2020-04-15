package engine.utils

import kotlin.reflect.KClass

class DIContainer<FOR> {

    val container = mutableMapOf<String, FOR>()

    inline fun <reified T : FOR> getSecure(): T? =
            container[T::class.simpleName] as T?;

    inline fun <reified T : FOR> get(): T =
            getSecure<T>() ?: throw NullPointerException("Failed get modules \"" + T::class.simpleName + "\n")

    inline fun <reified T : FOR> put(module: T): T {
        container[T::class.simpleName as String] = module
        return module
    }

    fun has(module: String): Boolean {
        return container.containsKey(module)
    }

    fun has(module: KClass<*>): Boolean {
        return container.containsKey(module.simpleName!!)
    }

}
