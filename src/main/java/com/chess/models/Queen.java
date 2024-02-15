package com.chess.models;

import java.util.ArrayList;

class Queen extends Piece{

    public Queen(String _color, int _location){
        this.color = _color;
        this.location = _location;
    }
    

    public ArrayList<Integer> getMoves(){
        ArrayList<Integer> moves = new ArrayList<>();
        int maxWest = this.location % 8, maxNorth = this.location / 8, maxEast = 7-maxWest, maxSouth = 7-maxNorth;

        //north east
        int distance = Math.min(maxNorth, maxEast);
        for(int i = 1; i <= distance; i++){
            moves.add(this.location-(i*7));
        }

        //north west
        distance = Math.min(maxNorth, maxWest);
        for(int j = 1; j <= distance; j++){
            moves.add(this.location-(j*9));
        }

        //south west
        distance = Math.min(maxSouth, maxWest);
        for(int k = 1; k < distance; k++){
            moves.add(this.location+(k*7));
        }

        //south east
        distance = Math.min(maxSouth, maxEast);
        for(int l = 1; l <= distance; l++){
            moves.add(this.location+(l*9));
        }

        // Cardinal directions
        int row = (this.location/8)*8;
        int col = (this.location%8);
        int counter = 0;
        while(counter < 8){
            moves.add(row);
            moves.add(col);
            row++;
            col+=8;
            counter++;
        }
        return moves;
    }
}