package com.chess.models;

public class Board {
    public static final int NUM_SQUARES = 64;
    public static final int NUM_ROWS = 8;

    private Square[] squares;

    public Board(){
        squares = new Square[NUM_SQUARES];
        for(int i = 0; i < squares.length; i++){
            squares[i] = new Square(i);
        }
    }

    /*
     * @returns the piece located at the given location
     * @requires the location given is with 0 <= location <= 63
     */
    public Piece getPiece(int location){
        return squares[location].p;
    }

    public Square getSquare(int location){
        return squares[location];
    }

}
