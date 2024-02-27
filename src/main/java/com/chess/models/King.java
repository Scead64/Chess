package com.chess.models;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class King extends Piece{

    public King(String _color, int _location){
        this.color = _color;
        this.location = _location;
        try{
            this.pieceImage = new Image("chess_" + this.color + "_king.png");
            this.pieceImageView = new ImageView(this.pieceImage);
            this.pieceImageView.setPreserveRatio(true);
        } catch(Exception e) {
            System.out.println("Error creating king image");
        }
    }
    

    public ArrayList<Integer> getMoves(Board board){
        ArrayList<Integer> moves = new ArrayList<>();
        int maxWest = this.location % 8, maxNorth = this.location / 8, maxEast = 7-maxWest, maxSouth = 7-maxNorth;
        if(maxNorth > 0){
            MoveHelper.verifyMove(moves, this.color, this.location+Board.NORTH, board.getSquare(this.location+Board.NORTH));
            if(maxEast > 0){
                MoveHelper.verifyMove(moves, this.color, this.location+Board.NORTH_EAST, board.getSquare(this.location+Board.NORTH_EAST));
            }
            if(maxWest > 0){
                MoveHelper.verifyMove(moves, this.color, this.location+Board.NORTH_WEST, board.getSquare(this.location+Board.NORTH_WEST));
            }
        }
        if(maxSouth > 0){
            MoveHelper.verifyMove(moves, this.color, this.location+Board.SOUTH, board.getSquare(this.location+Board.SOUTH));
            if(maxEast > 0){
                MoveHelper.verifyMove(moves, this.color, this.location+Board.SOUTH_EAST, board.getSquare(this.location+Board.SOUTH_EAST));
            }
            if(maxWest > 0){
                MoveHelper.verifyMove(moves, this.color, this.location+Board.SOUTH_WEST, board.getSquare(this.location+Board.SOUTH_WEST));

            }
        }
        if(maxEast > 0){
            MoveHelper.verifyMove(moves, this.color, this.location+Board.EAST, board.getSquare(this.location+Board.EAST));
        }
        if(maxWest > 0){
            MoveHelper.verifyMove(moves, this.color, this.location+Board.WEST, board.getSquare(this.location+Board.WEST));
        }
        return moves;
    }
}