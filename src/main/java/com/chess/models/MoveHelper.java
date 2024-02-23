package com.chess.models;

import java.util.ArrayList;

public class MoveHelper{
    
    public static ArrayList<Integer> getCardinals(int location, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        moves.addAll(getNorth(location, color, board));
        moves.addAll(getSouth(location, color, board));
        moves.addAll(getEast(location, color, board));
        moves.addAll(getWest(location, color, board));
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
    
    public static ArrayList<Integer> getNorth(int location, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int maxNorth = location/8;
        for(int i = 1; i <= maxNorth; i++){
            if(verifyColor(moves, color, location - (i*8), board.getSquare(location - (i*8)))){
                break;
            }
        }
        return moves;
    }

    public static ArrayList<Integer> getSouth(int location, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int maxSouth = 7-(location/8);
        for(int i = 1; i <= maxSouth; i++){
            if(verifyColor(moves, color, location + (i*8), board.getSquare(location + (i*8)))){
                break;
            }
        }
        return moves;
    }

    public static ArrayList<Integer> getWest(int location, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int maxWest = location % 8;
        for(int i = 1; i <= maxWest; i++){
            if(verifyColor(moves, color, location - i, board.getSquare(location - i))){
                break;
            }
        }
        return moves;
    }

    public static ArrayList<Integer> getEast(int location, String color, Board board){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int maxEast = 7-(location % 8);
        for(int i = 1; i <= maxEast; i++){
            if(verifyColor(moves, color, location + i, board.getSquare(location + i))){
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