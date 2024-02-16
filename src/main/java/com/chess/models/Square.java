package com.chess.models;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class Square {
    Piece p;
    StackPane sp;
    Rectangle sq;

    public Square(){
    }


    public Piece getPiece(){
        return this.p;
    }

    public Rectangle getSquare(){
        return this.sq;
    }

    public StackPane getPane(){
        return this.sp;
    }

    public void setPiece(Piece _p){
        this.p = _p;
    }

    public void setSquare(Rectangle _sq){
        this.sq = _sq;
    }

    public void setPane(StackPane _sp){
        this.sp = _sp;
    }
}
