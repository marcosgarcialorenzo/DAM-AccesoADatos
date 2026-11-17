package RA5;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class ConsultasSucursales {

    private Document cargarXML(String filePath) throws Exception {
        File entrada = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(entrada);

        // Normalizar elimina diferencias innecesarias de espacios y nodos de texto.
        doc.getDocumentElement().normalize();
        return doc;
    }

    public NodeList mostrarCuentasAhorro(String archivo) {
        try {
            Document doc = cargarXML(archivo);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//sucursal/cuenta[@tipo='AHORRO']";
            XPathExpression xPathExpression = xPath.compile(expression);
            return (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void imprimirNodos(NodeList productos) {
        if (productos == null || productos.getLength() == 0) {
            System.out.println("No se encontraron productos.");
            return;
        }
        for (int i = 0; i < productos.getLength(); i++) {
            Node producto = productos.item(i);
            if (producto.getNodeName().equals("sucursal")) {
                NodeList detalles = producto.getChildNodes();
                for (int j = 0; j < detalles.getLength(); j++) {
                    Node detalle = detalles.item(j);
                    if (detalle.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println(
                                "  " + detalle.getNodeName() + ": "
                                        + detalle.getTextContent().trim());
                    }
                }
            } else {
                System.out.println(
                        "  " + producto.getNodeName() + ": "
                                + producto.getTextContent().trim());
            }
        }
    }

    public void mostrarNumeroCuentasAhorroPorSucursal(String archivo) {
        try {
            Document doc = cargarXML(archivo);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//sucursal";
            XPathExpression xPathExpression = xPath.compile(expression);
            NodeList sucursales = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < sucursales.getLength(); i++) {
                Node sucursal = sucursales.item(i);
                String countExpression = "count(cuenta[@tipo='AHORRO'])";
                Double count = (Double) xPath.evaluate(countExpression, sucursal, XPathConstants.NUMBER);
                String codigo = sucursal.getAttributes().getNamedItem("codigo").getNodeValue();
                System.out.println(codigo + " " + count.intValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NodeList mostrarCuentasPensionesSUC3(String archivo) {
        try {
            Document doc = cargarXML(archivo);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//sucursal[@codigo='SUC3']/cuenta[@tipo='PENSIONES']";
            XPathExpression xPathExpression = xPath.compile(expression);
            return (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}