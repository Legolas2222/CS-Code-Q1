package com.suchbaum;

import com.binary.tree.custom.BinaryTree;

public class Suchbaum {
    public static String Suche(String name, BinaryTree<String> baum) {
        if (name != null && !baum.isEmpty()) {
            if (baum.getContent().equals(name)) {
                return baum.getContent();
            } else if (baum.getContent().compareTo(name) < 0) {
                return Suche(name, baum.getLeftTree());
            } else {
                return Suche(name, baum.getRightTree());
            }
        }
        return null;
    }

    public static void Einfuegen(String name, BinaryTree<String> baum) {
        if (name == null || baum == null) {
            return;
        }
        if (baum.isEmpty()) {
            baum.setContent(name);
            return;
        }
        if (baum.getContent().compareTo(name) < 0) {
            if (baum.getLeftTree() == null) {
                baum.setLeftTree(new BinaryTree<String>(name));
            } else {
                Einfuegen(name, baum.getLeftTree());
            }
        } else if (baum.getLeftTree() == null) {
            baum.setRightTree(new BinaryTree<String>(name));
        } else {
            Einfuegen(name, baum.getRightTree());
        }
    }

}
