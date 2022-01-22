package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JTextField texto;
    private JTextArea areaTexto;
    private FileManager fileManager;
    private Escucha escucha;


    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("FilesManager app");
        this.setSize(200,100);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        escucha = new Escucha();
        fileManager = new FileManager();
        //Set up JComponents
        headerProject = new Header("File Manager", Color.BLACK);
        this.add(headerProject,BorderLayout.NORTH);

        texto = new JTextField(10);
        texto.addActionListener(escucha);
        add(texto,BorderLayout.SOUTH);
        areaTexto = new JTextArea(10,30);
        areaTexto.setText(fileManager.lecturaFile());
        JScrollPane scroll = new JScrollPane(areaTexto);
        this.add(scroll,BorderLayout.CENTER);

    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            fileManager.escribirTexto(texto.getText());
            areaTexto.setText(fileManager.lecturaFile());
        }
    }
}
