package com.chess.models;

import java.util.ArrayList;

class Rook extends Piece{

    public Rook(String _color, int _location){
        this.color = _color;
        this.location = _location;
    }
    
    public ArrayList<Integer> getMoves(){
        ArrayList<Integer> moves = new ArrayList<>();
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