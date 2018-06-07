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
public class Point3D extends Point {
    public int z = 0;
    
    Point3D(int x, int y, int z) {
        super(x,y);
        this.z = z;
    }
    
    public void move(int x, int y, int z) {
        super.move(x, y);
        this.z += z;
    }
}
