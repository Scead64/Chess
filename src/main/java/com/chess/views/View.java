package com.chess.views;

import com.chess.models.*;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class View {
    
    public static final int SQUARE_SIZE = 100;

    public static void drawBoard( Group root, Board board){
        System.out.println("Entering View Loop");
        for(int i = 0; i < Board.NUM_SQUARES; i++){
            Square sq = board.getSquare(i);
            int row = i / 8, col = i % 8;
            Rectangle squareDrawing = new Rectangle(SQUARE_SIZE*row,SQUARE_SIZE*col,SQUARE_SIZE,SQUARE_SIZE);
            if((row+i)%2 == 0){
                squareDrawing.setFill(Color.WHITE);
            } else {
                squareDrawing.setFill(Color.AQUA);
            }
            sq.setSquare(squareDrawing);
            root.getChildren().add(squareDrawing);
        }
        System.out.println("Exiting View Loop");
    }
}
