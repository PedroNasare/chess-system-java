package boardgame;

import Chess.Color;

public abstract class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board, Color color) {
		this.board = board;
		//não é necessario colocar o valor null no position, ele ja vem de padrão
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumm()];
	}
	
	public boolean isTheraAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
			for(int i=0; i<mat.length; i++) {
				for(int j=0; j<mat.length; j++) {
					if(mat[i][j]) {
						return true;
					}
				}
			}
			return false;
	}
}
	


