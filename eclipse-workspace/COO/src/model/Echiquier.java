package model;

import java.util.List;

public class Echiquier implements BoardGames {

	public Echiquier() {
		
	}
	
	public void switchJoueur() {
		
	}
	
	public List<PieceIHM> getPiecesIHM(){
		return null;
		
	}
	
	public String toString() {
		return "";
	}
	
	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		return false;
	}

}
