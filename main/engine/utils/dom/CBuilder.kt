package engine.utils.dom

import engine.dom.Div
import engine.utils.CBaseProps
import org.w3c.dom.Element
import kotlin.browser.document
import kotlin.dom.clear

abstract class CBuilder<Props : CProps>(val element: Element) {

    val childs = mutableListOf<CBuilder<*>>()
    lateinit var props: Props;
    fun init(props: Props) {
        this.props = props;
    }

    abstract fun render();
    fun rerender() {
        childs.forEach {
            it.unmount(element);
            childs.remove(it);
        }
        render();
        //console.log("[",getId(),"] has " + childs.size)
        childs.forEach {
            it.rerender();
            //console.log("Mounting [", it.getId(), "] to [", getId(), "]")
            it.mount(element);
        }
    }

    fun props(cb: Props.() -> Unit) {
        cb(props)
    }

    operator fun String.unaryPlus() {
        element.textContent = this;
    }

    operator fun List<CBuilder<*>>.unaryPlus() {
        forEach {
            childs.add(it);
            it.rerender();
            it.mount(element);
        }
    }


    /**
     * Mount this component
     * to element
     */
    private fun mount(to: Element) {
        this.componentWillMount();
        to.appendChild(element);
        this.componentDidMount();
    }
    /**
     * Mount this component
     * to element
     */
    private fun unmount(from: Element) {
        if (element.parentElement == from) {
       //     console.log("[", element, "]\tunmounting from\t[", from, "]")
            from.removeChild(element);
        }
    }

    /**
     * override this method
     */
    open fun componentDidMount() {}

    /**
     * override this method
     */
    open fun componentWillMount() {}


    fun getId(): String {
        var id = element.tagName;
        if (this.props is CBaseProps) {
            val baseProps = (this.props as CBaseProps)
            if (baseProps.className.isNotEmpty()) {
                id += "." + baseProps.className.replace(" ", ".")
            }
        }
        return id;
    }

    fun mkEl(el: String) : Element {
        return document.createElement(el);
    }

    fun getElements(cb: CBuilder<*>.() -> Unit) : List<CBuilder<*>> {
        val wrapper = Div(mkEl("div"), cb);
        wrapper.render();
        return wrapper.childs;
    }
    fun getElement(cb: CBuilder<*>.() -> Unit) : CBuilder<*> {
        val wrapper = Div(mkEl("div"), cb);
        wrapper.render();
        return wrapper.childs[0]
    }
}
