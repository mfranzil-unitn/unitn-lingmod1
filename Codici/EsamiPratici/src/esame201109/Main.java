package esame201109;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Main extends Application {

    Griglia grigliaSx, grigliaDx;
    
    @Override
    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane();
        
        GridPane grids = new GridPane();
        Scene scene = new Scene(root);

        grigliaSx = new Griglia(true);
        grigliaDx = new Griglia(false);

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        column1.setPercentWidth(50);
        column2.setPercentWidth(50);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100);

        grids.getColumnConstraints().addAll(column1, column2);
        grids.getRowConstraints().add(row1);

        GridPane.setConstraints(grigliaSx, 0, 0);
        GridPane.setConstraints(grigliaDx, 1, 0);

        grids.setPadding(new Insets(20, 20, 20, 20));
        grids.setHgap(10);
        grids.setVgap(10);

        grids.getChildren().addAll(grigliaSx, grigliaDx);

        grids.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            try {
                Cella temp = (Cella) e.getTarget();
                if (temp.isWhiteOnly() && temp.isCurrentlyWhite()) {
                    grigliaDx.changeCell(GridPane.getRowIndex(temp), GridPane.getColumnIndex(temp));
                } else if (!temp.isWhiteOnly() && !temp.isCurrentlyWhite()) {
                    grigliaSx.changeCell(GridPane.getRowIndex(temp), GridPane.getColumnIndex(temp));
                }
            } catch (ClassCastException ex) {
                System.out.println("Cannot click on something else than a Cella");
            }
        });
        
        Button reset = new Button("Reset");
        reset.setOnAction((ActionEvent e) -> {
            grigliaSx.reset();
            grigliaDx.reset();
        });
        
        Button stampa = new Button("Stampa");
        stampa.setOnAction((ActionEvent e) -> {
            grigliaSx.print();
        });
        
        root.getChildren().addAll(stampa, reset, grids);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Griglie");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
