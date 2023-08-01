package Chess.pieces;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;
import boardgame.Position;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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
		
		//#specialmove Castling
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			//roque menor
			Position posT1 = new Position(position.getRow(), position.getColumm() +3);
			if(testRookCastling(posT1)) {
				Position p1 = new Position(position.getRow(), position.getColumm() +1);
				Position p2 = new Position(position.getRow(), position.getColumm() +2);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumm() + 2] = true;
				}
			}
				//roque maior
				Position posT2 = new Position(position.getRow(), position.getColumm() -4);
				if(testRookCastling(posT2)) {
					Position p1 = new Position(position.getRow(), position.getColumm() -1);
					Position p2 = new Position(position.getRow(), position.getColumm() -2);
					Position p3 = new Position(position.getRow(), position.getColumm() -3);
					if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
						mat[position.getRow()][position.getColumm() -2] = true;
					}
					}
			}
		return mat;
	}

}
