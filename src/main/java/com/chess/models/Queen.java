package com.chess.models;

import java.util.ArrayList;

class Queen extends Bishop{

    public Queen(String _color, int _location){
        super(_color, _location);
    }
    

    public ArrayList<Integer> getMoves(){
        ArrayList<Integer> moves = super.getMoves();

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