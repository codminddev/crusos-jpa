package orderapi.ecommerce;

import java.io.InputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orderapi.ecommerce.entity.Product;

public class Binarios {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		
		em.getTransaction().begin();
		
		try(InputStream stream = Binarios.class.getClassLoader().getResourceAsStream("META-INF/galletas.jpg")){
			byte[] bytes = new byte[stream.available()];
			System.out.println("bytes > " + stream.available());
			stream.read(bytes);
			
			Product product = new Product();
			product.setImage(bytes);
			product.setName("Producto con Imagen");
			product.setPrice(100d);
			
			em.persist(product);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		em.getTransaction().commit();
		
		
		Product productoImagen = em.createNamedQuery("Product.findByName", Product.class)
			.setParameter("name", "Producto con Imagen")
			.getSingleResult();
		
		System.out.println(productoImagen.getId() + "," + productoImagen.getImage().length);
		
	}
}
