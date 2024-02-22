package com.chess.models;

import java.io.FileInputStream;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends Piece{

    public Rook(String _color, int _location){
        this.color = _color;
        this.location = _location;
        try{
            this.pieceImage = new Image("chess_" + this.color + "_rook.png");
            this.pieceImageView = new ImageView(this.pieceImage);
            this.pieceImageView.setPreserveRatio(true);
        } catch(Exception e) {
            System.out.println("Error creating rook image");
        }
    }
    
    public ArrayList<Integer> getMoves(){
        ArrayList<Integer> moves = new ArrayList<>();
        int row = (this.location/8)*8;
        int col = (this.location%8);
        int counter = 0;
        while(counter < 8){
            moves.add(row);
            moves.add(col);
            row++;
            col+=8;
            counter++;
        }
        return moves;
    }
}