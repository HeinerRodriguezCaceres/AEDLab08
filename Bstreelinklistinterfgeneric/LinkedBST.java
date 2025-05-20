package Bstreelinklistinterfgeneric;

import java.util.LinkedList;
import java.util.Queue;

import bstreeInterface.BinarySearchTree;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
	class Node{
		public E data;
		public Node left;
		public Node right;
		
		public Node(E data) {
			this (data, null, null);
		}
		public Node(E data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
private Node root;
    
    public LinkedBST() {
        this.root = null;
    }
    
    @Override
    public boolean isEmpty() {
        return root == null;
    }
    
    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insertRec(root, data);
    }
    
    private Node insertRec(Node node, E data) throws ItemDuplicated {
        if (node == null) {
            return new Node(data);
        }
        
        int compareResult = data.compareTo(node.data);
        
        if (compareResult < 0) {
            node.left = insertRec(node.left, data);
        } else if (compareResult > 0) {
            node.right = insertRec(node.right, data);
        } else {
            throw new ItemDuplicated("El elemento ya existe en el árbol");
        }
        
        return node;
    }
    
    @Override
    public E search(E data) throws ItemNoFound {
        Node result = searchRec(root, data);
        if (result == null) {
            throw new ItemNoFound("Elemento no encontrado en el árbol");
        }
        return result.data;
    }
    
    private Node searchRec(Node node, E data) {
        if (node == null || node.data.equals(data)) {
            return node;
        }
        
        return data.compareTo(node.data) < 0 
            ? searchRec(node.left, data) 
            : searchRec(node.right, data);
    }
    
    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El árbol está vacío");
        }
        root = deleteRec(root, data);
    }
    
    private Node deleteRec(Node node, E data) {
        if (node == null) {
            return null;
        }
        
        int compareResult = data.compareTo(node.data);
        
        if (compareResult < 0) {
            node.left = deleteRec(node.left, data);
        } else if (compareResult > 0) {
            node.right = deleteRec(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            
            node.data = minValue(node.right);
            node.right = deleteRec(node.right, node.data);
        }
        
        return node;
    }
    
    private E minValue(Node node) {
        E minv = node.data;
        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }
    
    @Override
    public void destroy() {
        root = destroyRec(root);
    }
    
    private Node destroyRec(Node node) {
        if (node != null) {
            node.left = destroyRec(node.left);
            node.right = destroyRec(node.right);
        }
        return null;
    }
    
    @Override
    public String toString() {
        return inOrderToString();
    }
    
    private String inOrderToString() {
        StringBuilder sb = new StringBuilder();
        inOrderToString(root, sb);
        return sb.toString().trim();
    }
    
    private void inOrderToString(Node node, StringBuilder sb) {
        if (node != null) {
            inOrderToString(node.left, sb);
            sb.append(node.data).append(" ");
            inOrderToString(node.right, sb);
        }
    }
    public String preOrder() {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString().trim();
    }

    private void preOrder(Node node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.data).append(" ");
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }

    public String postOrder() {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString().trim();
    }

    private void postOrder(Node node, StringBuilder sb) {
        if (node != null) {
            postOrder(node.left, sb);
            postOrder(node.right, sb);
            sb.append(node.data).append(" ");
        }
    }

    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString().trim();
    }

    private void inOrder(Node node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.data).append(" ");
            inOrder(node.right, sb);
        }
    }
    public E findMin() throws ItemNoFound {
        if (isEmpty()) {
            throw new ItemNoFound("El árbol está vacío");
        }
        return findMinNode(root).data;
    }

    private Node findMinNode(Node node) throws ItemNoFound {
        if (node == null) {
            throw new ItemNoFound("Nodo no encontrado");
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public E findMax() throws ItemNoFound {
        if (isEmpty()) {
            throw new ItemNoFound("El árbol está vacío");
        }
        return findMaxNode(root).data;
    }

    private Node findMaxNode(Node node) throws ItemNoFound {
        if (node == null) {
            throw new ItemNoFound("Nodo no encontrado");
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
    public void destroyNodes() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El árbol está vacío");
        }
        root = destroyNodesRec(root);
    }

    private Node destroyNodesRec(Node node) {
        if (node != null) {
            node.left = destroyNodesRec(node.left);
            node.right = destroyNodesRec(node.right);
        }
        return null;
    }

     public int countAllNodes() {
        return countAllNodesRec(root);
    }

    private int countAllNodesRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countAllNodesRec(node.left) + countAllNodesRec(node.right);
    }

    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }
        return 1 + countNodesRec(node.left) + countNodesRec(node.right);
    }

    public int height(E x) throws ItemNoFound {
        Node subTreeRoot = searchRec(root, x);
        if (subTreeRoot == null) {
            return -1;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(subTreeRoot);
        int height = -1;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            height++;
            
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return height;
    }

    public int amplitude(int nivel) {
        if (isEmpty() || nivel < 0) {
            return 0;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;
        int maxWidth = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            if (currentLevel == nivel) {
                return levelSize;
            }
            
            if (levelSize > maxWidth) {
                maxWidth = levelSize;
            }
            
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            currentLevel++;
        }
        
        return (nivel <= currentLevel) ? 0 : maxWidth;
    }
    
    
    
    public int areaBST() {
        if (isEmpty()) {
            return 0;
        }
        
        int height = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            height++;
            
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        
        int leafCount = 0;
        queue.clear();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (current.left == null && current.right == null) {
                leafCount++;
            } else {
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        
        return leafCount * height;
    }
    
    
    
    public String drawBST() {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty()) {
            drawBSTRec(root, 0, sb);
        }
        return sb.toString();
    }

    private void drawBSTRec(Node node, int level, StringBuilder sb) {
        if (node != null) {
            drawBSTRec(node.right, level + 1, sb);
            
            for (int i = 0; i < level; i++) {
                sb.append("    ");
            }
            sb.append(node.data).append("\n");
            
            drawBSTRec(node.left, level + 1, sb);
        }
    }

    public String parenthesize() {
        StringBuilder sb = new StringBuilder();
        parenthesizeRec(root, 0, sb);
        return sb.toString();
    }


    private void parenthesizeRec(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            return;
        }
        
        for (int i = 0; i < depth; i++) {
            sb.append("  "); 
        }
        
        sb.append(node.data).append("\n");
        
        if (node.left != null || node.right != null) {
            for (int i = 0; i < depth; i++) {
                sb.append("  ");
            }
            sb.append("(\n");
            
            parenthesizeRec(node.left, depth + 1, sb);
            
            parenthesizeRec(node.right, depth + 1, sb);
            
            for (int i = 0; i < depth; i++) {
                sb.append("  ");
            }
            sb.append(")\n");
        }
    }
    
    
}
