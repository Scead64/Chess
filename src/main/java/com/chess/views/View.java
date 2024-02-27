package com.chess.views;

import com.chess.models.*;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class View {
    
    public static final int SQUARE_SIZE = 100;
    public static final Color COLOR_1 = Color.ALICEBLUE;
    public static final Color COLOR_2 = Color.SANDYBROWN;
    public static final Color HIGHLIGHT = Color.AQUA;
    public static final Color SELECTED = Color.GOLD;

    public static void drawBoard( Group root, Board board){
        System.out.println("Entering View Loop");
        for(int i = 0; i < Board.NUM_SQUARES; i++){
            Square sq = board.getSquare(i);            
            int row = i / 8, col = i % 8;
            Rectangle squareDrawing = new Rectangle(0,0,SQUARE_SIZE,SQUARE_SIZE);
            if((row+i)%2 == 0){
                squareDrawing.setFill(COLOR_1);
            } else {
                squareDrawing.setFill(COLOR_2);
            }
            sq.setSquare(squareDrawing);
            StackPane sp = new StackPane(squareDrawing);
            sp.setLayoutX(SQUARE_SIZE*col);
            sp.setLayoutY(SQUARE_SIZE*row);
            System.out.println(i + " " + sp.getLayoutX() + " " + sp.getLayoutY());
            sq.setPane(sp);
            root.getChildren().add(sp);
        }
        System.out.println("Exiting View Loop");
    }

    public static void drawPieces(Board board){
        for(int pawnIndex = 0; pawnIndex < Piece.PAWN_START.length; pawnIndex++){
            int blackLoc = Piece.PAWN_START[pawnIndex];
            int whiteLoc = flipCoordinate(blackLoc);
            Piece pBlack = new Pawn("black", blackLoc);
            Piece pWhite = new Pawn("white", whiteLoc);
            setPiece(board, pBlack, "black", blackLoc);
            setPiece(board, pWhite, "white", whiteLoc);
        }

        for(int knightIndex = 0; knightIndex < Piece.KNIGHT_START.length; knightIndex++){
            int blackLoc = Piece.KNIGHT_START[knightIndex];
            int whiteLoc = flipCoordinate(blackLoc);
            Piece pBlack = new Knight("black", blackLoc);
            Piece pWhite = new Knight("white", whiteLoc);
            setPiece(board, pBlack, "black", blackLoc);
            setPiece(board, pWhite, "white", whiteLoc);
        }

        for(int bishopIndex = 0; bishopIndex < Piece.BISHOP_START.length; bishopIndex++){
            int blackLoc = Piece.BISHOP_START[bishopIndex];
            int whiteLoc = flipCoordinate(blackLoc);
            Piece pBlack = new Bishop("black", blackLoc);
            Piece pWhite = new Bishop("white", whiteLoc);
            setPiece(board, pBlack, "black", blackLoc);
            setPiece(board, pWhite, "white", whiteLoc);
        }

        for(int rookIndex = 0; rookIndex < Piece.ROOK_START.length; rookIndex++){
            int blackLoc = Piece.ROOK_START[rookIndex];
            int whiteLoc = flipCoordinate(blackLoc);
            Piece pBlack = new Rook("black", blackLoc);
            Piece pWhite = new Rook("white", whiteLoc);
            setPiece(board, pBlack, "black", blackLoc);
            setPiece(board, pWhite, "white", whiteLoc);
        }

        for(int queenIndex = 0; queenIndex < Piece.QUEEN_START.length; queenIndex++){
            int blackLoc = Piece.QUEEN_START[queenIndex];
            int whiteLoc = flipCoordinate(blackLoc);
            Piece pBlack = new Queen("black", blackLoc);
            Piece pWhite = new Queen("white", whiteLoc);
            setPiece(board, pBlack, "black", blackLoc);
            setPiece(board, pWhite, "white", whiteLoc);
        }

        for(int kingIndex = 0; kingIndex < Piece.KING_START.length; kingIndex++){
            int blackLoc = Piece.KING_START[kingIndex];
            int whiteLoc = flipCoordinate(blackLoc);
            Piece pBlack = new King("black", blackLoc);
            Piece pWhite = new King("white", whiteLoc);
            setPiece(board, pBlack, "black", blackLoc);
            setPiece(board, pWhite, "white", whiteLoc);
        }
    }

    private static void setPiece(Board board, Piece p, String color, int loc){
        StackPane sp = board.getSquare(loc).getPane();
        p.getImageView().setFitHeight(SQUARE_SIZE);
        sp.getChildren().add(p.getImageView());
        board.getSquare(loc).setPiece(p);
    }
    

    public static int flipCoordinate(int n){
        int row = n/8;
        int col = n%8;
        int newRow = 8*(7-row);

        return newRow+col;
    }

    public static void highlightSquare(Square sq){
        sq.getSquare().setFill(HIGHLIGHT);
    }

    public static void unhighlightSquare(Square sq){
        int loc = sq.getLocation();
        if((loc+(loc/8)) % 2 == 0){
            sq.getSquare().setFill(COLOR_1);
        } else {
            sq.getSquare().setFill(COLOR_2);
        }
    }
}
