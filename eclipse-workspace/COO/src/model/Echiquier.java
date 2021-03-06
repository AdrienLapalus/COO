package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Echiquier implements BoardGames {
	
	private String message;
	Jeu currentJeu;
	Jeu previousJeu;
	
	Jeu jb;
	Jeu jn;
	
	
	public Echiquier() {
		jb = new Jeu(Couleur.BLANC);
		jn = new Jeu(Couleur.NOIR);
		currentJeu = jb;
		
	}
	
	public void switchJoueur() {
		if (currentJeu == jb) {
			message += "\nC'est au tour du noir";
			currentJeu = jn;
			previousJeu = jb;
		}
		else {
			message += "\nC'est au tour du blanc";
			currentJeu = jb;
			previousJeu = jn;
		}
	}
	
	public List<PieceIHM> getPiecesIHM(){
		List<PieceIHM> list = new LinkedList<PieceIHM>();
		List<PieceIHM> pieceb = jb.getPiecesIHM();
		List<PieceIHM> piecen = jn.getPiecesIHM();
		list.addAll(pieceb);
		list.addAll(piecen);
		return list;
	}
	
	public String toString() {
		String ret = "";
		ret += "Jeu Blanc : \n";
		ret += jb.toString();
		ret += "Jeu Noir : \n";
		ret += jn.toString();
		return ret;
	}
	
	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean ret = false;
		if(isMoveOk(xInit, yInit, xFinal, yFinal)) {
			currentJeu.move(xInit, yInit, xFinal, yFinal);
			ret = true;
		}
		message = "";
		message += ret;
		message += "\n";
		return ret;
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		Couleur couleur = currentJeu.getCouleur();
		return couleur;
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		Couleur couleur = currentJeu.getPieceColor(x, y);
		return couleur;
	}

	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		boolean ret = false;
		ret = currentJeu.isMoveOk(xInit, yInit, xFinal, yFinal);
		return ret;
	}
	
	public static void main(String[] args) {
		Echiquier e = new Echiquier();
		System.out.println(e);
		System.out.println(e.getPieceColor(3, 6));
		e.switchJoueur();
		System.out.println(e.getPieceColor(3, 6));
	}
	
}
