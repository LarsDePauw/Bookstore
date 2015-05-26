import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.*;

public class TestEntityManager {
    private EntityManager em;

    @Test
    public void testOurLogic() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RealDolmenPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        BookRepository bookRepository = new BookRepositoryBean(em);
        List<Book> books = bookRepository.findAllBooks();
        assertEquals(6, books.size());

        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();


    }


}



