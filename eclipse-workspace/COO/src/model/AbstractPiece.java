package model;

public abstract class AbstractPiece implements Pieces {
	
	public String name;
	private Couleur couleur;
	private Coord coord;

	public AbstractPiece(Couleur couleur, Coord coord) {
		this.name = getClass().getSimpleName();
		this.couleur = couleur;
		this.coord = coord;
	}
	
	public boolean capture() {
		return false;
		
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	
	public int getX() {
		return coord.x;
	}
	
	public int getY() {
		return coord.y;
	}
	
	public abstract boolean isMoveOK(int xFinal, int yFinal);
	
	public boolean move(int xFinal, int yFinal) {
		boolean ret = false;
		if(isMoveOK(xFinal, yFinal)) {
			coord.x = xFinal;
			coord.y = yFinal;
			ret = true;
		}	
		return ret;
	}
	
	/*
	public boolean validCoord(int xFinal,int yFinal) {
		boolean ret = false;
		if (xFinal >= 0 && xFinal <= 7 && yFinal >= 0 && yFinal <= 7) {
			ret = true;
		}
		return ret;
	}
	*/
	
	
	public String toString() {
		return name +  " est aux coordonnée" + coord;
	}
	
	public static void main(String[] args) {
		Pieces maTour = new Tour(Couleur.NOIR, new Coord(0, 0));
		Pieces monRoi = new Roi(Couleur.BLANC, new Coord(2,2));
		System.out.println(monRoi.move(3, 3));
		System.out.println(monRoi);
	}
}

