package orderapi.ecommerce.test;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Dates {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		em.createQuery("select YEAR(e.regDate) from Customer e where e.regDate > :regDate")
			.setParameter("regDate", new Date(), TemporalType.DATE)
			.getResultList()
			.forEach(x -> System.out.println(ReflectionToStringBuilder.toString(x, ToStringStyle.MULTI_LINE_STYLE)));
	}
}
