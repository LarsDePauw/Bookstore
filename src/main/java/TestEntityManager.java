
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


import static org.junit.Assert.*;

public class TestEntityManager {
    private EntityManager em;
    private Logger logger = LoggerFactory.getLogger(TestEntityManager.class);


    @Test
    public void testOurLogic() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RealDolmenPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        BookRepository bookRepository = new BookRepositoryBean(em);
        List<Book> books = bookRepository.findAllBooks();
        assertEquals(7, books.size());

        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();


    }
}




