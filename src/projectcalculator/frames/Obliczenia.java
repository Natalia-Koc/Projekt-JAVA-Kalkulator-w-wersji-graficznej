package projectcalculator.frames;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextField;

public class Obliczenia {

    private double x;
    private double y = 0;
    private double wynik;
    private String znak, pamiec = "", symbol;
    JTextField poleTekstowe;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getWynik() {
        switch (this.znak) {
            case "+":
                dodawanie();
                break;
            case "-":
                odejmowanie();
                break;
            case "*":
                mnozenie();
                break;
            case "/":
                dzielenie();
                break;
            default:
                break;
        }
        try {
            File file = new File("HistoriaOperacji.txt");
            FileWriter czyIstnieje = new FileWriter(file, true);
            BufferedWriter pomocZapisu = new BufferedWriter(czyIstnieje);
            pomocZapisu.write(pamiec + "\n");
            pomocZapisu.close();
        } catch (IOException e) {
            System.out.println("Brak pliku!");
        }
        return wynik;
    }

    public void setWynik(double wynik) {
        this.wynik = wynik;
    }

    public void setZnak(String znak) {
        this.znak = znak;
    }

    public void dodawanie() {
        wynik = x + y;
        pamiec = Double.toString(x) + "+" + Double.toString(y) + "=" + Double.toString(wynik);
    }

    public void odejmowanie() {
        wynik = x - y;
        pamiec = Double.toString(x) + "-" + Double.toString(y) + "=" + Double.toString(wynik);
    }

    public void mnozenie() {
        wynik = x * y;
        pamiec = Double.toString(x) + "*" + Double.toString(y) + "=" + Double.toString(wynik);
    }

    public void dzielenie() {
        wynik = x / y;
        pamiec = Double.toString(x) + "/" + Double.toString(y) + "=" + Double.toString(wynik);
    }

}
