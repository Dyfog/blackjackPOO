package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaPrincipal extends JFrame implements ActionListener{
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

        JLabel textoPregunta = new JLabel();
        textoPregunta.setText("Eliga el juego que desea jugar");

        JButton botonBlackjack = new JButton();
        botonBlackjack.setText("Blackjack");
        JButton botonBullseye = new JButton();
        botonBullseye.setText("Bullseye");

        panel.add(textoPregunta);
        panel.add(botonBlackjack);
        panel.add(botonBullseye);

        this.add(panel);

        botonBlackjack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, JuegoBlackjack.jugar());
            }
        });






    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
