package projectcalculator.frames;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;

public class Historia extends JFrame {

    public Historia() throws IOException {
        File file1 = new File("HistoriaOperacji.txt");
        Desktop desktop = Desktop.getDesktop();

        if (!Desktop.isDesktopSupported()) {
            System.out.println(" Desktop nie jest wspierany ");
            return;
        }
        if (file1.exists()) {
            desktop.open(file1);
        }
    }

}
