package engine.api

import org.w3c.dom.events.Event
import org.w3c.xhr.XMLHttpRequest

class Request {
    var url: String = "";
    var method: String = "post";
    var headers = mutableMapOf<String, String>()
    var body: dynamic = undefined;

    private var requester: XMLHttpRequest = XMLHttpRequest();


    constructor() {}
    constructor(url: String) : this() {
        this.url = url;
    }
    constructor(url: String, method: String) : this(url) {
        this.method = method;
    }


    fun run(cb: (ok: Boolean, data: XMLHttpRequest, event: Event) -> Unit) {
        requester.onerror = {
            cb(false, requester, it)
        }
        requester.onloadend = {
            cb(true, requester, it)
        }
        requester.open(method, url);
        requester.send(body)
    }
}
fun <T> XMLHttpRequest.json() : T {
    return JSON.parse(responseText)
}
