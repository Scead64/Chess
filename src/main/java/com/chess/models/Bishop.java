package com.chess.models;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bishop extends Piece{

    public Bishop(String _color, int _location){
        this.color = _color;
        this.location = _location;
        try{
            this.pieceImage = new Image("chess_" + this.color + "_bishop.png");
            this.pieceImageView = new ImageView(this.pieceImage);
            this.pieceImageView.setPreserveRatio(true);
        } catch(Exception e) {
            System.out.println("Error creating bishop image");
        }
    }
    

    public ArrayList<Integer> getMoves(Board board){
        return MoveHelper.getOrdinals(this.location, this.color, board);
    }
}