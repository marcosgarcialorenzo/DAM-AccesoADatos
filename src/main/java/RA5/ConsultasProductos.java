package RA5;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

public class ConsultasProductos {

    // 1. Obtener los productos que sean placas base
    public NodeList mostrarProductosPlacaBase(String filePath) {
        try {
            // Cargamos el documento XML desde la ruta recibida.
            Document doc = cargarXML(filePath);

            // Creamos el objeto que permite realizar consultas XPath.
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Seleccionamos los productos cuya denominación contiene "Placa Base".
            String expression = "/productos/produc[contains(denominacion, 'Placa Base')]";
            XPathExpression xPathExpression = xPath.compile(expression);

            // Ejecutamos la consulta y devolvemos todos los nodos encontrados.
            return (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 2. Contar las memorias de la zona 10
    public int contarMemoriasZona10(String filePath) {
        try {
            Document doc = cargarXML(filePath);
            XPath xPath = XPathFactory.newInstance().newXPath();

            String expression =
                    "count(/productos/produc[contains(denominacion, 'Memoria') and cod_zona=10])";

            XPathExpression xPathExpression = xPath.compile(expression);

            Double contador = (Double) xPathExpression.evaluate(
                    doc, XPathConstants.NUMBER);

            return contador.intValue();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 3. Obtener la denominación y el precio de todos los productos
    public NodeList mostrarDenominacionYPrecio(String filePath) {
        try {
            // Cargamos el documento XML desde la ruta recibida.
            Document doc = cargarXML(filePath);

            // Creamos el objeto que permite realizar consultas XPath.
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Seleccionamos los productos cuya denominación contiene "Placa Base".
            String expression = "/productos/produc/denominacion | /productos/produc/precio";
            XPathExpression xPathExpression = xPath.compile(expression);

            // Ejecutamos la consulta y devolvemos todos los nodos encontrados.
            return (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 4. Obtener productos con precio mayor de 60 y zona 20
    public NodeList mostrarProductosPrecioMayor60Zona20(String filePath) {
        try {
            // Cargamos el documento XML desde la ruta recibida.
            Document doc = cargarXML(filePath);

            // Creamos el objeto que permite realizar consultas XPath.
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Seleccionamos los productos cuya denominación contiene "Placa Base".
            String expression = "/productos/produc[precio>60 and cod_zona=20]";
            XPathExpression xPathExpression = xPath.compile(expression);

            // Ejecutamos la consulta y devolvemos todos los nodos encontrados.
            return (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 5. Obtener la media del precio de los micros
    // XPath 1.0 de Java no dispone de avg(), por eso calculamos la media en Java.
    public double calcularMediaPrecioMicros(String filePath) {
        try {
            // Cargamos el documento XML desde la ruta recibida.
            Document doc = cargarXML(filePath);

            // Creamos el objeto que permite realizar consultas XPath.
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Seleccionamos los productos cuya denominación contiene "Placa Base".
            String expression = "avg(/productos/produc[contains(denominacion, 'Micro')]/precio)";
            XPathExpression xPathExpression = xPath.compile(expression);

            // Ejecutamos la consulta y devolvemos todos los nodos encontrados.
            return (Double) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Double.parseDouble(null);
    }

    // 6. Obtener productos cuyo stock mínimo sea mayor que el actual
    public NodeList mostrarProductosConFaltaDeStock(String filePath) {
        try {
            // Cargamos el documento XML desde la ruta recibida.
            Document doc = cargarXML(filePath);

            // Creamos el objeto que permite realizar consultas XPath.
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Seleccionamos los productos cuya denominación contiene "Placa Base".
            String expression = "/productos/produc[stock_minimo > stock_actual]";
            XPathExpression xPathExpression = xPath.compile(expression);

            // Ejecutamos la consulta y devolvemos todos los nodos encontrados.
            return (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 7. Obtener denominación y precio de los productos de la zona 40
    // cuyo stock mínimo sea mayor que el stock actual.
    public NodeList mostrarProductosZona40ConFaltaDeStock(String filePath) {
        try {
            // Cargamos el documento XML desde la ruta recibida.
            Document doc = cargarXML(filePath);

            // Creamos el objeto que permite realizar consultas XPath.
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Seleccionamos los productos cuya denominación contiene "Placa Base".
            String expression = "/productos/produc[stock_minimo > stock_actual and cod_zona=40]";
            XPathExpression xPathExpression = xPath.compile(expression);

            // Ejecutamos la consulta y devolvemos todos los nodos encontrados.
            return (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 8. Obtener el producto más caro de todos
    public NodeList mostrarProductoMasCaro(String filePath) {
        return obtenerProductoExtremo(filePath, 0, true);
    }

    // 9. Obtener el producto más barato de la zona 20
    public NodeList mostrarProductoMasBaratoZona20(String filePath) {
        return obtenerProductoExtremo(filePath, 20, false);
    }

    // 10. Obtener el producto más caro de la zona 10
    public NodeList mostrarProductoMasCaroZona10(String filePath) {
        return obtenerProductoExtremo(filePath, 10, true);
    }

    // para las opciones 8,9,10 calcular el producto mas caro y mas barato
    private NodeList obtenerProductoExtremo(String filePath, int zona, boolean maximo) {
        try {
            // Cargamos el documento XML desde la ruta recibida.
            Document doc = cargarXML(filePath);

            // Creamos el objeto que permite realizar consultas XPath.
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression;
            // Seleccionamos los productos cuya denominación contiene "Placa Base".
            if (maximo) {
                expression = zona != 0
                        ? "/productos/produc[cod_zona=" + zona + " and precio = max(/productos/produc[cod_zona=" + zona + "]/precio)]"
                        : "/productos/produc[precio = max(/productos/produc/precio)]";
            } else {
                expression = zona != 0
                        ? "/productos/produc[cod_zona=" + zona + " and precio = min(/productos/produc[cod_zona=" + zona + "]/precio)]"
                        : "/productos/produc[precio = min(/productos/produc/precio)]";
            }
            XPathExpression xPathExpression = xPath.compile(expression);
            // Ejecutamos la consulta y devolvemos todos los nodos encontrados.
            return (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cargar el archivo XML
    private Document cargarXML(String filePath) throws Exception {
        File entrada = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(entrada);
        doc.getDocumentElement().normalize();
        return doc;
    }

    // Imprimir todos los campos de cada producto
    public void imprimirProductos(NodeList productos) {
        if (productos == null || productos.getLength() == 0) {
            System.out.println("No se encontraron productos.");
            return;
        }

        for (int i = 0; i < productos.getLength(); i++) {
            Node producto = productos.item(i);

            System.out.println("\nProducto:");

            if (producto.getNodeName().equals("produc")) {
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

    // Imprimir solo denominación y precio solo para la opcion 7
    public void imprimirDenominacionYPrecio(NodeList productos) {
        if (productos == null || productos.getLength() == 0) {
            System.out.println("No se encontraron productos.");
            return;
        }

        for (int i = 0; i < productos.getLength(); i++) {
            Node producto = productos.item(i);

            try {
                XPath xPath = XPathFactory.newInstance().newXPath();

                String denominacion =
                        xPath.evaluate("denominacion", producto).trim();

                String precio =
                        xPath.evaluate("precio", producto).trim();

                System.out.println(
                        "Producto: " + denominacion
                                + " | Precio: " + precio + " euros");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}