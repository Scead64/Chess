package com.chess.models;

import javafx.scene.shape.Rectangle;

public class Square {
    Piece p;
    Rectangle sq;

    public Square(){
    }

    public void setPiece(Piece _p){
        this.p = _p;
    }

    public Piece getPiece(){
        return this.p;
    }
}
