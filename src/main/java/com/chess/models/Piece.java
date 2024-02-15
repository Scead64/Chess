package com.chess.models;

import java.util.ArrayList;

public abstract class Piece {
    String color; 
    int location;

    //Moves peice from its location to new coordinate n.
    void move(int n){
        this.location = n;
    }

    abstract ArrayList<Integer> getMoves();
    




}