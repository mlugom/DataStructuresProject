/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Farid Estepa
 */
public class Registro {

    public static void main(String[] args) throws IOException {

        ArrayList<Usuario> arreglo_empleados = new ArrayList<>();
        ArrayList<Usuario> arreglo_clientes = new ArrayList<>();
        ArrayList<Usuario> arreglo_peliculas = new ArrayList<>();

        String ruta_clientes = "clientes.txt";
        String ruta_empleados = "empleados.txt";
        String ruta_peliculas = "peliculas.txt";

        File archivo1 = new File(ruta_clientes);
        FileWriter w = new FileWriter(archivo1);
        BufferedWriter bw = new BufferedWriter(w);
        PrintWriter wr = new PrintWriter(bw);

        Scanner lecture = new Scanner(archivo1);

        char abc[] = {'a', 'b', 'c', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] nombre = new char[8];
        int edad = 0, id = 0;
        boolean rol = true;
        String name = "";
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 8; i++) {
                int el = (int) (Math.random() * 12);
                nombre[i] = (char) abc[el];

                name = name + nombre[i];
                rol = Math.random() < 0.5;

                edad = (int) (Math.random() * 80);
                id = 10000000 + (int) (Math.random() * 9999999);

            }
            if (rol == true) {
                arreglo_empleados.add(new Empleado(name, edad, id, rol));
            } else {
                arreglo_clientes.add(new Cliente(name, edad, id, rol));
            }

            wr.write(nombre);
            wr.write(";" + edad + ";" + id + ";" + rol);
            wr.write('\n');
        }

        Scanner sc = new Scanner(System.in);

        System.out.flush();
        System.out.println("/////////////////////////////////////////");
        System.out.println("              Bienvenido");
        System.out.println("¿Qué desea hacer?");
        System.out.println("1) Ingresar usuario");
        System.out.println("2) Registrar usuario");
        // System.out.println("3) Consultar usuario");
        System.out.println("4) Consultar pelicula");
        System.out.println("/////////////////////////////////////////");

        int seleccion = sc.nextInt();
        switch (seleccion) {
            case 1:

            case 2:
                for (int i = 0; i < 30; i++) {
                    System.out.println("");
                }
                System.out.println("Ingrese nombre");
                String nombre_dinamico = sc.next();
                System.out.println("Ingrese edad");
                int edad_dinamico = sc.nextInt();
                System.out.println("Ingrese id");
                int id_dinamico = sc.nextInt();
                System.out.println("¿Es usted empleado? (si o no)");
                String rol_dinamico = sc.next();

                if (rol_dinamico.equals("si")) {
                    System.out.println("Ingrese clave (dada por la empresa)");
                    // La clave por defecto es 0000
                    String clave_dinamico = sc.next();
                    if (clave_dinamico.equals("0000")) {
                        arreglo_empleados.add(new Cliente(nombre_dinamico, edad_dinamico, id_dinamico, true));
                        System.out.println("Registrado con éxito");
                    } else {
                        System.out.println("Clave incorrecta");
                    }

                } else {

                    wr.write(nombre_dinamico);
                    wr.write(";" + edad_dinamico + ";" + id_dinamico + ";" + "false");
                    wr.write('\n');

                    arreglo_clientes.add(new Cliente(nombre_dinamico, edad_dinamico, id_dinamico, false));
                    System.out.println("Registrado con éxito");

                }
                wr.close();
                bw.close();
        }

    }
}
