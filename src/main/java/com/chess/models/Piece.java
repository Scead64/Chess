package com.chess.models;

import java.util.ArrayList;

public abstract class Piece {
    String color; 
    int location;

    //Moves peice from its location to new coordinate n.
    void move(int n){
        this.location = n;
    }

    /*
     * Checks if a move is valid.
     * A move can be invalid for one of three reasons:
     * 
     * 1. A square contains a piece of the same color
     * 2. Moving the piece places the king of the same color in check.
     * 3. The king is already in check, and the move does not solve this.
     * 
     * @returns true if viable, false otherwise.
     */
    // public boolean verifyMove(int location){
    //     Piece p = board.getPiece(location);
    //     if(p != null){
    //         if (p.color.equals(this.color)){
    //             return false;
    //         }
    //     }

    //     //TODO: add checks for steps 2 & 3
    //     return true;
    // }


    abstract ArrayList<Integer> getMoves();
    




}