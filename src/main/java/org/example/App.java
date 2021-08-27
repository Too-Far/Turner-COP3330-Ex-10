/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Turner
 */
package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class App
{

    public static void compileMessage(float subTotal, float tax, float total)
    {
        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println(
                "Subtotal: $" +df.format(subTotal) +"\n"
                + "Tax: $"+ df.format(tax) + "\n"
                + "Total: $" + df.format(total)
        );
    }

    public static void calcTotal(Map<Integer, Float> values)
    {
        float subTotal = 0;
        float taxRate = 0.55f;
        float tax;
        float total;
        DecimalFormat df = new DecimalFormat("#.00");
        for (Float val : values.values())
        {
            subTotal += Float.parseFloat(df.format(val));
            System.out.println(df.format(val));
        }
        tax = subTotal * taxRate;
        total = subTotal + tax;
        compileMessage(subTotal, tax, total);
    }

    public static void getInput()  {
        DecimalFormat df = new DecimalFormat("#.00");

        int itemNum = 1;
        Map<Integer, Float> items = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter the totals for each item you have. Press any other key When you are done.");
        while (true)
        {
            System.out.println("Please enter the amount of item " + itemNum);
            try {
                items.put(itemNum, Float.valueOf(df.format(Float.parseFloat(reader.readLine()))));
                itemNum++;
            } catch (Exception e)
            {
                break;
            }
        }
        calcTotal(items);
    }

    public static void main( String[] args )  {
        getInput();
    }
}
