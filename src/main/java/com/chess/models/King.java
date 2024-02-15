package com.chess.models;

import java.util.ArrayList;

class King extends Piece{

    public King(String _color, int _location){
        this.color = _color;
        this.location = _location;
    }
    

    public ArrayList<Integer> getMoves(){
        ArrayList<Integer> moves = new ArrayList<>();
        int maxWest = this.location % 8, maxNorth = this.location / 8, maxEast = 7-maxWest, maxSouth = 7-maxNorth;
        if(maxNorth > 0){
            moves.add(this.location-8);
            if(maxEast > 0){
                moves.add(this.location-7);
            }
            if(maxWest > 0){
                moves.add(this.location-9);
            }
        }
        if(maxSouth > 0){
            moves.add(this.location+8);
            if(maxEast > 0){
                moves.add(this.location+9);
            }
            if(maxWest > 0){
                moves.add(this.location+7);
            }
        }
        if(maxEast > 0){
            moves.add(this.location+1);
        }
        if(maxWest > 0){
            moves.add(this.location-1);
        }
        return moves;
    }
}