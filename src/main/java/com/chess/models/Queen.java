package com.chess.models;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen extends Piece{

    public Queen(String _color, int _location){
        this.color = _color;
        this.location = _location;
        try{
            this.pieceImage = new Image("chess_" + this.color + "_queen.png");
            this.pieceImageView = new ImageView(this.pieceImage);
            this.pieceImageView.setPreserveRatio(true);
        } catch(Exception e) {
            System.out.println("Error creating queen image");
        }
    }
    

    public ArrayList<Integer> getMoves(Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        moves.addAll(MoveHelper.getCardinals(location, this.color, board));
        moves.addAll(MoveHelper.getOrdinals(location, this.color, board));
        return moves;
    }
}