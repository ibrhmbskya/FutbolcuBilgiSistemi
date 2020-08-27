package com.company;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    // constructor methodlar.
    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    // get set methodlari.
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }



    // Sporcu ekleme methodu.
    public void addSporcu(Sporcu sporcu){
        Node newNode = new Node(sporcu, null, null);
        boolean flag = false;
        // bossa direk ekleniyor.
        if(isEmpty()) {
            this.head = newNode;
        }
        // bos degilse...
        else{
            Node previousNode =this.head;
            Node currentNode = this.head;
            while (!flag){
                // currentNode bossa ekliyor.
                if (currentNode == null){
                    this.tail = newNode;
                    this.tail.setPreviousNode(previousNode);
                    previousNode.setNextNode(this.tail);
                    break;
                }
                // gelen isim ve soyisim alfabetik olarak uygun yere ekleniyor.
                else if (newNode.getSporcu().getNameSurname().compareTo(currentNode.getSporcu().getNameSurname()) < 0) {
                    insertNode(currentNode, newNode);
                    break;
                }
                else if (newNode.getSporcu().getNameSurname().compareTo(currentNode.getSporcu().getNameSurname()) > 0){
                    previousNode = currentNode;
                    currentNode = currentNode.getNextNode();
                }
            }
        }
        // son node ise ve baş degilse son node olarak atiyor.
        if(newNode.getNextNode() == null && newNode != this.head)
            this.tail = newNode;
    }

    // araya ekleme methodu.
    public void insertNode(Node currentNode, Node inNode){
        // ilk node ise.
        if (currentNode == this.head){
            inNode.setNextNode(this.head);
            this.head.setPreviousNode(inNode);
            this.head = inNode;

        }
        else {
            Node previousNode = currentNode.getPreviousNode();
            previousNode.setNextNode(inNode);
            inNode.setPreviousNode(previousNode);
            inNode.setNextNode(currentNode);
            currentNode.setPreviousNode(inNode);
        }
    }

    // ilk node boş mu diye bakiyor.
    public boolean isEmpty(){
        return this.head == null;
    }

    //TEKRAR KONTROL ET
    //ad soyada gore sporcu arama.
    public List<Sporcu> searchSporcu(String name){
        List<Sporcu> clubList = new ArrayList<>();
        Node currentNode = this.head;
        while (currentNode != null){
            if(currentNode.getSporcu().getNameSurname().equals(name))
                clubList.add(currentNode.getSporcu());
            else if (currentNode.getSporcu().getNameSurname().compareTo(name) > 0)
                break;

            currentNode = currentNode.getNextNode();
        }
        return clubList;
    }
    // Sporcu silme.
    public boolean deleteNode(String name){
        Node currentNode = this.head;
        Node previousNode = this.head;
        while (currentNode != null){
            if(currentNode.getSporcu().getNameSurname().equals(name)){
                if (currentNode == this.head){
                    this.head = currentNode.getNextNode();
                    this.head.setPreviousNode(null);
                }
                else if (currentNode == this.tail){
                    this.tail = previousNode;
                    this.tail.setNextNode(null);
                }
                else {
                    previousNode.setNextNode(currentNode.getNextNode());
                    currentNode.getNextNode().setPreviousNode(previousNode);
                }
                return true;
            }
            else if (currentNode.getSporcu().getNameSurname().compareTo(name) > 0)
                return false;
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        return false;
    }
}
