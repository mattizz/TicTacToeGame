import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mateusz on 15.12.2017.
 */
public class MenuAPI extends JFrame implements ActionListener{

    private JPanel theMainPanel;
    private JButton newGameButton;
    private JButton statisticsButton;
    private JButton exitButton;
    private boolean firstGame = true;
    private TicTacToe game;
    private int numberOfGames=0;

    public MenuAPI(){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double halfWidth = screenSize.getWidth()/2;
        double halfHeight = screenSize.getHeight()/2;

        int x = (int) halfWidth;
        int y= (int) halfHeight;

        this.setBounds(x-100, y-75, 200, 150);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        theMainPanel = new JPanel();
        theMainPanel.setLayout(new BoxLayout(theMainPanel, BoxLayout.PAGE_AXIS));
        this.add(theMainPanel);

        newGameButton = new JButton("New game");
        newGameButton.addActionListener(this);
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        statisticsButton = new JButton("Statistics");
        statisticsButton.addActionListener(this);
        statisticsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        theMainPanel.add(Box.createRigidArea(new Dimension(0,10)));
        theMainPanel.add(newGameButton);
        theMainPanel.add(Box.createRigidArea(new Dimension(0,10)));
        theMainPanel.add(statisticsButton);
        theMainPanel.add(Box.createRigidArea(new Dimension(0,10)));
        theMainPanel.add(exitButton);
        theMainPanel.add(Box.createRigidArea(new Dimension(0,10)));
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==newGameButton){
            if(firstGame==true){
                numberOfGames++;
                game = new TicTacToe();
                firstGame=false;
            }else{
                numberOfGames++;
                game.dispose();
                game = new TicTacToe();
            }
        }else if(e.getSource()==statisticsButton){
            System.out.println("Liczba rozegranych gier - " + numberOfGames);
        }else if(e.getSource()==exitButton){
            System.exit(0);
        }
    }
}
