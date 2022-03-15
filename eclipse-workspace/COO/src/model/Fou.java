package model;

public class Fou extends AbstractPiece {
	
	public Fou(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		return false;
	}
}
