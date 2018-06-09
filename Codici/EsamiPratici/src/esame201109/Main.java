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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    Griglia grigliaSx, grigliaDx;

    @Override
    public void start(Stage primaryStage) {
        Button reset = new Button("Reset");
        Button stampa = new Button("Stampa");
        Text modeText = new Text("Uguale");
        Button modeButton = new Button("Modalità");

        GridPane root = new GridPane();
        FlowPane buttons = new FlowPane();
        Scene scene = new Scene(root);

        grigliaSx = new Griglia(true);
        grigliaDx = new Griglia(false);

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        column1.setPercentWidth(50);
        column2.setPercentWidth(50);

        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        row1.setPercentHeight(10);
        row2.setPercentHeight(90);

        root.getColumnConstraints().addAll(column1, column2);
        root.getRowConstraints().addAll(row1, row2);

        GridPane.setConstraints(grigliaSx, 0, 1);
        GridPane.setConstraints(grigliaDx, 1, 1);
        GridPane.setConstraints(reset, 0, 0);
        GridPane.setConstraints(stampa, 1, 0);
        GridPane.setConstraints(modeText, 2, 0);
        GridPane.setConstraints(modeButton, 3, 0);

        root.setPadding(new Insets(20, 20, 20, 20));
        root.setHgap(5);
        root.setVgap(5);

        root.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            try {
                Cella temp = (Cella) e.getTarget();
                modeButton.setDisable(true);
                int x = GridPane.getRowIndex(temp);
                int y = GridPane.getColumnIndex(temp);
                if (temp.isWhiteOnly() && temp.isCurrentlyWhite()) {
                    grigliaDx.changeCell(x, y);
                } else if (!temp.isWhiteOnly() && !temp.isCurrentlyWhite()) {
                    grigliaSx.changeCell(x, y);
                }
            } catch (ClassCastException ex) {
                System.out.println("Cannot click on something else than a Cella");
            }
        });

        reset.setOnAction((ActionEvent e) -> {
            grigliaSx.reset();
            grigliaDx.reset();
            modeButton.setDisable(false);
        });

        stampa.setOnAction((ActionEvent e) -> {
            grigliaSx.print();
        });

        modeButton.setOnAction((ActionEvent e) -> {
            if (!grigliaDx.isSpeculare()) {
                grigliaDx.setSpeculare(true);
                grigliaSx.setSpeculare(true);
                modeText.setText("Speculare");
            } else {
                grigliaDx.setSpeculare(false);
                grigliaSx.setSpeculare(true);
                modeText.setText("Uguale");
            }
        });

        buttons.getChildren().addAll(stampa, reset, modeText, modeButton);
        root.getChildren().addAll(buttons, grigliaSx, grigliaDx);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Griglie");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
