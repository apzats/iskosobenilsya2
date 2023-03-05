package domain.app;
import java.awt.event.*;

import org.w3c.dom.css.Counter;


public class ActionHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(frame,"Любое событие:" + counter);
        if(e.getSource() == textField) {
            counter = Long.parseLong(textField.getText(), 10);
            JOptionPane.showMessageDialog(frame,"Ваш период:" + counter);
       }
    }

    
}
