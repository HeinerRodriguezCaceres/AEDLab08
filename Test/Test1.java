package Test;

import Bstreelinklistinterfgeneric.LinkedBST;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;

public class Test1 {
	public static void main(String[] args) {
        try {
            LinkedBST<Integer> bst = new LinkedBST<>();
            System.out.println("Árbol creado. ¿Está vacío? " + bst.isEmpty());

            System.out.println("\n=== Insertando elementos ===");
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);
            System.out.println("In-Orden: " + bst.inOrder());
            System.out.println("Pre-Orden: " + bst.preOrder());
            System.out.println("Post-Orden: " + bst.postOrder());

            System.out.println("\n=== Conteo de nodos ===");
            System.out.println("Total de nodos: " + bst.countAllNodes());
            System.out.println("Nodos no-hoja: " + bst.countNodes());

            System.out.println("\n=== Búsqueda y altura ===");
            System.out.println("Altura del subárbol con raíz 50: " + bst.height(50));
            System.out.println("Altura del subárbol con raíz 30: " + bst.height(30));
            System.out.println("Altura del subárbol con raíz 100 (no existe): " + bst.height(100));

            System.out.println("\n=== Amplitud por niveles ===");
            for (int i = 0; i < 4; i++) {
                System.out.println("Amplitud nivel " + i + ": " + bst.amplitude(i));
            }

            System.out.println("\n=== Mínimo y máximo ===");
            System.out.println("Mínimo: " + bst.findMin());
            System.out.println("Máximo: " + bst.findMax());

            System.out.println("\n=== Eliminando nodos ===");
            bst.delete(20); 
            System.out.println("In-Orden después de eliminar 20: " + bst.inOrder());
            bst.delete(30);
            System.out.println("In-Orden después de eliminar 30: " + bst.inOrder());
            bst.delete(50);
            System.out.println("In-Orden después de eliminar 50: " + bst.inOrder());

            System.out.println("\n=== Eliminando todos los nodos ===");
            bst.destroyNodes();
            System.out.println("Árbol después de destroyNodes(). ¿Está vacío? " + bst.isEmpty());
            System.out.println("Total de nodos: " + bst.countAllNodes());

            System.out.println("\n=== Pruebas con árbol vacío ===");
            try {
                bst.findMin();
            } catch (ItemNoFound e) {
                System.out.println("Excepción al buscar mínimo en árbol vacío: " + e.getMessage());
            }

            try {
                bst.destroyNodes();
            } catch (ExceptionIsEmpty e) {
                System.out.println("Excepción al destruir árbol vacío: " + e.getMessage());
            }

        } catch (ItemDuplicated | ItemNoFound | ExceptionIsEmpty e) {
            System.out.println("Error durante las pruebas: " + e.getMessage());
        }
    }

}
