package com.chess.models;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends Piece{

    public Rook(String _color, int _location){
        this.color = _color;
        this.location = _location;
        try{
            this.pieceImage = new Image("chess_" + this.color + "_rook.png");
            this.pieceImageView = new ImageView(this.pieceImage);
            this.pieceImageView.setPreserveRatio(true);
        } catch(Exception e) {
            System.out.println("Error creating rook image");
        }
    }
    
    public ArrayList<Integer> getMoves(Board board){
        return MoveHelper.getCardinals(this.location, this.color, board);
    }
}