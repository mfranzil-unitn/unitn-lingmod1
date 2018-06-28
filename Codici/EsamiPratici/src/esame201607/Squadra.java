package esame201607;

import esame201607.bandiere.*;
import javafx.scene.paint.Color;

import java.util.Collections;
import java.util.LinkedList;

public class Squadra implements Comparable<Squadra> {

    private Bandiera bandiera;
    private String name;
    private int punti;

    public Squadra(String name) {
        this.name = name;
        this.bandiera = generateBandiera(name);
        this.punti = 0;
    }

    private Bandiera generateBandiera(String name) {
        switch (name) {
            case "Spagna":
                bandiera = new BandieraTreFasceOrizzontali(Color.RED, Color.YELLOW, Color.RED);
                break;
            case "Germania":
                bandiera = new BandieraTreFasceOrizzontali(Color.BLACK, Color.RED, Color.YELLOW);
                break;
            case "Russia":
                bandiera = new BandieraTreFasceOrizzontali(Color.WHITE, Color.BLUE, Color.RED);
                break;
            case "Olanda":
                bandiera = new BandieraTreFasceOrizzontali(Color.RED, Color.WHITE, Color.BLUE);
                break;
            case "Bulgaria":
                bandiera = new BandieraTreFasceOrizzontali(Color.WHITE, Color.GREEN, Color.RED);
                break;
            case "Ungheria":
                bandiera = new BandieraTreFasceOrizzontali(Color.RED, Color.WHITE, Color.GREEN);
                break;
            case "Austria":
                bandiera = new BandieraTreFasceOrizzontali(Color.RED, Color.WHITE, Color.RED);
                break;
            case "Italia":
                bandiera = new BandieraTreFasceVerticali(Color.RED, Color.WHITE, Color.GREEN);
                break;
            case "Belgio":
                bandiera = new BandieraTreFasceVerticali(Color.RED, Color.YELLOW, Color.BLACK);
                break;
            case "Irlanda":
                bandiera = new BandieraTreFasceVerticali(Color.RED, Color.WHITE, Color.LIGHTGREEN);
                break;
            case "Francia":
                bandiera = new BandieraTreFasceVerticali(Color.RED, Color.WHITE, Color.BLUE);
                break;
            case "Svezia":
                bandiera = new BandieraCroce(Color.BLUE, Color.YELLOW);
                break;
            case "Finlandia":
                bandiera = new BandieraCroce(Color.WHITE, Color.DARKBLUE);
                break;
            case "Danimarca":
                bandiera = new BandieraCroce(Color.RED, Color.WHITE);
                break;
            case "Polonia":
                bandiera = new BandieraDueFasceOrizzontali(Color.WHITE, Color.RED);
                break;
            case "Ucraina":
                bandiera = new BandieraDueFasceOrizzontali(Color.BLUE, Color.YELLOW);
                break;
            case "Islanda":
                bandiera = new BandieraCroceDoppia(Color.BLUE, Color.WHITE, Color.RED);
                break;
            case "Norvegia":
                bandiera = new BandieraCroceDoppia(Color.RED, Color.WHITE, Color.DARKBLUE);
                break;
            case "Pride":
                bandiera = new BandieraNFasceOrizzontali(Color.RED,
                        Color.ORANGE, Color.YELLOW, Color.GREEN,
                        Color.BLUE, Color.PURPLE, Color.INDIGO);
                break;
            default:
                bandiera = null;
                break;
        }
        return bandiera;
    }

    public void aggiungiPunti(int punti) {
        this.punti += punti;
    }

    public int getPunti() {
        return punti;
    }

    @Override
    public String toString() {
        return name;
    }

    public Bandiera getBandiera() {
        return bandiera;
    }

    @Override
    public int compareTo(Squadra o) {
        int res = o.getPunti() - this.getPunti();
        if (res == 0) {
            return this.toString().compareTo(o.toString());
        } else {
            return res;
        }
    }

    public static LinkedList<Squadra> getSquadreRandom() {
        LinkedList<Squadra> squadreRandom = new LinkedList<>();
        squadreRandom.add(new Squadra("Spagna"));
        squadreRandom.add(new Squadra("Germania"));
        squadreRandom.add(new Squadra("Russia"));
        squadreRandom.add(new Squadra("Olanda"));
        squadreRandom.add(new Squadra("Bulgaria"));
        squadreRandom.add(new Squadra("Ungheria"));
        squadreRandom.add(new Squadra("Austria"));
        squadreRandom.add(new Squadra("Italia"));
        squadreRandom.add(new Squadra("Belgio"));
        squadreRandom.add(new Squadra("Irlanda"));
        squadreRandom.add(new Squadra("Francia"));
        squadreRandom.add(new Squadra("Svezia"));
        squadreRandom.add(new Squadra("Finlandia"));
        squadreRandom.add(new Squadra("Danimarca"));
        squadreRandom.add(new Squadra("Polonia"));
        squadreRandom.add(new Squadra("Ucraina"));
        squadreRandom.add(new Squadra("Pride"));
        squadreRandom.add(new Squadra("Islanda"));
        squadreRandom.add(new Squadra("Norvegia"));
        Collections.shuffle(squadreRandom);
        return squadreRandom;
    }
}
