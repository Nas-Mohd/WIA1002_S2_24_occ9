/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsweek2;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class Duo<A,B> {
    A first;
    B second;
    
    public static void main(String[] args) {
        Duo<String, Integer> sideShape = new Duo("Square", 2);
        Duo<Double, Double> points = new Duo(1.0,2.5);
    }
    
    Duo(A a, B b){
        first = a;
        second = b;
    }
    
}
