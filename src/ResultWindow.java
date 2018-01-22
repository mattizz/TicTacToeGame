import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mateusz on 16.12.2017.
 */
public class ResultWindow extends JFrame implements ActionListener
{
    private JPanel thePanel;
    private JLabel theLabel;
    private JButton theButton;
    private String text;
    private TicTacToe window = null;

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==theButton){
            new TicTacToe();
            this.dispose();
            if(window!=null){
                window.dispose();
            }
        }
    }


    public ResultWindow(int result){
            this.setBounds(50, 50, 200, 100);
            this.setResizable(false);
            this.setVisible(true);

            thePanel = new JPanel();
            thePanel.setLayout(new BoxLayout(thePanel, BoxLayout.PAGE_AXIS));
            this.add(thePanel);

            if(result==0){
                text="Wygraly X!";
            }else if(result==1){
                text="Wygraly O!";
            }else if(result==2){
                text="REMIS";
            }

            theLabel = new JLabel(text);
            theButton = new JButton("OK");

            theLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            theButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            theButton.addActionListener(this);
            thePanel.add(Box.createRigidArea(new Dimension(0,10)));
            thePanel.add(theLabel);
            thePanel.add(Box.createRigidArea(new Dimension(0,10)));
            thePanel.add(theButton);
            thePanel.add(Box.createRigidArea(new Dimension(0,10)));
        }

    public void setWindow(TicTacToe window) {
        this.window = window;
    }
}