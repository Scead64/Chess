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

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static final int NUM_SQUARES = 64;
    public static final int NUM_ROWS = 8;
    public static final int SQUARE_SIZE = 100;


    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        scene = new Scene(root,  SQUARE_SIZE*NUM_ROWS, SQUARE_SIZE*NUM_ROWS, Color.BLACK);
        Image icon = new Image("Chess_tile_pl.png");
        
        stage.setTitle("Chess");
        stage.getIcons().add(icon);
        // stage.setResizable(false);
        // scene = new Scene(loadFXML("primary"), 640, 480);

        Rectangle[] squares = new Rectangle[64];
        for(int i = 0; i < NUM_ROWS; i++){
            for(int j = 0; j < NUM_ROWS; j++){
                int index = (i*NUM_ROWS)+j;
                squares[index] = new Rectangle(SQUARE_SIZE*j,SQUARE_SIZE*i,SQUARE_SIZE,SQUARE_SIZE);
                if((i+j) % 2 == 0){
                    squares[index].setFill(Color.WHITE);
                } else {
                    squares[index].setFill(Color.AQUA);
                }
                root.getChildren().add(squares[index]);
            }
        }

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