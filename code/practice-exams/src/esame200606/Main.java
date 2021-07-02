package esame200606;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TextField x_yellow_coord = new TextField("75") {{
            setPrefWidth(50);
        }};
        TextField y_yellow_coord = new TextField("75") {{
            setPrefWidth(50);
        }};
        Text x_yellow_txt = new Text("Pannello giallo - X");
        Text y_yellow_txt = new Text("Pannello giallo - Y");

        TextField x_blue_coord = new TextField("75") {{
            setPrefWidth(50);
        }};
        TextField y_blue_coord = new TextField("75") {{
            setPrefWidth(50);
        }};
        Text x_blue_txt = new Text("Pannello blu - X");
        Text y_blue_txt = new Text("Pannello blu - Y");

        Button reset = new Button("Reset");
        Button caa = new Button("Cambia area attiva");
        Rectangle aa = new Rectangle(8, 8, Color.YELLOW);

        Button dx = new Button("->");
        Button sx = new Button("<-");
        Button su = new Button("^");
        Button giu = new Button("v");

        BorderPane root = new BorderPane();
        GridPane panel = new GridPane();
        RectangleArea area = new RectangleArea();

        panel.add(x_yellow_txt, 0, 0);
        panel.add(y_yellow_txt, 0, 1);
        panel.add(x_yellow_coord, 1, 0);
        panel.add(y_yellow_coord, 1, 1);
        panel.add(x_blue_txt, 2, 0);
        panel.add(y_blue_txt, 2, 1);
        panel.add(x_blue_coord, 3, 0);
        panel.add(y_blue_coord, 3, 1);
        panel.add(reset, 2, 2);
        panel.add(caa, 0, 2);
        panel.add(aa, 1, 2);
        panel.add(sx, 7, 0);
        panel.add(dx, 8, 0);
        panel.add(su, 7, 1);
        panel.add(giu, 8, 1);

        panel.setHgap(10);
        panel.setVgap(10);
        panel.setPadding(new Insets(10, 10, 10, 10));

        root.setCenter(area);
        root.setTop(panel);

        reset.setOnAction(e -> area.redraw(Integer.parseInt(x_yellow_coord.getText()),
                Integer.parseInt(y_yellow_coord.getText()),
                Integer.parseInt(x_blue_coord.getText()), Integer.parseInt(y_blue_coord.getText())));

        caa.setOnAction(e -> {
                    if (aa.getFill().equals(Color.YELLOW)) {
                        aa.setFill(Color.BLUE);
                        area.setBlueSelected(true);
                    } else {
                        aa.setFill(Color.YELLOW);
                        area.setBlueSelected(false);
                    }
                }
        );

        root.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case A:
                    sx.fire();
                    break;
                case S:
                    dx.fire();
                    break;
                case W:
                    su.fire();
                    break;
                case Z:
                    giu.fire();
                    break;
                default:
                    break;
            }
        });

        dx.setOnAction(e -> move(area, 0));
        sx.setOnAction(e -> move(area, 1));
        su.setOnAction(e -> move(area, 2));
        giu.setOnAction(e -> move(area, 3));


        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rettangoli");
        primaryStage.show();
    }

    public void move(RectangleArea area, int direction) {
        if (area.isBlueSelected()) {
            area.move(true, direction);
        } else {
            area.move(false, direction);
        }
    }
}
