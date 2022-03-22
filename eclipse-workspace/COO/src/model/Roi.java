/**
 * 
 */
package model;

/**
 * @author cpe
 *
 */
public class Roi extends AbstractPiece {

	/**
	 * @param couleur
	 * @param coord
	 */
	public Roi(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	@Override
	public boolean isMoveOK(int xFinal, int yFinal) {
		boolean ret = false;
		if (!(xFinal == getX() && yFinal == getY())) {
			if(Math.abs(xFinal - getX()) <= 1 && Math.abs(yFinal-getY()) <= 1){
				ret = true;
			}
			
		}
		
		return ret;
	}

}
