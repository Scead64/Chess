package com.chess.views;

import com.chess.models.*;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class View {
    public static final int NUM_SQUARES = 64;
    public static final int NUM_ROWS = 8;
    public static final int SQUARE_SIZE = 100;

    public static void drawBoard( Group root, Board board){
        for(int i = 0; i < NUM_SQUARES; i++){
            Square sq = board.getSquare(i);
            int row = i / 8, col = i % 8;
            Rectangle squareDrawing = new Rectangle(SQUARE_SIZE*row,SQUARE_SIZE*col,SQUARE_SIZE,SQUARE_SIZE);
            if(i%2 == 0){
                squareDrawing.setFill(Color.WHITE);
            } else {
                squareDrawing.setFill(Color.AQUA);
            }
            sq.setSquare(squareDrawing);
            root.getChildren().add(squareDrawing);
        }
    }
}
