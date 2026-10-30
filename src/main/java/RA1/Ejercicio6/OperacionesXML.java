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
        NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();
    }

    public void listarDepartamentos(String nombrefichero) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(nombrefichero));
            document.getDocumentElement().normalize();
            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
            NodeList departamentos = document.getElementsByTagName("departamento");
            for (int i = 0; i < departamentos.getLength(); i++) {
                Node departamento = departamentos.item(i);
                if (departamento.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) departamento;
                    System.out.println("Numero: " + getNodo("numero", elemento));
                    System.out.println("Nombre: " + getNodo("nombre", elemento));
                    System.out.println("Localidad: " + getNodo("localidad", elemento));
                    System.out.println("----------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarPorLocalidad(String nombrefichero) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(nombrefichero));
            document.getDocumentElement().normalize();
            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
            NodeList departamentos = document.getElementsByTagName("departamento");
            for (int i = 0; i < departamentos.getLength(); i++) {
                Node departamento = departamentos.item(i);
                if (departamento.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) departamento;
                    if (getNodo("localidad", elemento).equalsIgnoreCase("Guadalajara")) {
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
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            int numero = 0;
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(nombrefichero));
            document.getDocumentElement().normalize();
            NodeList departamentos = document.getElementsByTagName("departamento");
            for (int i = 0; i < departamentos.getLength(); i++) {
                Node departamento = departamentos.item(i);
                if (departamento.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) departamento;
                    if (Integer.parseInt(getNodo("numero", elemento)) > numero) {
                        numero = Integer.parseInt(getNodo("numero", elemento));
                    }
                }
            }
            System.out.println("El número de departamento más alto es: " + numero);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void GuardarXML(Document doc, String nombreFichero) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(
                new DOMSource(doc),
                new StreamResult(new File(nombreFichero))
        );

        System.out.println("Archivo guardado con éxito.");
    }

    public void listarCiclosFormativos(String nombrefichero) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(nombrefichero));
            document.getDocumentElement().normalize();
            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
            NodeList ciclosFormativos = document.getElementsByTagName("cicloformativo");
            for (int i = 0; i < ciclosFormativos.getLength(); i++) {
                Node cicloFormativo = ciclosFormativos.item(i);
                if (cicloFormativo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) cicloFormativo;
                    System.out.println("ID: " + elemento.getAttribute("id"));
                    System.out.println("Nombre: " + getNodo("nombre", elemento));
                    System.out.println("Instituto: " + getNodo("instituto", elemento));
                    System.out.println("Curso: " + getNodo("curso", elemento));
                    System.out.println("Localidad: " + getNodo("localidad", elemento));
                    System.out.println("Numero alumnos: " + getNodo("numalumnos", elemento));
                    System.out.println("----------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void añadirCicloFormativo(String nombrefichero) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(nombrefichero));
            doc.getDocumentElement().normalize();

            Scanner sc = new Scanner(System.in);
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

            Element nuevo = doc.createElement("cicloformativo");
            nuevo.setAttribute("id", id);

            nuevo.appendChild(crearCampo(doc, "nombre", nombreCiclo));
            nuevo.appendChild(crearCampo(doc, "instituto", instituto));
            nuevo.appendChild(crearCampo(doc, "curso", curso));
            nuevo.appendChild(crearCampo(doc, "localidad", localidad));
            nuevo.appendChild(crearCampo(doc, "numalumnos", numAlumnos));

            doc.getDocumentElement().appendChild(nuevo);
            GuardarXML(doc, nombrefichero);
            System.out.println("Ciclo añadido.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Crea <etiqueta>texto</etiqueta> para no repetir 3 líneas por campo
    private Element crearCampo(Document doc, String etiqueta, String texto) {
        Element e = doc.createElement(etiqueta);
        e.appendChild(doc.createTextNode(texto));
        return e;
    }

    public void modificarCiclosFormativos(String nombreFichero) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Numero de alumnos: ");
            String numAlumnos = sc.nextLine();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(nombreFichero));
            doc.getDocumentElement().normalize();
            NodeList ciclosFormativos = doc.getElementsByTagName("cicloformativo");
            boolean encontrado = false;
            for (int i = 0; i < ciclosFormativos.getLength(); i++) {
                Node cicloFormativo = ciclosFormativos.item(i);
                if (cicloFormativo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) cicloFormativo;
                    if (elemento.getAttribute("id").equals(id)) {
                        elemento.getElementsByTagName("numalumnos").item(0).setTextContent(numAlumnos);
                        encontrado = true;
                    }
                }
            }
            if (encontrado) {
                GuardarXML(doc, nombreFichero);
                System.out.println("Número de alumnos modificado.");
            } else {
                System.out.println("No existe ningún ciclo con id=" + id + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}