package com.chess.controllers;


import com.chess.models.Board;
import com.chess.models.Square;
import com.chess.views.View;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.scene.shape.Rectangle;

public class Controller {
    // public final Region view;

    public Controller() {

    }

    public static void setBoard(Group root){
        Board board = new Board();
        System.out.println("Entering View");
        View.drawBoard(root, board);
        System.out.println("Exiting View");

        View.drawPieces(board);
        for(int i = 0; i < Board.NUM_SQUARES; i++){
            Square sq = board.getSquare(i);
            sq.getPane().setOnMouseClicked(e -> {
                int loc = sq.getLocation() + 8;
                if(loc > 63){
                    loc = loc-63;
                }
                board.getSquare(loc).getSquare().setFill(Color.BLACK);
                System.out.println(sq.hasPiece());
            });
        }
    }
    
    public static void selectSquare(){
        
    }
}
