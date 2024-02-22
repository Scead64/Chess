package com.chess.models;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Piece {
    public static final int[] ROOK_START = {0,7};
    public static final int[] BISHOP_START = {2,5};
    public static final int[] KNIGHT_START = {1,6};
    public static final int[] QUEEN_START = {3};
    public static final int[] KING_START = {4};
    public static final int[] PAWN_START = {8,9,10,11,12,13,14,15};

    String color; 
    int location;
    Image pieceImage;
    ImageView pieceImageView;

    Piece(){

    }

    //Moves peice from its location to new coordinate n.
    void move(int n){
        this.location = n;
    }

    public ImageView getImageView(){
        return this.pieceImageView;
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