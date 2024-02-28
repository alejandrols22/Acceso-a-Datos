package ejercicio3;

import javax.xml.transform.OutputKeys;

import org.exist.xmldb.EXistResource;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;
import org.xmldb.api.modules.XQueryService;



public class QueryXML2 {

    // URI para conectarse a la base de datos XML existente en localhost en el puerto 8080
    private static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/";

    // Nombre de la colección donde se encuentran los datos XML
    private static String COLLECTION = "serie";

    // Nombre del recurso XML dentro de la colección
    private static String RESOURCE = "serie.xml";

    public static void main(String args[]) throws Exception {

        final String driver = "org.exist.xmldb.DatabaseImpl";

        // Inicializa el controlador de la base de datos
        Class cl = Class.forName(driver);
        Database database = (Database) cl.getDeclaredConstructor().newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);

        Collection col = null;
		XMLResource res = null;
		try {
            // Obtiene la colección
            col = DatabaseManager.getCollection(URI + COLLECTION, "admin", "1234");
            col.setProperty(OutputKeys.INDENT, "no");

            if (col != null) {
                // Consulta para recuperar todas las series
                System.out.println("Todas las series:");
                realizarConsulta(col, "//serie");

                // Consulta para recuperar series emitidas a partir del año 2000
                System.out.println("\nSeries emitidas desde el año 2000:");
                realizarConsulta(col, "//serie[inicio_emision >= 2000]");
            }
        } catch (XMLDBException xe) {
            xe.printStackTrace();
        } finally {
            // Limpieza de recursos
            if (col != null) {
                col.close();
            }
        }
    }
		private static void realizarConsulta(Collection col, String xpath) throws XMLDBException {
	        XPathQueryService xpathService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
	        ResourceSet result = xpathService.query(xpath);
	        ResourceIterator i = result.getIterator();
	        while (i.hasMoreResources()) {
	            Resource r = i.nextResource();
	            System.out.println((String) r.getContent());
	        }
	    }
	}
