package com.company;

import java.util.ArrayList;
import java.util.Random;
import static java.lang.Math.sqrt;

class Math {
    private long number;


    Math() {
        this.number = randomPrime() - 1;
    }

    long getNumber() {
        return number;
    }

    int randomNatural() {
        Random random = new Random(System.currentTimeMillis());
        int i = random.nextInt(1000000 - 10000) + 10000;
        return i;
    }


    private boolean isPrime(int n) {
        for (int i = 2; i <= sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int randomPrime() {
        int a = 20000;
        int b = 2100000;
        int i;
        Random random = new Random(System.currentTimeMillis());
        int res = random.nextInt(b - a) + a;
        for (i = res; i < 2 * res; i++) {
            if (isPrime(i) && isPrime((i - 1) / 2)) {
                return i;
            }
        }
        return i;
    }

    ArrayList<Long> numberFactorization() {
        ArrayList<Long> fact = new ArrayList<>();
        long number1 = number;
        while (number1 % 2 == 0) {
            number1 = number1 / 2;
            fact.add(2L);
        }
        for (int i = 3; i * i <= number1; i = i + 2) {
            if (number1 % i == 0) {
                number1 = number1 / i;
                fact.add((long) i);
                i = i - 2;
            }
        }
        if (number1 != 1) {
            fact.add(number1);
        }
        System.out.println(fact);
        return fact;

    }

   long primitiveRoot(ArrayList<Long> fact) {
        int g;
        for (g = 1; g <= number + 1; g++) {
            boolean check = true;
            for (Long aFact : fact) {
                long a= powMod(g, number / aFact,number+1);
                check &= a != 1;
            }
            if (check) {
                return g;
            }
        }
        return 0;
    }

    long powMod(long base, long exp, long mod ) {
        long d = 1;
        while (exp > 1) {
            if (exp % 2 == 0) {
                base = (base * base) % mod;
                exp /= 2;
            } else {
                exp -= 1;
                d=(d*base)%mod;

            }
        }
        return (d*base)%mod;

    }
}
