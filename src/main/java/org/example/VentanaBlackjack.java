package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBlackjack extends JFrame implements ActionListener {
    private JPanel panelContenedor;
    private JPanel panelResultado;
    private JPanel panelPregunta;
    private JLabel textoPrevioGanador;
    private JLabel ganador;
    private JLabel preguntaJugarNuevamente;
    private JButton botonVolver;
    private JButton botonJugarOtraVez;
    private VentanaPrincipal ventanaPrincipal; // Referencia a la ventana principal

    public VentanaBlackjack(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal; // Asignar la referencia de la ventana principal
        initVentanaBlackjack();
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initVentanaBlackjack() {
        panelContenedor = new JPanel();

        panelResultado = new JPanel();
        panelPregunta = new JPanel();

        textoPrevioGanador = new JLabel();
        textoPrevioGanador.setText("El resultado es: ");

        ganador = new JLabel();
        ganador.setText(JuegoBlackjack.jugar());

        preguntaJugarNuevamente = new JLabel();
        preguntaJugarNuevamente.setText("¿Desea jugar nuevamente?");

        botonVolver = new JButton();
        botonVolver.setText("Volver");

        botonJugarOtraVez = new JButton();
        botonJugarOtraVez.setText("Jugar otra vez");

        panelResultado.add(textoPrevioGanador);
        panelResultado.add(ganador);
        panelPregunta.add(preguntaJugarNuevamente);
        panelPregunta.add(botonVolver);
        panelPregunta.add(botonJugarOtraVez);

        panelContenedor.add(panelResultado);
        panelContenedor.add(panelPregunta);

        this.add(panelContenedor);

        botonJugarOtraVez.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ganador.setText(JuegoBlackjack.jugar());
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

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}