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
        setPawns(board, "black", Piece.PAWN_START);
        setPawns(board, "white", Piece.PAWN_START);

        setKnights(board, "black", Piece.ROOK_START);
        setKnights(board, "white", Piece.ROOK_START);

        setBishops(board, "black", Piece.BISHOP_START);
        setBishops(board, "white", Piece.BISHOP_START);

        setRooks(board, "black", Piece.KNIGHT_START);
        setRooks(board, "white", Piece.KNIGHT_START);

        setQueens(board, "black", Piece.KING_START);
        setQueens(board, "white", Piece.KING_START);

        setKings(board, "black", Piece.QUEEN_START);
        setKings(board, "white", Piece.QUEEN_START);

    }

    private static void setPawns(Board board, String color, int[] locations){
        for(int loc: locations){
            if(color.equals("white")){
                loc = flipCoordinate(loc);
            }
            Piece p = new Pawn(color, loc);
            StackPane sp = board.getSquare(loc).getPane();
            p.getImageView().setFitHeight(SQUARE_SIZE);
            sp.getChildren().add(p.getImageView());

        }
    }

    private static void setBishops(Board board, String color, int[] locations){
        for(int loc: locations){
            if(color.equals("white")){
                loc = flipCoordinate(loc);
            }
            Piece p = new Bishop(color, loc);
            StackPane sp = board.getSquare(loc).getPane();
            p.getImageView().setFitHeight(SQUARE_SIZE);
            sp.getChildren().add(p.getImageView());

        }
    }

    private static void setRooks(Board board, String color, int[] locations){
        for(int loc: locations){
            if(color.equals("white")){
                loc = flipCoordinate(loc);
            }
            Piece p = new Rook(color, loc);
            StackPane sp = board.getSquare(loc).getPane();
            p.getImageView().setFitHeight(SQUARE_SIZE);
            sp.getChildren().add(p.getImageView());

        }
    }
    
    private static void setKnights(Board board, String color, int[] locations){
        for(int loc: locations){
            if(color.equals("white")){
                loc = flipCoordinate(loc);
            }
            Piece p = new Knight(color, loc);
            StackPane sp = board.getSquare(loc).getPane();
            p.getImageView().setFitHeight(SQUARE_SIZE);
            sp.getChildren().add(p.getImageView());

        }
    }

    private static void setQueens(Board board, String color, int[] locations){
        for(int loc: locations){
            if(color.equals("white")){
                loc = flipCoordinate(loc);
            }
            Piece p = new Queen(color, loc);
            StackPane sp = board.getSquare(loc).getPane();
            p.getImageView().setFitHeight(SQUARE_SIZE);
            sp.getChildren().add(p.getImageView());

        }
    }

    private static void setKings(Board board, String color, int[] locations){
        for(int loc: locations){
            if(color.equals("white")){
                loc = flipCoordinate(loc);
            }
            Piece p = new Pawn(color, loc);
            StackPane sp = board.getSquare(loc).getPane();
            p.getImageView().setFitHeight(SQUARE_SIZE);
            sp.getChildren().add(p.getImageView());

        }
    }


    

    private static int flipCoordinate(int n){
        int row = n/8;
        int col = n%8;
        int newRow = 8*(7-row);

        return newRow+col;
    }
}
