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

    //Moves peice from its location to new coordinate n.

    public ImageView getImageView(){
        return this.pieceImageView;
    }

    public String getColor(){
        return this.color;
    }

    public int getLocation(){
        return this.location;
    }

    public void setLocation(int loc){
        this.location = loc;
    }
    


    public abstract ArrayList<Integer> getMoves(Board board);
    




}