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

public class QueryXML {

	// URI para conectarse a la base de datos XML existente en localhost en el
	// puerto 8080
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

			// Configura la propiedad de salida para indentación
			col.setProperty(OutputKeys.INDENT, "no");

			// Obtiene el recurso XML de la colección
			res = (XMLResource) col.getResource(RESOURCE);

			// Verifica si el recurso existe
			if (res == null) {
				System.out.println("Base de datos no encontrada!");
			} else {
				// Imprime el contenido del recurso
				System.out.println(res.getContent());
			}
		} finally {
			// Limpieza de recursos

			if (res != null) {
				try {
					// Libera los recursos del recurso exist
					((EXistResource) res).freeResources();
				} catch (XMLDBException xe) {
					xe.printStackTrace();
				}
			}

			if (col == null) {
				System.out.println("No se pudo conectar a la colección: " + COLLECTION);
				return;
			}
			try {
				// Cierra la colección
				col.close();
			} catch (XMLDBException xe) {
				xe.printStackTrace();
			}
		}
	}
}
