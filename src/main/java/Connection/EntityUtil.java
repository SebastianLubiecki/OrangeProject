package Connection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public enum EntityUtil {
    INSTANCE;

    private EntityManager em;

    private EntityUtil() {
        em = Persistence.createEntityManagerFactory("persistance").createEntityManager();
    }
}
