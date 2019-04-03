package Service.Operations.Implementation;


import Models.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;


public class teamOpartionTest {
    private SessionFactory sessionFactory;

    @Before
    public void setup() {

        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        sessionFactory = new MetadataSources(standardServiceRegistry)
                .buildMetadata()
                .buildSessionFactory();
    }

    void testInsertNewTeam() {

        Team team = new Team();
        team.setName("New York");
        team.setTotalScore(234444L);

        // czy w tym miejscu nie powinnismy testowac metody z klasy?
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(team);

            transaction.commit();
            session.close();
        }

        Team team1;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            team1 = session.createQuery("from Team t where t.name= :name", Team.class)
                    .setParameter("name", team.getName())
                    .getSingleResult();
            transaction.commit();
            session.close();
        }
        assertNotNull(team1);
        assertEquals(team, team1);

    }

    void testDeleteTeam() {

    }

    void testUpdateTeamName() {

    }

    void testGetTeam() {

    }

    void testGetListOfTeams() {
    }

    void testListOfTeamGames() {
    }
}
