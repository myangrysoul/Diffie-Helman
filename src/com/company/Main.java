package com.company;

//import java.math.BigDecimal;

//import static java.lang.Math.pow;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class Main {

    public static void main(String[] args) {
        long start=System.nanoTime();
   Subcriber alice=new Subcriber("Alice");
    Subcriber bob=new Subcriber("Bob");
    System.out.println(alice.getName()+"'s and "+bob.getName()+"'s secret keys are "+alice.exchangeKeysProcess(bob));
    long end=System.nanoTime();
    System.out.println("Exec time "+ round((end-start)/pow(10,6))+" ms");
    /* BigDecimal a=BigDecimal.valueOf(pow(3,83));
        System.out.println(a);
        a =a.remainder(BigDecimal.valueOf(167));
        System.out.println(a);
        double a1=pow(3,83);
        a1=a1%167;
        System.out.println(a1);*/

    }
}
