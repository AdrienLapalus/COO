package model;

public class Fou extends AbstractPiece {
	
	public Fou(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
	}
	
	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		boolean ret = false;
		int coordX = Math.abs(xFinal-getX());
		int coordY = Math.abs(yFinal-getY());
		System.out.println(coordX + "" + coordY);
		if( coordX == coordY ) {
			ret = true;
		}	
		return ret;
	}

}
