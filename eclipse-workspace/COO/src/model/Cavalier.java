package model;

public class Cavalier extends AbstractPiece{


	public Cavalier(Couleur couleur_de_piece,Coord coord) {
		super(couleur_de_piece,coord);
	}
	
	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		boolean ret = false;
		if(Math.abs(xFinal)-getX()==1 && Math.abs(yFinal)-getY()==2) {
			ret = true;
		}
		if(Math.abs(xFinal)-getX()==2 && Math.abs(yFinal)-getY()==1) {
			ret = true;
		}
		return ret;
	}
}
