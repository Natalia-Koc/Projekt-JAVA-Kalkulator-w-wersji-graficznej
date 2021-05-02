package projectcalculator.frames;

import java.awt.EventQueue;
import projectcalculator.frames.myElements.MyJButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import projectcalculator.frames.actions.SłuchaczLiczby;

public class ButtonsPanel extends JPanel {

    JTextField poleTekstowe;
    String liczba = "0", znak, pamiec;
    Double wynik = 0.0;
    Obliczenia obliczenia = new Obliczenia();

    public ButtonsPanel() {
        super();
        setLayout(null);
        setSize(500, 545);
        setButtons();
    }

    private void setButtons() {
        JTextField renderujPoleTekstowe = renderujPoleTekstowe();
        renderujPoleTekstowe.setBounds(6, 6, 466, 118);
        add(renderujPoleTekstowe);
        JPanel renderujLiczby = renderujLiczby(renderujPoleTekstowe);
        renderujLiczby.setBounds(0, 251, 360, 250);
        add(renderujLiczby);
        JPanel renderujProsteOperacje = renderujProsteOperacje(renderujPoleTekstowe);
        renderujProsteOperacje.setBounds(360, 190, 121, 310);
        add(renderujProsteOperacje);
        JPanel renderujTrudneOperacje = renderujTrudneOperacje(renderujPoleTekstowe);
        renderujTrudneOperacje.setBounds(0, 190, 360, 62);
        add(renderujTrudneOperacje);
        JPanel renderujTrygonometrie = renderujTrygonometrie(renderujPoleTekstowe);
        renderujTrygonometrie.setBounds(0, 128, 482, 62);
        add(renderujTrygonometrie);
        JPanel renderujZapis = renderujZapis(renderujPoleTekstowe);
        renderujZapis.setBounds(0, 500, 481, 42);
        add(renderujZapis);
    }

    private JTextField renderujPoleTekstowe() {
        JTextField panelTekstowy = new JTextField();
        panelTekstowy.setFont(new Font("Arial", Font.PLAIN, 20));
        panelTekstowy.setHorizontalAlignment(SwingConstants.RIGHT);
        return panelTekstowy;
    }

    private JPanel renderujProsteOperacje(JTextField poleTekstowe) {
        JPanel panelLiczby = new JPanel(new GridLayout(5, 1));
        liczba = poleTekstowe.getText();
        MyJButton dzielenie = new MyJButton("/");
        dzielenie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obliczenia.setX(Double.parseDouble(poleTekstowe.getText()));
                obliczenia.setZnak("/");
                poleTekstowe.setText("");
            }
        });
        panelLiczby.add(dzielenie);
        MyJButton mnożenie = new MyJButton("*");
        mnożenie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obliczenia.setX(Double.parseDouble(poleTekstowe.getText()));
                obliczenia.setZnak("*");
                poleTekstowe.setText("");
            }
        });
        panelLiczby.add(mnożenie);
        MyJButton odejmowanie = new MyJButton("-");
        odejmowanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obliczenia.setX(Double.parseDouble(poleTekstowe.getText()));
                obliczenia.setZnak("-");
                poleTekstowe.setText("");
            }
        });
        panelLiczby.add(odejmowanie);
        MyJButton dodawanie = new MyJButton("+");
        dodawanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obliczenia.setX(Double.parseDouble(poleTekstowe.getText()));
                poleTekstowe.setText("");
                obliczenia.setZnak("+");
                obliczenia.dodawanie();
            }
        });
        panelLiczby.add(dodawanie);
        MyJButton oblicz = new MyJButton("=");
        oblicz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obliczenia.setY(Double.parseDouble(poleTekstowe.getText()));
                poleTekstowe.setText(Double.toString(obliczenia.getWynik()));
            }
        });
        panelLiczby.add(oblicz);
        return panelLiczby;
    }

    private JPanel renderujLiczby(JTextField poleTekstowe) {
        JPanel panelLiczby = new JPanel(new GridLayout(4, 3));
        SłuchaczLiczby słuchaczLiczby = new SłuchaczLiczby(poleTekstowe);

        for (int i = 9; i > 0; i--) {
            MyJButton liczba = new MyJButton("" + i, poleTekstowe);
            panelLiczby.add(liczba);
        }
        MyJButton liczba1 = new MyJButton("");
        panelLiczby.add(liczba1);
        MyJButton liczba2 = new MyJButton("0", poleTekstowe);
        panelLiczby.add(liczba2);
        MyJButton liczba3 = new MyJButton(".", poleTekstowe);
        panelLiczby.add(liczba3);
        return panelLiczby;
    }

    private JPanel renderujTrudneOperacje(JTextField poleTekstowe) {
        JPanel panelLiczby = new JPanel(new GridLayout(1, 3));

        MyJButton undo = new MyJButton("C");
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                poleTekstowe.setText("");
                liczba = "0";
                wynik = 0.0;
            }
        });
        panelLiczby.add(undo);
        MyJButton potega = new MyJButton("^2");
        potega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczba = poleTekstowe.getText();
                String linia = Double.toString(Math.pow(Double.parseDouble(liczba), 2));
                poleTekstowe.setText(linia);
                pamiec = liczba + "^2" + "=" + linia;
                zapis();
            }
        });
        panelLiczby.add(potega);
        MyJButton pierwiastek = new MyJButton("√");
        pierwiastek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczba = poleTekstowe.getText();
                String linia = Double.toString(Math.sqrt(Double.parseDouble(liczba)));
                poleTekstowe.setText(linia);
                pamiec = "√" + liczba + "=" + linia;
                zapis();
            }
        });
        panelLiczby.add(pierwiastek);
        return panelLiczby;
    }

    private JPanel renderujTrygonometrie(JTextField poleTekstowe) {
        JPanel panelLiczby = new JPanel(new GridLayout(1, 4));

        MyJButton sin = new MyJButton("sin");
        sin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczba = poleTekstowe.getText();
                String linia = Double.toString(Math.sin(Double.parseDouble(liczba)));
                poleTekstowe.setText(linia);
                pamiec = "sin(" + liczba + ") =" + linia;
                zapis();
            }
        });
        panelLiczby.add(sin);
        MyJButton cos = new MyJButton("cos");
        cos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczba = poleTekstowe.getText();
                String linia = Double.toString(Math.cos(Double.parseDouble(liczba)));
                poleTekstowe.setText(linia);
                pamiec = "cos(" + liczba + ") =" + linia;
                zapis();
            }
        });
        panelLiczby.add(cos);
        MyJButton tg = new MyJButton("tg");
        tg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczba = poleTekstowe.getText();
                String linia = Double.toString(Math.tan(Double.parseDouble(liczba)));
                poleTekstowe.setText(linia);
                pamiec = "tan(" + liczba + ") =" + linia;
                zapis();
            }
        });
        panelLiczby.add(tg);
        MyJButton ctg = new MyJButton("ctg");
        ctg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczba = poleTekstowe.getText();
                String linia = Double.toString(1 / Math.cos(Double.parseDouble(liczba)));
                poleTekstowe.setText(linia);
                pamiec = "ctg(" + liczba + ") =" + linia;
                zapis();
            }
        });
        panelLiczby.add(ctg);
        return panelLiczby;
    }

    private JPanel renderujZapis(JTextField poleTekstowe) {
        JPanel panelLiczby = new JPanel(new GridLayout(1, 1));

        MyJButton zapis = new MyJButton("Historia operacji");
        zapis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new Historia();
                        } catch (IOException ex) {
                            System.out.println("Brak pliku!");
                        }
                    }
                });
            }
        });
        panelLiczby.add(zapis);
        return panelLiczby;
    }

    public void zapis() {
        try {
            File file = new File("HistoriaOperacji.txt");
            FileWriter strumienDoPliku = new FileWriter(file, true);
            BufferedWriter zapisujeNaRaz = new BufferedWriter(strumienDoPliku);
            zapisujeNaRaz.write(pamiec + "\n");
            zapisujeNaRaz.close();
        } catch (IOException e) {
            System.out.println("Brak pliku!");
        }
    }
}
