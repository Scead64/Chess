package com.chess.models;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn extends Piece{

    public Pawn(String _color, int _location){
        this.color = _color;
        this.location = _location;
        try{
            this.pieceImage = new Image("chess_" + this.color + "_pawn.png");
            this.pieceImageView = new ImageView(this.pieceImage);
            this.pieceImageView.setPreserveRatio(true);
        } catch(Exception e) {
            System.out.println("Error creating pawn image");
        }
    }
    
    public ArrayList<Integer> getMoves(Board board){
        ArrayList<Integer> moves = new ArrayList<>();
        int move = this.location-8;
        if(this.color.equals("black")){
            move +=16;
        }
        
        if((this.location%8 != 0) && board.getSquare(move - 1).hasPiece() && !board.getSquare(move - 1).getPiece().getColor().equals(this.color)){
            moves.add(move-1);
        }
        if((this.location%8 != 7) && board.getSquare(move + 1).hasPiece() && !board.getSquare(move + 1).getPiece().getColor().equals(this.color)){
            moves.add(move+1);
        }
        if(!board.getSquare(move).hasPiece()){
            moves.add(move);
            if(this.color.equals("white") && (this.location/8 == 6) && !board.getSquare(move-8).hasPiece()){
                moves.add(move-8);
            } else if(this.color.equals("black") && (this.location/8 == 1) && !board.getSquare(move+8).hasPiece()){
                moves.add(move+8);
            }
        }
        return moves;
    }
}