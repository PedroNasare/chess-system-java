package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		//não é necessario colocar o valor null no position, ele ja vem de padrão
	}

	protected Board getBoard() {
		return board;
	}
	
	

}
