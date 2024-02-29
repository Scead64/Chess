package com.chess.controllers;


import java.util.ArrayList;

import com.chess.models.*;
import com.chess.views.View;
import javafx.scene.Group;

public class Controller {

    public static Board board;
    public static Piece selectedPiece = null;
    public static boolean turnIsWhite = true;
    public static ArrayList<Square> moveSet = new ArrayList<Square>();

    public static ArrayList<Piece> blackPieces = new ArrayList<Piece>();
    public static ArrayList<Integer> blackSquares = new ArrayList<Integer>();

    public static ArrayList<Piece> whitePieces = new ArrayList<Piece>();
    public static ArrayList<Integer> whiteAquares = new ArrayList<Integer>();

    public static Piece whiteKing = null;
    public static Piece blackKing = null;
    public static boolean whiteInCheck = false, blackInCheck = false;


    
    public static void setBoard(Group root){
        board = new Board();
        System.out.println("Entering View");
        View.drawBoard(root, board);
        System.out.println("Exiting View");
        View.drawPieces(board, blackPieces, whitePieces);
        blackKing = board.getSquare(Piece.KING_START[0]).getPiece();
        whiteKing = board.getSquare(MoveHelper.flipCoordinate(Piece.KING_START[0])).getPiece();

        for(int i = 0; i < Board.NUM_SQUARES; i++){
            Square sq = board.getSquare(i);
            sq.getPane().setOnMouseClicked(e -> {
                if(selectedPiece == null){
                    if(sq.hasPiece() && getPossibleMoves(sq)){
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
    
    public static boolean getPossibleMoves(Square sq){
        moveSet.clear();
        
        for(int loc : sq.getPiece().getMoves(board)){
            moveSet.add(board.getSquare(loc));
        }
        
        int line = checkForDiscoveredChecks(sq.getPiece());
        
        //potential Discovered check
        if(line != 0){
            for(int i = 0; i < moveSet.size(); i++){
                if((sq.getLocation() - moveSet.get(i).getLocation()) % line != 0){
                    moveSet.remove(i);
                    i--;
                }
            }
        }

        return moveSet.size() > 0 ? true : false;
    }

    public static void selectPiece(Square sq){
        selectedPiece = sq.getPiece();

        for(Square sqChoice : moveSet){
            View.highlightSquare(sqChoice);
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
        getFirstPieceInAllDirections();
        

        // If destination square has a piece, remove it (i.e. "take" the opponents piece)
        if(sq.hasPiece()){
            sq.getPane().getChildren().remove(1);
            if(turnIsWhite){
                blackPieces.remove(sq.getPiece());
            } else {
                whitePieces.remove(sq.getPiece());
            }
            sq.getPiece().setLocation(-1);

            System.out.println(whitePieces);
            System.out.println(blackPieces);
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

        if(Pawn.class.isInstance(sq.getPiece())){
            checkForPromotion(sq);
        }

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

    public static int checkForDiscoveredChecks(Piece p){
        if(p != whiteKing && p != blackKing){
            int direction = 0;
            Piece king;
            if(turnIsWhite){
                king = whiteKing;
            } else {
                king = blackKing;
            }
    
            //Check if piece aligns with the king along a line
            direction = inLineWithKing(king, p.getLocation());

            //If it aligns, check if it "blocks" the king. i.e. the first piece in the direction of the king on the same line is the king
            if(direction != 0 && MoveHelper.getFirstPieceInDirection(p.getLocation(), direction, board) == king){

                //get the piece on the opposite side of the line
                Piece p2 = MoveHelper.getFirstPieceInDirection(p.getLocation(), direction*-1, board);

                //Check if there is such a piece and if it's the enemy color
                if(p2 != null && !p2.getColor().equals(king.getColor())){
                    
                    //Check if the piece threatens the king.
                    if(Queen.class.isInstance(p2) || Bishop.class.isInstance(p2)){
                        if(direction == Board.NORTH_EAST || direction == Board.NORTH_WEST || direction == Board.SOUTH_EAST || direction == Board.SOUTH_WEST){
                            //Moving away from line causes discovered check!
                            return direction;
                        }
                    }
                    if (Queen.class.isInstance(p2) || Rook.class.isInstance(p2)){
                        if(direction == Board.NORTH || direction == Board.WEST || direction == Board.EAST || direction == Board.SOUTH){
                            //Moving away from line causes discovered check!
                            return direction;
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Gets the direction of the given location in relation to the associated King.
     * @param king
     *      The king to compare to
     * @param loc
     *      The given location to compare to
     * @return 
     *      One of NORTH, EAST, SOUTH, WEST, NORTHEAST, NORTHWEST, SOUTHEAST, SOUTHWEST if the king is in line with the location,
     *      0 otherwise
     */
    public static int inLineWithKing(Piece king, int loc){
        int kingLocation = king.getLocation();
        
        if(kingLocation/8 == loc/8){
            return loc - kingLocation < 0? Board.EAST : Board.WEST;
        
        } else if (kingLocation%8 == loc%8){
            return loc - kingLocation < 0? Board.SOUTH : Board.NORTH;

        } else {
            int diff = Math.abs(loc - kingLocation);            
            if(diff % 7 == 0){
                return loc - kingLocation < 0? Board.SOUTH_WEST : Board.NORTH_EAST;
            } else if(diff % 9 == 0){
                return loc - kingLocation < 0? Board.SOUTH_EAST : Board.NORTH_WEST;
            }
        }
        return 0;
    }

    public static void getFirstPieceInAllDirections(){
        int loc = selectedPiece.getLocation();
        verifyFirstPieceInDirection(loc, Board.NORTH);
        verifyFirstPieceInDirection(loc, Board.SOUTH);
        verifyFirstPieceInDirection(loc, Board.EAST);
        verifyFirstPieceInDirection(loc, Board.WEST);
        verifyFirstPieceInDirection(loc, Board.NORTH_EAST);
        verifyFirstPieceInDirection(loc, Board.NORTH_WEST);
        verifyFirstPieceInDirection(loc, Board.SOUTH_EAST);
        verifyFirstPieceInDirection(loc, Board.SOUTH_WEST);
    }

    public static void verifyFirstPieceInDirection(int loc, int direction){
        Piece p = MoveHelper.getFirstPieceInDirection(loc, direction, board);
        if(p != null && !Knight.class.isInstance(p)){
            // if(p.getColor().equals(selectedPiece.getColor())){

            // } else {

            // }
        }
    }

    public static void checkForPromotion(Square sq){
        if(turnIsWhite && sq.getPiece().getLocation()/8 == 0){
            whitePieces.remove(sq.getPiece());
            sq.getPiece().setLocation(-1);
            sq.getPane().getChildren().remove(1);
            Piece q = new Queen("white", sq.getLocation());
            View.setPiece(board, q, sq.getLocation());
            whitePieces.add(sq.getPiece());

        } else if(!turnIsWhite && sq.getPiece().getLocation()/8 == 7){
            blackPieces.remove(sq.getPiece());
            sq.getPiece().setLocation(-1);
            sq.getPane().getChildren().remove(1);
            Piece q = new Queen("black", sq.getLocation());
            View.setPiece(board, q, sq.getLocation());
            blackPieces.add(sq.getPiece());
        }
    }
}
