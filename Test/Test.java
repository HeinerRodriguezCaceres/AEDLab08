package Test;

import Bstreelinklistinterfgeneric.LinkedBST;
import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;

public class Test {
	public static void main(String[] args) {
        try {
            LinkedBST<Integer> bst = new LinkedBST<>();
            
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);
            
            System.out.println("Pre-Orden: " + bst.preOrder());
            System.out.println("In-Orden: " + bst.inOrder());
            System.out.println("Post-Orden: " + bst.postOrder());
            
            System.out.println("Mínimo: " + bst.findMin());
            System.out.println("Máximo: " + bst.findMax());
            
            System.out.println("Buscar 40: " + bst.search(40));
            System.out.println("Buscar 100: " + bst.search(100));
            
        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ItemNoFound e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
