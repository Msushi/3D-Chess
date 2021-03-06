package chessGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessFrame extends JFrame{
    private JPanel mainPanel;
    private JButton upArrow, downArrow;
    private ChessBoard board;
    private JLabel elevatorLevel, playerA, playerB;
    private static int currentDimension;
    
    
    public ChessFrame(){
      super("Three-Dimensional Chess");
      mainPanel = new JPanel(new GridBagLayout());
      add(mainPanel);
      currentDimension = 1;
      addElements();
      mainPanel.setVisible(true);
    }
    
    public static int getDimension(){
        return currentDimension-1;
    }
    
    
    private void addElements(){
      elevatorLevel = new JLabel("1");
      
      GridBagConstraints c = new GridBagConstraints();
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 0;
      c.gridy = 0;
      c.weightx = 0.6;
      c.gridwidth = 3;
      c.gridheight = 3;
      board = new ChessBoard();
      board.addMouseListener(new MouseAction());
      board.setPreferredSize(new Dimension(360, 360));
      mainPanel.add(board, c);
      
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.gridx = 3;
      c.gridy = 0;
      c.weightx = 0.1;
      c.insets = new Insets(10, 20, 10, 20);
      
      upArrow = new JButton(new ImageIcon("Chess_Piece_Icons/UpArrow.png"));
      upArrow.setPreferredSize(new Dimension(64,64));
      mainPanel.add(upArrow, c);
      upArrow.addActionListener(new UpArrowAction());
      
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 3;
      c.gridy = 1;
      c.weighty = 0.1;
      c.insets = new Insets(10, 20, 10, 20);
      
      elevatorLevel = new JLabel(Integer.toString(currentDimension));
      mainPanel.add(elevatorLevel, c);
      
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 3;
      c.gridy = 2;
      c.weighty = 0.1;
      c.insets = new Insets(10, 20, 10, 20);
      
      downArrow = new JButton(new ImageIcon("Chess_Piece_Icons/DownArrow.png"));
      downArrow.setPreferredSize(new Dimension(64,64));
      mainPanel.add(downArrow, c);
      downArrow.addActionListener(new DownArrowAction());
      
      System.out.println(board.getY() + " is the lottery num of the day");
    }
    
    private class DownArrowAction implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (currentDimension != 1) {
                currentDimension--;
                elevatorLevel.setText(Integer.toString(currentDimension));
                board.repaint();
            }
            
        }
    }
    private class UpArrowAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (currentDimension != 8) {
                currentDimension++;
                elevatorLevel.setText(Integer.toString(currentDimension));
                board.repaint();
            }
            
        }
    }
    private class MouseAction implements MouseListener {
        public void mouseClicked(MouseEvent e) {
        	System.out.println("Mouse Coordinates: " + e.getX() + ", " + (e.getY()));
            System.out.println(Integer.toString((e.getX() - board.getX()) / 45) + Integer.toString((e.getY()) / 45) + Integer.toString(currentDimension) );
            if (board.interpretInput((e.getX() - board.getX()) / 45, (e.getY()) / 45, getDimension())){
                board.repaint();
        	}
        }
        public void mouseEntered(MouseEvent e) {
            
        }
        public void mouseExited(MouseEvent e) {
            
        }
        public void mousePressed(MouseEvent e) {
            
        }
        public void mouseReleased(MouseEvent e) {
            
        }
    }
}
