/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.point;

/**
 * @author matte
 */
public class NamedPoint extends Point {

    String name;

    public NamedPoint(int x, int y, String name) {
        super(x, y); //prima istruzione!
        this.name = name;
    }

    public static void main(String a[]) {
        NamedPoint p = new NamedPoint(5, 3, "A");
        System.out.println(p);
    }

    public String toString() { //Overriding
        return name + super.toString();
    }
}
