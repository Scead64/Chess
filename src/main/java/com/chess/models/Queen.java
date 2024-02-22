package com.chess.models;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen extends Bishop{

    public Queen(String _color, int _location){
        super(_color, _location);
        try{
            this.pieceImage = new Image("chess_" + this.color + "_queen.png");
            this.pieceImageView = new ImageView(this.pieceImage);
            this.pieceImageView.setPreserveRatio(true);
        } catch(Exception e) {
            System.out.println("Error creating queen image");
        }
    }
    

    public ArrayList<Integer> getMoves(){
        ArrayList<Integer> moves = super.getMoves();
        int maxWest = this.location % 8, maxNorth = this.location / 8, maxEast = 7-maxWest, maxSouth = 7-maxNorth;

        for(int north = 1; north <= maxNorth; north++){
            moves.add(this.location-(8*north));
        }
        
        for(int south = 1; south <= maxSouth; south++){
            moves.add(this.location+(8*south));
        }

        for(int west = 1; west <= maxWest; west++){
            moves.add(this.location-west);
        }

        for(int east = 1; east <= maxEast; east++){
            moves.add(this.location+east);
        }
        return moves;
    }
}