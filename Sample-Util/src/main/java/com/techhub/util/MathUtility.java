package com.techhub.util;

public class MathUtility {

    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int divide(int a, int b){
        return a / b;
    }

    public int power(int a, int power){
        int result = a;
        for(int i=0; i<power-1; i++){
            result = result * result;
        }
        return result;
    }
}
