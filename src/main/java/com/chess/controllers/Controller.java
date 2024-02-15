package com.chess.controllers;


import com.chess.models.Board;
import com.chess.views.View;

import javafx.scene.Group;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
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
        // for(int i = 0; i < View.NUM_SQUARES; i++){
        //     Rectangle sq = board.getSquare(i).getSquare();
        //     // sq.setOnMouseClicked(e -> sq.setFill(Color.BLACK));
        // }
    }
    // EventHandler<MouseEvent> handleMouseClick = new EventHandler() {
        
    // }
}
