import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Lars De Pauw on 26/05/15.
 */
public abstract class AbstractTestEntityManager {
    public static EntityManagerFactory emf;
    public EntityManager em;

    @BeforeClass
    public static void initializeEntityManagerFactory(){
        emf = Persistence.createEntityManagerFactory("RealDolmenPersistenceUnit");
    }

    @AfterClass
    public static void destroyEntityManagerFactory(){
        emf.close();
    }

    @Before
    public void initializeEntityManager(){
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @After
    public void destroyEntityManager(){
        em.getTransaction().commit();
        em.close();
    }
}
