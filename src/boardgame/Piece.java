package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		//n�o � necessario colocar o valor null no position, ele ja vem de padr�o
	}

	protected Board getBoard() {
		return board;
	}
	
	

}
