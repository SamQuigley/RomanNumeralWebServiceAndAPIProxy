/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.numeralconverter;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mateusz Matuszczyk
 */
public class RomanToNumber {

private static final Map<Character, Integer> map = new HashMap<>(7);
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
 
public int romanToNumber(String romanNumeral) {
    int arabicNumeral = 0;
    int roman_len = romanNumeral.length() - 1;
    for (int i = 0; i < roman_len; i++) {
        if (map.get(romanNumeral.charAt(i)) < map.get(romanNumeral.charAt(i + 1))) {
            arabicNumeral -= map.get(romanNumeral.charAt(i));
        } else {
            arabicNumeral += map.get(romanNumeral.charAt(i));
        }
    }
    return arabicNumeral += map.get(romanNumeral.charAt(roman_len));
}
    
    
}
