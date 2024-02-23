package com.chess.models;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Knight extends Piece{

    public Knight(String _color, int _location){
        this.color = _color;
        this.location = _location;
        try{
            this.pieceImage = new Image("chess_" + this.color + "_knight.png");
            this.pieceImageView = new ImageView(this.pieceImage);
            this.pieceImageView.setPreserveRatio(true);
        } catch(Exception e) {
            System.out.println("Error creating knight image");
        }
    }
    
    public ArrayList<Integer> getMoves(Board board){
        ArrayList<Integer> moves = new ArrayList<>();
        int maxWest = this.location % 8, maxNorth = this.location / 8, maxEast = 7-maxWest, maxSouth = 7-maxNorth;

        if(maxNorth >= 2){
            if(maxWest > 0){
                moves.add(this.location-17);
            }
            if(maxEast > 0){
                moves.add(this.location-15);
            }
        }

        if(maxSouth >= 2){
            if(maxWest > 0){
                moves.add(this.location+15);
            }
            if(maxEast > 0){
                moves.add(this.location+17);
            }
        }

        if(maxWest >= 2){
            if(maxNorth > 0){
                moves.add(this.location-10);
            }
            if(maxSouth > 0){
                moves.add(this.location+6);
            }
        }

        if(maxEast >= 2){
            if(maxNorth > 0){
                moves.add(this.location-6);
            }
            if(maxSouth > 0){
                moves.add(this.location+10);
            }
        }
        
        return moves;
    }
}