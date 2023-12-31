package boardgame;

public class Position {
	
	private int row;
	private int columm;
	
	public Position(int row, int columm) {
		this.row = row;
		this.columm = columm;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return columm;
	}

	public void setColumn(int columm) {
		this.columm = columm;
	}
	
	public void setValues(int row, int column) {
		this.row = row;
		this.columm = column;
	}
	
	@Override
	public String toString(){
		return row + ", "+ columm;
	}
}
	