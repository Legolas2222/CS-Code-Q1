package com.morsecodebaum;

public class Main {
    public static void main(String[] args) {
        Morsecodebaum m = new Morsecodebaum();
        // m.testDecode("-.-");
        // m.erzeugeMorsecode('K', m.getMorsecodebaum(), "");
        //m.morseCodieren("Hallo Welt");
        m.erzeugeMorsecodeS('K', m.getMorsecodebaum(), "");
        //System.out.println(m.morseCodierenS("Hallo Welt"));
    }
}