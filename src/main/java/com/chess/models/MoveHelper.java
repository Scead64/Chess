package com.chess.models;

import java.util.ArrayList;

public class MoveHelper{
    

    
    public static ArrayList<Integer> getCardinals(int location, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int maxNorth = location/Board.NUM_ROWS,  maxSouth = Board.ROW_MAX_INDEX-(maxNorth), maxWest = location % Board.NUM_ROWS, maxEast = Board.ROW_MAX_INDEX - maxWest;

        moves.addAll(getDirection(location, Board.NORTH, maxNorth, color, board));
        moves.addAll(getDirection(location, Board.EAST, maxEast, color, board));
        moves.addAll(getDirection(location, Board.SOUTH, maxSouth, color, board));
        moves.addAll(getDirection(location, Board.WEST, maxWest, color, board));
        return moves;
    }

    public static ArrayList<Integer> getOrdinals(int location, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int maxNorth = location/Board.NUM_ROWS,  maxSouth = Board.ROW_MAX_INDEX-(maxNorth), maxWest = location % Board.NUM_ROWS, maxEast = Board.ROW_MAX_INDEX - maxWest;

        moves.addAll(getDirection(location, Board.NORTH_EAST, Math.min(maxNorth, maxEast), color, board));
        moves.addAll(getDirection(location, Board.NORTH_WEST, Math.min(maxNorth, maxWest), color, board));
        moves.addAll(getDirection(location, Board.SOUTH_EAST, Math.min(maxSouth, maxEast), color, board));
        moves.addAll(getDirection(location, Board.SOUTH_WEST, Math.min(maxSouth, maxWest), color, board));
        return moves;
    }
    
    public static ArrayList<Integer> getDirection(int location, int direction, int maxDistance, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        for(int i = 1; i <= maxDistance; i++){
            if(verifyMove(moves, color, location + (i*direction), board.getSquare(location + (i*direction)))){
                break;
            }
        }
        return moves;
    }

    public static Piece getFirstPieceInDirection(int location, int direction, int maxDistance, Board board){
        for(int i = 1; i <= maxDistance; i++){
            if(board.getSquare(location + (i*direction)).hasPiece()){
                return board.getSquare(location + (i*direction)).getPiece();
            }
        }
        return null;
    }

    public static boolean verifyMove(ArrayList<Integer> moves, String color, int location, Square sq){
        if(!(sq.hasPiece() && sq.getPiece().getColor().equals(color))){
            moves.add(location);
        }
        return sq.hasPiece();
    }
}