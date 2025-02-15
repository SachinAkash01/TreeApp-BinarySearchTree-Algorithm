/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author it21351372
 */
public class Tree {
    
    public Node root;
    public static String order="";

    public Tree(Node root) {
        root = null;
    }
    
    public void insert(int v){
        Node newNode = new Node(v);
        if (root == null){
            root = newNode;
        }
        else{
            Node current = root;
            Node parent;
            
            while (true){
                parent = current;
                if (v < current.getNumber()){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else{
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
        
    } 
    
    public Node search(int key){
        Node current = root;
        while (current != null){
            if (key == current.getNumber()){
                return current;
            }
            else if (key < current.getNumber()){
                current = current.leftChild;
            }
            else{
                current = current.rightChild;
            }
        }
        return null;
    } 
    
    public String display(int op){     
        order = "";     
        switch(op)     
        {         
            case 1: inOrder(root);break;         
            case 2: preOrder(root);break;         
            case 3: postOrder(root);break;         
            default: break;     
        }     
        return order; 
    }
    
    public boolean delete(int key)
    {
	Node current = root;
        Node parent = root;
	boolean isLeftChild = true;
	while(current.getNumber() != key)
	{
		parent = current;
			if(key < current.getNumber())
			{
				isLeftChild = true;
				current = current.leftChild;
			}
			else
			{
				isLeftChild = false;
				current = current.rightChild;
			}
		if(current == null)
			return false;
	}

        if(current.leftChild==null && current.rightChild==null)
        {
		if(current == root)
			root = null;
		else if(isLeftChild)
			parent.leftChild = null;
		else
			parent.rightChild = null;
          }
	else if(current.rightChild==null)
		if(current == root)
				root = current.leftChild;
		else if(isLeftChild)
			parent.leftChild = current.leftChild;
		else
 			parent.rightChild = current.leftChild;

	else if(current.leftChild==null)
		if(current == root)
			root = current.rightChild;
		else if(isLeftChild)
			parent.leftChild = current.rightChild;
		else
			parent.rightChild = current.rightChild;
        else
        {
            Node successor = getSuccessor(current);
            if(current == root)
                        root = successor;
            else if(isLeftChild)
                        parent.leftChild = successor;
            else
                        parent.rightChild = successor;

            successor.leftChild = current.leftChild;

        }

        return true;
    }

    private Node getSuccessor(Node dn)
        {
        Node sp = dn;
        Node s = dn;
        Node current = s.rightChild;

        while(current != null)
        {
            sp = s;
            s = current;
            current = current.leftChild;
        }
        if(s != dn.rightChild)
        {
            sp.leftChild = s.rightChild;
            s.rightChild = dn.rightChild;
        }
        return s;
    }
    
    private void inOrder(Node lr){
        if(lr != null)
      	{ 
            inOrder(lr.leftChild);
            order += "( "+lr.getNumber()+")"+",";
            inOrder(lr.rightChild); 
      }
    } 
    
    private void preOrder(Node lr){
        if (lr != null){
            order += "( "+lr.getNumber()+")"+",";
            preOrder(lr.leftChild);
            preOrder(lr.rightChild);
        }
    } 
    
    private void postOrder(Node lr){
        if (lr != null){     
            postOrder(lr.leftChild);
            postOrder(lr.rightChild);
            order += "( "+lr.getNumber()+")"+",";
        }
    }
}
