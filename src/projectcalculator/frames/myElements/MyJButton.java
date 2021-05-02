package projectcalculator.frames.myElements;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import projectcalculator.frames.actions.SłuchaczLiczby;

/**
 *
 * @author Tala
 */
public class MyJButton extends JButton {

    public MyJButton() {
        super();
    }

    public MyJButton(String text, JTextField poleTekstowe) {
        super(text);
        this.addActionListener(new SłuchaczLiczby(poleTekstowe));

        Border border = BorderFactory.createBevelBorder(1, Color.red, Color.blue);
        this.setBorder(border);

    }

    public MyJButton(String text) {
        super(text);

        Border border = BorderFactory.createBevelBorder(1, Color.red, Color.blue);
        this.setBorder(border);

    }

}
