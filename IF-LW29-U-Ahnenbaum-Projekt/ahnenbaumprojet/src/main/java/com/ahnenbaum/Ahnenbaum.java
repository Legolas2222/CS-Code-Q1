package com.ahnenbaum;

import com.binary.tree.custom.BinaryTree;

public class Ahnenbaum {
    public BinaryTree<Ahne> lisasAhnenbaum;

    public Ahnenbaum() {
        this.lisasAhnenbaum = new BinaryTree<Ahne>();
    }

    public static void main(String[] args) {
        Ahnenbaum a = new Ahnenbaum();
        // Lisa
        a.lisasAhnenbaum.setContent(new Ahne("Lisa", "Simpson", 'w'));

        // Homer
        a.lisasAhnenbaum.setLeftTree(new BinaryTree<Ahne>(new Ahne("Homer", "Simpson", 'm')));

        // Homers Eltern
        a.lisasAhnenbaum.getLeftTree().setLeftTree(new BinaryTree<Ahne>(new Ahne("Abraham", "Simpson", 'm')));
        a.lisasAhnenbaum.getLeftTree().setRightTree(new BinaryTree<Ahne>(new Ahne("Mona", "Simpson", 'w')));

        // Marge
        a.lisasAhnenbaum.setRightTree(new BinaryTree<Ahne>(new Ahne("Marge", "Simpson", 'w')));

        // Marges Eltern
        a.lisasAhnenbaum.getRightTree().setLeftTree(new BinaryTree<Ahne>(new Ahne("Clancy", "Bouvier", 'm')));
        a.lisasAhnenbaum.getRightTree().setRightTree(new BinaryTree<Ahne>(new Ahne("Jacqueline", "Bouvier", 'w')));
    }
}
