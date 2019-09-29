/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.*;
import java.awt.Robot;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Farid Estepa
 */
public class Registro {

    public static void limpiarPantalla() {
        try {
            Robot robbie = new Robot();
            robbie.keyPress(17);
            robbie.keyPress(76);
            robbie.keyRelease(17);
            robbie.keyRelease(76);

            Thread.sleep(100);

            robbie.keyPress(17);
            robbie.keyPress(16);
            robbie.keyPress(82);
            robbie.keyRelease(17);
            robbie.keyRelease(16);
            robbie.keyRelease(82);
            Thread.sleep(100);
        } catch (Exception ex) {
        }

    }

    public static Sala elegirSala(Sala[] salas, int hora) {
        int indice = 0;
        for (int i = 0; i < salas.length; i++) {
            for (int j = 0; j < salas[i].getFunciones().size(); j++) {
                if (salas[i].getFunciones().get(j).getHora() == hora) {
                    indice++;
                }
            }
        }
        if(indice==3){
            return null;
        }else{
            return salas[indice];
        }
    }

    public static void escribirArchivo(ArrayList<Usuario> entradas, String rutaArchivo) {
        BufferedWriter writerInv = null;
        try {
            writerInv = new BufferedWriter(new FileWriter(rutaArchivo, false));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < entradas.size(); i++) {
            try {

                writerInv.write(entradas.get(i).getNombre() + " " + entradas.get(i).getEdad() + " " + entradas.get(i).getDocumento());
                writerInv.newLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {
            writerInv.close();
        } catch (IOException ex) {

        }

    }

    public static void escribirArchivopeli(ArrayList<Pelicula> entradas, String rutaArchivo) {
        BufferedWriter writerInv = null;
        try {
            writerInv = new BufferedWriter(new FileWriter(rutaArchivo, false));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < entradas.size(); i++) {
            try {

                writerInv.write(entradas.get(i).getTitulo() + " " + entradas.get(i).getDuracion() + " " + entradas.get(i).getEdadMinima());
                writerInv.newLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {
            writerInv.close();
        } catch (IOException ex) {

        }

    }

    public static ArrayList<Usuario> leerArchivo(String filePath) throws FileNotFoundException {

        Scanner s = new Scanner(new File(filePath));
        ArrayList<Usuario> data = new ArrayList<>();
        String Name_provicional = "";
        int edad_provicional = 0, id_provicional = 0;

        while (s.hasNextLine()) {
            Name_provicional = s.next();
            edad_provicional = s.nextInt();
            id_provicional = s.nextInt();

            data.add(new Usuario(Name_provicional, id_provicional, id_provicional));
        }
        s.close();

        return data;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        ArrayList<Usuario> arreglo_empleados = new ArrayList<>();
        ArrayList<Usuario> arreglo_clientes = new ArrayList<>();
        ArrayList<Pelicula> arreglo_peliculas = new ArrayList<>();
        ArrayList<Cliente> clientesConAsiento = new ArrayList<>();
        
        

        Sala[] salas = new Sala[3];
        for (int i = 0; i < 3; i++) {
            salas[i] = new Sala(i + 1);
        }
        Date fecha = new Date(2019, 9, 30);
        int hora = 8;

        String ruta_clientes = "clientes.txt";
        String ruta_empleados = "empleados.txt";
        String ruta_peliculas = "peliculas.txt";
        /*
        arreglo_clientes = leerArchivo(ruta_clientes);
        arreglo_empleados = leerArchivo(ruta_empleados);
        //arreglo_peliculas= leerArchivo(ruta_peliculas);
         */
        File archivo1 = new File(ruta_clientes);
        if (!archivo1.exists()) {
            archivo1.createNewFile();
        }
        FileWriter w = new FileWriter(archivo1);
        BufferedWriter bw = new BufferedWriter(w);
        PrintWriter wr = new PrintWriter(bw);

        Scanner lecture = new Scanner(archivo1);

//Acá se hace la parte de random
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
            arreglo_clientes.add(new Cliente(name, edad, id));
            escribirArchivo(arreglo_clientes, ruta_clientes);
            name = "";
        }

        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 8; i++) {
                int el = (int) (Math.random() * 12);
                nombre[i] = (char) abc[el];

                name = name + nombre[i];
                rol = Math.random() < 0.5;

                edad = (int) (Math.random() * 80);
                id = 10000000 + (int) (Math.random() * 9999999);

            }
            arreglo_empleados.add(new Empleado(name, edad, id));
            escribirArchivo(arreglo_empleados, ruta_empleados);
            name = "";
        }

        Scanner sc = new Scanner(System.in);
        boolean estado = true;

        do {
            limpiarPantalla();
            System.out.println("/////////////////////////////////////////");
            System.out.println("              Bienvenido");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1) Ingresar usuario");
            System.out.println("2) Registrar usuario");
            // System.out.println("3) Consultar usuario");
            System.out.println("3) Consultar pelicula");
            System.out.println("/////////////////////////////////////////");

            int seleccion = sc.nextInt();
            switch (seleccion) {

                case 1:
                    boolean valido = false;
                    boolean rolPrueba = false;
                    Thread.sleep(1000);
                    limpiarPantalla();

                    System.out.println("Ingrese su documento");
                    int id_prueba = sc.nextInt();
                    for (int i = 0; i < arreglo_empleados.size(); i++) {
                        if (id_prueba == arreglo_empleados.get(i).getDocumento()) {
                            valido = true;
                            rolPrueba = true;
                            break;
                        }
                    }
                    if (!valido) {
                        for (int i = 0; i < arreglo_clientes.size(); i++) {
                            if (id_prueba == arreglo_clientes.get(i).getDocumento()) {
                                valido = true;
                                rolPrueba = false;
                                break;
                            }
                        }
                    }
                    if(!valido){
                        System.out.println("Usuario no encontrado");
                        Thread.sleep(3000);
                    }
                    if (valido) {
                        if (rolPrueba) {
                            boolean seguirMenuEmpleado = true;
                            do {
                                Thread.sleep(1000);
                                limpiarPantalla();
                                System.out.println("Bienvenido, señor(a) empleado/a. Seleccione la acción a realizar");
                                System.out.println("1. Actualizar fecha");
                                System.out.println("2. Actualizar hora");
                                System.out.println("3. Actualizar peliculas");
                                System.out.println("4. Terminar sesión");
                                int selEmpleado = sc.nextInt();
                                switch (selEmpleado) {
                                    case 1:
                                        Thread.sleep(1000);
                                        limpiarPantalla();
                                        System.out.print("Día: ");
                                        int nuevoDia = sc.nextInt();
                                        System.out.print("Mes: ");
                                        int nuevoMes = sc.nextInt();
                                        System.out.print("Año: ");
                                        int nuevoAno = sc.nextInt();
                                        fecha = new Date(nuevoAno, nuevoMes, nuevoDia);
                                        break;
                                    case 2:
                                        Thread.sleep(1000);
                                        limpiarPantalla();
                                        System.out.print("Hora: ");
                                        int nuevaHora = sc.nextInt();
                                        hora = nuevaHora;
                                        break;
                                    case 3:
                                        boolean seguirActualizandoPelicula = true;
                                        do {
                                            Thread.sleep(1000);
                                            limpiarPantalla();
                                            System.out.println("Seleccione accion");
                                            System.out.println("1. Agregar pelicula");
                                            System.out.println("2. Agregar horario");
                                            System.out.println("3. Regresar");
                                            int selPelicula = sc.nextInt();
                                            switch (selPelicula) {
                                                case 1:
                                                    boolean seguirAgregandoPelicula = true;
                                                    do {
                                                        Thread.sleep(1000);
                                                        limpiarPantalla();
                                                        System.out.print("Ingrese título: ");
                                                        String titulo = sc.next();
                                                        System.out.print("Ingrese duracion en horas (no superior a 3): ");
                                                        int duracion = sc.nextInt();
                                                        System.out.print("Ingrese edad mínima: ");
                                                        int edadMinima = sc.nextInt();
                                                        arreglo_peliculas.add(new Pelicula(titulo, duracion, edadMinima));
                                                        escribirArchivopeli(arreglo_peliculas, ruta_peliculas);
                                                        System.out.println("Película agregada satisfactoriamente");
                                                        Thread.sleep(2000);
                                                        limpiarPantalla();
                                                        System.out.println("1. Agregar otra película");
                                                        System.out.println("2. Regresar");
                                                        int selAgregarMasPeliculas = sc.nextInt();
                                                        if (selAgregarMasPeliculas == 2) {
                                                            seguirAgregandoPelicula = false;
                                                        }
                                                    } while (seguirAgregandoPelicula);
                                                    break;
                                                case 2:
                                                    boolean seguirAgregandoHorario = true;
                                                    do {
                                                        Thread.sleep(1000);
                                                        limpiarPantalla();
                                                        if (arreglo_peliculas.isEmpty()) {
                                                            System.out.println("No hay películas en cartelera");
                                                            Thread.sleep(3000);
                                                            seguirAgregandoHorario = false;
                                                        } else {
                                                            System.out.println("Seleccione película");
                                                            for (int i = 0; i < arreglo_peliculas.size(); i++) {
                                                                System.out.println((i + 1) + ". " + arreglo_peliculas.get(i).getTitulo());
                                                            }
                                                            int indicePelicula = sc.nextInt() - 1;
                                                            System.out.println("Ingrese hora (entre las 9 y las 21)");
                                                            int horaPelicula = sc.nextInt();
                                                            Funcion funcAux = new Funcion(arreglo_peliculas.get(indicePelicula), fecha, horaPelicula, elegirSala(salas, horaPelicula));
                                                            if (funcAux.getSala() == null) {
                                                                System.out.println("No hay salas disponibles");
                                                            } else {
                                                                arreglo_peliculas.get(indicePelicula).addFuncion(funcAux);
                                                                System.out.println("Horario agregado satisfactoriamente");
                                                            }
                                                            Thread.sleep(2000);
                                                            limpiarPantalla();
                                                            System.out.println("1. Agregar otro horario");
                                                            System.out.println("2. Regresar");
                                                            int selAgregarMasHorarios = sc.nextInt();
                                                            if (selAgregarMasHorarios == 2) {
                                                                seguirAgregandoHorario = false;
                                                            }
                                                        }
                                                    } while (seguirAgregandoHorario);
                                                    break;
                                                case 3:
                                                    seguirActualizandoPelicula = false;
                                                    break;
                                                default:
                                                    System.out.println("Dato incorrecto");
                                                    break;
                                            }
                                        } while (seguirActualizandoPelicula);
                                        break;
                                    case 4:
                                        seguirMenuEmpleado = false;
                                        break;
                                    default:
                                        System.out.println("Dato incorrecto");
                                        break;
                                }
                            } while (seguirMenuEmpleado);
                        } else {
                            boolean seguirSelPelicula = false;
                            do{
                            System.out.println("Bienvenido, señor(a) cliente. Por favor seleccione la película que desea ver.");
                            for (int i = 0; i < arreglo_peliculas.size(); i++) {
                                System.out.println((i + 1) + ") " + arreglo_peliculas.get(i).getTitulo());
                            }
                            int sel = 0;
                            boolean peliculaExists = true;
                            do{
                                peliculaExists = true;
                                sel = sc.nextInt()-1;
                                if(sel>=arreglo_peliculas.size()){
                                    System.out.println("Dato incorrecto");
                                    peliculaExists = false;
                                }
                            }while(!peliculaExists);
                            
                            

                            System.out.println("Seleccione un horario");
                            for (int i = 0; i < arreglo_peliculas.get(sel).getFunciones().size(); i++) {
                                System.out.println((i + 1) + ") " + arreglo_peliculas.get(i).getFunciones().get(i).getHora());
                            }
                            int sel2 = 0;
                            boolean horarioExists = true;
                            do{
                                horarioExists = true;
                                sel2 = sc.nextInt()-1;
                                if(sel2>=arreglo_peliculas.get(sel).getFunciones().size()){
                                    System.out.println("Dato incorrecto");
                                    horarioExists = false;
                                }
                            }while(!horarioExists);
                            Asiento[][] asientos = arreglo_peliculas.get(sel).getFunciones().get(sel2).getSala().getAsientos();
                                System.out.println("  1 2 3 4 5 6 7 ");
                            for (int i = 0; i < asientos.length; i++) {
                                System.out.print((char)(i+65)+" ");
                                for (int j = 0; j < asientos[i].length; j++) {
                                    if (asientos[i][j].isDisponibilidad() == true) {
                                        System.out.print("0 ");
                                    } else {
                                        System.out.print("x ");
                                    }
                                }
                                System.out.println("");
                            }
                                System.out.println("////PANTALLA////");
                            boolean filaCorrecta = false;
                            int fila = -1;
                            String letra = "";
                            do {
                                System.out.println("Por favor seleccione una fila(a,b,c)");
                                letra = sc.next();
                                if (letra.equals("a")) {
                                    fila = 0;
                                    filaCorrecta = true;
                                } else if (letra.equals("b")) {
                                    fila = 1;
                                    filaCorrecta = true;
                                } else if (letra.equals("c")) {
                                    fila = 2;
                                    filaCorrecta = true;
                                } else {
                                    System.out.println("Dato incorrecto");
                                }
                            } while (!filaCorrecta);
                            boolean asientoDisponible = false;
                            int col = 0;
                            do {
                                System.out.println("Por favor seleccione una columna (1 a 7)");
                                col = sc.nextInt() - 1;

                                if (asientos[fila][col].isDisponibilidad()) {
                                    asientoDisponible = true;
                                }else if(col>6){
                                    System.out.println("El asiento no existe");
                                }else {
                                    System.out.println("El asiento está ocupado.");
                                }
                            } while (!asientoDisponible);
                            Asiento asientoAux = new Asiento(letra.charAt(0), col, false);
                            
                            Thread.sleep(1000);
                            limpiarPantalla();
                            System.out.println("Por favor, confirme su selección (si/no).");
                            System.out.println("Película: " + arreglo_peliculas.get(sel).getTitulo());
                            System.out.println("Hora: " + arreglo_peliculas.get(sel).getFunciones().get(sel2).getHora());
                            System.out.println("Asiento: " + letra + (col+1));
                            System.out.println("Sala: " + arreglo_peliculas.get(sel).getFunciones().get(sel2).getSala().getNumSala());
                            String confirmacion = sc.next();
                            if(confirmacion.equals("no")){
                                seguirSelPelicula = true;
                            }else{
                                for (int i = 0; i < arreglo_clientes.size(); i++) {
                                    if(id_prueba == arreglo_clientes.get(i).getDocumento()){
                                        clientesConAsiento.add(new Cliente(arreglo_clientes.get(i).getNombre(),arreglo_clientes.get(i).getEdad(),arreglo_clientes.get(i).getDocumento()));
                                        clientesConAsiento.get(clientesConAsiento.size()-1).setAsiento(asientoAux);
                                        clientesConAsiento.get(clientesConAsiento.size()-1).setFuncion(arreglo_peliculas.get(sel).getFunciones().get(sel2));                                          
                                    }
                                }
                                seguirSelPelicula = false;
                                System.out.println("Compra exitosa.");
                                Thread.sleep(1000);
                            }
                            }while(seguirSelPelicula);
                        }
                    }
                    break;

                case 2:
                    limpiarPantalla();
                    System.out.println("Ingrese nombre (sin espacios)");
                    String nombre_dinamico = sc.next();
                    System.out.println("Ingrese edad");
                    int edad_dinamico = sc.nextInt();
                    System.out.println("Ingrese documento");
                    int id_dinamico = sc.nextInt();
                    System.out.println("¿Es usted empleado? (si o no)");
                    String rol_dinamico = sc.next();

                    if (rol_dinamico.equals("si")) {
                        System.out.println("Ingrese clave (dada por la empresa)");
                        // La clave por defecto es 0000
                        String clave_dinamico = sc.next();

                        if (clave_dinamico.equals("0000")) {

                            arreglo_empleados.add(new Empleado(nombre_dinamico, edad_dinamico, id_dinamico));
                            escribirArchivo(arreglo_empleados, ruta_empleados);

                            System.out.println("Registrado con éxito");
                            Thread.sleep(2000);
                            limpiarPantalla();
                        } else {
                            System.out.println("Clave incorrecta");
                            Thread.sleep(2000);
                            limpiarPantalla();
                        }

                    } else {

                        arreglo_clientes.add(new Cliente(nombre_dinamico, edad_dinamico, id_dinamico));
                        escribirArchivo(arreglo_clientes, ruta_clientes);

                        System.out.println("Registrado con éxito");
                        Thread.sleep(2000);
                        limpiarPantalla();

                    }

                    break;
                case 3:
                    Thread.sleep(2000);
                    limpiarPantalla();
                    break;
            }

        } while (estado == true);

    }
}
