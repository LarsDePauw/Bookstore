import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Lars De Pauw on 26/05/15.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RealDolmenPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        BookRepositoryBean brb = new BookRepositoryBean(entityManager);
        System.out.println(brb.findAllBooks());

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();


    }
}
