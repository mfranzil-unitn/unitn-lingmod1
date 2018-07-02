package esame201807;

import esame201807.figure.CerchioGiallo;
import esame201807.figure.EsagonoGiallo;
import esame201807.figure.TriangoloGiallo;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Controls extends GridPane {

    private Button add, removeBottom, removeTop, print;
    private ToggleButton circle, triangle, hexagon;
    private CellContainer cellContainer;
    private ToggleGroup tg;

    public Controls(ContainerStack stack) {
        add = new Button("Add");
        removeBottom = new Button("Remove Bottom");
        removeTop = new Button("Remove top");
        print = new Button("Print");

        circle = new ToggleButton("Circle");
        triangle = new ToggleButton("Triangle");
        hexagon = new ToggleButton("Hexagon");

        tg = new ToggleGroup();
        circle.setToggleGroup(tg);
        triangle.setToggleGroup(tg);
        hexagon.setToggleGroup(tg);

        cellContainer = new CellContainer();
        cellContainer.setTranslateX(100);

        add.setPrefWidth(120);
        removeBottom.setPrefWidth(120);
        removeTop.setPrefWidth(120);
        print.setPrefWidth(120);

        circle.setPrefWidth(80);
        triangle.setPrefWidth(80);
        hexagon.setPrefWidth(80);


        add(add, 0, 0, 3, 1);
        add(removeBottom, 3, 0, 3, 1);
        add(removeTop, 0, 1, 3, 1);
        add(print, 3, 1, 3, 1);
        add(cellContainer, 0, 2, 1, 1);
        add(circle, 0, 4, 2, 1);
        add(triangle, 2, 4, 2, 1);
        add(hexagon, 4, 4, 2, 1);

        setPadding(new Insets(50, 0, 0, 10));

        circle.setOnAction(e -> {
            cellContainer.removeFigura();
            cellContainer.setFigura(new CerchioGiallo());
        });
        hexagon.setOnAction(e -> {
            cellContainer.removeFigura();
            cellContainer.setFigura(new EsagonoGiallo());
        });

        triangle.setOnAction(e -> {
            cellContainer.removeFigura();
            cellContainer.setFigura(new TriangoloGiallo());
        });

        add.setOnAction(e -> {
            try {
                Shape temp = cellContainer.getFigura();

                FadeTransition ft = new FadeTransition();
                ft.setFromValue(0.0);
                ft.setToValue(1.0);
                ft.setDuration(Duration.seconds(1));
                ft.setNode(temp);
                ft.play();

                cellContainer.removeFigura();

                stack.push(temp);
                tg.getSelectedToggle().setSelected(false);
            } catch (NullPointerException ex) {
                new Alert(Alert.AlertType.ERROR, "Nessuna figura selezionata!").showAndWait();
            }
        });

        removeTop.setOnAction(e -> stack.popTop());

        removeBottom.setOnAction(e -> stack.popBottom());

        print.setOnAction(e -> stack.print());
    }
}
