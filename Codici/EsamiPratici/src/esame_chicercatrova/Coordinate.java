/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame_chicercatrova;

/**
 *
 * @author Matteo Franzil
 */
public class Coordinate implements Comparable<Coordinate> {

    private double x, y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = false;
        if (obj != null & obj instanceof Coordinate) {
            if (((Coordinate) obj).x == this.x && ((Coordinate) obj).y == this.y) {
                res = true;
            }
        }
        return res;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    @Override
    public int compareTo(Coordinate o) {
        int res = -1;
        if (o != null) {
            res = (int) Math.abs(Math.sqrt(Math.pow(o.x - this.x, 2) + Math.pow(o.y - this.y, 2)));
        }
        return res;
    }
}
