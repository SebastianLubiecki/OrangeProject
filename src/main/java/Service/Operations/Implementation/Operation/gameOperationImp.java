package Service.Operations.Implementation.Operation;

import Models.Game;
import Models.Team;
import Service.Operations.Interfaces.Operation.gameOperations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class gameOperationImp implements gameOperations {


    @Override
    public List<Game> getListOfGames(/*Long team_id*/) {
        List<Game> gameList;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        gameList = entityManager.createQuery("select teamHomeName,teamAwayName FROM Game").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        if (gameList == null) {
            System.out.println("No players found. ");
        }
        for (Game game : gameList) {
            System.out.println(game);
        }
        return gameList;
    }

    @Override
    public List<Game> listOfGameWhereTeamScoreMoreThen(int numberOfPoint, Team team) {
        List <Game> gameListAway;
        List <Game> gameListHome;
        List <Game> gameList = new ArrayList<>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        gameListAway = entityManager.createQuery("from Game g where teamAwayScore>:numberOfPoint and teamAway=:teamId", Game.class)
                .setParameter("teamId", team.getTeamId())
                .setParameter("numberOfPoint", numberOfPoint)
                .getResultList();
        gameListHome = entityManager.createQuery("from Game g where teamHomeScore>:numberOfPoint and teamHome=:teamId", Game.class)
                .setParameter("teamId", team.getTeamId())
                .setParameter("numberOfPoint", numberOfPoint)
                .getResultList();

        entityManager.getTransaction().commit();
        gameList.addAll(gameListAway);
        gameList.addAll(gameListHome);

        return gameList;
    }
}
