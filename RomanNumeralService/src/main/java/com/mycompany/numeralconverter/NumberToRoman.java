/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.numeralconverter;

/**
 *
 * @author Sam Quigley, 14474028
 * Repo - https://github.com/SamQuigley/WebServiceAndAPI
 */
import java.util.TreeMap;

public class NumberToRoman {

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public String NumberToRoman(int userInput) {
        int l  = map.floorKey(userInput);
        if (userInput == l) 
        {
            return map.get(userInput);
        }
        return map.get(l) + NumberToRoman(userInput - l);
    }
}
