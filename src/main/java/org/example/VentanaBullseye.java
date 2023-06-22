package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaBullseye extends JFrame {
    JPanel panel;
    JList<String> listaCaballos;
    JList<String> listaApuestas;

    JLabel textoJuego;
    JLabel dineroRestante;
    JLabel preguntaJugarNuevamente;
    JButton jugarNuevamente;
    private VentanaPrincipal ventanaPrincipal; // Referencia a la ventana principal

    public VentanaBullseye(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal; // Asignar la referencia de la ventana principal
        initVentanaBullseye();
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initVentanaBullseye() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        textoJuego = new JLabel();
        textoJuego.setText("Elija un caballo y el monto a apostar para jugar, puede jugar repetidas veces");

        preguntaJugarNuevamente = new JLabel();
        preguntaJugarNuevamente.setText("¿Desea jugar nuevamente?");

        listaCaballos = new JList<String>();
        listaApuestas = new JList<String>();


        JScrollPane scrollPane = new JScrollPane(listaCaballos);
        scrollPane.setPreferredSize(new Dimension(200, 120));

        JScrollPane scrollPaneApuestas = new JScrollPane(listaApuestas);
        scrollPaneApuestas.setPreferredSize(new Dimension(200, 120));

        panel.add(textoJuego);
        panel.add(scrollPane);
        panel.add(scrollPaneApuestas);

        panel.add(preguntaJugarNuevamente);

        this.add(panel);
    }

    public void mostrarCaballos(ArrayList<Caballo> caballos) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Caballo caballo : caballos) {
            model.addElement(caballo.getNombre()+",Nro: "+caballo.getId()+", Color: "+caballo.getColor());
        }
        listaCaballos.setModel(model);
    }

    public void mostrarApuestas() {
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("$500, si gana multiplica x2");
        model.addElement("$1000, si gana multiplica x3");
        model.addElement("$5000, si gana multiplica x4");
        model.addElement("$10000, si gana multiplica x5");
        model.addElement("$25000, si gana multiplica x7");
        model.addElement("$50000, si gana multiplica x10");
        listaApuestas.setModel(model);
    }
}
