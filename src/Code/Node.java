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
public class Node {
    int number;  
    public Node leftChild;  
    public Node rightChild;
    
    

    public Node(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
