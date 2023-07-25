package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;
import boardgame.Position;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	public boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// above

		p.setValues(position.getRow() - 1, position.getColumm());
		if (getBoard().positionExists(p) && canMove(p)){
			mat[p.getRow()][p.getColumm()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getColumm() + 1);
		if (getBoard().positionExists(p) && canMove(p)){
			mat[p.getRow()][p.getColumm()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getColumm() - 1);
		if (getBoard().positionExists(p) && canMove(p)){
			mat[p.getRow()][p.getColumm()] = true;
		}

		// down
		p.setValues(position.getRow() + 1, position.getColumm());
		if (getBoard().positionExists(p) && canMove(p)){
			mat[p.getRow()][p.getColumm()] = true;
		}

		// diagonal superior direita
		p.setValues(position.getRow() - 1, position.getColumm() + 1);
		if (getBoard().positionExists(p) && canMove(p)){
			mat[p.getRow()][p.getColumm()] = true;
		}

		// diagonal superior esquerda
		p.setValues(position.getRow() - 1, position.getColumm() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumm()] = true;
		}

		// diagonal inferior esquerda
		p.setValues(position.getRow() + 1, position.getColumm() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumm()] = true;
		}

		// diagonal inferior direita
		p.setValues(position.getRow() + 1, position.getColumm() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumm()] = true;
		}
		
		

		return mat;
	}

}
