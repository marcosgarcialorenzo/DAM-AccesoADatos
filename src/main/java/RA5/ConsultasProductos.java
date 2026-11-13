package RA5;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import net.sf.saxon.xpath.XPathFactoryImpl;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

/**
 * Contiene las consultas XPath relacionadas con el fichero de productos.
 *
 * <p>La clase trabaja con un {@link Document}, que representa el XML en memoria,
 * y devuelve bien una lista de nodos ({@link NodeList}) o bien un valor numérico,
 * dependiendo del tipo de consulta.</p>
 */
public class ConsultasProductos {

    /**
     * Devuelve los productos cuya denominación contiene "Placa Base".
     *
     * @param filePath ruta del fichero XML
     * @return nodos {@code produc} que cumplen el filtro, o {@code null} si falla la consulta
     */
    public NodeList mostrarProductosPlacaBase(String filePath) {
        try {
            Document doc = cargarXML(filePath);
            XPath xPath = XPathFactory.newInstance().newXPath();

            // contains() permite localizar la frase aunque la denominación tenga más texto.
            String expression = "/productos/produc[contains(denominacion, 'Placa Base')]";
            XPathExpression xPathExpression = xPath.compile(expression);

            // NODESET indica que el resultado esperado es una colección de nodos XML.
            return (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Cuenta las memorias almacenadas en la zona 10.
     *
     * @param filePath ruta del fichero XML
     * @return número de productos que cumplen ambos filtros
     */
    public int contarMemoriasZona10(String filePath) {
        try {
            Document doc = cargarXML(filePath);
            XPath xPath = XPathFactory.newInstance().newXPath();

            // count() devuelve un número; se filtra por denominación y por código de zona.
            String expression =
                    "count(/productos/produc[contains(denominacion, 'Memoria') and cod_zona=10])";

            XPathExpression xPathExpression = xPath.compile(expression);
            Double contador = (Double) xPathExpression.evaluate(
                    doc, XPathConstants.NUMBER);

            // XPath devuelve Double incluso cuando el resultado representa un entero.
            return contador.intValue();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Selecciona únicamente los nodos de denominación y precio de todos los productos.
     *
     * @param filePath ruta del fichero XML
     * @return nodos {@code denominacion} y {@code precio}, o {@code null} si falla la consulta
     */
    public NodeList mostrarDenominacionYPrecio(String filePath) {
        try {
            Document doc = cargarXML(filePath);
            XPath xPath = XPathFactory.newInstance().newXPath();

            // El operador | une los resultados de dos rutas XPath distintas.
            String expression = "/productos/produc/denominacion | /productos/produc/precio";
            XPathExpression xPathExpression = xPath.compile(expression);
            return (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Devuelve los productos con precio superior a 60 y ubicados en la zona 20.
     *
     * @param filePath ruta del fichero XML
     * @return productos que cumplen los dos filtros
     */
    public NodeList mostrarProductosPrecioMayor60Zona20(String filePath) {
        try {
            Document doc = cargarXML(filePath);
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Dentro de los corchetes se indican las condiciones que debe cumplir cada producto.
            String expression = "/productos/produc[precio>60 and cod_zona=20]";
            XPathExpression xPathExpression = xPath.compile(expression);
            return (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Calcula la media de los precios de los microprocesadores.
     *
     * <p>Se utiliza Saxon porque el XPath estándar de Java es XPath 1.0 y no
     * incluye la función {@code avg()}.</p>
     *
     * @param filePath ruta del fichero XML
     * @return media de los precios, o {@code 0.0} si se produce un error
     */
    public double calcularMediaPrecioMicros(String filePath) {
        try {
            Document doc = cargarXML(filePath);

            // XPathFactoryImpl crea el evaluador de Saxon, compatible con avg().
            XPathFactory saxonXPathFactory = new XPathFactoryImpl();
            XPath xPath = saxonXPathFactory.newXPath();

            // La ruta selecciona los precios de los productos cuya denominación contiene "Micro".
            String expression = "avg(/productos/produc[contains(denominacion, 'Micro')]/precio)";
            XPathExpression xPathExpression = xPath.compile(expression);

            // NUMBER convierte el resultado numérico de avg() en un Double de Java.
            return (Double) xPathExpression.evaluate(doc, XPathConstants.NUMBER);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    /**
     * Devuelve los productos cuyo stock mínimo es superior al stock actual.
     *
     * @param filePath ruta del fichero XML
     * @return productos con falta de stock
     */
    public NodeList mostrarProductosConFaltaDeStock(String filePath) {
        try {
            Document doc = cargarXML(filePath);
            XPath xPath = XPathFactory.newInstance().newXPath();

            // La comparación numérica se realiza automáticamente sobre el contenido de los elementos.
            String expression = "/productos/produc[stock_minimo > stock_actual]";
            XPathExpression xPathExpression = xPath.compile(expression);
            return (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Devuelve los productos de la zona 40 que necesitan reposición.
     *
     * @param filePath ruta del fichero XML
     * @return productos de la zona 40 cuyo stock mínimo supera al actual
     */
    public NodeList mostrarProductosZona40ConFaltaDeStock(String filePath) {
        try {
            Document doc = cargarXML(filePath);
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Se combinan las condiciones de stock y zona con el operador and.
            String expression = "/productos/produc[stock_minimo > stock_actual and cod_zona=40]";
            XPathExpression xPathExpression = xPath.compile(expression);
            return (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /** Devuelve el producto o productos con el precio máximo de todo el XML. */
    public NodeList mostrarProductoMasCaro(String filePath) {
        return obtenerProductoExtremo(filePath, 0, true);
    }

    /** Devuelve el producto o productos más baratos de la zona 20. */
    public NodeList mostrarProductoMasBaratoZona20(String filePath) {
        return obtenerProductoExtremo(filePath, 20, false);
    }

    /** Devuelve el producto o productos más caros de la zona 10. */
    public NodeList mostrarProductoMasCaroZona10(String filePath) {
        return obtenerProductoExtremo(filePath, 10, true);
    }

    /**
     * Método común para las consultas de precio máximo y mínimo.
     *
     * @param filePath ruta del fichero XML
     * @param zona código de zona; el valor 0 significa todas las zonas
     * @param maximo {@code true} para buscar el máximo y {@code false} para el mínimo
     * @return productos que tienen el precio extremo solicitado
     */
    private NodeList obtenerProductoExtremo(String filePath, int zona, boolean maximo) {
        try {
            Document doc = cargarXML(filePath);

            // También se necesita Saxon aquí porque max() y min() no son funciones XPath 1.0.
            XPathFactory saxonXPathFactory = new XPathFactoryImpl();
            XPath xPath = saxonXPathFactory.newXPath();
            String expression;

            // Si zona es 0 se calcula el extremo global; si no, solo dentro de esa zona.
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
            return (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Lee el fichero XML y lo transforma en un árbol DOM.
     *
     * @param filePath ruta del fichero XML
     * @return documento XML listo para evaluarse con XPath
     * @throws Exception si el fichero no existe o no puede analizarse
     */
    private Document cargarXML(String filePath) throws Exception {
        File entrada = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(entrada);

        // Normalizar elimina diferencias innecesarias de espacios y nodos de texto.
        doc.getDocumentElement().normalize();
        return doc;
    }

    /**
     * Imprime todos los campos de cada nodo recibido.
     *
     * <p>Cuando recibe un elemento {@code produc}, recorre sus hijos e ignora
     * los nodos de texto producidos por los saltos de línea del XML.</p>
     *
     * @param productos nodos que se mostrarán por consola
     */
    public void imprimirProductos(NodeList productos) {
        if (productos == null || productos.getLength() == 0) {
            System.out.println("No se encontraron productos.");
            return;
        }

        // NodeList se recorre mediante índices, desde 0 hasta length - 1.
        for (int i = 0; i < productos.getLength(); i++) {
            Node producto = productos.item(i);

            System.out.println("\nProducto:");

            if (producto.getNodeName().equals("produc")) {
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

    /**
     * Imprime únicamente la denominación y el precio de cada producto.
     *
     * @param productos nodos {@code produc} que se mostrarán
     */
    public void imprimirDenominacionYPrecio(NodeList productos) {
        if (productos == null || productos.getLength() == 0) {
            System.out.println("No se encontraron productos.");
            return;
        }

        for (int i = 0; i < productos.getLength(); i++) {
            Node producto = productos.item(i);

            try {
                // Estas expresiones son relativas al nodo produc actual.
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