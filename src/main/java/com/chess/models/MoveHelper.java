package com.chess.models;

import java.util.ArrayList;

public class MoveHelper{
    public static final int NORTH = -8;
    public static final int SOUTH = 8;
    public static final int EAST = 1;
    public static final int WEST = -1;

    public static final int NORTH_EAST = -7;
    public static final int NORTH_WEST = -9;
    public static final int SOUTH_EAST = 9;
    public static final int SOUTH_WEST = 7;

    
    public static ArrayList<Integer> getCardinals(int location, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int maxNorth = location/8, maxEast = 7 - (location % 8),  maxSouth = 7-(location/8), maxWest = location % 8;

        moves.addAll(getDirection(location, NORTH, maxNorth, color, board));
        moves.addAll(getDirection(location, EAST, maxEast, color, board));
        moves.addAll(getDirection(location, SOUTH, maxSouth, color, board));
        moves.addAll(getDirection(location, WEST, maxWest, color, board));
        return moves;
    }

    public static ArrayList<Integer> getOrdinals(int location, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int maxNorth = location/8, maxEast = 7 - (location % 8),  maxSouth = 7-(location/8), maxWest = location % 8;

        moves.addAll(getDirection(location, NORTH_EAST, Math.min(maxNorth, maxEast), color, board));
        moves.addAll(getDirection(location, NORTH_WEST, Math.min(maxNorth, maxWest), color, board));
        moves.addAll(getDirection(location, SOUTH_EAST, Math.min(maxSouth, maxEast), color, board));
        moves.addAll(getDirection(location, SOUTH_WEST, Math.min(maxSouth, maxWest), color, board));
        return moves;
    }
    
    public static ArrayList<Integer> getDirection(int location, int direction, int maxDistance, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        for(int i = 1; i <= maxDistance; i++){
            if(verifyColor(moves, color, location + (i*direction), board.getSquare(location + (i*direction)))){
                break;
            }
        }
        return moves;
    }
    
    public static boolean verifyColor(ArrayList<Integer> moves, String color, int location, Square sq){
        if(!(sq.hasPiece() && sq.getPiece().getColor().equals(color))){
            moves.add(location);
        }
        return sq.hasPiece();
    }
}