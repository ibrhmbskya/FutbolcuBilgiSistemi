package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SporcuForm {
    private JTabbedPane menuTabbedPane;
    private JLabel nameLabel;
    private JLabel bDayLabel;
    private JLabel clubLabel;
    private JTextField nameText;
    private JButton addButton;
    private JPanel addDVD;
    private JButton saveAndExitButton;
    private JPanel searchDvd;
    private JTextField searchNameTextField;
    private JLabel searchNameLabel;
    private JButton searchButton;
    private JTextArea searchTextArea;
    private JPanel deleteDvd;
    private JTextField delNameTextField;
    private JTextField delTitleTextField;
    private JButton silButton;
    private JPanel listDvdAlphabetical;
    private JRadioButton aZListeleRadioButton;
    private JRadioButton zAListeleRadioButton;
    private JTextArea listTextArea;
    private JButton listButton;
    private JPanel listDvd2000;
    private JTextArea listTextArea2000;
    private ButtonGroup buttonGroup;
    public static DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    private JPanel SporcuPanel;
    private JTextField bDayText;
    private JTextField clubText;
    private JPanel searchSporcu;
    private JPanel deleteSporcu;
    private JLabel deleteNameLabel;


    public SporcuForm() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sporcu newSporcu;
                if (nameText.getText().equals("") || bDayText.getText().equals("") || clubText.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Bilgileri eksiksiz giriniz!!");
                else {
                    String s=bDayText.getText();
                    String[] parcala=s.split("/");
                    Date bDay=new Date(Integer.parseInt(parcala[0]),Integer.parseInt(parcala[1]),Integer.parseInt(parcala[2]));
                    newSporcu = new Sporcu(nameText.getText(), bDay);
                    List<String> club = new ArrayList<>();
                    club = Arrays.asList(clubText.getText().replace("\r\n", "").split(", |,"));
                    for (int i = 0; i < club.size(); i++)
                        newSporcu.addClub(club.get(i));
                    doublyLinkedList.addSporcu(newSporcu);
                    nameText.setText("");
                    bDayText.setText("");
                    clubText.setText("");
                    JOptionPane.showMessageDialog(null, "Sporcu eklendi..");
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            //Girilen sporcu ismine göre arama buton işlemleri
            @Override
            public void actionPerformed(ActionEvent e) {
                searchTextArea.setText("");
                List<Sporcu> clubList;
                if (searchNameTextField.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Sporcunun ismini giriniz!!");
                else{
                    clubList = doublyLinkedList.searchSporcu(searchNameTextField.getText());
                    if (clubList.size() == 0)
                        JOptionPane.showMessageDialog(null, "Girdiğiniz sporcuya ait bilgi bulunamadı");
                    else {
                        for (int i = 0; i < clubList.size(); i++)
                            searchTextArea.append(clubList.get(i).toString() + "\n");
                        searchTextArea.setVisible(true);
                    }
                }

            }
        });
        silButton.addActionListener(new ActionListener() {
            //Girilen Sporcu silme buton işlemlei
            @Override
            public void actionPerformed(ActionEvent e) {
                if (delNameTextField.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Bilgileri eksiksiz giriniz!!");
                else{
                    boolean isDelete = doublyLinkedList.deleteNode(delNameTextField.getText());
                    if (isDelete)
                        JOptionPane.showMessageDialog(null, "Sporcu silindi..");
                    else
                        JOptionPane.showMessageDialog(null, "Sporcu bulunamadı!!");
                }
            }
        });
        ItemListener listener = new ItemListener() {
            // A'dan Z'ye ve Z'den A'ya siralama buton işlemleri
            @Override
            public void itemStateChanged(ItemEvent e) {
                ButtonGroup group = new ButtonGroup();
                group.add(aZListeleRadioButton);
                group.add(zAListeleRadioButton);
                listTextArea.setText("");
                Node currentNode;
                if (aZListeleRadioButton.isSelected()){
                    currentNode = doublyLinkedList.getHead();
                    while (currentNode != null) {
                        listTextArea.append(currentNode.getSporcu().toString() + "\n");
                        currentNode = currentNode.getNextNode();
                    }
                }
                else {
                    currentNode = doublyLinkedList.getTail();
                    while (currentNode != null) {
                        listTextArea.append(currentNode.getSporcu().toString() + "\n");
                        currentNode = currentNode.getPreviousNode();
                    }
                }
            }
        };
        aZListeleRadioButton.addItemListener(listener);
        zAListeleRadioButton.addItemListener(listener);


        saveAndExitButton.addActionListener(new ActionListener() {
            //Dosyaya yazma islemleri
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Sporcu.txt")));
                    Node currentNode = doublyLinkedList.getHead();
                    List<String> club;
                    while (currentNode != null){
                        writer.write(currentNode.getSporcu().getNameSurname() + ", " + currentNode.getSporcu().getBirthDate());
                        club = currentNode.getSporcu().getClub();
                        for (int i = 0; i < club.size(); i++)
                            writer.write( ", " + club.get(i));
                        if (currentNode.getNextNode() == null) {
                            writer.write(".");
                            break;
                        }
                        else
                            writer.write(".\n");
                        currentNode = currentNode.getNextNode();
                    }
                    writer.close();
                    System.exit(0);

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });

    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("SporcuForm");
        frame.setContentPane(new SporcuForm().SporcuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Sporcu newSporcu;
        List<String> sporcuInfo ;
        Scanner scan = null;
        String s;
        // dosyadan okuma islemleri.

        File file = new File("sporcu.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        int i=0;
        String satir = reader.readLine();

        while (satir!=null) {

            sporcuInfo = Arrays.asList(satir.split(", "));
            s=sporcuInfo.get(1);
            String[] parcala=s.split("/");
            Date bday=new Date(Integer.parseInt(parcala[0]),Integer.parseInt(parcala[1]), Integer.parseInt(parcala[2]));
            System.out.println(bday.toString());
            System.out.println(sporcuInfo.get(0));
            newSporcu = new Sporcu(sporcuInfo.get(0), bday);
            for (int k = 2; k < sporcuInfo.size(); k++)
                newSporcu.addClub(sporcuInfo.get(k));
            doublyLinkedList.addSporcu(newSporcu);
            satir = reader.readLine();
        }


        }

}

