package it.franzil.javafx.test;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * @author matte
 */
class EventEcho implements EventHandler<Event> {

    private final Application outer;
    int counter = 0;

    EventEcho(final Application outer) {
        this.outer = outer;
    }

    @Override
    public void handle(Event t) {
        System.out.println(++counter + " Ricevuto evento del tipo " + t.getEventType());
    }

}
