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
        
        if(!board.getSquare(move).hasPiece()){
            moves.add(move);
            
            //Check if pawn has not moved yet
            if(this.color.equals("white") && (this.location/8 == 6)){
                move-=8;
                if(!board.getSquare(move).hasPiece()){
                    moves.add(move);
                }
            } else if (this.location/8 == 1){
                move+=8;
                if(!board.getSquare(move).hasPiece()){
                    moves.add(move);
                }
            }
        }
        return moves;
    }
}