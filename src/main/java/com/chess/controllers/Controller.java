package com.chess.controllers;


import java.util.ArrayList;

import com.chess.models.*;
import com.chess.views.View;
import javafx.scene.Group;

public class Controller {
    // public final Region view;

    public static Board board;
    public static Piece selectedPiece = null;
    public static boolean turnIsWhite = true;
    public static ArrayList<Square> moveSet = new ArrayList<Square>();
    public static ArrayList<Piece> checkSet = new ArrayList<Piece>();
    public static Piece whiteKing = null;
    public static Piece blackKing = null;
    public static boolean whiteInCheck = false, blackInCheck = false;


    
    public static void setBoard(Group root){
        board = new Board();
        System.out.println("Entering View");
        View.drawBoard(root, board);
        System.out.println("Exiting View");
        View.drawPieces(board);
        blackKing = board.getSquare(Piece.KING_START[0]).getPiece();
        whiteKing = board.getSquare(View.flipCoordinate(Piece.KING_START[0])).getPiece();

        for(int i = 0; i < Board.NUM_SQUARES; i++){
            Square sq = board.getSquare(i);
            sq.getPane().setOnMouseClicked(e -> {
                if(selectedPiece == null){
                    if(sq.hasPiece() && (sq.getPiece().getMoves(board).size() > 0)){
                        if((turnIsWhite && sq.getPiece().getColor().equals("white")) || 
                            (!turnIsWhite && sq.getPiece().getColor().equals("black"))){
                            selectPiece(sq);
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
        View.hightlightSelectedSquare(sq);
    }

    public static void deselectPiece(Piece p){
        for(Square sq : moveSet){
            View.unhighlightSquare(sq);
        }
        View.unhighlightSquare(board.getSquare(p.getLocation()));
        selectedPiece = null;
        moveSet.clear();
    }

    
    public static void movePiece(Square sq){
        checkSet.clear();
        getFirstPieceInAllDirections();
        for(Piece p : checkSet){
            System.out.println(p.getClass());
            System.out.println(p.getLocation());
        }

        // If destination square has a piece, remove it (i.e. "take" the opponents piece)
        if(sq.hasPiece()){
            sq.getPane().getChildren().remove(1);
        }

        // Remove Piece and image from its current square
        board.getSquare(selectedPiece.getLocation()).getPane().getChildren().remove(1);
        board.getSquare(selectedPiece.getLocation()).setPiece(null);

        // Add piece and image to new square
        sq.getPane().getChildren().add(selectedPiece.getImageView());
        sq.setPiece(selectedPiece);

        // Unhighlight squares
        deselectPiece(selectedPiece);

        // Set the piece's new location and check if it puts opponents king in check
        sq.getPiece().setLocation(sq.getLocation());
        checkForChecks(sq.getPiece());

        // Change the turn
        turnIsWhite = !turnIsWhite;
    }

    public static void checkForChecks(Piece p){
        for(int loc : p.getMoves(board)){
            if(board.getSquare(loc).hasPiece() && board.getSquare(loc).getPiece().equals(whiteKing)){
                whiteInCheck = true;
                System.out.println("white in check");
                break;
            } else if(board.getSquare(loc).hasPiece() && board.getSquare(loc).getPiece().equals(blackKing)){
                blackInCheck = true;
                System.out.println("black in check");
                break;
            }
        }  
    }

    // public static void checkForDiscoveredChecks(Piece p, int loc){
    //     int maxNorth = loc/Board.NUM_ROWS,  maxSouth = Board.ROW_MAX_INDEX-(maxNorth), maxWest = loc % Board.NUM_ROWS, maxEast = Board.ROW_MAX_INDEX - maxWest;

    //     if(Queen.class.isInstance(p) || Rook.class.isInstance(p)){

    //         verifyFirstPieceInDirection(loc, Board.NORTH, maxWest);
    //     }
    //     if(Queen.class.isInstance(p) || Bishop.class.isInstance(p)){
            
    //     }
    //     if(!Knight.class.isInstance(p)){

    //     }
    // }

    public static void getFirstPieceInAllDirections(){
        int loc = selectedPiece.getLocation();
        int maxNorth = loc/Board.NUM_ROWS,  maxSouth = Board.ROW_MAX_INDEX-(maxNorth), maxWest = loc % Board.NUM_ROWS, maxEast = Board.ROW_MAX_INDEX - maxWest;
        verifyFirstPieceInDirection(loc, Board.NORTH, maxNorth);
        verifyFirstPieceInDirection(loc, Board.SOUTH, maxSouth);
        verifyFirstPieceInDirection(loc, Board.EAST, maxEast);
        verifyFirstPieceInDirection(loc, Board.WEST, maxWest);
        verifyFirstPieceInDirection(loc, Board.NORTH_EAST, Math.min(maxNorth, maxEast));
        verifyFirstPieceInDirection(loc, Board.NORTH_WEST, Math.min(maxNorth, maxWest));
        verifyFirstPieceInDirection(loc, Board.SOUTH_EAST, Math.min(maxSouth, maxEast));
        verifyFirstPieceInDirection(loc, Board.SOUTH_WEST, Math.min(maxSouth, maxWest));
    }

    public static void verifyFirstPieceInDirection(int loc, int direction, int maxDistance){
        Piece p = MoveHelper.getFirstPieceInDirection(loc, direction, maxDistance, board);
        if(p != null && !Knight.class.isInstance(p)){
            checkSet.add(p);
            // if(p.getColor().equals(selectedPiece.getColor())){

            // } else {

            // }
        }
    }
}
