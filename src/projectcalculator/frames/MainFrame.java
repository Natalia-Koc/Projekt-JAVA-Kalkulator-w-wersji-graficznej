package projectcalculator.frames;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    public MainFrame(String tytuł) {
        super(tytuł);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(494, 579);
        setLayout(null);
        setLocation(600, 50);
        add(new ButtonsPanel());
        setVisible(true);
    }

}
