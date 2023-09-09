package event

class EventManager {

    private  val listeners = mutableListOf<EventListener>()

    fun addListener(listener: EventListener){
        listeners.add(listener)
    }

    fun removeListener(listener: EventListener){
        listeners.remove(listener)
    }

    fun dispatchEvent(event: Event){
        for(listener in listeners){
            listener.onEvent(event)
        }
    }
}