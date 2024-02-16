package com.chess.controllers;


import com.chess.models.Board;
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
            StackPane sp = board.getSquare(i).getPane();
            Rectangle sq = board.getSquare(i).getSquare();
            sp.setOnMouseClicked(e -> {
                sq.setFill(Color.BLACK);
                System.out.println(sp.getLayoutX() + " " + sp.getLayoutY());
            });
        }
    }
    
    public static void selectSquare(){
        
    }
}
