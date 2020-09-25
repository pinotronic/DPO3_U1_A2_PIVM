package actividad2;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Actividad2 extends JFrame implements ActionListener{

    JFrame winMain;
    private JPanel Panelmenu;
    private int size_x = 640, size_y = 500;
    JButton BTNCargar, BTNCargarVisual, BTNGuardar;
    JTextArea JtextTexto;
    JLabel LBLNombreAlumno, LBLMatricula, LBLTitulo, LBLnombreTrabajador, LBLrfc, LBLnumEmpleado;
    JTextField TXTNombre, TXTRfc, TXTNumEmpleado;

    public Actividad2() {
        this.setTitle("DPSO_U1_A1_PIVM");
        this.setSize(size_x, size_y);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        GUI();

    }

    public static void main(String[] args) {
        Toolkit mipantalla = Toolkit.getDefaultToolkit();
        Actividad2 ventana = new Actividad2();
        ventana.setVisible(true);
    }

    private void GUI() {
        Panelmenu = new JPanel();
        Panelmenu.setBackground(Color.darkGray);

        JTextArea JtextTexto = new JTextArea();
        JtextTexto.setBounds(10, 100, 600, 280);
        Panelmenu.add(JtextTexto);

        JButton BTNCargar = new JButton("Abrir x ruta => C:\\prueba.txt");
        BTNCargar.setBounds(330, 390, 220, 50);
        Panelmenu.add(BTNCargar);

        JButton BTNCargarVisual = new JButton("Buscar y Seleccionar (visual)");
        BTNCargarVisual.setBounds(100, 390, 220, 50);
        Panelmenu.add(BTNCargarVisual);

        LBLTitulo = new JLabel("NOMINA");// se crea la etiqueta
        LBLTitulo.setForeground(Color.white);
        LBLTitulo.setBounds(250, 10, 80, 20); //se da dimension y colocacion
        Panelmenu.add(LBLTitulo);// se agrega a la ventana

        LBLnumEmpleado = new JLabel("No. Empleado");// se crea la etiqueta
        LBLnumEmpleado.setForeground(Color.white);
        LBLnumEmpleado.setBounds(150, 70, 80, 20); //se da dimension y colocacion
        Panelmenu.add(LBLnumEmpleado);// se agrega a la ventana

        TXTNumEmpleado = new JTextField("No. Empleado");// se crea la etiqueta
        TXTNumEmpleado.setBounds(250, 70, 80, 20); //se da dimension y colocacion
        Panelmenu.add(TXTNumEmpleado);// se agrega a la ventana

        LBLnombreTrabajador = new JLabel("Nombre");// se crea la etiqueta
        LBLnombreTrabajador.setForeground(Color.white);
        LBLnombreTrabajador.setBounds(150, 30, 80, 20); //se da dimension y colocacion
        Panelmenu.add(LBLnombreTrabajador);// se agrega a la ventana

        TXTNombre = new JTextField("Nombre");// se crea la etiqueta
        TXTNombre.setBounds(250, 30, 300, 20); //se da dimension y colocacion
        Panelmenu.add(TXTNombre);// se agrega a la ventana

        TXTRfc = new JTextField("RFC");// se crea la etiqueta
        TXTRfc.setBounds(250, 50, 80, 20); //se da dimension y colocacion
        Panelmenu.add(TXTRfc);// se agrega a la ventana

        LBLrfc = new JLabel("RFC");// se crea la etiqueta
        LBLrfc.setForeground(Color.white);
        LBLrfc.setBounds(150, 50, 30, 20); //se da dimension y colocacion
        Panelmenu.add(LBLrfc);// se agrega a la ventana

        TXTRfc = new JTextField("RFC");// se crea la etiqueta
        TXTRfc.setBounds(250, 50, 80, 20); //se da dimension y colocacion
        Panelmenu.add(TXTRfc);// se agrega a la ventana

        JButton BTNGuardar = new JButton("Guardar");
        BTNGuardar.setBounds(332, 50, 100, 50);
        Panelmenu.add(BTNGuardar);

        LBLNombreAlumno = new JLabel("Pino Martin Vargas Marquez.");// se crea la etiqueta
        LBLNombreAlumno.setForeground(Color.white);
        LBLNombreAlumno.setBounds(150, 440, 180, 20); //se da dimension y colocacion
        Panelmenu.add(LBLNombreAlumno);// se agrega a la ventana

        LBLMatricula = new JLabel("ES172005165");
        LBLMatricula.setForeground(Color.white);
        LBLMatricula.setBounds(350, 440, 150, 20);
        Panelmenu.add(LBLMatricula);

        BTNCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ManejoArchivos cargaArchivo = new ManejoArchivos();

                String Texto;
                try {
                    Texto = "Pino Martin Vargas Marquez." + " ES172005165" + "\n" + cargaArchivo.AbrirArchivo("C:\\prueba.txt");
                    JtextTexto.setText("");
                    JtextTexto.setText(Texto);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Actividad2.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            private PopupMenu AbrirArchivo(String dOneDrive__Universidad_Abierta_y_a_Distan) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });

        BTNCargarVisual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ManejoArchivos LeerArchivos = new ManejoArchivos();

                String Texto;
                try {
                    JtextTexto.setText("");
                    Texto = "Pino Martin Vargas Marquez." + " ES172005165" + "\n" + LeerArchivos.LeerArchivo();
                    JtextTexto.setText(Texto);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Actividad2.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            private PopupMenu AbrirArchivo(String dOneDrive__Universidad_Abierta_y_a_Distan) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });

        BTNGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ManejoArchivos cargaArchivo = new ManejoArchivos();

                String Texto;
                String numeroEmpleado;
                String nombre;
                String rfc;
                String direccionDirectorio="c:\\tarea\\Nomina.txt";
                numeroEmpleado = TXTNumEmpleado.getText();
                nombre = TXTNombre.getText();
                rfc = TXTRfc.getText();
                Texto = "# Empleado: "+ numeroEmpleado+ " Nombre: " + nombre  + " RFC: "+ rfc + "\n" ;
                cargaArchivo.GuardarFichero(Texto, direccionDirectorio);
                

            }

            private PopupMenu AbrirArchivo(String dOneDrive__Universidad_Abierta_y_a_Distan) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            private void GuardarFichero(String Texto, String direccionDirectorio) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        Panelmenu.setLayout(null);//quitamos layout
        this.getContentPane().add(Panelmenu);
        Panelmenu.setVisible(true);
        Panelmenu.setBorder(BorderFactory.createLineBorder(Color.red, 1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
