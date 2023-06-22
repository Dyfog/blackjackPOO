package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaPrincipal extends JFrame implements ActionListener{
    private JLabel bienveida;
    private JLabel textoPregunta;
    private JButton botonBlackjack;
    private JButton botonBullseye;
    private JPanel panel;

    public VentanaPrincipal(){
        initVentanaPrincipal();
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initVentanaPrincipal(){

        JPanel panel = new JPanel();

        JLabel bienvenida = new JLabel();
        bienvenida.setText("Bienvenida/o al Casino Deluxe");

        JLabel textoPregunta = new JLabel();
        textoPregunta.setText("Eliga el juego que desea jugar");

        JButton botonBlackjack = new JButton();
        botonBlackjack.setText("Blackjack");
        JButton botonBullseye = new JButton();
        botonBullseye.setText("Bullseye");

        panel.add(bienvenida);
        panel.add(textoPregunta);
        panel.add(botonBlackjack);
        panel.add(botonBullseye);

        this.add(panel);

        botonBullseye.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaBullseye vBullseye = new VentanaBullseye(VentanaPrincipal.this);
                vBullseye.mostrarCaballos(JuegoBullseye.crearCaballos());
                vBullseye.mostrarApuestas();
                VentanaPrincipal.this.setVisible(false);
                vBullseye.setVisible(true);
            }
        });

        botonBlackjack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaBlackjack vBlackjack = new VentanaBlackjack(VentanaPrincipal.this);
                VentanaPrincipal.this.setVisible(false);
                vBlackjack.setVisible(true);



            }
        });






    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
