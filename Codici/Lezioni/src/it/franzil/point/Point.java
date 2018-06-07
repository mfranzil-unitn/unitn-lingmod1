/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.point;

/**
 *
 * @author matte
 */
public class Point {

    public int x = 0;
    public int y = 0;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public static void main(String a[]) {
        Point p = new Point(5, 3);
        System.out.println(p);
    }
}
