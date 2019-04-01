package Service.Operations.Implementation;

import Models.Game;
import Service.Operations.Interfaces.gameOperations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class gameOperationImp implements gameOperations {

    public Game insertNewGame(Game game) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(game);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return game;
    }
    private Game findGameById(Long id) {
        Game game = new Game();
        game.setGameId(id);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            game = entityManager.find(Game.class, game.getGameId());
        } catch (NullPointerException e) {
            System.out.println("Entity not found!");
        }
        return game;
    }
    public Boolean deleteGame(Game game) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        game=findGameById(game.getGameId());
        boolean isGameDeleted = false;
        try {
            entityManager.getTransaction().begin();
            game = entityManager.find(Game.class, game.getGameId());
            entityManager.remove(game);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            isGameDeleted = true;
        } catch (PersistenceException | NullPointerException e) {
            System.out.println("Something went wrong. Game can not be deleted!");
        }
        return isGameDeleted;
    }
    public Game updateGame(Game game) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type teamHomeScore of the game you want to change: ");
        Integer teamHomeScore = scanner.nextInt();
        System.out.print("Type teamAwaycore of the game you want to change: ");
        Integer teamAwayScore = scanner.nextInt();
        game.setTeamHomeScore(teamHomeScore);
        game.setTeamAwayScore(teamAwayScore);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(game);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return game;
    }
    public List<Game> getListOfGames(/*Long team_id*/) {
        List<Game> gameList;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        gameList=entityManager.createQuery("select teamHomeName,teamAwayName FROM Game").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        if (gameList == null) {
            System.out.println("No players found. ");
        }
        Iterator<Game> it = gameList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        return gameList;
    }
}
