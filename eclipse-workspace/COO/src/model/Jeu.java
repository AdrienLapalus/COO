package model;

import java.awt.List;

public class Jeu {
	
	private Couleur couleur;

	public Jeu(Couleur couleur) {
		this.couleur = couleur;
	}
	
	public boolean capture(int xCatch, int yCatch) {
		return false;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	
	public Coord getKingCoord() {
		return null;
	}

	public Couleur getPieceColor(int x, int y) {
		return null;
	}
	
	public List<PieceIHM> getPiecesIHM(){
		return null;
	}
	
	public String getPieceType(int x,int y) {
		return null;
	}
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal){
	}
	
	public boolean isPawnPromotion(int xFinal, int yFinal) {
		return false;
	}
}
	
}