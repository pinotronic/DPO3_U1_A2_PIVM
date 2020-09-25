package actividad2;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.*;
import javax.swing.JFileChooser;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ManejoArchivos {
    public static String ruta = "";
        private File archivo = null;

    public String AbrirArchivo(String direccion) throws FileNotFoundException {

        String texto = "";
        try {
            BufferedReader cargaarchivo = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while ((bfRead = cargaarchivo.readLine()) != null) {
                temp = temp + bfRead + "\n";
            }
            texto = temp;
        } catch (Exception e) {
            System.err.println("No se encontro Archivo");
        }
        return texto;
    }

    public String LeerArchivo() throws FileNotFoundException {
        String texto = "";
        Scanner entrada = null;
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Texto (.txt)", "txt");
        fileChooser.setFileFilter(filtro);
        int valor = fileChooser.showOpenDialog(fileChooser);
        if (valor == JFileChooser.APPROVE_OPTION) {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            try {

                String temp = "";
                File f = new File(ruta);
                entrada = new Scanner(f);

                while (entrada.hasNext()) {
                    temp = temp + entrada.nextLine() + "\n";

                    System.out.println(temp);
                }
                texto = temp;
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                if (entrada != null) {
                    entrada.close();
                }
            }
        }

        return texto;
    }

    public void GuardarFichero(String SCadena, String ruta) {

        System.out.println(ruta);
        archivo = new File(ruta);
        try {

            if (archivo.exists()) {
                archivo.delete();
            }
            FileWriter escribirArchivo;
            try (BufferedWriter wr = new BufferedWriter(new FileWriter(archivo))) {
                escribirArchivo = new FileWriter(archivo, true);
                try (BufferedWriter buffer = new BufferedWriter(escribirArchivo)) {
                    buffer.write(SCadena);
                    buffer.newLine();
                     JOptionPane.showMessageDialog(null, "Los Datos se han Guardado en c:\\tarea\\Nomina.txt");
                }
            }
            escribirArchivo.close();
        } catch (HeadlessException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
