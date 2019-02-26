package com.edu.appswbd.practica.uno.Frames;

import com.edu.appswbd.practica.uno.Convertidor.Convertidor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Clase que implementa extiende JFrame e implementa los metodos Action listener y MouseListener
public class ConvertidorFrame extends JFrame implements ActionListener, MouseListener{

    //Declaracion
    private JScrollPane jsP1;
    private JTextArea  txtArea1;
    private JScrollPane jsP2;
    private JTextArea  txtArea2;
    private JButton btnConvertir;
    private JComboBox jC1;
    private JTextArea txtMatricula;
    private JTextArea txtNombres;
    private JTextArea txtApellidos;




    Convertidor metodos = new Convertidor();


    //Constructor
    public ConvertidorFrame() throws HeadlessException {
        this.setName("ConvertidorJson");
        this.setLocation(300,100);
        this.setSize(800,500);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.setResizable(false);

        this.setIconImage(new ImageIcon("C:/Users/Jesus Adan/IdeaProjects/_1145285ConvertidorJSON/src/main/resources/Images/json.png").getImage());

    //Metodo incio
        init();

    }


    //metodo donde se le agregaran los componentes a la ventana
    public void init(){

        //Inicializacion

        txtArea1=new JTextArea("Ingrese Texto Clase o XML");
        jsP1= new JScrollPane(txtArea1);
        jsP1.setBounds(20,5,300,400);
        this.add(jsP1);


        txtArea2=new JTextArea("");
        jsP2= new JScrollPane(txtArea2);
        jsP2.setBounds(460,5,300,400);
        this.add(jsP2);

        btnConvertir= new JButton("Convertir");
        btnConvertir.setBounds(340,300,100,30);
        this.add(btnConvertir);



        jC1=new JComboBox();
        jC1.setBounds(100,420,100,30);
        jC1.addItem("XML");
        jC1.addItem("Java");

        this.add(jC1);

        txtMatricula=new JTextArea("Matricula");
        txtMatricula.setBounds(20,5,50,20);
        txtMatricula.setVisible(false);
        this.add(txtMatricula);


        txtNombres=new JTextArea("Nombre");
        txtNombres.setBounds(20,20,50,20);
        txtNombres.setVisible(false);
        this.add(txtNombres);

        txtApellidos=new JTextArea("Apellido");
        txtApellidos.setBounds(35,100,50,20);
        txtApellidos.setVisible(false);
        this.add(txtApellidos);




        //Acciones
        btnConvertir.addActionListener(this);
        txtArea1.addMouseListener(this);
        jC1.addMouseListener( this);





    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(btnConvertir)) {
            String textoEntrada = txtArea1.getText();
            if (textoEntrada.trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "No hay texto", "Texto vacio", JOptionPane.WARNING_MESSAGE);
            } else if(jC1.getSelectedItem()=="Java") {
                //metodo de transformar clase a json mandando como parametro el texto de entrada y regresarlo a una cadena de texto convertido
            String cadenaJSON= metodos.convertirClaseToJson(txtArea1.getText());

                txtArea2.setText("");
                txtArea2.setText(cadenaJSON);

            } else if(jC1.getSelectedItem()=="XML") {
                //metodo de transformar clase a json mandando como parametro el texto de entrada y regresarlo a una cadena de texto convertido
                String cadenaJSON= metodos.convertirXmlToJson(txtArea1.getText());


                txtArea2.setText("");
                txtArea2.setText(cadenaJSON);
                if(txtArea2.getText().equals("{}")){
                    JOptionPane.showMessageDialog(this, "Ingrese formato XML", "No es formato XML", JOptionPane.WARNING_MESSAGE);

                }
            }

            }

    }

    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(txtArea1)) {
            txtArea1.setText(null);

        }

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }



}
