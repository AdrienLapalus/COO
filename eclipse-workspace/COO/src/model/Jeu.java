package model;

import java.util.LinkedList;
import java.util.List;

import tools.ChessPiecesFactory;
import tools.ChessSinglePieceFactory;



public class Jeu {
	
	private Couleur couleur;

	Coord previousCoord = new Coord(-1,-1);
	Coord currentCoord = new Coord(-1,-1);
	List<Pieces> pieces;
	
	public Jeu(Couleur couleur) {
		this.couleur = couleur;
		pieces = ChessPiecesFactory.newPieces(couleur);
	}
	
	public boolean capture(int xCatch, int yCatch) {
		return false;
	}
	
	public void setPossibleCapture() {
		
	}
	
	public void setCastling() {
		
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	
	public Coord getKingCoord() {
		Coord c = new Coord(0,0);
		for(Pieces p : pieces) {
			if(getPieceType(p.getX(), p.getY()) == Roi.class.getSimpleName()) {
				c.x = p.getX();
				c.y = p.getY();
				
			}
		}
		return c;
	}

	public Couleur getPieceColor(int x, int y) {
		Couleur ret = null;
		Pieces p = findPiece(x, y);
		if(p != null) {
			ret = p.getCouleur();
		}
		return ret;
	}
	
	public List<PieceIHM> getPiecesIHM(){
		PieceIHM newPieceIHM = null;
		List<PieceIHM> list = new LinkedList<PieceIHM>();
		for (Pieces piece : pieces){
			boolean existe = false;
			// si le type de piece existe déjà dans la liste de PieceIHM
			// ajout des coordonnées de la pièce dans la liste de Coord de ce type
			// si elle est toujours en jeu (x et y != -1)
			for ( PieceIHM pieceIHM : list){
				if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
					existe = true;
					if (piece.getX() != -1){
						pieceIHM.add(new Coord(piece.getX(), piece.getY()));
					}
				}
			}
			// sinon, création d'une nouvelle PieceIHM si la pièce est toujours en jeu
			if (! existe) {
				if (piece.getX() != -1){
					newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
					piece.getCouleur());
					newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
					list.add(newPieceIHM);
				}
			}
		}
		return list;
		}
	
	public String getPieceType(int x,int y) {
		String ret = "";
		Pieces p = findPiece(x, y);
		ret = getClass().getSimpleName();
		return ret;
	}
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal){
		boolean ret = false;
		if ((xInit != xFinal && yInit == yFinal) || (xInit == xFinal && yInit != yFinal)) {
			if(Coord.coordonnees_valides(xFinal, yFinal)) {
				ret = true;
			}
		}
		return ret;
		
	}
	public void undoMove() {
		//TODO
		if (previousCoord.x != -1 && previousCoord.y != -1) {
			Pieces piece = findPiece(currentCoord.x, currentCoord.y);
			pieces.remove(piece);
			pieces.add(ChessSinglePieceFactory.newPiece(piece.getCouleur(), getPieceType(currentCoord.x, currentCoord.y), previousCoord.x, previousCoord.y));
		}
		
	}
	
	public void undoCapture() {
		
	}
	
	public boolean isPawnPromotion(int xFinal, int yFinal) {
		return false;
	}
	
	public boolean move(int xInit,int yInit,int xFinal,int yFinal) {
		boolean ret = false;
		boolean test = false;
		if(isMoveOk(xInit, yInit, xFinal, yFinal)) {
			Pieces piece = findPiece(xInit, yInit);
			test = piece.move(xFinal, yFinal);
			if(test) {			
				previousCoord.x = xInit;
				previousCoord.y = yInit;
				currentCoord.x = xInit;
				currentCoord.y = yInit;
				ret = true;
			}
		}
		return ret;
	}
	
	public boolean isPieceHere(int x,int y) {
		boolean ret = false;
		if(findPiece(x,y) != null) {
			ret = true;
		}
		return ret;
	}
	

	@Override
	public String toString() {
		String ret = "";
		for(Pieces p : pieces) {
			ret += p.toString() +"\n";
		}
		return ret;
	}
	
	
	private Pieces findPiece(int x, int y) {
		Pieces ret = null;
		for(Pieces p : pieces) {
			if(p.getX() == x && p.getY() == y) {
				ret = p;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Jeu j = new Jeu (Couleur.BLANC);
		System.out.println(j);
		boolean oui = j.move(7, 6,7, 4);
		System.out.println(j);
		
	}
}
	

	