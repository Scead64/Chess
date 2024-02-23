package com.chess.controllers;


import java.util.ArrayList;

import com.chess.models.Board;
import com.chess.models.Piece;
import com.chess.models.Square;
import com.chess.views.View;
import javafx.scene.Group;

public class Controller {
    // public final Region view;

    public static Board board;
    public static Piece selectedPiece = null;
    public static boolean turnIsWhite = true;
    public static ArrayList<Square> moveSet = new ArrayList<Square>();
    public static ArrayList<Square> removeSet = new ArrayList<Square>();

    public static void setBoard(Group root){
        board = new Board();
        System.out.println("Entering View");
        View.drawBoard(root, board);
        System.out.println("Exiting View");

        View.drawPieces(board);
        for(int i = 0; i < Board.NUM_SQUARES; i++){
            Square sq = board.getSquare(i);
            sq.getPane().setOnMouseClicked(e -> {
                if(selectedPiece == null){
                    if(sq.hasPiece() && (sq.getPiece().getMoves(board).size() > 0)){
                        if((turnIsWhite && sq.getPiece().getColor().equals("white")) || 
                            (!turnIsWhite && sq.getPiece().getColor().equals("black"))){
                            selectPiece(sq);
                            System.out.println("hihi");
                        }
                    }
                } else {
                    if(moveSet.contains(sq)){
                        movePiece(sq);
                    } else {
                        deselectPiece(selectedPiece);
                    }    
                }
                
            });
        }
    }
    
    public static void selectPiece(Square sq){
        selectedPiece = sq.getPiece();
        for(int loc : sq.getPiece().getMoves(board)){
            moveSet.add(board.getSquare(loc));
            View.highlightSquare(board.getSquare(loc));
        }
    }

    public static void deselectPiece(Piece p){
        for(Square sq : moveSet){
            View.unhighlightSquare(sq);
        }
        selectedPiece = null;
        moveSet.clear();
    }

    public static void movePiece(Square sq){
        if(sq.hasPiece()){
            sq.getPane().getChildren().remove(1);
        }
        board.getSquare(selectedPiece.getLocation()).getPane().getChildren().remove(1);
        board.getSquare(selectedPiece.getLocation()).setPiece(null);
        sq.getPane().getChildren().add(selectedPiece.getImageView());
        sq.setPiece(selectedPiece);
        deselectPiece(selectedPiece);
        sq.getPiece().setLocation(sq.getLocation());
        turnIsWhite = !turnIsWhite;
    }
}
