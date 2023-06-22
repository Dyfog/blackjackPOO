package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaBullseye extends JFrame {
    JPanel panel;
    JList<String> listaCaballos;
    JList<String> listaApuestas;

    JLabel textoJuego;
    JLabel textoDineroRestante;
    JLabel dineroRestante;
    JLabel preguntaJugar;
    JLabel esGanador;
    JButton botonJugarNuevamente;
    JButton botonVolver;
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

        textoDineroRestante = new JLabel();
        textoDineroRestante.setText("A usted le quedan: " );

        dineroRestante = new JLabel();
        dineroRestante.setText("50000");

        preguntaJugar = new JLabel();
        preguntaJugar.setText("¿Que desea hacer?");

        botonVolver = new JButton("Volver");
        botonJugarNuevamente = new JButton("Jugar");

        esGanador = new JLabel();

        listaCaballos = new JList<String>();
        listaApuestas = new JList<String>();


        JScrollPane scrollPane = new JScrollPane(listaCaballos);
        scrollPane.setPreferredSize(new Dimension(200, 120));

        JScrollPane scrollPaneApuestas = new JScrollPane(listaApuestas);
        scrollPaneApuestas.setPreferredSize(new Dimension(200, 120));

        panel.add(textoJuego);
        panel.add(scrollPane);
        panel.add(scrollPaneApuestas);

        panel.add(textoDineroRestante);
        panel.add(dineroRestante);
        panel.add(preguntaJugar);
        panel.add(botonVolver);
        panel.add(botonJugarNuevamente);
        panel.add(esGanador);

        this.add(panel);


        botonJugarNuevamente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int caballoIndex = listaCaballos.getSelectedIndex();
                int apuestaIndex = listaApuestas.getSelectedIndex();
                int idCaballoGanador=-1;
                if (caballoIndex!=-1 && apuestaIndex!=-1){
                    if (JuegoBullseye.jugarBullseyeVentana(caballoIndex)){
                        esGanador.setText("¡Felicidades, Usted es el ganador!");
                        String textoDineroRestante = dineroRestante.getText();
                        int dineroActual = Integer.parseInt(textoDineroRestante);
                        int apuesta = JuegoBullseye.determinarValorApuestaVentana(apuestaIndex);
                        int multiplicador = JuegoBullseye.determinarMultiplicadorVentana(apuestaIndex);
                        dineroRestante.setText(String.valueOf(dineroActual+apuesta*(multiplicador-1)));
                    }else {
                        esGanador.setText("Tristemente, perdió");
                        String textoDineroRestante = dineroRestante.getText();
                        int dineroActual = Integer.parseInt(textoDineroRestante);
                        int apuesta = JuegoBullseye.determinarValorApuestaVentana(apuestaIndex);
                        if(dineroActual-apuesta<=0){
                            mostrarVentanaPerdedor();
                        }
                        dineroRestante.setText(String.valueOf(dineroActual-apuesta));

                    }
                }
            }
        });
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == botonVolver) {
                    ventanaPrincipal.setVisible(true); // Mostrar la ventana principal
                    dispose(); // Cerrar la ventana actual
                }
            }
        });
    }

    public void mostrarVentanaPerdedor() {
        JOptionPane.showMessageDialog(this, "Ha perdido el juego.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        ventanaPrincipal.setVisible(true); // Mostrar la ventana principal
        dispose(); // Cerrar la ventana actual
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
