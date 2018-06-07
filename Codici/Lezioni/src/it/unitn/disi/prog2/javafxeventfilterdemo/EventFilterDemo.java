package it.unitn.disi.prog2.javafxeventfilterdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class EventFilterDemo extends Application {

    public void start(final Stage stage) {
        class SuperHandler implements EventHandler<ActionEvent> {

            SuperHandler() {
                super();
            }
            
            EventTarget target;
            Object source;
            String id;

            @Override
            public void handle(ActionEvent t) {
                target = t.getTarget();
                source = t.getSource();
                id = null;
                if (source instanceof Node) {
                    id = ((Node) source).getId();
                } else if (source instanceof Stage) {
                    id = "STAGE";
                } else if (source instanceof Scene) {
                    id = "SCENE";
                } else {
                    System.out.println("Unrecognized Object" + source);
                }
            }
        
        ;
        }
        SuperHandler filter = new SuperHandler() {
            @Override
            public void handle(ActionEvent t) {
                super.handle(t);
                System.out.println("FILTER:" + id + " " + source + " ==> " + target);
            }
        };
        SuperHandler handler = new SuperHandler() {
            @Override
            public void handle(ActionEvent t) {
                super.handle(t);
                System.out.println("HANDLER:" + id + " " + source + " ==> " + target);
            }
        };
        SuperHandler cutter = new SuperHandler() {
            @Override
            public void handle(ActionEvent t) {
                super.handle(t);
                System.out.println("CUTTER:" + id + " " + source + " ==> " + target);
                t.consume();
            }
        };
        TilePane layout = new TilePane();
        Button button = new Button("UNO");
        Button button2 = new Button("DUE");
        layout.getChildren().addAll(button, button2);
        Scene scene = new Scene(layout);

        layout.setId("STACKPANE");
        button.setId("BUTTON-1");
        button2.setId("BUTTON-2");

        scene.addEventFilter(ActionEvent.ACTION, filter);
        scene.addEventHandler(ActionEvent.ACTION, handler);
        stage.addEventFilter(ActionEvent.ACTION, filter);
        stage.addEventHandler(ActionEvent.ACTION, handler);
        layout.addEventFilter(ActionEvent.ACTION, filter);
        layout.addEventHandler(ActionEvent.ACTION, handler);
        button.addEventFilter(ActionEvent.ACTION, filter);
        button.addEventHandler(ActionEvent.ACTION, handler);
        button2.addEventFilter(ActionEvent.ACTION, filter);
        button2.addEventHandler(ActionEvent.ACTION, handler);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
