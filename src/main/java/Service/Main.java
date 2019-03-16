package Service;

import Models.Game;
import Models.Player;
import Models.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Team team1 = new Team();
        team1.setName("LAL");
        Team team2 = new Team();
        team2.setName("NYK");
        List<Team> teams = new ArrayList<Team>();
        teams.add(team1);
        teams.add(team2);


        Player player1 = new Player();
        Player player2 = new Player();
        player1.setFirstName("ja");
        player1.setSurName("sadasd");
        player1.setAge(21);
        player1.setTeam(team1);
        player1.setExperience(2);

        player2.setFirstName("tysdsa");
        player2.setSurName("sabnbbvnb");
        player2.setAge(11);
        player2.setTeam(team2);
        player2.setExperience(12);

        Game game = new Game();
        game.setTeamAway(team1.getName());
        game.setTeamAwayScore(12);
        game.setTeamHomeScore(23);
        game.setTeamHome(team2.getName());
        game.setTeam(teams);
        game.setTeamAwayWine(false);
        game.setTeamHomeWine(true);

        entityManager.getTransaction().begin();
        entityManager.persist(team1);
        entityManager.persist(team2);
        entityManager.persist(player1);
        entityManager.persist(player2);
        entityManager.persist(game);

        entityManager.getTransaction().commit();

        entityManager.refresh(game);
        entityManager.close();
        entityManagerFactory.close();


    }
}
