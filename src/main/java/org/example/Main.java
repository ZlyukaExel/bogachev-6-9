package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите x: ");
        double x = sc.nextDouble();
        System.out.print("Введите n: ");
        int n = sc.nextInt();
        System.out.print("Введите e: ");
        double e = sc.nextDouble();

        double sumOfN = 0, grThanE = 0, grThanEDivTen = 0, funcRes, prevVal = x;
        
        int multiplyer = 1;
        for (int i = 1; i < n * 2; i+=2) {
            multiplyer *= -1;
            double res = multiplyer * f(i, prevVal, x);

            sumOfN += res;
            if (Math.abs(res) > e / 10) {
                grThanEDivTen += res;
                if(Math.abs(res) > e)
                    grThanE += res;
            }
            prevVal = res;
        }

        funcRes = Math.exp(x + Math.sqrt(x * x + 1));

        System.out.println("\nСумма слагаемых = " + sumOfN +
                "\nСумма абсолютных элементов больше e = " + grThanE +
                "\nСумма абсолютных элементов больше e/10 = " + grThanEDivTen +
                "\nЗначение функции = " + funcRes);
    }

    public static  double f(int n, double prev, double x){
        return prev * n / (n + 1) * n * x * x / (n + 2);
    }
}