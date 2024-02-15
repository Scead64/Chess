package com.chess.controllers;

import com.chess.models.Board;
import com.chess.views.View;

import javafx.scene.Group;
import javafx.scene.layout.Region;

public class Controller {
    // public final Region view;

    public Controller() {

    }

    public void setBoard(Group root){
        Board board = new Board();
        View.drawBoard(root, board);
    }
}
