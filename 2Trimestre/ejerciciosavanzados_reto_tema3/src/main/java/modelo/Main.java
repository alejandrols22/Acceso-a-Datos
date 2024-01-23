package modelo;

import modelo.*;
import modelo.dao.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Configurar la sesión de Hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Crear instancias DAO
        LibroDAO libroDao = new LibroDAO(sessionFactory);
        AutorDAO autorDao = new AutorDAO(sessionFactory);
        CategoriaDAO categoriaDao = new CategoriaDAO(sessionFactory);
        ClienteDAO clienteDao = new ClienteDAO(sessionFactory);
        PedidoDAO pedidoDao = new PedidoDAO(sessionFactory);

        // Insertar autores
        for (int i = 1; i <= 10; i++) {
            Autor autor = new Autor("Autor " + i, "Biografía del autor " + i);
            autorDao.crearAutor(autor);
            System.out.println("Autor insertado: " + autor);
        }

        // Insertar categorías
        for (int i = 1; i <= 10; i++) {
            Categoria categoria = new Categoria("Categoria " + i, "Descripción de la categoría " + i);
            categoriaDao.crearCategoria(categoria);
            System.out.println("Categoría insertada: " + categoria);
        }

        // Insertar libros
        for (int i = 1; i <= 10; i++) {
            Libro libro = new Libro("Libro " + i, 20.99 + i, 50 + i);
            libroDao.crearLibro(libro);
            System.out.println("Libro insertado: " + libro);
        }

        // Insertar clientes
        for (int i = 1; i <= 10; i++) {
            Cliente cliente = new Cliente("Cliente " + i, "cliente" + i + "@example.com", "Calle " + i);
            clienteDao.crearCliente(cliente);
            System.out.println("Cliente insertado: " + cliente);
        }

        // Insertar pedidos
        for (int i = 1; i <= 10; i++) {
            Cliente cliente = clienteDao.leerCliente(i); // Asumiendo que los clientes ya están creados
            Pedido pedido = new Pedido(new Date(), 100 + i, cliente);
            pedidoDao.crearPedido(pedido);
            System.out.println("Pedido insertado: " + pedido);
        }
        
        // Ejemplo de operaciones CRUD
        // Crear y guardar una nueva entidad Autor
        Autor autor = new Autor("Gabriel García Márquez", "Biografía...");
        autorDao.crearAutor(autor);
        Autor autorInsertado = autorDao.leerAutor(autor.getId());
        System.out.println("Autor insertado: " + autorInsertado);

        // Crear y guardar una nueva entidad Categoria
        Categoria categoria = new Categoria("Novela", "Descripción de novela");
        categoriaDao.crearCategoria(categoria);
        Categoria categoriaInsertada = categoriaDao.leerCategoria(categoria.getId());
        System.out.println("Categoría insertada: " + categoriaInsertada);

        // Crear y guardar una nueva entidad Libro
        Libro libro = new Libro("Cien años de soledad", 39.99, 100);
        libro.getAutores().add(autor);
        libro.getCategorias().add(categoria);
        libroDao.crearLibro(libro);
        Libro libroInsertado = libroDao.leerLibro(libro.getId());
        System.out.println("Libro insertado: " + libroInsertado);

        // Crear y guardar una nueva entidad Cliente
        Cliente cliente = new Cliente("Juan Pérez", "juan@example.com", "Calle Falsa 123");
        clienteDao.crearCliente(cliente);
        Cliente clienteInsertado = clienteDao.leerCliente(cliente.getId());
        System.out.println("Cliente insertado: " + clienteInsertado);

        // Crear y guardar una nueva entidad Pedido
        Pedido pedido = new Pedido(new Date(), 39.99, cliente);
        pedidoDao.crearPedido(pedido);

        // Actualizar entidad
        libro.setPrecio(29.99);
        libroDao.actualizarLibro(libro);

        // Leer entidad
        Libro libroLeido = libroDao.leerLibro(libro.getId());
        System.out.println("Libro leído: " + libroLeido);

        // Eliminar entidad
        libroDao.eliminarLibro(libroLeido.getId());

        // Consultas HQL y características adicionales
        List<Libro> librosDeAutor = libroDao.obtenerLibrosDeAutor("Gabriel García Márquez");
        System.out.println("Libros del autor: " + librosDeAutor);

        List<Libro> librosDeCategoria = libroDao.obtenerLibrosPorCategoria("Novela");
        System.out.println("Libros de la categoría: " + librosDeCategoria);

        List<Pedido> pedidosCliente = clienteDao.obtenerPedidosCliente(cliente.getId());
        System.out.println("Pedidos del cliente: " + pedidosCliente);

        // Gestionar stock y descuentos
        libroDao.venderLibro(libro.getId(), 10);
        libroDao.devolverLibro(libro.getId(), 5);

        pedido.setDescuento(10.0); // Aplicar descuento
        pedidoDao.actualizarPedido(pedido);

        // Búsqueda
        List<Libro> librosBuscados = libroDao.buscarLibrosPorTitulo("soledad");
        System.out.println("Libros encontrados: " + librosBuscados);

        // Cerrar la sesión de Hibernate
        sessionFactory.close();
    }
}
