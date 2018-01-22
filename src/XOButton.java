import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mateusz on 14.12.2017.
 */
public class XOButton extends JButton{

    ImageIcon X, O;
    private boolean isSet=false;
    private int sign =  2 ; //0 - o, 1- X, 2 - nothing

    public XOButton(){
        X = new ImageIcon(this.getClass().getResource("x.png"));
        O = new ImageIcon(this.getClass().getResource("o.png"));
    }

    public void setIsSet(boolean set) {
        isSet = set;
    }

    public boolean isSet() {
        return isSet;
    }

    public void setIcon(int i){
        sign=i;
        if(i==0) {
            setIcon(O);

        }else if(i==1){
            setIcon(X);
        }
    }

    public int getSign() {
        return sign;
    }
}
