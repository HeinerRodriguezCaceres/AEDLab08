package Test;

import Bstreelinklistinterfgeneric.LinkedBST;
import exceptions.ItemDuplicated;

public class Test3 {
	public static void main(String[] args) {
	    try {
	        LinkedBST<String> salesTree = new LinkedBST<>();
	        
	        salesTree.insert("Sales");
	        salesTree.insert("Domestic");
	        salesTree.insert("International");
	        salesTree.insert("Canada");
	        salesTree.insert("S. America");
	        salesTree.insert("Overseas");
	        salesTree.insert("Africa");
	        salesTree.insert("Europe");
	        salesTree.insert("Asia");
	        salesTree.insert("Australia");
	        
	        System.out.println("Representación parentética del árbol de ventas:");
	        System.out.println(salesTree.parenthesize());
	        
	    } catch (ItemDuplicated e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}

}
