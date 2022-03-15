package model;

public interface Pieces {
	
	public boolean capture();
	
	public Couleur getCouleur();
	
	public int getX();
	
	public int getY();
	
	public boolean isMoveOK(int xFinal, int yFinal);
	
	public boolean move(int xFinal, int yFinal);

}
