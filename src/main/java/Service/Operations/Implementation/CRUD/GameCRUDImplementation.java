package Service.Operations.Implementation.CRUD;

import Models.Game;
import Service.Operations.Interfaces.CRUD.GameCRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.util.Scanner;

public class GameCRUDImplementation implements GameCRUD {

    @Override
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

    @Override
    public Boolean deleteGame(Game game) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        game = findGameById(game.getGameId());
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

    @Override
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
}

