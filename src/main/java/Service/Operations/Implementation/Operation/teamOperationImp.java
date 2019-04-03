package Service.Operations.Implementation.Operation;

import Models.Game;
import Models.Player;
import Models.Team;
import Service.Operations.Interfaces.Operation.TeamOperations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class teamOperationImp implements TeamOperations {

    @Override
    public List<Team> getListOfTeams() { //dziala
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

    @Override
    public List<Game> listOfTeamGames(Team team) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Game> listOfTeamAwayGame;
        List<Game> listOfTeamHomeGame;
        List<Game> finaleListGame = new ArrayList();
        entityManager.getTransaction().begin();
        listOfTeamAwayGame = entityManager.createQuery("from Game where teamAway = :name",
                Game.class).setParameter("name", team.getName()).getResultList();
        listOfTeamHomeGame = entityManager.createQuery("from Game  where teamHome = :name",
                Game.class).setParameter("name", team.getName()).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        finaleListGame.addAll(listOfTeamHomeGame);
        finaleListGame.addAll(listOfTeamAwayGame);

        return finaleListGame;
    }

    @Override
    public List<Game> listOfWingingGamesGivenTeam(Team team) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Game> listOfTeamAwayGame;
        List<Game> listOfTeamHomeGame;
        List<Game> finaleListGame = new ArrayList();
        entityManager.getTransaction().begin();
        listOfTeamAwayGame = entityManager.createQuery("from Game where teamAway = :name and isTeamAwayWin=true",
                Game.class).setParameter("name", team.getName()).getResultList();
        listOfTeamHomeGame = entityManager.createQuery("from Game  where teamHome = :name and isTeamHomeWin=true",
                Game.class).setParameter("name", team.getName()).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        finaleListGame.addAll(listOfTeamHomeGame);
        finaleListGame.addAll(listOfTeamAwayGame);

        return finaleListGame;
    }

    @Override
    public List<Game> listOfLosingGamesGivenTeam(Team team) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Game> listOfTeamAwayGame;
        List<Game> listOfTeamHomeGame;
        List<Game> finaleListGame = new ArrayList();
        entityManager.getTransaction().begin();
        listOfTeamAwayGame = entityManager.createQuery("from Game where teamAway = :name and isTeamAwayWin=false",
                Game.class).setParameter("name", team.getName()).getResultList();
        listOfTeamHomeGame = entityManager.createQuery("from Game  where teamHome = :name and isTeamHomeWin=false",
                Game.class).setParameter("name", team.getName()).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        finaleListGame.addAll(listOfTeamHomeGame);
        finaleListGame.addAll(listOfTeamAwayGame);

        return finaleListGame;
    }

    @Override
    public List<Game> listOfTeamGamesAgainstGivenTeam(Team team, Team enemy) { //or enemy string name? 2 options
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Game> listOfTeamAwayGame;
        List<Game> listOfTeamHomeGame;
        List<Game> finaleListGame = new ArrayList();
        entityManager.getTransaction().begin();
        listOfTeamAwayGame = entityManager.createQuery("from Game where teamAway = :name and teamHome= :enemyName",
                Game.class).setParameter("name", team.getName())
                .setParameter("enemyName", enemy.getName())
                .getResultList();
        listOfTeamHomeGame = entityManager.createQuery("from Game  where teamHome = :name and teamAway= :enemyName",
                Game.class).setParameter("name", team.getName())
                .setParameter("enemyName", enemy.getName())
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        finaleListGame.addAll(listOfTeamHomeGame);
        finaleListGame.addAll(listOfTeamAwayGame);

        return finaleListGame;
    }

    @Override
    public List<Player> listOfInjuredPlayerInTeam(Team team) {
        return null;
    }
}
