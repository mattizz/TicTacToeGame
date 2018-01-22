import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mateusz on 14.12.2017.
 */
public class TicTacToe extends JFrame implements ActionListener{

    private JPanel theGamePanel = new JPanel();
    private XOButton buttons[] = new XOButton[9];
    private int turn = 1;
    private int visitedFields = 0;
    public boolean draw = false;
    private boolean win = false;


    public TicTacToe(){
        super("TicTacToe");
        this.setSize(400, 400);
        setResizable(true);

        theGamePanel.setBounds(0, 200, 400, 400 );
        theGamePanel.setLayout(new GridLayout(3, 3 ));
        for(int i=0; i<9; i++){
            buttons[i] = new XOButton();
            buttons[i].addActionListener(this);
            theGamePanel.add(buttons[i]);
        }

        this.add(theGamePanel);
        setVisible(true);
    }


    public void checkResult(){

        //CHECK COLUMNS
        for(int i=0; i<3; i++){
            if(buttons[i].getSign()==0 && buttons[i+3].getSign()==0 && buttons[i+6].getSign()==0){
                System.out.println("Wygraly O");
                win=true;
            }else if(buttons[i].getSign()==1 && buttons[i+3].getSign()==1 && buttons[i+6].getSign()==1){
                System.out.println("Wygraly X");
                win=true;
            }
        }

        //CHECK ROWS
        for(int i=0; i<9; i+=3){
            if(buttons[i].getSign()==0 && buttons[i+1].getSign()==0 && buttons[i+2].getSign()==0){
                System.out.println("Wygraly O");
                win=true;
            }else if(buttons[i].getSign()==1 && buttons[i+1].getSign()==1 && buttons[i+2].getSign()==1){
                System.out.println("Wygraly X");
                win=true;
            }
        }

        //CHECK DIAGONAL ->
        if(buttons[0].getSign()==0 && buttons[4].getSign()==0 && buttons[8].getSign()==0){
            System.out.println("Wygraly O");
            win=true;
        }else if(buttons[0].getSign()==1 && buttons[4].getSign()==1 && buttons[8].getSign()==1){
            System.out.println("Wygraly X");
            win=true;
        }

        //CHECK DIAGONAL <-
        if(buttons[2].getSign()==0 && buttons[4].getSign()==0 && buttons[6].getSign()==0){
            System.out.println("Wygraly O");
            win=true;
        }else if(buttons[2].getSign()==1 && buttons[4].getSign()==1 && buttons[6].getSign()==1){
            System.out.println("Wygraly X");
            win=true;
        }

        if(win!=true && visitedFields==9){
            draw=true;
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<9; i++){
            if((e.getSource()==buttons[i]) && (buttons[i].isSet()==false)){
                buttons[i].setIsSet(true);
                visitedFields++;
                buttons[i].setIcon(turn);
                if(win==false){
                    if(turn==0){
                        turn=1;
                    }else if(turn==1) {
                        turn = 0;
                    }
                }
                checkResult();
                if(win==true){
                    ResultWindow winWindow = new ResultWindow(turn);
                    winWindow.setWindow(this);
                }else if(draw==true){
                    ResultWindow winWindow = new ResultWindow(2);
                    winWindow.setWindow(this);
                }
            }
        }
    }
}
