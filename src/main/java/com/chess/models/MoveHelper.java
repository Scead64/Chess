package com.chess.models;

import java.util.ArrayList;

public class MoveHelper{
    public static final int NORTH = -8;
    public static final int SOUTH = 8;
    public static final int EAST = 1;
    public static final int WEST = -1;
    
    public static ArrayList<Integer> getCardinals(int location, String color, Board board){
        int maxNorth = location/8, maxEast = 7 - (location % 8),  maxSouth = 7-(location/8), maxWest = location % 8;
        ArrayList<Integer> moves = new ArrayList<Integer>();
        moves.addAll(getCardinalDirection(location, NORTH, maxNorth, color, board));
        moves.addAll(getCardinalDirection(location, EAST, maxEast, color, board));
        moves.addAll(getCardinalDirection(location, SOUTH, maxSouth, color, board));
        moves.addAll(getCardinalDirection(location, WEST, maxWest, color, board));
        return moves;
    }

    public static ArrayList<Integer> getOrdinals(int location, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        moves.addAll(getNorthEast(location, color, board));
        moves.addAll(getNorthWest(location, color, board));
        moves.addAll(getSouthEast(location, color, board));
        moves.addAll(getSouthWest(location, color, board));
        return moves;
    }
    
    public static ArrayList<Integer> getCardinalDirection(int location, int direction, int maxDistance, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        for(int i = 1; i <= maxDistance; i++){
            if(verifyColor(moves, color, location + (i*direction), board.getSquare(location + (i*direction)))){
                break;
            }
        }
        return moves;
    }

    public static ArrayList<Integer> getNorthEast(int location, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int maxNorth = location/8, maxEast = 7 - (location % 8);
        int distance = Math.min(maxNorth, maxEast);
        for(int i = 1; i <= distance; i++){
            if(verifyColor(moves, color, location - (i*7), board.getSquare(location - (i*7)))){
                break;
            }
        }
        return moves;
    }

    public static ArrayList<Integer> getNorthWest(int location, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int maxNorth = location/8, maxWest = location % 8;
        int distance = Math.min(maxNorth, maxWest);
        for(int i = 1; i <= distance; i++){
            if(verifyColor(moves, color, location - (i*9), board.getSquare(location - (i*9)))){
                break;
            }
        }
        return moves;
    }

    public static ArrayList<Integer> getSouthEast(int location, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int maxSouth = 7-(location/8), maxEast = 7 - (location % 8);
        int distance = Math.min(maxSouth, maxEast);
        for(int i = 1; i <= distance; i++){
            if(verifyColor(moves, color, location + (i*9), board.getSquare(location + (i*9)))){
                break;
            }
        }
        return moves;
    }

    public static ArrayList<Integer> getSouthWest(int location, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int maxSouth = 7-(location/8), maxWest = location % 8;
        int distance = Math.min(maxSouth, maxWest);
        for(int i = 1; i <= distance; i++){
            System.out.println(i);
            if(verifyColor(moves, color, location + (i*7), board.getSquare(location + (i*7)))){
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