package model;

public class Tour extends AbstractPiece {
	
	public Tour(Couleur couleur_de_piece,Coord coord) {
		super(couleur_de_piece,coord);
	}

	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		boolean ret = false;
		if ((xFinal == getX() && yFinal != getY()) || (xFinal != this.getX() && yFinal == this.getY()) ) {
			ret = true;
		}
		return ret;
	}

}
