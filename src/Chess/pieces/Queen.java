package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;
import boardgame.Position;

public class Queen extends ChessPiece{
	
	public Queen(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
	return null;
	}
}
