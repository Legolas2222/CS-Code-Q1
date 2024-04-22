package com.suchbaum.wastueich;



public class Traversierung
{
    //Attribute
    private BinaryTree<Integer> b1, b2, b3, b4, b5, b6, b7;
    
    //Konstruktoren
    public Traversierung(){
        b1 = new BinaryTree<Integer>(3);
        b2 = new BinaryTree<Integer>(7);
        b3 = new BinaryTree<Integer>(10);
        b4 = new BinaryTree<Integer>(6, null, b2);
        b5 = new BinaryTree<Integer>(11, b3, null);
        b6 = new BinaryTree<Integer>(9, b4, b5);
        b7 = new BinaryTree<Integer>(5, b1, b6);
    }
    
    
    //Methoden    
    public void test(){
        System.out.println("Preordered:");
        preordered(b7);
        System.out.println();
        System.out.println("Inordered:");
        inordered(b7);
        System.out.println();
        System.out.println("Postordered:");
        postordered(b7);
        System.out.println();
        System.out.println();        
        System.out.println("WasTueIch:");
        wasTueIch(b7);
        System.out.println();
    }
    
    public void preordered(BinaryTree<Integer> pTree){
        System.out.print(pTree.getContent()+" ");
        if(!pTree.getLeftTree().isEmpty())
            preordered(pTree.getLeftTree());
        if(!pTree.getRightTree().isEmpty())
            preordered(pTree.getRightTree());           
    }
    
    public void inordered(BinaryTree<Integer> pTree){
        if(!pTree.getLeftTree().isEmpty())
            inordered(pTree.getLeftTree());
        System.out.print(pTree.getContent()+" ");
        if(!pTree.getRightTree().isEmpty())
            inordered(pTree.getRightTree());       
    }
     
    public void postordered(BinaryTree<Integer> pTree){
        if(!pTree.getLeftTree().isEmpty())
            postordered(pTree.getLeftTree());
        if(!pTree.getRightTree().isEmpty())
            postordered(pTree.getRightTree());   
        System.out.print(pTree.getContent()+" ");
    }
    
    public void wasTueIch(BinaryTree<Integer> b){
        Stack<BinaryTree<Integer>> stapel = new Stack<BinaryTree<Integer>>();
        while (!stapel.isEmpty() || !b.isEmpty()){
            if(!b.isEmpty()){
                stapel.push(b);
                b = b.getLeftTree();
            }
            else{
                b = stapel.top();
                stapel.pop();
                System.out.println(b.getContent());
                b = b.getRightTree();
            }            
        } 
    }
    
    public int anzahlKnoten(){
        return bestimmeAnzahl(b7);
    }    
    
    public int bestimmeAnzahl(BinaryTree<Integer> b){
        int anz = 0;
        Stack<BinaryTree<Integer>> stapel = new Stack<BinaryTree<Integer>>();
        while (!stapel.isEmpty() || !b.isEmpty()){
            if(!b.isEmpty()){
                stapel.push(b);
                b = b.getLeftTree();
            }
            else{
                b = stapel.top();
                stapel.pop();
                anz++;
                System.out.println(anz);
                b = b.getRightTree();
            }            
        } 
        return anz;
    }    

}
