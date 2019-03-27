package Service.Operations.Implementation;

import Models.Player;
import Models.Team;
import Service.Operations.Interfaces.playerOperations;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class playerOperationImp implements playerOperations {

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

    public Player getPlayer(Long id) { //dziala
        Player player = new Player();
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

    public List<Player> getListOfPlayersInTeam(Team team) { // dziala
        List playerList;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String hql = " from Player where teamId = :teamId";
        System.out.println(team.getTeamId());
        Query query = entityManager.createQuery(hql).setParameter("teamId", team.getTeamId());
        playerList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        if (playerList == null) {
            System.out.println("No players found. ");
            return null;
        }

        return playerList;
    }

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


}