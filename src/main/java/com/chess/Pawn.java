package com.chess;

class Pawn extends Piece{
    boolean color;
    int x,y;

    public Pawn(boolean _color, int _x, int _y){
        this.color = _color;
        this.x = _x;
        this.y = _y;
    }

    void move(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    void getMoves(){
        // if()
    }

    void promote(){

    }

}