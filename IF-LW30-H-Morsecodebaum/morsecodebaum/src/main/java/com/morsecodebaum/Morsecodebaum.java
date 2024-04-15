package com.morsecodebaum;
import com.binary.tree.custom.BinaryTree;

public class Morsecodebaum{
    
    private BinaryTree<String> morsecodebaum;

    public Morsecodebaum(){
        BinaryTree<String>[] b = new BinaryTree[40];
        b[0]=new BinaryTree<String>("5");
        b[1]=new BinaryTree<String>("4");
        b[2]=new BinaryTree<String>("3");
        b[3]=new BinaryTree<String>("2");
        b[4]=new BinaryTree<String>("+");
        b[5]=new BinaryTree<String>("1");
        b[6]=new BinaryTree<String>("6");
        b[7]=new BinaryTree<String>("=");
        b[8]=new BinaryTree<String>("/");
        b[9]=new BinaryTree<String>("7");
        b[10]=new BinaryTree<String>("8");
        b[11]=new BinaryTree<String>("9");
        b[12]=new BinaryTree<String>("0");
        b[13]=new BinaryTree<String>("H");
        b[14]=new BinaryTree<String>("V");
        b[15]=new BinaryTree<String>("F");
        b[16]=new BinaryTree<String>("L");
        b[17]=new BinaryTree<String>("P");
        b[18]=new BinaryTree<String>("J");
        b[19]=new BinaryTree<String>("B");
        b[20]=new BinaryTree<String>("X");
        b[21]=new BinaryTree<String>("C");
        b[22]=new BinaryTree<String>("Y");
        b[23]=new BinaryTree<String>("Z");
        b[24]=new BinaryTree<String>("Q");
        b[25]=new BinaryTree<String>("S",b[13],b[14]);
        b[26]=new BinaryTree<String>("U",b[15],null);
        b[27]=new BinaryTree<String>("R",b[16],null);
        b[28]=new BinaryTree<String>("W",b[17],b[18]);
        b[29]=new BinaryTree<String>("D",b[19],b[20]);
        b[30]=new BinaryTree<String>("K",b[21],b[22]);
        b[31]=new BinaryTree<String>("G",b[23],b[24]);
        b[32]=new BinaryTree<String>("O");
        b[33]=new BinaryTree<String>("I",b[25],b[26]);
        b[34]=new BinaryTree<String>("A",b[27],b[28]);
        b[35]=new BinaryTree<String>("N",b[29],b[30]);
        b[36]=new BinaryTree<String>("M",b[31],b[32]);
        b[37]=new BinaryTree<String>("E",b[33],b[34]);
        b[38]=new BinaryTree<String>("T",b[35],b[36]);
        morsecodebaum=new BinaryTree<String>("?",b[37],b[38]);
    }

    public void testDecode(String s){
        System.out.print("Decodiert mit print:  " + s + "   ->   ");
        morsezeichenDecodieren(morsecodebaum, s);
        System.out.println();
        //System.out.println("Decodiert mit return: " + s + "   ->   " + decode(morsecodebaum, s));
        System.out.println();
        //System.out.println("Decodiert mehrere Buchstaben: " + s + "   ->   " + morseCodeDecodieren(s));
    }
    
    //HA zum 17.04.:
    //Morsecode für einen Buchstaben decodieren und mit print ausgeben
    public void morsezeichenDecodieren(BinaryTree<String> b, String code){
        char[] elements = code.toCharArray();
        BinaryTree<String> current = b;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == '.') {
                if (current.getLeftTree() != null) {
                    current = current.getLeftTree();
                }
                else {
                    System.out.println("Fehler, Morsecode gehört nicht zu einem Eintrag im Baum");
                    break;
                }
            }
            if (elements[i] == '-') {
                if (current.getRightTree() != null) {
                    current = current.getRightTree();    
                }
                else {
                    System.out.println("Fehler, Morsecode gehört nicht zu einem Eintrag im Baum");
                    break;
                }
            }
        }
        System.out.print(current.getContent());
    }

    //HA zum 17.04.:
    //Morsecode für einen Buchstaben decodieren und zurückgeben
    public String decode(BinaryTree<String> b, String code){
        char[] elements = code.toCharArray();
        BinaryTree<String> current = b;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == '.') {
                if (current.getLeftTree() != null) {
                    current = current.getLeftTree();
                }
                else {
                    System.out.println("Fehler, Morsecode gehört nicht zu einem Eintrag im Baum");
                    break;
                }
            }
            if (elements[i] == '-') {
                if (current.getRightTree() != null) {
                    current = current.getRightTree();    
                }
                else {
                    System.out.println("Fehler, Morsecode gehört nicht zu einem Eintrag im Baum");
                    break;
                }
            }
        }
        return current.getContent();
    }    
    
    //HA zum 17.04.:
    //Decodiert mehrere Buchstaben
    public String morseCodeDecodieren(String code){
        String[] letterCodes = code.split(" ");
        String[] result = new String[letterCodes.length]; 
        for (int i = 0; i < letterCodes.length; i++) {
            result[i] = decode(morsecodebaum, letterCodes[i]);
        }
        return result.toString();
    }

    //
    //
    public void morseCodieren(String pText){
        //EIGENER CODE
    }  

    //
    //
    public void erzeugeMorsecode(char pZeichen, BinaryTree<String> pTree, String pCode){
        //EIGENER CODE
    }    

}

    
