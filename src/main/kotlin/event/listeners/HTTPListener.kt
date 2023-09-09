package event.listeners

import event.Event
import event.EventListener
import event.EventType

class HTTPListener : EventListener {

    override fun onEvent(event: Event) {
        when(event.type){
            EventType.HTTPListener -> {
                println("HAAALLOOO")
            }
        }
    }
}