package Service.Operations.Implementation.CRUD;

import Models.Team;
import Service.Operations.Interfaces.CRUD.TeamCRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class TeamCRUDImplementation implements TeamCRUD {

    @Override
    public Team insertNewTeam() { // dziala
        Team team = new Team();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type name of the team you want to add: ");
        String nameOfTheTeam = scanner.nextLine();
        team.setName(nameOfTheTeam);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(team);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return team;
    }

    @Override
    public Team findTeamByName(String name) { //dziala
        Team team;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        team = entityManager.createQuery("from Team t where name = :name",
                Team.class).setParameter("name", name).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return team;
    }

    @Override
    public Team updateTeamName(Team team) {  //dziala
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type name of the team you want to change: ");
        String nameOfTheTeam = scanner.nextLine();
        team.setName(nameOfTheTeam);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(team);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return team;
    }

    @Override
    public Boolean deleteTeam(Team team) {  //dziala
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        team = findTeamById(team.getTeamId());
        boolean isDeleted = false;
        try {
            entityManager.getTransaction().begin();
            team = entityManager.find(Team.class, team.getTeamId());
            entityManager.remove(team);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            isDeleted = true;
        } catch (NullPointerException e) {
            System.out.println("There is no team to remove!");
        }
        return isDeleted;
    }

    private Team findTeamById(Long id) { //dziala
        Team team = new Team();
        team.setTeamId(id);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            team = entityManager.find(Team.class, team.getTeamId());
        } catch (NullPointerException e) {
            System.out.println("Entity not found!");
        }
        return team;
    }
}
