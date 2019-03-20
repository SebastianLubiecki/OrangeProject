package Service.Operations.Implementation;

import Models.Game;
import Models.Team;
import Service.Operations.Interfaces.teamOperations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class teamOperationImp implements teamOperations {

    public Team insertNewTeam() { // only name of the team... to update
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

    public Boolean deleteTeam(Team team) {
        return null;
    }

    public Team updateTeamName(Team team) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type name of the team you want to change: ");
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

    public Team getTeam(String name) {
        Team team;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        team = entityManager.createQuery("from Team t where t.name = :name",
                Team.class).setParameter("name", name).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return team;
    }

    public List<Team> getListOfTeams() {
        List<Team> listOfTeams;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        listOfTeams = entityManager.createQuery("from Team",
                Team.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return listOfTeams;
    }


    public List<Game> listOfTeamGames(Team team) {
        return null;
    }
}
