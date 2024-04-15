package com.ahnenbaum;

import com.binary.tree.custom.BinaryTree;

public class Ahnenbaum {
    public BinaryTree<Ahne> lisasAhnenbaum;

    public Ahnenbaum() {
        this.lisasAhnenbaum = new BinaryTree<Ahne>();
    }

    public void setUpTopDown() {
        
        // Lisa
        this.lisasAhnenbaum.setContent(new Ahne("Lisa", "Simpson", 'w'));

        // Homer
        this.lisasAhnenbaum.setLeftTree(new BinaryTree<Ahne>(new Ahne("Homer", "Simpson", 'm')));

        // Homers Eltern
        this.lisasAhnenbaum.getLeftTree().setLeftTree(new BinaryTree<Ahne>(new Ahne("Abraham", "Simpson", 'm')));
        this.lisasAhnenbaum.getLeftTree().setRightTree(new BinaryTree<Ahne>(new Ahne("Mona", "Simpson", 'w')));

        // Marge
        this.lisasAhnenbaum.setRightTree(new BinaryTree<Ahne>(new Ahne("Marge", "Simpson", 'w')));

        // Marges Eltern
        this.lisasAhnenbaum.getRightTree().setLeftTree(new BinaryTree<Ahne>(new Ahne("Clancy", "Bouvier", 'm')));
        this.lisasAhnenbaum.getRightTree().setRightTree(new BinaryTree<Ahne>(new Ahne("Jacqueline", "Bouvier", 'w')));
    }

    public void setUpBottomUp() {
        BinaryTree<Ahne> jacqueline = new BinaryTree<Ahne>(new Ahne("Jacqueline", "Bouvier", 'w'));
        BinaryTree<Ahne> clancy = new BinaryTree<Ahne>(new Ahne("Clancy", "Bouvier", 'm'));

        BinaryTree<Ahne> marge = new BinaryTree<Ahne>(null, jacqueline, clancy);

        BinaryTree<Ahne> mona = new BinaryTree<Ahne>(new Ahne("Mona", "Simpson", 'w'));
        BinaryTree<Ahne> abraham = new BinaryTree<Ahne>(new Ahne("Abraham", "Simpson", 'm'));

        BinaryTree<Ahne> homer = new BinaryTree<Ahne>(new Ahne("Homer", "Simpson", 'm'), mona, abraham);

        BinaryTree<Ahne> lisa = new BinaryTree<Ahne>(new Ahne("Lisa", "Simpson", 'w'), homer, marge);

        this.lisasAhnenbaum = lisa;
    }
}
