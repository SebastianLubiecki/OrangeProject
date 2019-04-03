package Service.Operations.Implementation.CRUD;

import Models.Player;
import Service.Operations.Interfaces.CRUD.PlayerCRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Scanner;

public class PlayerCRUDImplementation implements PlayerCRUD {

    @Override
    public Player insertNewPlayer(Player player) { //dziala
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(player);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return player;
    }

    private Player findPlayerById(Long id) { //dziala
        Player player = new Player();
        player.setPlayerId(id);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            player = entityManager.find(Player.class, player.getPlayerId());
        } catch (NullPointerException e) {
            System.out.println("Entity not found!");
        }
        return player;
    }

    @Override
    public Player getPlayerById(Long id) { //dziala
        Player player;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        player = entityManager.createQuery("from Player p where p.id = :id",
                Player.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return player;
    }

    @Override
    public List<Player> getPlayerBySurName(String name) {
        List<Player> playerList;

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        playerList = entityManager.createQuery("from Player p where surName= :name", Player.class)
                .setParameter("name", name)
                .getResultList();
        if (playerList.size() == 0) {
            System.out.println("There is not player with surname " + name);
            return null;
        }
        entityManager.getTransaction().commit();
        return playerList;
    }

    @Override
    public Player updatePlayer(Player player) {  //dziala

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type last name of the player you want to change: ");
        String lastNameOfThePlayer = scanner.nextLine();
        player.setSurName(lastNameOfThePlayer);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(player);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return player;

    }

    @Override
    public Boolean deletePlayerInTeam(Player player) {  // dziala
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        player = findPlayerById(player.getPlayerId());
        boolean isDeleted = false;
        try {
            entityManager.getTransaction().begin();
            player = entityManager.find(Player.class, player.getPlayerId());
            entityManager.remove(player);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            isDeleted = true;
        } catch (PersistenceException | NullPointerException e) {
            System.out.println(" Wrong implementation in algo!");
        }
        return isDeleted;
    }
}
