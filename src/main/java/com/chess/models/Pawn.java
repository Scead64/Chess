package com.chess.models;

import java.io.FileInputStream;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Pawn extends Piece{

    public Pawn(String _color, int _location){
        this.color = _color;
        this.location = _location;
        try{
            this.pieceImage = new Image(new FileInputStream("chess_" + this.color + "_pawn.png"));
            this.pieceImageView = new ImageView(this.pieceImage);
        } catch(Exception e) {
            System.out.println("Error creating pawn image");
        }
    }
    
    public ArrayList<Integer> getMoves(){
        ArrayList<Integer> moves = new ArrayList<>();
        if(this.color.equals("white")){
            moves.add(this.location-8);

            //Check if pawn has not moved yet
            if(this.location/8 == 6){
                moves.add(this.location-16);
            }
        } else {
            moves.add(this.location+8);
            if(this.location/8 == 1){
                moves.add(this.location+16);
            }
        }
        return moves;
    }
}