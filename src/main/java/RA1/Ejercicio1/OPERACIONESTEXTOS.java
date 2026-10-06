package RA1.Ejercicio1;

import java.io.*;

public class OPERACIONESTEXTOS {

    public static void infoFichero(String rutaFichero, String rutaDirectorio) {
        File f1 = new File(rutaFichero);
        File dir = new File(rutaDirectorio);
        if (f1.exists()) {
            System.out.println("Nombre del fichero  : " + f1.getName());
            System.out.println("Ruta                : " + f1.getPath());
            System.out.println("Ruta absoluta       : " + f1.getAbsolutePath());
            System.out.println("Se puede escribir   : " + f1.canRead());
            System.out.println("Se puede leer       : " + f1.canWrite());
            System.out.println("Tamaño              : " + f1.length());
            System.out.println("Es un directorio    : " + f1.isDirectory());
            System.out.println("Es un fichero       : " + f1.isFile());
        } else {
            System.err.println("El fichero no existe");
        }
        if (dir.isDirectory()) {
            File[] contenido = dir.listFiles();
            if (contenido != null) {
                for (int i = 0; i < contenido.length; i++) {
                    System.out.println(contenido[i].getName());
                }
            }
        } else {
            System.err.println("El directorio no existe o no es un directorio");
        }
    }

    public static void crearFicheroDirectorio(String rutaDirectorio, String nombreArchivo, String nombreDirectorio) {
        File dir = new File(rutaDirectorio);
        if (!dir.exists()) {
            System.err.println("El directorio no existe");
            return;
        }
        if (!dir.isDirectory()) {
            System.err.println("La ruta no es un directorio");
            return;
        }
        File nuevoDir = new File(dir, nombreDirectorio);
        if (nuevoDir.mkdir()) {
            System.out.println("Directorio creado: " + nuevoDir.getAbsolutePath());
        } else {
            System.err.println("No se pudo crear el directorio o ya existe");
        }
        File f1 = new File(dir, nombreArchivo);
        try {
            if (f1.createNewFile()) {
                System.out.println("Fichero creado: " + f1.getAbsolutePath());
            } else {
                System.err.println("El fichero ya existe");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el fichero: " + e.getMessage());
        }
    }

    public static void leerCaracteres(String rutaFichero) {
        int contador = 0;
        try (Reader lector = new FileReader(rutaFichero)) {
            int valorUnicode;
            while ((valorUnicode = lector.read()) != -1) {
                System.out.println("Valor Unicode: " + valorUnicode + " | Carácter: " + (char) valorUnicode);
                contador++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el fichero: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
        System.out.println("Número de caracteres: " + contador);
    }

    public static void leerLineas(String rutaFichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                System.out.println("Línea " + (contador + 1) + ": " + linea);
                contador++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el fichero: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    public static void leerLineasPares(String rutaFichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                if ((contador + 1) % 2 == 0) {
                    System.out.println("Línea " + (contador + 1) + ": " + linea);
                }
                contador++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el fichero: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    public static void escribirFichero(String rutaFichero, String[] lineas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFichero))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

    public static void escribirLineasImpares(String rutaFichero, String[] lineas) {
        int contador = 0;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFichero))) {
            for (String linea : lineas) {
                if (linea != null) {
                    if ((contador + 1) % 2 != 0) {
                        bw.write(linea);
                        bw.newLine();
                    }
                }
                contador++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copiarFicheroConFin(String rutaOrigen, String rutaDestino) {
        try (FileReader fr = new FileReader(rutaOrigen)) {
            try (FileWriter fw = new FileWriter(rutaDestino)) {
                int c;
                while ((c = fr.read()) != -1) {
                    fw.write(c);
                }
                fw.write("\nFin del fichero");
            }
        } catch (IOException e) {
            System.err.println("Error al copiar el fichero: " + e.getMessage());
        }
    }

    public static void separarParesImpares(String rutaFichero, String rutaPares, String rutaImpares) {
        try (FileReader fr = new FileReader(rutaFichero)) {
            try (FileWriter fw = new FileWriter(rutaPares)) {
                int contador = 0;
                int c;
                while ((c = fr.read()) != -1) {
                    if ((contador + 1) % 2 == 0) {
                        fw.write(c);
                    }
                    contador++;
                }
                fw.write("\nFin PARES");
            }
        } catch (IOException e) {
            System.err.println("Error al copiar el fichero: " + e.getMessage());
        }
        try (FileReader fr = new FileReader(rutaFichero)) {
            try (FileWriter fw = new FileWriter(rutaImpares)) {
                int contador = 0;
                int c;
                while ((c = fr.read()) != -1) {
                    if ((contador + 1) % 2 != 0) {
                        fw.write(c);
                    }
                    contador++;
                }
                fw.write("\nFin IMPARES");
            }
        } catch (IOException e) {
            System.err.println("Error al copiar el fichero: " + e.getMessage());
        }
    }

    public static void buscarPalabra(String rutaFichero, String palabraBuscada) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            int contador = 0;
            boolean encontrada = false;
            String palabras[] = null;
            while ((linea = br.readLine()) != null) {
                palabras = linea.split(" ");
                for (int i = 0; i < palabras.length; i++) {
                    if (palabras[i].equals(palabraBuscada)) {
                        System.out.println("Línea " + (contador + 1) + ": " + linea);
                        encontrada = true;
                    }
                }
                contador++;
            }
            if (!encontrada) {
                System.out.println("No se ha encontrado la palabra '" + palabraBuscada + "' en el fichero.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el fichero: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    public static void copiarLineasMayores10(String rutaEntrada, String rutaSalida) {
        if (rutaEntrada == null || rutaEntrada.isBlank() || rutaSalida == null || rutaSalida.isBlank()) {
            System.err.println("Las rutas de entrada y salida no pueden estar vacías.");
            return;
        }
        File ficheroEntrada = new File(rutaEntrada);
        File ficheroSalida = new File(rutaSalida);
        if (!ficheroEntrada.exists()) {
            System.err.println("No se ha encontrado el fichero de entrada: " + ficheroEntrada.getPath());
            return;
        }
        if (!ficheroEntrada.isFile()) {
            System.err.println("La ruta de entrada no corresponde a un fichero: " + ficheroEntrada.getPath());
            return;
        }
        if (!ficheroEntrada.canRead()) {
            System.err.println("No se puede leer el fichero de entrada: " + ficheroEntrada.getPath());
            return;
        }
        if (ficheroSalida.exists() && !ficheroSalida.canWrite()) {
            System.err.println("No se puede escribir en el fichero de salida: " + ficheroSalida.getPath());
            return;
        }
        int lineasCopiadas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada)); BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroSalida))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.length() > 10) {
                    bw.write(linea);
                    bw.newLine();
                    lineasCopiadas++;
                }
            }
            System.out.println("Se han copiado " + lineasCopiadas + " líneas con más de 10 caracteres en '" + ficheroSalida.getPath() + "'.");
        } catch (FileNotFoundException e) {
            System.err.println("No se ha podido abrir alguno de los ficheros: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer o escribir los ficheros: " + e.getMessage());
        } catch (SecurityException e) {
            System.err.println("No hay permisos suficientes para acceder a los ficheros.");
        }
    }

    public static void copiarFicheros(String rutaOrigen, String rutaDestino) {
        if (rutaOrigen == null || rutaOrigen.isBlank() || rutaDestino == null || rutaDestino.isBlank()) {
            System.err.println("Las rutas de origen y destino no pueden estar vacías.");
            return;
        }
        File ficheroOrigen = new File(rutaOrigen);
        File ficheroDestino = new File(rutaDestino);
        if (!ficheroOrigen.exists()) {
            System.err.println("No se ha encontrado el fichero de origen: " + ficheroOrigen.getPath());
            return;
        }
        if (!ficheroOrigen.isFile()) {
            System.err.println("La ruta de origen no corresponde a un fichero: " + ficheroOrigen.getPath());
            return;
        }
        if (!ficheroOrigen.canRead()) {
            System.err.println("No se puede leer el fichero de origen: " + ficheroOrigen.getPath());
            return;
        }
        if (ficheroDestino.exists() && !ficheroDestino.canWrite()) {
            System.err.println("No se puede escribir en el fichero de destino: " + ficheroDestino.getPath());
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(ficheroOrigen)); BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroDestino))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Se ha copiado el contenido del fichero '" + ficheroOrigen.getPath() + "' al fichero '" + ficheroDestino.getPath() + "'.");
        } catch (FileNotFoundException e) {
            System.err.println("No se ha podido abrir alguno de los ficheros: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer o escribir los ficheros: " + e.getMessage());
        } catch (SecurityException e) {
            System.err.println("No hay permisos suficientes para acceder a los ficheros.");
        }
    }
}