package com.company;

// node class i olusturuldu.
public class Node {
    private Sporcu sporcu;
    private Node nextNode;
    private Node previousNode;

    // constructor methodlar.
    Node(Sporcu sporcu, Node nextSporcu, Node previousSporcu){
        this.sporcu= sporcu;
        this.nextNode = nextSporcu;
        this.previousNode = previousSporcu;
    }

    // set get methodlari.
    public void setDvd(Sporcu sporcu) {
        this.sporcu = sporcu;
    }

    public Sporcu getSporcu() {
        return sporcu;
    }

    public void setNextNode(Node node){
        this.nextNode = node;
    }

    public void setPreviousNode(Node node){
        this.previousNode = node;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }
}
