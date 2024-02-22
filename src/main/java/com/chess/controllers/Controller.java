package com.chess.controllers;


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

    public static void setBoard(Group root){
        board = new Board();
        System.out.println("Entering View");
        View.drawBoard(root, board);
        System.out.println("Exiting View");

        View.drawPieces(board);
        for(int i = 0; i < Board.NUM_SQUARES; i++){
            Square sq = board.getSquare(i);
            sq.getPane().setOnMouseClicked(e -> {
                if(sq.hasPiece()){
                    if(selectedPiece == null){
                        selectPiece(sq);                        
                    } else {
                        deselectPiece(selectedPiece);
                        selectPiece(sq);
                    }
                } 
            });
        }
    }
    
    public static void selectPiece(Square sq){
        for(int loc : sq.getPiece().getMoves()){
            View.highlightSquare(board.getSquare(loc));
        }
        selectedPiece = sq.getPiece();
    }

    public static void deselectPiece(Piece p){
        for(int loc : p.getMoves()){
            View.unhighlightSquare(board.getSquare(loc));
        }
        selectedPiece = null;
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
    public boolean verifyMove(int location){
        Piece p = board.getPiece(location);
        if(p != null){
            if (p.getColor().equals(selectedPiece.getColor())){
                return false;
            }
        }

        //TODO: add checks for steps 2 & 3
        return true;
    }
}
