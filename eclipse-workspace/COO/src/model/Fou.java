package model;

public class Fou extends AbstractPiece {
	
	public Fou(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
	}
	
	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		boolean ret = false;
		if (xFinal != getX() && yFinal != getY()) {
			if(Math.abs(xFinal-getX()) == Math.abs(yFinal)-getY()) {
				ret = true;
			}	
		}
		return ret;
	}

}
