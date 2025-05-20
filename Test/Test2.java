package Test;

import Bstreelinklistinterfgeneric.LinkedBST;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;

public class Test2 {
	public static void main(String[] args) {
        try {
            LinkedBST<Integer> bst = new LinkedBST<>();
            
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            
            System.out.println("Buscar 30: " + bst.search(30));
            System.out.println("Mínimo: " + bst.findMin());
            
            bst.delete(50);
            bst.destroy();
            
        } catch (ItemDuplicated e) {
            System.out.println("Error de duplicado: " + e.getMessage());
        } catch (ItemNoFound e) {
            System.out.println("Error de no encontrado: " + e.getMessage());
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error de árbol vacío: " + e.getMessage());
        }
    }

}
