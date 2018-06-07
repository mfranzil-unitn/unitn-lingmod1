/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.franzil.collections;

import java.util.*;

/**
 *
 * @author matte
 */
public abstract class Stack extends LinkedList {

    public void inserisci(int x) {
        Number n = new Number(x);
        this.add(n);
    }

    abstract public int estrai();
}
