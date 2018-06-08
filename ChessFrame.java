import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessFrame extends JFrame{
    private JPanel mainPanel;
    private JLabel board;
    private JButton upArrow, downArrow;
    private JLabel elevatorLevel, playerA, playerB;
    private int currentDimension;
    
    public ChessFrame(){
      super("3d chess is great");
      mainPanel = new JPanel(new GridBagLayout());
      add(mainPanel);
      currentDimension = 1;
      addElements();
      setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
      setVisible(true);
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
      board = new JLabel(createImageIcon("Chess Piece Icons/ChessBoard.jpg"));
      mainPanel.add(board, c);
      
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.gridx = 3;
      c.gridy = 0;
      c.weightx = 0.1;
      c.insets = new Insets(10, 20, 10, 20);
      
      upArrow = new JButton(createImageIcon("Chess Piece Icons/UpArrow.png"));
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
      
      downArrow = new JButton(createImageIcon("Chess Piece Icons/DownArrow.png"));
      downArrow.setPreferredSize(new Dimension(64,64));
      mainPanel.add(downArrow, c);
      downArrow.addActionListener(new DownArrowAction());
    }
    
    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } 
        else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    private class DownArrowAction implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            currentDimension--;
            elevatorLevel.setText(Integer.toString(currentDimension));
        }
    }
    private class UpArrowAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            currentDimension++;
            elevatorLevel.setText(Integer.toString(currentDimension));
        }
    }
}
