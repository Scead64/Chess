package com.chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

import com.chess.controllers.Controller;
import com.chess.models.Board;
import com.chess.views.View;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    


    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        scene = new Scene(root,  View.SQUARE_SIZE*Board.NUM_ROWS, View.SQUARE_SIZE*Board.NUM_ROWS, Color.CYAN);
        Image icon = new Image("Chess_tile_pl.png");
        stage.setTitle("Chess");
        stage.getIcons().add(icon);
        Controller.setBoard(root);


        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}