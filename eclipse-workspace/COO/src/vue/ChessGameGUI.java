package vue;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import javax.swing.JFrame;

import controler.ChessGameControlers;
import controler.controlerLocal.ChessGameControler;
import model.Coord;
import model.Couleur;
import model.PieceIHM;
import tools.ChessImageProvider;
import tools.ChessPieceImage;

public class ChessGameGUI extends JFrame implements MouseListener, MouseMotionListener, Observer {
	
	JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;
	ChessGameControlers chessGameControler;
    Coord initCoord;
	Coord finalCoord;
	
    public ChessGameGUI() {
    	
    }
    
    public ChessGameGUI(String name,ChessGameControlers chessGameControler,Dimension boardSize) {
    	
        //  Use a Layered Pane for this this application
        	 layeredPane = new JLayeredPane();
        	  getContentPane().add(layeredPane);
        	  layeredPane.setPreferredSize(boardSize);
        	  layeredPane.addMouseListener(this);
        	  layeredPane.addMouseMotionListener(this);
        	  
        	  this.chessGameControler = chessGameControler;
        	  //Add a chess board to the Layered Pane 
        	 
        	  chessBoard = new JPanel();
        	  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        	  chessBoard.setLayout( new GridLayout(8, 8) );
        	  chessBoard.setPreferredSize( boardSize );
        	  chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
        	 
        	  for (int i = 0; i < 64; i++) {
        	  JPanel square = new JPanel( new BorderLayout() );
        	  chessBoard.add( square );
        	 
        	  int row = (i / 8) % 2;
        	  if (row == 0)
        	  square.setBackground( i % 2 == 0 ? Color.black : Color.white );
        	  else
        	  square.setBackground( i % 2 == 0 ? Color.white : Color.black );
        	  }
    	
    }
    	 
    	  //Add a few pieces to the board
    	 /*
    	  JLabel piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile("Pion",Couleur.BLANC))) ;
    	  JPanel panel = (JPanel)chessBoard.getComponent(0);
    	  panel.add(piece);
    	  piece = new JLabel(new ImageIcon("/home/vinod/amarexamples/chess1.jpg"));
    	  panel = (JPanel)chessBoard.getComponent(15);
    	  panel.add(piece);
    	  piece = new JLabel(new ImageIcon("/home/vinod/amarexamples/king.jpg"));
    	  panel = (JPanel)chessBoard.getComponent(16);
    	  panel.add(piece);
    	  piece = new JLabel(new ImageIcon("/home/vinod/amarexamples/camel.jpg"));
    	  panel = (JPanel)chessBoard.getComponent(20);
    	  panel.add(piece);
    	  */
    
public void update(Observable arg0, Object arg1) {
	List<PieceIHM> piecesIHM = (List<PieceIHM>) arg1;
	// création d'un tableau 2D avec les noms des pièces
	for(PieceIHM pieceIHM : piecesIHM) {
		Couleur color = pieceIHM.getCouleur();
		String type = pieceIHM.getTypePiece();
		for(Coord coord : pieceIHM.getList()) {
			JLabel piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile(type,color)));
	   	  	JPanel panel = (JPanel)chessBoard.getComponent(coord.y*8 + coord.x);
	   	  	if(panel.getComponentCount() == 0) {
	   	  		panel.add(piece);
	   	  	}
	   	  	
		}
		
		
	}
}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e){
		  chessPiece = null;
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		 
		  if (c instanceof JPanel) 
		  return;
		  
		
		  Point parentLocation = c.getParent().getLocation();
		  xAdjustment = parentLocation.x - e.getX();
		  yAdjustment = parentLocation.y - e.getY();
		  initCoord = getCoord(c);
		  chessPiece = (JLabel)c;
		  chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		  layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
		  }
	
	private Coord getCoord(Component c) {
		  Component square = c instanceof JLabel ? c.getParent() : c;
		  Container ech = square.getParent();
		  Component[] cases = ech.getComponents();
		  int indexCases = Arrays.asList(cases).indexOf(square);
		  int x = indexCases%8;
		  int y = indexCases/8;
		  return new Coord(x,y);
	}
	@Override
	 public void mouseReleased(MouseEvent e) {
		  if(chessPiece == null) return;
		 
		  chessPiece.setVisible(false);
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		  Container ech = c.getParent();
		  Component[] cases = ech.getComponents();
		  System.out.println(cases);
		  finalCoord = getCoord(c);
		  System.out.println(initCoord + "" +finalCoord);
		  boolean result = chessGameControler.move(initCoord, finalCoord);
		  System.out.println(result);
		  if(result) {
			  if (c instanceof JLabel){
				  Container parent = c.getParent();
				  parent.remove(0);
				  parent.add( chessPiece );
				  }
			  else {
				  Container parent = (Container)c;
				  parent.add( chessPiece );
				  }
			  chessPiece.setVisible(true);
				  }
		  	
		  }
		

	@Override
	public void mouseDragged(MouseEvent me) {
		  if (chessPiece == null) return;
		 chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
		 }

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		  JFrame frame = new ChessGameGUI();
		  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
		  frame.pack();
		  frame.setResizable(true);
		  frame.setLocationRelativeTo( null );
		  frame.setVisible(true);
		 }
}
