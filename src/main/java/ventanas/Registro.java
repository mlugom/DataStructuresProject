/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Esta es la versión de la entrega intermedia. Se implementan colas, pilas,
//arreglos dinámicos propios y arboles, así como una primera interfaz gráfica
package ventanas;

import clases.*;
import java.awt.Robot;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import estructuras.*;

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

    

    public static void escribirArchivo(ArbolUsuarios entradas, String rutaArchivo) throws IOException {
        BufferedWriter writerInv = null;
        try {
            writerInv = new BufferedWriter(new FileWriter(rutaArchivo, false));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        /*for (int i = 0; i < entradas.size(); i++) {
            try {

                writerInv.write(entradas.get(i).getNombre() + " " + entradas.get(i).getEdad() + " " + entradas.get(i).getDocumento());
                writerInv.newLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }*/
        
        entradas.read(writerInv);

        try {
            writerInv.close();
        } catch (IOException ex) {

        }

    }

    public static void escribirArchivopeli(HeapDouble entradas, String rutaArchivo) {
        BufferedWriter writerInv = null;
        try {
            writerInv = new BufferedWriter(new FileWriter(rutaArchivo, false));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (int i = 1; i <= entradas.size(); i++) {
            try {

                writerInv.write(entradas.getArreglo().get(i).getTitulo() + " " + entradas.getArreglo().get(i).getDuracion() + " " + entradas.getArreglo().get(i).getEdadMinima() + " " + entradas.getArreglo().get(i).getPuntuacion());
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

      public static ArbolUsuarios leerArchivo(String filePath) throws FileNotFoundException {

        File prueba = new File(filePath);
        Scanner s = new Scanner(prueba);
        ArbolUsuarios data = new ArbolUsuarios();
        String Name_provicional = "";
        int edad_provicional = 0, id_provicional = 0;

        while(s.hasNext()) {

            Name_provicional = s.next();

            edad_provicional = Integer.parseInt(s.next());

            id_provicional = Integer.parseInt(s.next());
            data.insert(new Usuario(Name_provicional, id_provicional, id_provicional));
        }
        s.close();

        return data;
    }

    public static HeapDouble leerArchivopel(String filePath) throws FileNotFoundException {

        Scanner s = new Scanner(new File(filePath));
        HeapDouble data = new HeapDouble();
        String Name_provicional = "";
        int duracion_provicional = 0, edadM_provicional = 0;
        double puntuacion_provicional = 0;

        
        while(s.hasNext()) {
            Name_provicional = s.next();
            duracion_provicional = Integer.parseInt(s.next());
            edadM_provicional = Integer.parseInt(s.next());
            puntuacion_provicional = Double.parseDouble(s.next());
            data.insert(new Pelicula(Name_provicional, duracion_provicional, edadM_provicional,puntuacion_provicional));
        }
        s.close();

        return data;
    }
    //Farid Está trabajando en esta función
    /*
        public static ArrayList<Pelicula> leerArchivopel(String filePath) throws FileNotFoundException {

        Scanner s = new Scanner(new File(filePath));
        ArrayList<Pelicula> data = new ArrayList<>();
        String Name_provicional = "";
        int duracion_provicional = 0, edadM_provicional = 0;
        int numeroFunciones=0;
        int[] funciones= new int[numeroFunciones];

        
        while(s.hasNext()) {
            Name_provicional = s.next();
            duracion_provicional = Integer.parseInt(s.next());
            edadM_provicional = Integer.parseInt(s.next());
            numeroFunciones=Integer.parseInt(s.next());
            for (int i = 0; i < numeroFunciones; i++) {
             funciones[i]=Integer.parseInt(s.next());   
            }
        //    data.add(new Pelicula(Name_provicional, duracion_provicional, edadM_provicional,numeroFunciones,funciones));
            data.add(new Pelicula(Name_provicional, duracion_provicional, edadM_provicional));
        }
        s.close();

        return data;
    }
    */

    public static void main(String[] args) throws IOException, InterruptedException {

        HeapDouble arreglo_peliculas = new HeapDouble();
        ArbolUsuarios clientesConAsiento = new ArbolUsuarios();
        ArbolUsuarios arbolClientes = new ArbolUsuarios();
        ArbolUsuarios arbolEmpleados = new ArbolUsuarios();
        
        int contadorSala = 0;
        
        

        Sala[] salas = new Sala[3];
        for (int i = 1; i <= 3; i++) {
            salas[i-1] = new Sala(i);
        }
        Fecha fecha = new Fecha(10,11,2019);
        int hora = 6;

        String ruta_clientes = "clientes.txt";
        String ruta_empleados = "empleados.txt";
        String ruta_peliculas = "peliculas.txt";
     
        ////Acá leemos la base de datos 
        // Y sobreescribimos
        
        arbolClientes = leerArchivo(ruta_clientes);
        
        escribirArchivo(arbolClientes, ruta_clientes);
       
        arbolEmpleados = leerArchivo(ruta_empleados);
        
        escribirArchivo(arbolEmpleados, ruta_empleados);
         
        arreglo_peliculas = leerArchivopel(ruta_peliculas);
        escribirArchivopeli(arreglo_peliculas, ruta_peliculas);
        
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
//
//Acá se comenta y se descomenta (solo necesario la primera vez)
//
        /*
        
//Agregamos clientes
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 8; i++) {
                int el = (int) (Math.random() * 12);
                nombre[i] = (char) abc[el];

                name = name + nombre[i];
            }
            rol = Math.random() < 0.5;

            edad = (int) (Math.random() * 80);
            id = 10000000 + (int) (Math.random() * 9999999);

            arbolClientes.insert(new Cliente(name, edad, id));
            escribirArchivo(arbolClientes, ruta_clientes);
            name = "";
        }
//Agregamos empleados
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 8; i++) {
                int el = (int) (Math.random() * 12);
                nombre[i] = (char) abc[el];

                name = name + nombre[i];
            }
            rol = Math.random() < 0.5;

            edad = (int) (Math.random() * 80);
            id = 10000000 + (int) (Math.random() * 9999999);

            arbolEmpleados.insert(new Empleado(name, edad, id));
            escribirArchivo(arbolEmpleados, ruta_empleados);
            name = "";
        }
//Agregamos peliculas    
        String Tit = "";
        int duration = 0, edadMin = 0;
        double puntuacion = 0;

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 8; i++) {
                int l = (int) (Math.random() * 12);
                 nombre[i] = (char) abc[l];

                Tit = Tit + nombre[i];
            }
            duration = (int) (Math.random() * 3);
            edadMin = 7 + (int) (Math.random() * 11);
            puntuacion = (Math.random() * 10);

            arreglo_peliculas.insert(new Pelicula(Tit, duration, edadMin,puntuacion));
            escribirArchivopeli(arreglo_peliculas, ruta_peliculas);
            Tit = "";
        }
        */        
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
                    if(arbolEmpleados.contains(id_prueba)){
                        valido = true;
                        rolPrueba = true;
                    }
                    if (!valido) {
                        if(arbolClientes.contains(id_prueba)){
                            valido = true;
                            rolPrueba = false;
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
                                        System.out.print("La fecha de hoy es " + fecha.getDay() +"/"+ fecha.getMonth() +"/"+ fecha.getYear()+". ¿Desea actualizar? (s/n): ");
                                        String seleccionFecha = sc.next();
                                        if(seleccionFecha.equals("s")){
                                            Fecha nuevaFecha = new Fecha();
                                            if(fecha.getDay() < 28){
                                                nuevaFecha = new Fecha(fecha.getYear(),fecha.getMonth(),fecha.getDay()+1);                                                
                                            }else if(fecha.getMonth() == 1){
                                                nuevaFecha = new Fecha(fecha.getYear(),2,1);                                              
                                            }else if((fecha.getMonth() <= 6 && fecha.getMonth()%2 == 0) || (fecha.getMonth() > 6 && fecha.getMonth() < 11 && fecha.getMonth()%2 != 0)){
                                                if(fecha.getDay() < 31){
                                                    nuevaFecha = new Fecha(fecha.getYear(),fecha.getMonth(),fecha.getDay()+1);
                                                }else{
                                                    nuevaFecha = new Fecha(fecha.getYear(),fecha.getMonth()+1,1);
                                                }                              
                                            }else if((fecha.getMonth() <= 6 && fecha.getMonth()%2 != 0) || (fecha.getMonth() > 6 && fecha.getMonth() < 11 && fecha.getMonth()%2 == 0)){
                                                if(fecha.getDay() < 30){
                                                    nuevaFecha = new Fecha(fecha.getYear(),fecha.getMonth(),fecha.getDay()+1);
                                                }else{
                                                    nuevaFecha = new Fecha(fecha.getYear(),fecha.getMonth()+1,1);
                                                }
                                            }else{
                                                if(fecha.getDay() < 31){
                                                    nuevaFecha = new Fecha(fecha.getYear(),fecha.getMonth(),fecha.getDay()+1);
                                                }else{
                                                    nuevaFecha = new Fecha(fecha.getYear()+1,0,1);
                                                }
                                            }
                                            fecha = nuevaFecha;
                                            for(int i = 0; i < 3; i++){
                                                salas[i].vaciarSala();
                                            }
                                        }
                                        break;
                                    case 2:
                                        Thread.sleep(1000);
                                        limpiarPantalla();                                     
                                        System.out.print("Hora: " + hora + ". ¿Desea actualizar? (s/n) ");
                                        String seleccionHora = sc.next();                                    
                                        if(seleccionHora.equals("s")){
                                            for(int i = 0; i<3; i++){
                                                if(hora >= salas[i].getHoraFuncion()+3){
                                                    salas[i].despacharFuncion();        
                                                }
                                            }
                                            for(int i = 0; i < arreglo_peliculas.size();i++){
                                                for(int j = 0; j< arreglo_peliculas.getArreglo().get(i).getFunciones().size();i++){
                                                    if(arreglo_peliculas.getArreglo().get(i).getFunciones().get(j).getHora() == hora){
                                                        arreglo_peliculas.getArreglo().get(i).getFunciones().remove(j);
                                                    }
                                                }
                                            }
                                            if(hora < 21){
                                                hora+=3;
                                            }else{
                                                hora = 6;
                                                Fecha nuevaFecha = new Fecha();
                                                if (fecha.getDay() < 28) {
                                                    nuevaFecha = new Fecha(fecha.getYear(), fecha.getMonth(), fecha.getDay() + 1);
                                                } else if (fecha.getMonth() == 1) {
                                                    nuevaFecha = new Fecha(fecha.getYear(), 2, 1);
                                                } else if ((fecha.getMonth() <= 6 && fecha.getMonth() % 2 == 0) || (fecha.getMonth() > 6 && fecha.getMonth() < 11 && fecha.getMonth() % 2 != 0)) {
                                                    if (fecha.getDay() < 31) {
                                                        nuevaFecha = new Fecha(fecha.getYear(), fecha.getMonth(), fecha.getDay() + 1);
                                                    } else {
                                                        nuevaFecha = new Fecha(fecha.getYear(), fecha.getMonth() + 1, 1);
                                                    }
                                                } else if ((fecha.getMonth() <= 6 && fecha.getMonth() % 2 != 0) || (fecha.getMonth() > 6 && fecha.getMonth() < 11 && fecha.getMonth() % 2 == 0)) {
                                                    if (fecha.getDay() < 30) {
                                                        nuevaFecha = new Fecha(fecha.getYear(), fecha.getMonth(), fecha.getDay() + 1);
                                                    } else {
                                                        nuevaFecha = new Fecha(fecha.getYear(), fecha.getMonth() + 1, 1);
                                                    }
                                                } else {
                                                    if (fecha.getDay() < 31) {
                                                        nuevaFecha = new Fecha(fecha.getYear(), fecha.getMonth(), fecha.getDay() + 1);
                                                    } else {
                                                        nuevaFecha = new Fecha(fecha.getYear() + 1, 0, 1);
                                                    }
                                                }
                                                fecha = nuevaFecha;
                                                for (int i = 0; i < 3; i++) {
                                                    salas[i].vaciarSala();
                                                }
                                            }
                                        }
                                        break;
                                    case 3:
                                        boolean seguirActualizandoPelicula = true;
                                        do {
                                            Thread.sleep(1000);
                                            limpiarPantalla();
                                            System.out.println("Seleccione accion");
                                            System.out.println("1. Agregar pelicula");
                                            System.out.println("2. Asignar función");
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
                                                        System.out.print("Ingrese puntuación promedio de la película: ");
                                                        double puntuacion = sc.nextDouble();
                                                        arreglo_peliculas.insert(new Pelicula(titulo, duracion, edadMinima, puntuacion));
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
                                                    if (hora == 6) {
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
                                                                for (int i = 1; i <= arreglo_peliculas.size(); i++) {
                                                                    System.out.println(i + ". " + arreglo_peliculas.getArreglo().get(i).getTitulo() + ". Puntuación: " + arreglo_peliculas.getArreglo().get(i).getPuntuacion());
                                                                }
                                                                int indicePelicula = sc.nextInt();                                             
                                                                
                                                                Funcion funcAux = new Funcion(arreglo_peliculas.getArreglo().get(indicePelicula), fecha, salas[contadorSala].getHoraFuncion(), salas[contadorSala]);
                                                                salas[contadorSala].addFuncion(arreglo_peliculas.getArreglo().get(indicePelicula), fecha);
                                                                if(contadorSala < 2){
                                                                    contadorSala++;
                                                                }else{
                                                                    contadorSala = 0;
                                                                }
                                                                arreglo_peliculas.getArreglo().get(indicePelicula).addFuncion(funcAux);
                                                                System.out.println("La película quedó para las " + funcAux.getHora() + " en la sala " + (funcAux.getSala().getNumSala()) + ".");

                                                                Thread.sleep(2000);
                                                                limpiarPantalla();
                                                                System.out.println("1. Asignar otra función");
                                                                System.out.println("2. Regresar");
                                                                int selAgregarMasHorarios = sc.nextInt();
                                                                if (selAgregarMasHorarios == 2) {
                                                                    seguirAgregandoHorario = false;
                                                                }
                                                            }
                                                        } while (seguirAgregandoHorario);
                                                    } else {
                                                        System.out.println("Sólo se pueden asignar funciones a las 6.");
                                                        Thread.sleep(3000);
                                                        limpiarPantalla();
                                                    }
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
                            for (int i = 1; i <= arreglo_peliculas.size(); i++) {
                                System.out.println(i + ") " + arreglo_peliculas.getArreglo().get(i).getTitulo() + ". Puntuación: " + arreglo_peliculas.getArreglo().get(i).getPuntuacion());
                            }
                            int sel = 0;
                            boolean peliculaExists = true;
                            do{
                                peliculaExists = true;
                                sel = sc.nextInt();
                                if(sel>=arreglo_peliculas.size()){
                                    System.out.println("Dato incorrecto");
                                    peliculaExists = false;
                                }
                            }while(!peliculaExists);
                            
                            

                                System.out.println("Seleccione un horario");
                                if (arreglo_peliculas.getArreglo().get(sel).getFunciones().size() == 0) {
                                    System.out.println("No hay horarios disponibles");
                                    seguirSelPelicula = false;
                                    Thread.sleep(1000);
                                } else {
                                    for (int i = 0; i < arreglo_peliculas.getArreglo().get(sel).getFunciones().size(); i++) {
                                        System.out.println((i + 1) + ") " + arreglo_peliculas.getArreglo().get(sel).getFunciones().get(i).getHora());
                                    }
                                    int sel2 = 0;
                                    boolean horarioExists = true;
                                    do {
                                        horarioExists = true;
                                        sel2 = sc.nextInt() - 1;
                                        if (sel2 >= arreglo_peliculas.getArreglo().get(sel).getFunciones().size()) {
                                            System.out.println("Dato incorrecto");
                                            horarioExists = false;
                                        }
                                    } while (!horarioExists);
                                    Asiento[][] asientos = arreglo_peliculas.getArreglo().get(sel).getFunciones().get(sel2).getAsientos();
                                    System.out.println("  1 2 3 4 5 6 7 ");
                                    for (int i = 0; i < asientos.length; i++) {
                                        System.out.print((char) (i + 65) + " ");
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
                                        } else if (col > 6) {
                                            System.out.println("El asiento no existe");
                                        } else {
                                            System.out.println("El asiento está ocupado.");
                                        }
                                    } while (!asientoDisponible);
                                    Asiento asientoAux = new Asiento(letra.charAt(0), col, false);                                    

                                    Thread.sleep(1000);
                                    limpiarPantalla();
                                    System.out.println("Por favor, confirme su selección (si/no).");
                                    System.out.println("Película: " + arreglo_peliculas.getArreglo().get(sel).getTitulo());
                                    System.out.println("Hora: " + arreglo_peliculas.getArreglo().get(sel).getFunciones().get(sel2).getHora());
                                    System.out.println("Asiento: " + letra + (col + 1));
                                    System.out.println("Sala: " + arreglo_peliculas.getArreglo().get(sel).getFunciones().get(sel2).getSala().getNumSala());
                                    String confirmacion = sc.next();
                                    if (confirmacion.equals("no")) {
                                        seguirSelPelicula = true;
                                    } else {

                                        if (arbolClientes.contains(id_prueba)) {
                                            Cliente clienteAux = new Cliente(arbolClientes.find(id_prueba).getNombre(), arbolClientes.find(id_prueba).getEdad(), arbolClientes.find(id_prueba).getDocumento());
                                            clienteAux.setAsiento(asientoAux);
                                            clienteAux.setFuncion(arreglo_peliculas.getArreglo().get(sel).getFunciones().get(sel2));
                                            clientesConAsiento.insert(clienteAux);
                                            arreglo_peliculas.getArreglo().get(sel).getFunciones().get(sel2).ocuparAsiento(fila, col);
                                        }

                                        seguirSelPelicula = false;
                                        System.out.println("Compra exitosa.");
                                        Thread.sleep(1000);
                                    }
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
                            Empleado empleadoAux = new Empleado(nombre_dinamico, edad_dinamico, id_dinamico);
                            arbolEmpleados.insert(empleadoAux);
                            escribirArchivo(arbolEmpleados, ruta_empleados);

                            System.out.println("Registrado con éxito");
                            Thread.sleep(2000);
                            limpiarPantalla();
                        } else {
                            System.out.println("Clave incorrecta");
                            Thread.sleep(2000);
                            limpiarPantalla();
                        }

                    } else {
                        Cliente clienteAux = new Cliente(nombre_dinamico, edad_dinamico, id_dinamico);
                        arbolClientes.insert(clienteAux);
                        escribirArchivo(arbolClientes, ruta_clientes);

                        System.out.println("Registrado con éxito");
                        Thread.sleep(2000);
                        limpiarPantalla();

                    }

                    break;
                case 3:
                  limpiarPantalla();
                    
                    if (arreglo_peliculas.size() != 0) {
                        for (int i = 1; i <= arreglo_peliculas.size(); i++) {
                            System.out.println((i + 1) + ") " + arreglo_peliculas.getArreglo().get(i).getTitulo() + " ..... Duración: " + arreglo_peliculas.getArreglo().get(i).getDuracion() + " horas ....."
                                    + " Edad Minima: " + arreglo_peliculas.getArreglo().get(i).getEdadMinima() + " ..... Puntuación: " + arreglo_peliculas.getArreglo().get(i).getPuntuacion());
                        }

                        System.out.println("");
                        System.out.println("¿Qué película desea consultar?");
                        int numPel = sc.nextInt();

                        limpiarPantalla();
                        System.out.println("                                " + arreglo_peliculas.getArreglo().get(numPel - 1).getTitulo());
                        System.out.println("");

                        if (arreglo_peliculas.getArreglo().get(numPel - 1).getFunciones().size() != 0) {
                            System.out.println("Horarios:");
                            for (int i = 0; i < arreglo_peliculas.getArreglo().get(numPel - 1).getFunciones().size(); i++) {
                                System.out.println((i+1) + ") " + arreglo_peliculas.getArreglo().get(numPel - 1).getFunciones().get(i).getHora());
                            }
                        } else {
                            System.out.println("No hay horarios disponibles.");
                        }
                        System.out.println("Escriba un caracter para continuar");
                        sc.next();
                    } else {
                        System.out.println("No hay películas en cartelera.");
                    }
                    break;
                default:
                    
                    
            }

        } while (estado == true);

    }
}
