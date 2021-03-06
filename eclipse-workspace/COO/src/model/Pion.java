package model;

public class Pion extends AbstractPiece implements Pions{
	
	private boolean firstPlay = true;
	
	public Pion(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece,coord);
	}
	
	
	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		return false;
	}
	


	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		boolean ret = false;
		if(getCouleur() == Couleur.NOIR) {
			if (firstPlay) {
				if (xFinal == getX() && (yFinal == getY()+1 || yFinal == getY()+2)){
					ret = true;
					firstPlay = false;
				}
			else {
				if (xFinal == getX() && yFinal == getY()+1){
					ret = true;
					}
			}
			}
		}
		else if(getCouleur() == Couleur.BLANC) {
			if (firstPlay) {
				
				if (xFinal == getX() && (yFinal == getY()-1 || yFinal == getY()-2)){
					ret = true;
					firstPlay = false;
					}
			}
			else {
				if (xFinal == getX() && yFinal == getY()-1){
					ret = true;
					}
			}
		
		}
		return ret;
	}
	

}
