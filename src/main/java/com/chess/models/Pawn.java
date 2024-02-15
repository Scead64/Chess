package com.chess.models;

import java.util.ArrayList;

class Pawn extends Piece{

    public Pawn(String _color, int _location){
        this.color = _color;
        this.location = _location;
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

    void promote(){

    }

}