package RA1.Ejercicio6;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class OperacionesXML {

    private static String getNodo(String etiqueta, Element elem) {
        NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes(); // Obtiene los nodos hijos de la etiqueta solicitada
        Node valornodo = (Node) nodo.item(0); // Selecciona el nodo que contiene el texto
        return valornodo.getNodeValue(); // Devuelve el valor almacenado dentro de la etiqueta
    }

    public void listarDepartamentos(String nombrefichero) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Crea la fábrica para construir documentos XML
        try {
            DocumentBuilder builder = factory.newDocumentBuilder(); // Prepara el analizador del documento
            Document document = builder.parse(new File(nombrefichero)); // Carga el fichero XML en memoria
            document.getDocumentElement().normalize(); // Normaliza la estructura del documento
            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName()); // Muestra el nombre de la raíz
            NodeList departamentos = document.getElementsByTagName("departamento"); // Obtiene todos los departamentos
            for (int i = 0; i < departamentos.getLength(); i++) { // Recorre cada departamento encontrado
                Node departamento = departamentos.item(i); // Obtiene el departamento actual
                if (departamento.getNodeType() == Node.ELEMENT_NODE) { // Comprueba que el nodo sea un elemento XML
                    Element elemento = (Element) departamento; // Convierte el nodo a Element para acceder a sus datos
                    System.out.println("Numero: " + getNodo("numero", elemento)); // Muestra el número del departamento
                    System.out.println("Nombre: " + getNodo("nombre", elemento)); // Muestra el nombre del departamento
                    System.out.println("Localidad: " + getNodo("localidad", elemento)); // Muestra la localidad del departamento
                    System.out.println("----------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarPorLocalidad(String nombrefichero) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Crea la fábrica de documentos XML
        try {
            DocumentBuilder builder = factory.newDocumentBuilder(); // Crea el analizador XML
            Document document = builder.parse(new File(nombrefichero)); // Lee el fichero indicado
            document.getDocumentElement().normalize(); // Ordena y normaliza los nodos del documento
            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName()); // Muestra la raíz del XML
            NodeList departamentos = document.getElementsByTagName("departamento"); // Busca todos los departamentos
            for (int i = 0; i < departamentos.getLength(); i++) { // Recorre la lista de departamentos
                Node departamento = departamentos.item(i); // Obtiene el nodo de la posición actual
                if (departamento.getNodeType() == Node.ELEMENT_NODE) { // Verifica que sea un elemento válido
                    Element elemento = (Element) departamento; // Convierte el nodo en un elemento
                    if (getNodo("localidad", elemento).equalsIgnoreCase("Guadalajara")) { // Filtra los departamentos de Guadalajara
                        System.out.println("Numero: " + getNodo("numero", elemento));
                        System.out.println("Nombre: " + getNodo("nombre", elemento));
                        System.out.println("Localidad: " + getNodo("localidad", elemento));
                        System.out.println("----------------------------");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarNumeroMayor(String nombrefichero) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Crea la fábrica para leer XML
        try {
            int numero = 0; // Guarda el número de departamento más alto encontrado
            DocumentBuilder builder = factory.newDocumentBuilder(); // Crea el analizador XML
            Document document = builder.parse(new File(nombrefichero)); // Carga el XML
            document.getDocumentElement().normalize(); // Normaliza el documento
            NodeList departamentos = document.getElementsByTagName("departamento"); // Obtiene los departamentos
            for (int i = 0; i < departamentos.getLength(); i++) { // Recorre todos los departamentos
                Node departamento = departamentos.item(i); // Obtiene el nodo actual
                if (departamento.getNodeType() == Node.ELEMENT_NODE) { // Comprueba que sea un elemento
                    Element elemento = (Element) departamento; // Convierte el nodo a elemento
                    if (Integer.parseInt(getNodo("numero", elemento)) > numero) { // Comprueba si es el número mayor
                        numero = Integer.parseInt(getNodo("numero", elemento)); // Actualiza el número máximo
                    }
                }
            }
            System.out.println("El número de departamento más alto es: " + numero);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void GuardarXML(Document doc, String nombreFichero) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance(); // Crea la fábrica para transformar el documento
        Transformer transformer = tf.newTransformer(); // Crea el transformador XML
        transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Activa la indentación del XML guardado
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // Define cuatro espacios de sangría
        transformer.transform(
                new DOMSource(doc), // Usa el documento DOM como origen
                new StreamResult(new File(nombreFichero)) // Escribe el resultado en el fichero indicado
        );

        System.out.println("Archivo guardado con éxito.");
    }

    public void listarCiclosFormativos(String nombrefichero) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Crea la fábrica de documentos
        try {
            DocumentBuilder builder = factory.newDocumentBuilder(); // Crea el analizador XML
            Document document = builder.parse(new File(nombrefichero)); // Lee el fichero XML
            document.getDocumentElement().normalize(); // Normaliza los nodos del documento
            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName()); // Muestra la raíz del XML
            NodeList ciclosFormativos = document.getElementsByTagName("cicloformativo"); // Obtiene todos los ciclos
            for (int i = 0; i < ciclosFormativos.getLength(); i++) { // Recorre cada ciclo formativo
                Node cicloFormativo = ciclosFormativos.item(i); // Obtiene el ciclo actual
                if (cicloFormativo.getNodeType() == Node.ELEMENT_NODE) { // Comprueba que el nodo sea un elemento
                    Element elemento = (Element) cicloFormativo; // Convierte el nodo a elemento
                    System.out.println("ID: " + elemento.getAttribute("id")); // Muestra el atributo identificador
                    System.out.println("Nombre: " + getNodo("nombre", elemento)); // Muestra el nombre del ciclo
                    System.out.println("Instituto: " + getNodo("instituto", elemento)); // Muestra el instituto
                    System.out.println("Curso: " + getNodo("curso", elemento)); // Muestra el curso
                    System.out.println("Localidad: " + getNodo("localidad", elemento)); // Muestra la localidad
                    System.out.println("Numero alumnos: " + getNodo("numalumnos", elemento)); // Muestra el número de alumnos
                    System.out.println("----------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void añadirCicloFormativo(String nombrefichero) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Crea la fábrica de documentos XML
        try {
            DocumentBuilder builder = factory.newDocumentBuilder(); // Crea el analizador XML
            Document doc = builder.parse(new File(nombrefichero)); // Carga el documento existente
            doc.getDocumentElement().normalize(); // Normaliza la estructura del documento

            Scanner sc = new Scanner(System.in); // Permite leer los datos introducidos por teclado
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Nombre: ");
            String nombreCiclo = sc.nextLine();
            System.out.print("Instituto: ");
            String instituto = sc.nextLine();
            System.out.print("Curso: ");
            String curso = sc.nextLine();
            System.out.print("Localidad: ");
            String localidad = sc.nextLine();
            System.out.print("Nº alumnos: ");
            String numAlumnos = sc.nextLine();

            Element nuevo = doc.createElement("cicloformativo"); // Crea el nuevo elemento cicloformativo
            nuevo.setAttribute("id", id); // Añade el identificador como atributo XML

            nuevo.appendChild(crearCampo(doc, "nombre", nombreCiclo)); // Añade el nombre al nuevo ciclo
            nuevo.appendChild(crearCampo(doc, "instituto", instituto)); // Añade el instituto
            nuevo.appendChild(crearCampo(doc, "curso", curso)); // Añade el curso
            nuevo.appendChild(crearCampo(doc, "localidad", localidad)); // Añade la localidad
            nuevo.appendChild(crearCampo(doc, "numalumnos", numAlumnos)); // Añade el número de alumnos

            doc.getDocumentElement().appendChild(nuevo); // Inserta el nuevo ciclo dentro de la raíz
            GuardarXML(doc, nombrefichero); // Guarda los cambios en el fichero
            System.out.println("Ciclo añadido.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Crea <etiqueta>texto</etiqueta> para no repetir 3 líneas por campo
    private Element crearCampo(Document doc, String etiqueta, String texto) {
        Element e = doc.createElement(etiqueta); // Crea la etiqueta XML indicada
        e.appendChild(doc.createTextNode(texto)); // Añade el texto dentro de la etiqueta
        return e; // Devuelve el campo completo
    }

    public void modificarCiclosFormativos(String nombreFichero) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Crea la fábrica de documentos
        try {
            Scanner sc = new Scanner(System.in); // Lee los datos introducidos por el usuario
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Numero de alumnos: ");
            String numAlumnos = sc.nextLine();
            DocumentBuilder builder = factory.newDocumentBuilder(); // Crea el analizador XML
            Document doc = builder.parse(new File(nombreFichero)); // Carga el fichero XML
            doc.getDocumentElement().normalize(); // Normaliza el documento
            NodeList ciclosFormativos = doc.getElementsByTagName("cicloformativo"); // Obtiene todos los ciclos
            boolean encontrado = false; // Indica si se ha encontrado el ciclo buscado
            for (int i = 0; i < ciclosFormativos.getLength(); i++) { // Recorre los ciclos formativos
                Node cicloFormativo = ciclosFormativos.item(i); // Obtiene el ciclo actual
                if (cicloFormativo.getNodeType() == Node.ELEMENT_NODE) { // Comprueba que sea un elemento XML
                    Element elemento = (Element) cicloFormativo; // Convierte el nodo para acceder a sus atributos
                    if (elemento.getAttribute("id").equals(id)) { // Compara el ID con el introducido
                        elemento.getElementsByTagName("numalumnos").item(0).setTextContent(numAlumnos); // Actualiza el número de alumnos
                        encontrado = true; // Marca que el ciclo existe
                    }
                }
            }
            if (encontrado) {
                GuardarXML(doc, nombreFichero); // Guarda el documento XML actualizado
                System.out.println("Número de alumnos modificado.");
            } else {
                System.out.println("No existe ningún ciclo con id=" + id + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}