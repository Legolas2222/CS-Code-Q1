package com.morsecodebaum;

import com.morsecodebaum.Morsecodebaum;

public class Main {
    public static void main(String[] args) {
        Morsecodebaum m = new Morsecodebaum();
        // m.testDecode("-.-");
        // m.erzeugeMorsecode('K', m.getMorsecodebaum(), "");
        m.morseCodieren("Hallo Welt");
    }
}