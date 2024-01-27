package com.antoniogarciaprats.tablero;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        HBox hb = new HBox(50);
        hb.setPadding(new Insets(50));

        GridPane board = new GridPane();
        for (int i=0; i<5; i++)
            for (int j=0; j<5; j++)
                board.add ( new Rectangle(50, 50,
                        Color.BEIGE), i,j);

        board.setGridLinesVisible(true);

        Circle circulo = new Circle( 20,
                Color.BROWN);
        board.add ( circulo, 3,2);
        GridPane.setHalignment(circulo,
                HPos.CENTER);

        GridPane panelControl = new GridPane();
        panelControl.setAlignment(Pos.CENTER);
        Button up = new Button("arriba");
        Button down = new Button("abajo");
        Button left = new Button("izquierda");
        Button right = new Button("derecha");

        panelControl.add (up, 1, 0);
        panelControl.add (down, 1, 2);
        panelControl.add (left, 0, 1);
        panelControl.add (right, 2, 1);

        GridPane.setHalignment(up, HPos.CENTER);
        GridPane.setValignment(up, VPos.CENTER);

        GridPane.setHalignment(down, HPos.CENTER);
        GridPane.setValignment(down, VPos.CENTER);

        GridPane.setHalignment(left, HPos.CENTER);
        GridPane.setValignment(left, VPos.CENTER);

        GridPane.setHalignment(right, HPos.CENTER);
        GridPane.setValignment(right, VPos.CENTER);

        panelControl.setHgap(10);
        panelControl.setVgap(10);

        up.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (GridPane.getRowIndex(circulo)>0)
                    GridPane.setRowIndex(circulo,
                            GridPane.getRowIndex(circulo)-1);
                else return;
            }
        });

        down.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (GridPane.getRowIndex(circulo)<4)
                    GridPane.setRowIndex(circulo,
                            GridPane.getRowIndex(circulo)+1);
                else return;
            }
        });

        left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (GridPane.getColumnIndex(circulo)>0)
                    GridPane.setColumnIndex(circulo,
                            GridPane.getColumnIndex(circulo)-1);
                else return;
            }
        });

        right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (GridPane.getColumnIndex(circulo)<4)
                    GridPane.setColumnIndex(circulo,
                            GridPane.getColumnIndex(circulo)+1);
                else return;
            }
        });

        hb.getChildren().addAll(panelControl, board);

        StackPane root = new StackPane();
        root.getChildren().add(hb);

        Scene display = new Scene(root);
        stage.setScene(display);
        stage.setTitle("Juego");
        stage.setResizable(false);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}