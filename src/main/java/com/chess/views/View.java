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
                squareDrawing.setFill(Color.WHITE);
            } else {
                squareDrawing.setFill(Color.AQUA);
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
        setPieces(board, "black", "pawn", Piece.PAWN_START);
        setPieces(board, "white", "pawn", Piece.PAWN_START);

        setPieces(board, "black", "rook", Piece.ROOK_START);
        setPieces(board, "white", "rook", Piece.ROOK_START);

        setPieces(board, "black", "bishop", Piece.BISHOP_START);
        setPieces(board, "white", "bishop", Piece.BISHOP_START);

        setPieces(board, "black", "knight", Piece.KNIGHT_START);
        setPieces(board, "white", "knight", Piece.KNIGHT_START);

        setPieces(board, "black", "king", Piece.KING_START);
        setPieces(board, "white", "king", Piece.KING_START);

        setPieces(board, "black", "queen", Piece.QUEEN_START);
        setPieces(board, "white", "queen", Piece.QUEEN_START);

    }

    private static void setPieces(Board board, String color, String piece, int[] locations){
        for(int loc: locations){
            if(color.equals("white")){
                loc = flipCoordinate(loc);
            }
            StackPane sp = board.getSquare(loc).getPane();
            Image img = new Image("chess_" + color + "_" + piece + ".png");
            ImageView iv = new ImageView(img);
            iv.setPreserveRatio(true);
            iv.setFitHeight(SQUARE_SIZE);
            sp.getChildren().add(iv);
        }
    }

    private static int flipCoordinate(int n){
        int row = n/8;
        int col = n%8;
        int newRow = 8*(7-row);

        return newRow+col;
    }
}
