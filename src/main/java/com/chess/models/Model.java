package com.chess.models;

public class Model {
    public static final int[] ROOK_START = {0,7};
    public static final int[] BISHOP_START = {1,6};
    public static final int[] KNIGHT_START = {2,5};
    public static final int QUEEN_START = 3;
    public static final int KING_START = 4;
    public static final int[] PAWN_START = {8,9,10,11,12,13,14,15};

    public void setWhite(){
        for(int n: ROOK_START){
            //Setup for Rooks
        }

        for(int n: BISHOP_START){
            //Setup for bishops
        }

        for(int n: KNIGHT_START){
            //Setup for knights
        }

        for(int n: PAWN_START){
            //Setup for pawns
        }

        //Setup king/queen
    }

    public void setBlock(){
        for(int n: ROOK_START){
            int coordinate = flipCoordinate(n);
            //Setup for Rooks
        }

        for(int n: BISHOP_START){
            int coordinate = flipCoordinate(n);
            //Setup for bishops
        }

        for(int n: KNIGHT_START){
            int coordinate = flipCoordinate(n);
            //Setup for knights
        }

        for(int n: PAWN_START){
            int coordinate = flipCoordinate(n);
            //Setup for pawns
        }

        int king = flipCoordinate(KING_START);
        int queen = flipCoordinate(QUEEN_START);
    }

    private static int flipCoordinate(int n){
        int row = n/8;
        int col = n%8;
        int newRow = 8*(7-row);
        int newCol = 7-col;

        return newRow+newCol;
    }

}
