package com.chess.views;

import com.chess.models.*;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class View {
    
    public static final int SQUARE_SIZE = 100;

    public static void drawBoard( Group root, Board board){
        System.out.println("Entering View Loop");
        for(int i = 0; i < Board.NUM_SQUARES; i++){
            Square sq = board.getSquare(i);            
            int row = i / 8, col = i % 8;
            Rectangle squareDrawing = new Rectangle(0,0,SQUARE_SIZE,SQUARE_SIZE);
            if((row+i)%2 == 0){
                squareDrawing.setFill(Color.ALICEBLUE);
            } else {
                squareDrawing.setFill(Color.SANDYBROWN);
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
            int loc = Piece.PAWN_START[pawnIndex];
            Piece pWhite = new Pawn("white", loc);
            Piece pBlack = new Pawn("black", loc);
            setPiece(board, pWhite, "white", loc);
            setPiece(board, pBlack, "black", loc);
        }

        for(int knightIndex = 0; knightIndex < Piece.KNIGHT_START.length; knightIndex++){
            int loc = Piece.KNIGHT_START[knightIndex];
            Piece pWhite = new Knight("white", loc);
            Piece pBlack = new Knight("black", loc);
            setPiece(board, pWhite, "white", loc);
            setPiece(board, pBlack, "black", loc);
        }

        for(int bishopIndex = 0; bishopIndex < Piece.BISHOP_START.length; bishopIndex++){
            int loc = Piece.BISHOP_START[bishopIndex];
            Piece pWhite = new Bishop("white", loc);
            Piece pBlack = new Bishop("black", loc);
            setPiece(board, pWhite, "white", loc);
            setPiece(board, pBlack, "black", loc);
        }

        for(int rookIndex = 0; rookIndex < Piece.ROOK_START.length; rookIndex++){
            int loc = Piece.ROOK_START[rookIndex];
            Piece pWhite = new Rook("white", loc);
            Piece pBlack = new Rook("black", loc);
            setPiece(board, pWhite, "white", loc);
            setPiece(board, pBlack, "black", loc);
        }

        for(int queenIndex = 0; queenIndex < Piece.QUEEN_START.length; queenIndex++){
            int loc = Piece.QUEEN_START[queenIndex];
            Piece pWhite = new Queen("white", loc);
            Piece pBlack = new Queen("black", loc);
            setPiece(board, pWhite, "white", loc);
            setPiece(board, pBlack, "black", loc);
        }

        for(int kingIndex = 0; kingIndex < Piece.KING_START.length; kingIndex++){
            int loc = Piece.KING_START[kingIndex];
            Piece pWhite = new King("white", loc);
            Piece pBlack = new King("black", loc);
            setPiece(board, pWhite, "white", loc);
            setPiece(board, pBlack, "black", loc);
        }
    }

    private static void setPiece(Board board, Piece p, String color, int loc){
        if(color.equals("white")){
            loc = flipCoordinate(loc);
        }
        StackPane sp = board.getSquare(loc).getPane();
        p.getImageView().setFitHeight(SQUARE_SIZE);
        sp.getChildren().add(p.getImageView());
    }
    

    private static int flipCoordinate(int n){
        int row = n/8;
        int col = n%8;
        int newRow = 8*(7-row);

        return newRow+col;
    }
}
