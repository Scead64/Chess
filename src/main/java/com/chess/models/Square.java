package com.chess.models;

import javafx.scene.shape.Rectangle;

public class Square {
    Piece p;
    Rectangle sq;

    public Square(){
    }


    public Piece getPiece(){
        return this.p;
    }

    public Rectangle getSquare(){
        return this.sq;
    }

    public void setPiece(Piece _p){
        this.p = _p;
    }

    public void setSquare(Rectangle square){
        this.sq = square;
    }
}
