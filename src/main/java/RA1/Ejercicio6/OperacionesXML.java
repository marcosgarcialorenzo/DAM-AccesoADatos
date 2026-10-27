package RA1.Ejercicio6;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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

    /*private void GuardarXML(Document doc) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(
                new DOMSource(doc),
                new StreamResult(new File(nombreficherociclos))
        );

        System.out.println("Archivo guardado con éxito.");
    }*/

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
}