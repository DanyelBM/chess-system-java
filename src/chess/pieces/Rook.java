package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position temp = new Position(0, 0);
		
		//acima
		temp.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(temp) && !getBoard().thereIsAPiece(temp)) {
			matrix[temp.getRow()][temp.getColumn()] = true;
			temp.setRow(temp.getRow() - 1);
		}
		if (getBoard().positionExists(temp) && isThereOpponentPiece(temp)) {
			matrix[temp.getRow()][temp.getColumn()] = true;
		}
		
		//esquerda
		temp.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(temp) && !getBoard().thereIsAPiece(temp)) {
			matrix[temp.getRow()][temp.getColumn()] = true;
			temp.setColumn(temp.getColumn() - 1);
		}
		if (getBoard().positionExists(temp) && isThereOpponentPiece(temp)) {
			matrix[temp.getRow()][temp.getColumn()] = true;
		}
		
		//direita
		temp.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(temp) && !getBoard().thereIsAPiece(temp)) {
			matrix[temp.getRow()][temp.getColumn()] = true;
			temp.setColumn(temp.getColumn() + 1);
		}
		if (getBoard().positionExists(temp) && isThereOpponentPiece(temp)) {
			matrix[temp.getRow()][temp.getColumn()] = true;
		}
		
		//abaixo
		temp.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(temp) && !getBoard().thereIsAPiece(temp)) {
			matrix[temp.getRow()][temp.getColumn()] = true;
			temp.setRow(temp.getRow() + 1);
		}
		if (getBoard().positionExists(temp) && isThereOpponentPiece(temp)) {
			matrix[temp.getRow()][temp.getColumn()] = true;
		}
					
		return matrix;
	}
}
