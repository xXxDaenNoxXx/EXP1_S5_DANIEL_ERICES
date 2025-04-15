package exp1_s5_daniel_erices;

import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;
/**
 *@author derices
 */
public class EXP1_S5_DANIEL_ERICES {
static int filas = 4; 
static int asientos = 10;
static int precioEntrada = 10000;
static double cant1 = 0.10; //si lleva entre 2 y 5 entradas
static double cant2 = 0.15; // si lleva mas de 6 entradas
static double cantE = 0.10; // si es estudiante 
static double cantA = 0.15; // si tiene mas de 65 
/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //inicio de filas      
        boolean [] fila1 = new boolean[asientos];
        boolean [] fila2 = new boolean[asientos];
        boolean [] fila3 = new boolean[asientos];
        boolean [] fila4 = new boolean[asientos];
        boolean salir = false;
        boolean volver = false;
        
        
        System.out.println("********************************");
        System.out.println("   Bienvendio al teatro Moro");
        System.out.println("El valor de la entrada es de $10.000");
        System.out.println("********************************");
        System.out.println("********************************");
        System.out.println(":::::::Descuentos::::::");
        System.out.println("Por la compra de 2 hasta 5 entrada, tienes un 10% de descuento en el total de la compra");
        System.out.println("Por la compra de 6 o mas entradas, tienes un 15% de descuenton el total de la compra");
        System.out.println("Por ser estudiante tienes un 10% de descuento en el total de la compra");
        System.out.println("Por tener 65 o mas años, tienes un 15% de descuento en el total de la compra");
        System.out.println("********************************");
        
       
        //inicio del menu
        while (!salir){
            Scanner usuario = new Scanner(System.in);
            //opciones del menu y su selección
            System.out.println("\n********************************");
            System.out.println("Seleccione alguna de las siguientes opciones: ");
            System.out.println("1.- Comprar entradas");
            System.out.println("2.- Revisar disponibilidad de asientos");
            System.out.println("3.- Eliminar reserva");
            System.out.println("4.- Buscador de reservas");
            System.out.println("5.- Salir de la aplicacion");
            System.out.print("Ingrese la opcion: ");
            String eleccion = usuario.nextLine().trim();
            while(!eleccion.matches("[1-5]")){
                System.out.println("********************************");
                System.out.println("Debe ingresar una de las opciones validas");
                eleccion = usuario.nextLine().trim();
                System.out.println("********************************");
                }
            int eleccion1 = Integer.parseInt(eleccion);
            System.out.println("********************************\n");
            switch (eleccion1){
                
                case 1 -> {
                    //compra de entradas
                    //ingrese la edad
                    System.out.println("********************************");
                    System.out.println("Favor ingrese su edad: ");
                    String edad = usuario.nextLine().toUpperCase().trim();
                    while (!edad.matches("\\d{1,2}")){
                        System.out.println("De ingresar una edad valida, entre 1-99 años: ");
                        edad = usuario.nextLine().toUpperCase().trim();
                        System.out.println("********************************");
                    }
                    int edad1  = Integer.parseInt(edad);
                    
                    //ingrese si es estudiante
                    System.out.println("********************************");
                    System.out.println("Ingrese si es estudiante (S/N): ");
                    String estudiante = usuario.nextLine().toUpperCase().trim();
                    while(!estudiante.matches("S||N")){
                        System.out.println("Debe ingresar S o N para responder");   
                        estudiante = usuario.nextLine().toUpperCase().trim();
                        System.out.println("********************************");
                    }
                    
                    //entradas a comprar
                    System.out.println("********************************");
                    System.out.println("Ingrese cuantas entreadas desea comprar: ");
                    String entradas = usuario.nextLine().toUpperCase().trim();
                    while(!entradas.matches("\\d{1,2}")){
                        System.out.println("Favor debe ingresar un numero valido entre el 1 y 40");
                        entradas = usuario.nextLine().toUpperCase().trim();
                        System.out.println("********************************");
                    }
                    int entradas1 = Integer.parseInt(entradas);
                    
                    //Solicitud de entradas 
                    String [] filasU = new String [entradas1];
                    for (int i = 0; i < entradas1; i++) {
                        System.out.println("********************************");
                        System.out.println("Ingrese la fila a la en la cual quiere comprar la entrada " +(i + 1));
                        filasU[i] = usuario.nextLine().toUpperCase().trim();
                        while(!filasU[i].matches("[A, B, C, D]")){
                            System.out.println("Debe ingresar una fila valida, debe ser entre A - B - C - D: ");
                            filasU[i] = usuario.nextLine().toUpperCase().trim();
                            System.out.println("********************************");
                        }
                        
                    }
                    
                    //Solicitud de los asientos que desea utilizar
                    int[] asientosU = new int[entradas1];
                    for (int i = 0; i < entradas1; i++) {
                        System.out.println("Ingrese el numero de la entrada " + (i + 1) + " del asiento que desea resever en la fila " + filasU[i]);
                        while(!usuario.hasNextInt()){
                            System.out.println("debe ingresar un valor entre 1 y 10: ");
                            usuario.next();
                        }
                        asientosU[i] = usuario.nextInt();
                        while(asientosU[i] < 1 | asientosU[i] > 10){
                            System.out.println("Debe ingresar un valor valido entre el 1 al 10");
                            asientosU[i] = usuario.nextInt();
                        }
                        
                    }
                    
                    //validacion si los asientos estan disponibles
                    for (int i = 0; i < entradas1; i++) {
                        boolean[] ftemporal = null; //se crea variable temporal
                        String fila = filasU[i]; //se crea para convertir el valor asignado de la matris en una cadena de texto para trabajar
                        int asiento = asientosU[i] -1 ;//se crea para convertir el valor asignado de la matris en una cadena de texto para trabajar
                        if (fila.matches("A")){ftemporal = fila1;
                        }else if (fila.matches("B")) {ftemporal = fila2;
                        }else if (fila.matches("C")) {ftemporal = fila3;
                        }else if (fila.matches("D")) {ftemporal =fila4;
                        }else{
                              System.out.println("Debe ingresar una opcion entre A - B - C - D");  //se imprime en caso de que el valor no coincida 
                                }                                                                     
                        while (ftemporal[asiento] == true){
                            System.out.println("Este asiento ya esta reservado. Ingrese otro numero de asiento para la fila " + fila + " asiento " + (asiento + 1));
                            while(!usuario.hasNextInt()){
                                System.out.println("Debe ingresar un valor entre el 1 y el 10");
                                usuario.next();
                            }
                            asiento = usuario.nextInt() - 1;
                            usuario.nextLine();
                            while(asiento < 1 | asiento > 10){
                                System.out.println("Debe ingresar un valor entre el 1 y el 10: ");
                                asiento = usuario.nextInt() - 1;
                                usuario.nextLine();
                            }
                            if (fila.matches("A")){ftemporal = fila1;
                            }else if (fila.matches("B")) {ftemporal = fila2;
                            }else if (fila.matches("C")) {ftemporal = fila3;
                            }else if (fila.matches("D")) {ftemporal = fila4;
                                }     
                        }
                        //Reserva del asiento 
                        if (fila.matches("A")){
                            fila1[asiento] = true;
                        }else if (fila.matches("B")){
                            fila2[asiento] = true;
                        }else if (fila.matches("C")){
                            fila3[asiento] = true;
                        }else{
                            fila4[asiento] = true;
                        }
      
                    }
                    //Variables para calcular los valores finales.
                    double valor;
                    double valorf; 
                    //aplicacion de descuentos
                    if (edad1 >= 65 && estudiante.matches("S") && entradas1 >= 5){
                        valor = (precioEntrada - (precioEntrada * cantA) - (precioEntrada * cantE) - (precioEntrada * cant2));
                        valorf = valor * entradas1;
                        System.out.println(valorf);
                        Locale locale = Locale.forLanguageTag("es-CL");
                        NumberFormat nfc = NumberFormat.getCurrencyInstance(locale);
                        String resultado = nfc.format(valorf);
                        System.out.println("********************************");
                        System.out.println("El precio de la entrada base es de $10.000");
                        System.out.println("El descuento es de un 10% por ser estudiante, un 15% por ser adulto mayor y 15% por comprar 6 o mas entradas");
                        System.out.println("El total a pagar es de: " + resultado);
                        System.out.println("********************************\n");
                    }else if (edad1 >= 65 && estudiante.matches("S") && entradas1 < 5 && entradas1 >= 2){
                        valor = (precioEntrada - (precioEntrada * cantA) - (precioEntrada * cantE) - (precioEntrada * cant1));
                        valorf = valor * entradas1;
                        System.out.println(valorf);
                        Locale locale = Locale.forLanguageTag("es-CL");
                        NumberFormat nfc = NumberFormat.getCurrencyInstance(locale);
                        String resultado = nfc.format(valorf);
                        System.out.println("********************************");
                        System.out.println("El precio de la entrada base es de $10.000");
                        System.out.println("El descuento es de un 10% por ser estudiante, un 15% por ser adulto mayor y 10% por comprar entre 2 y 5 entradas");
                        System.out.println("El total a pagar es de: " + resultado);
                        System.out.println("********************************\n");
                    }else if (edad1 >= 65 && estudiante.matches("N") && entradas1 >= 5){
                        valor = (precioEntrada - (precioEntrada * cantA) - (precioEntrada * cant2));
                        valorf = valor * entradas1;
                        System.out.println(valorf);
                        Locale locale = Locale.forLanguageTag("es-CL");
                        NumberFormat nfc = NumberFormat.getCurrencyInstance(locale);
                        String resultado = nfc.format(valorf);
                        System.out.println("********************************");
                        System.out.println("El precio de la entrada base es de $10.000");
                        System.out.println("El descuento es de un 15% por ser adulto mayor y 15% por comprar 6 o mas entradas");
                        System.out.println("El total a pagar es de: " + resultado);
                        System.out.println("********************************\n");
                    }else if(edad1 >= 65 && estudiante.matches("N") && entradas1 < 5 && entradas1 >= 2){
                        valor = (precioEntrada - (precioEntrada * cantA) - (precioEntrada * cant1));
                        valorf = valor * entradas1;
                        System.out.println(valorf);
                        Locale locale = Locale.forLanguageTag("es-CL");
                        NumberFormat nfc = NumberFormat.getCurrencyInstance(locale);
                        String resultado = nfc.format(valorf);
                        System.out.println("********************************");
                        System.out.println("El precio de la entrada base es de $10.000");
                        System.out.println("El descuento es de un 15% por ser adulto mayor y 10% por comprar entre 2 y 5 entradas");
                        System.out.println("El total a pagar es de: " + resultado);
                        System.out.println("********************************\n");
                    }else if(edad1 < 65 && estudiante.matches("S") && entradas1 >= 5){
                        valor = (precioEntrada - (precioEntrada * cantE) - (precioEntrada * cant2));
                        valorf = valor * entradas1;
                        System.out.println(valorf);
                        Locale locale = Locale.forLanguageTag("es-CL");
                        NumberFormat nfc = NumberFormat.getCurrencyInstance(locale);
                        String resultado = nfc.format(valorf);
                        System.out.println("********************************");
                        System.out.println("El precio de la entrada base es de $10.000");
                        System.out.println("El descuento es de un 10% por ser estudiante y 15% por comprar 6 o mas entradas");
                        System.out.println("El total a pagar es de: " + resultado);
                        System.out.println("********************************\n");
                    }else if (edad1 < 65 && estudiante.matches("S") && entradas1 < 5 &&  entradas1 >= 2){
                        valor = (precioEntrada - (precioEntrada * cantE) - (precioEntrada * cant1));
                        valorf = valor * entradas1;
                        System.out.println(valorf);
                        Locale locale = Locale.forLanguageTag("es-CL");
                        NumberFormat nfc = NumberFormat.getCurrencyInstance(locale);
                        String resultado = nfc.format(valorf);
                        System.out.println("********************************");
                        System.out.println("El precio de la entrada base es de $10.000");
                        System.out.println("El descuento es de un 10% por ser estudiante y 10% por comprar entre 2 y 5 entradas");
                        System.out.println("El total a pagar es de: " + resultado);
                        System.out.println("********************************\n");
                    }else if (edad1 < 65 && estudiante.matches("N") && entradas1 >= 5){
                        valor = (precioEntrada - (precioEntrada * cant2));
                        valorf = valor * entradas1;
                        System.out.println(valorf);
                        Locale locale = Locale.forLanguageTag("es-CL");
                        NumberFormat nfc = NumberFormat.getCurrencyInstance(locale);
                        String resultado = nfc.format(valorf);
                        System.out.println("********************************");
                        System.out.println("El precio de la entrada base es de $10.000");
                        System.out.println("El descuento es de un 15% por comprar 6 o mas entradas");
                        System.out.println("El total a pagar es de: " + resultado);
                        System.out.println("********************************\n");
                    }else if (edad1 < 65 && estudiante.matches("N") && entradas1 < 5){
                        valor = (precioEntrada - (precioEntrada * cant1));
                        valorf = valor * entradas1;
                        System.out.println(valorf);
                        Locale locale = Locale.forLanguageTag("es-CL");
                        NumberFormat nfc = NumberFormat.getCurrencyInstance(locale);
                        String resultado = nfc.format(valorf);
                        System.out.println("********************************");
                        System.out.println("El precio de la entrada base es de $10.000");
                        System.out.println("El descuento es de un 10% por comprar entre 2 y 5 entradas");
                        System.out.println("El total a pagar es de: " + resultado);
                        System.out.println("********************************\n");
                    }else if(edad1 >= 65 && estudiante.matches("S") && entradas1 == 1){
                        valor = (precioEntrada - (precioEntrada * cantA) - (precioEntrada * cantE));
                        valorf = valor * entradas1;
                        System.out.println(valorf);
                        Locale locale = Locale.forLanguageTag("es-CL");
                        NumberFormat nfc = NumberFormat.getCurrencyInstance(locale);
                        String resultado = nfc.format(valorf);
                        System.out.println("********************************");
                        System.out.println("El precio de la entrada base es de $10.000");
                        System.out.println("El descuento es de un 10% por ser estudiante, un 15% por ser adulto mayor y 15%");
                        System.out.println("El total a pagar es de: " + resultado);
                        System.out.println("********************************\n");
                    }else if (edad1 >= 65 && estudiante.matches("N") && entradas1 == 1){
                        valor = (precioEntrada - (precioEntrada * cantA));
                        valorf = valor * entradas1;
                        System.out.println(valorf);
                        Locale locale = Locale.forLanguageTag("es-CL");
                        NumberFormat nfc = NumberFormat.getCurrencyInstance(locale);
                        String resultado = nfc.format(valorf);
                        System.out.println("********************************");
                        System.out.println("El precio de la entrada base es de $10.000");
                        System.out.println("El descuento es de un 15% por ser adulto mayor");
                        System.out.println("El total a pagar es de: " + resultado);
                        System.out.println("********************************\n");
                    }else if(edad1 < 65 && estudiante.matches("S") && entradas1 == 1){
                        valor = (precioEntrada - (precioEntrada * cantE));
                        valorf = valor * entradas1;
                        System.out.println(valorf);
                        Locale locale = Locale.forLanguageTag("es-CL");
                        NumberFormat nfc = NumberFormat.getCurrencyInstance(locale);
                        String resultado = nfc.format(valorf);
                        System.out.println("********************************");
                        System.out.println("El precio de la entrada base es de $10.000");
                        System.out.println("El descuento es de un 10% por ser estudiante.");
                        System.out.println("El total a pagar es de: " + resultado);
                        System.out.println("********************************\n");
                    }else if(edad1 < 65 && estudiante.matches("N") && entradas1 == 1){
                        valorf = precioEntrada * entradas1;
                        System.out.println(valorf);
                        Locale locale = Locale.forLanguageTag("es-CL");
                        NumberFormat nfc = NumberFormat.getCurrencyInstance(locale);
                        String resultado = nfc.format(valorf);
                        System.out.println("********************************");
                        System.out.println("El precio de la entrada base es de $10.000");
                        System.out.println("No posee descuentos por la compra de entradas");
                        System.out.println("El total a pagar es de: " + resultado);
                        System.out.println("********************************\n");
                    }                   
                    
                }
                case 2 ->{
                    //revisar la disponibilidad de asientos
                    int fila = -1;
                    while(fila !=0){
                        System.out.println("\n********************************");
                        System.out.println("Disponibilidad de los asientos: ");
                        
                        for (int i = 0; i < filas; i++) {
                            char letra = (char) ('A' + i);//para transformar el indice numerico en alfabetico
                            boolean[] ftemporal;
                            if (i == 0) ftemporal = fila1;
                            else if (i == 1) ftemporal = fila2;
                            else if (i == 2) ftemporal = fila3;
                            else ftemporal = fila4;
                            
                            System.out.println("\n****** Fila: "+ letra +" ******");
                            
                            for (int j = 0; j < asientos; j++) {
                                
                                if (ftemporal[j]== true){
                                    
                                    System.out.print((j + 1) + "-**Reservado**  ");
                                }else{
                                    System.out.print((j + 1) + "-::Disponible::  ");
                                }
                                
                            }  
                         
                        }
                        fila = 0;
                    }
                    System.out.println("\n********************************");
                }
                case 3 ->{
                    //eliminar reserva de asientos
                   while(!volver){
                       System.out.println("********************************");
                       System.out.println("    Eliminar Reserva    ");
                       System.out.println("Elegir una de las siguientes opciones");
                       System.out.println("1.- Eliminar reserva");
                       System.out.println("2.- Comprobación de los asientos");
                       System.out.println("3.- Salir");
                       String eliminacion = usuario.nextLine().toUpperCase().trim();
                       while(!eliminacion.matches("[1-3]")){
                           System.out.println("Debe ingresar un valor entre 1 y 3: ");
                           eliminacion = usuario.nextLine().toUpperCase().trim();
                           
                   }
                       int eliminacion1 = Integer.parseInt(eliminacion);
                       //inicio del menu 
                       switch (eliminacion1){
                           case 1 -> {
                               
                               //seleccion de la fila
                               System.out.println("Ingrese la fila que desea eliminar la reserva: ");
                               String filaE = usuario.nextLine().toUpperCase().trim();
                               while(!filaE.matches("[A-D]")){
                                   System.out.println("Debe ingresar un valor entre A - B - C o D");
                                   filaE = usuario.nextLine().toUpperCase().trim();
                               }
                               
                               //seleccion del asiento
                               System.out.println("Ingrese el asiento en la fila " + filaE + " que desea eliminar la reserva:  ");
                               while(!usuario.hasNextInt()){
                                   System.out.println("Debe ingresar un valor entre 1 y 10");
                                   usuario.next();
                               }
                               int asientoE = usuario.nextInt();
                               while(asientoE < 1 | asientoE >10){
                                   System.out.println("Debe ingresar un valor entre 1 y 10");
                                   asientoE = usuario.nextInt();
                                   usuario.nextLine();
                               }
                               
                               boolean[] ftemp = null;//variable auxiliar
                               int asiE = asientoE - 1;
                               //Asignación de la fila auxiliar
                               switch(filaE){
                                   case "A" ->{
                                       ftemp = fila1;
                                   }
                                   case "B" -> {
                                       ftemp = fila2;
                                   }
                                   case "C" ->{
                                       ftemp = fila3;
                                   }
                                   case "D" ->{
                                       ftemp = fila4;
                                   }
                               }
                               //se comprueba de que si el asiento esta vacio o no 
                               while(ftemp[asiE] == false){
                                   System.out.println("********************************");
                                   System.out.println("El asiento no se encuentra reservado");
                                   System.out.println("********************************");
                                   asiE = usuario.nextInt();
                                   usuario.nextLine();
                                   while(!usuario.hasNextInt()){
                                       System.out.println("********************************");
                                       System.out.println("Debe ingresar un valor entre 1 y 10");
                                       System.out.println("********************************");
                                       usuario.next();
                                   }while(asiE < 1 | asiE > 10){
                                       System.out.println("********************************");
                                       System.out.println("Debe ingresar un valor entre 1 y 10");
                                       System.out.println("********************************");
                                       asiE = usuario.nextInt() - 1;
                                       usuario.nextLine();
                                   }
                                   if (filaE.matches("A")){ftemp = fila1;
                                   }else if (filaE.matches("B")) {ftemp = fila2;
                                   }else if (filaE.matches("C")) {ftemp = fila3;
                                   }else if (filaE.matches("D")) {ftemp = fila4;
                                }
                                   
                               }
                           switch (filaE) {
                               case "A" ->{
                                   ftemp[asiE] = false;
                               }
                               case "B" ->{
                                   ftemp[asiE] = false;
                               }
                               case "C" ->{
                                   ftemp[asiE] = false;
                               }
                               case "D" ->{
                                   ftemp[asiE] = false;
                               }
                           }
                           System.out.println("********************************");
                           System.out.println("La reserva fue eliminada");
                           System.out.println("********************************");
                           }
                           case 2 ->{
                                int fila = -1;
                                while(fila !=0){
                                System.out.println("\n********************************");
                                System.out.println("Disponibilidad de los asientos: ");
                        
                                for (int i = 0; i < filas; i++) {
                                    char letra = (char) ('A' + i);//para transformar el indice numerico en alfabetico
                                    boolean[] ftemporal;
                                    if (i == 0) ftemporal = fila1;
                                    else if (i == 1) ftemporal = fila2;
                                    else if (i == 2) ftemporal = fila3;
                                    else ftemporal = fila4;
                                    System.out.println("\n****** Fila: "+ letra +" ******");
                            
                                for (int j = 0; j < asientos; j++) {
                                if (ftemporal[j]== true){
                                    System.out.print((j + 1) + "-**Reservado**  ");
                                }else{
                                    System.out.print((j + 1) + "-::Disponible::  ");
                                }
                            } 
                        }
                        fila = 0;
                    }
                    System.out.println("********************************");
                
                           }
                           case 3 ->{
                               System.out.println("********************************");
                               System.out.println("Usted volvera al menu principal");
                               System.out.println("********************************");
                               volver = true;   
                           }
                       }
                           
                    }

                }
                case 4 ->{
                    System.out.println("********************************");
                    System.out.println("Buscador de reservas");
                    System.out.print("Ingrese la fila (A, B, C o D): ");
                    String buscarE = usuario.nextLine().toUpperCase().trim();

                    while (!buscarE.matches("[A-D]")) {
                        System.out.println("Debe ingresar un valor entre A - B - C o D");
                        buscarE = usuario.nextLine().toUpperCase().trim();
                    }

                    System.out.print("Ingrese el número de asiento (1 al 10) en la fila " + buscarE + ": ");
                    while (!usuario.hasNextInt()) {
                        System.out.println("Debe ingresar un valor entre 1 y 10");
                        usuario.next();
                    }

                    int buscarA = usuario.nextInt();
                    usuario.nextLine(); 

                    while (buscarA < 1 || buscarA > 10) {
                        System.out.println("Debe ingresar un valor entre 1 y 10");
                        buscarA = usuario.nextInt();
                        usuario.nextLine(); 
                    }

                    // Selecciona la fila correspondiente
                    boolean[] ftemp = switch (buscarE) {
                    case "A" -> fila1;
                    case "B" -> fila2;
                    case "C" -> fila3;
                    case "D" -> fila4;
                    default -> null;
                         };

                    // Verificamos estado del asiento
                    if (ftemp != null) {
                    boolean estado = ftemp[buscarA - 1];
                    if (estado) {
                        System.out.println("********************************");
                        System.out.println("La funcion para las 20:00 hrs de Chungking Express");
                        System.out.println("El asiento " + buscarA + " en la fila " + buscarE + " está **RESERVADO**.");
                        System.out.println("********************************");
                    } else {
                        System.out.println("********************************");
                        System.out.println("La funcion para las 20:00 hrs de Chungking Express");
                        System.out.println("El asiento " + buscarA + " en la fila " + buscarE + " está **DISPONIBLE**.");
                        System.out.println("********************************");
                     }
                            }

                }        
                case 5 ->{
                    //Cierre del sistema
                    System.out.println("Muchas gracias por su compra");
                    System.out.println("Que tenga una excelente funcion!!");
                    salir = true;
                }
                
            }
            
            
        }
        
    }
    
    
}