package com.morsecodebaum;
import com.binary.tree.custom.BinaryTree;

public class Morsecodebaum{
    
    private BinaryTree<String> morsecodebaum;

    public BinaryTree<String> getMorsecodebaum() {
        return morsecodebaum;
    }

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
        morsezeichenDecodieren(this.morsecodebaum, s);
    }
    
    //HA zum 17.04.:
    //Morsecode für einen Buchstaben decodieren und mit print ausgeben
    

    public void morsezeichenDecodieren(BinaryTree<String> b, String code){
        if (code.length()==0)
            System.out.println(b.getContent());
        else{
            if (code.charAt(0)=='.')
                morsezeichenDecodieren(b.getLeftTree(), code.substring(1));
            else
                morsezeichenDecodieren(b.getRightTree(), code.substring(1));                
        }
    }

    public String decode(BinaryTree<String> b, String code){
        if (code.length()==0)
            return(b.getContent());
        else{
            if (code.charAt(0)=='.')
                return decode(b.getLeftTree(), code.substring(1));
            else if (code.charAt(0)=='-')
                return decode(b.getRightTree(), code.substring(1));                
            else
                return "fehlerhafter Code";
        }
    }    

    public String morseCodeDecodieren(String code){
        String[] c = code.split(" ");
        String wort = "";
        for (int i=0; i<c.length; i++){
            wort = wort + decode(morsecodebaum, c[i]);
        }
        return wort;
    }

    //HA für den 19.04.
    //
    public void starteMorsecodebaumTraversierung(){
        //EIGENER CODE???
    }  

    //HA für den 19.04.
    //Ausgabe des gesamten Inhalts des Baums nach einem Traversierungsalgorithmus
    public void morsecodebaumTraversierung(BinaryTree<String> pTree){
        System.out.println("Preorder: ");
        pTree.preOrder(pTree);
        System.out.println("InOrder: ");
        pTree.inOrder(pTree);
        System.out.println("PostOrder: ");
        pTree.postOrder(pTree);

    }    

    //
    //
    public void morseCodieren(String pText){
        pText = pText.toUpperCase();
        char[] c = pText.toCharArray();
        for (int i = 0; i < c.length; i++) {
            erzeugeMorsecode(c[i], this.getMorsecodebaum(), "");
            System.out.print(" ");
        }
    }  

    //
    //
    public void erzeugeMorsecode(char pZeichen, BinaryTree<String> pTree, String pCode){
        if (pTree.getContent() == null) {
            return;
        }
        if (pZeichen == pTree.getContent().charAt(0))
            System.out.print(pCode);
        else{
            if (pTree.getLeftTree()!=null)
                erzeugeMorsecode(pZeichen, pTree.getLeftTree(), pCode+".");
            if (pTree.getRightTree()!=null)
                erzeugeMorsecode(pZeichen, pTree.getRightTree(), pCode+"-");
            
        }
    }    

}

    
