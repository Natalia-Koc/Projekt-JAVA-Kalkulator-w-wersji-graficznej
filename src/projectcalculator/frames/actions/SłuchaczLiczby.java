package projectcalculator.frames.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import projectcalculator.frames.myElements.MyJButton;

public class SłuchaczLiczby implements ActionListener {

    JTextField poleTekstowe;

    public SłuchaczLiczby(JTextField poleTekstowe) {
        this.poleTekstowe = poleTekstowe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (MyJButton) e.getSource();
        String value = source.getText();
        poleTekstowe.setText(poleTekstowe.getText() + value);
    }
}
