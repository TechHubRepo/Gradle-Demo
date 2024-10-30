package com.techhub.gradlemain;

import com.google.gson.JsonObject;
import com.techhub.util.MathUtility;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println(":::::::::::::: START :::::::::::::::");
        System.out.println("------------------------------------");

        int a = 54;
        int b = 28;
        System.out.println("A = "+a);
        System.out.println("B = "+b);

        MathUtility mathUtility = new MathUtility();
        System.out.println("ADDITION = "+mathUtility.add(a,b));
        System.out.println("SUBTRACTION = "+mathUtility.subtract(a,b));
        System.out.println("MULTIPLICATION = "+mathUtility.multiply(a,b));
        System.out.println("DIVISION = "+mathUtility.divide(a,b));
        System.out.println("A POWER 3 = "+mathUtility.power(a,3));
        System.out.println("B POWER 2 = "+mathUtility.power(b,2));

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("a",a);
        jsonObject.addProperty("b",b);
        jsonObject.addProperty("addition",mathUtility.add(a,b));
        jsonObject.addProperty("subtraction",mathUtility.subtract(a,b));
        jsonObject.addProperty("multiplication",mathUtility.multiply(a,b));
        jsonObject.addProperty("division",mathUtility.divide(a,b));
        jsonObject.addProperty("powerA3",mathUtility.power(a,3));
        jsonObject.addProperty("powerB2",mathUtility.power(b,2));
        System.out.println("JsonObject = "+jsonObject.toString());

        System.out.println("------------------------------------");
        System.out.println("::::::::::::::: END ::::::::::::::::");
        System.out.println("------------------------------------");
    }
}