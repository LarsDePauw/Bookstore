
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


import static org.junit.Assert.*;

public class TestEntityManager extends AbstractTestEntityManager {

    @Test
    public void testOurLogic() throws Exception {
        List<Book> books = em.createQuery("select b from Book b", Book.class).getResultList();
        assertEquals(7, books.size());


    }
}




