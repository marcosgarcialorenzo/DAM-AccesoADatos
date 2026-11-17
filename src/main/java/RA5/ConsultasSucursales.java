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

            // El operador | une los resultados de dos rutas XPath distintas.
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

        // NodeList se recorre mediante índices, desde 0 hasta length - 1.
        for (int i = 0; i < productos.getLength(); i++) {
            Node producto = productos.item(i);
            if (producto.getNodeName().equals("sucursal")) {
                NodeList detalles = producto.getChildNodes();
                // getChildNodes() también incluye nodos de texto; por eso se comprueba ELEMENT_NODE.
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
}