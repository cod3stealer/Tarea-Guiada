import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    public GUI() {
        //Propiedades

        //Establece el titulo de la ventana gráfica
        setTitle("Conversión Celsius / Farenheit");
        //Define el comportamiento de la app cuando el usuario cierra la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Define el tamaño inicial de la ventana
        setSize(new Dimension(800,300));
        //Posiciona la ventana en el centro de la pantalla
        setLocationRelativeTo(null);
        //Define un GridBagLayout como administrador de diseño de la ventana.
        //Esto permite tener más control sobre el contenido y configuración general.
        GridBagConstraints w = new GridBagConstraints();
        //Establece que debe llenar tanto el eje vertical como el horizontal dentro de la celda que ocupa
        w.fill = GridBagConstraints.BOTH;

        //JTextField: definicion de celdas y columnas
        JTextField celdas = new JTextField();
        celdas.setColumns(5);
        w.gridx = 0;
        w.gridy = 1;
        add(celdas,w);

        /**
         * // JButton: conversion a Farenheit y Celsius //
         *
         * Crea un boton con la etiqueta "conversion..." que se usará para la conversion de temperaturas.
         * Luego se agrega un LISTENER al boton y a su vez a este boton se le asigna un "actionPerformed"
         * lo cual determina la accion que realiza el boton una vez es presionado.
         *
         * Dentro de esto ultimo, se define la funcionalidad del boton:
         * Float f = Float.parseFloat(celdas.getText()); Esta línea obtiene el texto del campo de entrada (celdas) y lo convierte a un número decimal de tipo float.
         * Float c = ConTemp.farToCel(f); Esta línea llama a un método llamado farToCel de una clase llamada ConTemp. Convierte la temperatura de Fahrenheit (f) a Celsius y almacena el resultado en la variable c.
         * celdas.setText(String.valueOf(c)); Esta línea toma el resultado convertido en Celsius (c) y lo convierte a una cadena de texto usando String.valueOf(c).
         * Luego, establece el texto del campo de entrada (celdas) a esta cadena, mostrando la temperatura convertida al usuario.
         * */
        JButton celsius = new JButton("Conversion a Celsius");
        celsius.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Float f = Float.parseFloat(celdas.getText());
                Float c = ConTemp.farToCel(f);
                celdas.setText(String.valueOf(c));
            }
        });

        JButton faren = new JButton("Conversion a Farenheit");
        faren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Float c = Float.parseFloat(celdas.getText());
                Float f = ConTemp.celToFar(c);
                celdas.setText(String.valueOf(f));
            }
        });
        w.gridx = 1;
        w.gridy = 1;
        add(celdas,w);
    }
}
