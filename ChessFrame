import javax.swing.*;

public class ChessFrame extends JFrame{
    private JPanel mainPanel;
    private //picture of chessboard;
    private JButton upArrow, downArrow;
    private JLabel elevatorLevel, playerA, playerB;
    
    public ChessFrame(){
      super("3d chess is great");
      mainPanel = new JPanel(new GridBagLayout());
      add(mainPanel);
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
      mainpanel.add(//ADD_THAT_CHESSBOARD_HERE, c);
      
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.gridx = 3;
      c.gridy = 0;
      c.weightx = 0.1;
      c.insets = new Insets(10, 20, 10, 20);
      
      upArrow = new JButton(//gimme that arrow icon);
      mainpanel.add(upArrow, c);
      
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 3;
      c.gridy = 1;
      c.weighty = 0.1;
      c.insets = new Insets(10, 20, 10, 20);
      
      elevatorLevel = new JLabel("1");
      mainpanel.add(elevatorLevel, c);
      
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 3;
      c.gridy = 2;
      c.weighty = 0.1;
      c.insets = new Insets(10, 20, 10, 20);
      
      downArrow = new JButton(//gimme that arrow icon);
      mainpanel.add(downArrow, c);
