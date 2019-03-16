package Service.Operations.Implementation;

import Models.Player;
import Models.Team;
import Service.Operations.Interfaces.playerOperations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.util.List;

public class playerOperationImp implements playerOperations {

    public Player insertNewPlayer(Player player) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(player);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return player;
    }


    public Boolean deletePlayerInTeam(Player player) {
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
        } catch (PersistenceException | NullPointerException e) {// mozna rozbic na dwa w zaleznosci od bledu, do poprawy!
            System.out.println(" Wrong implementation in algo!");
        }
        return isDeleted;
    }

    private Player findPlayerById(Long id) {
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

    public List<Player> getListOfPlayersInTeam(Team team) {
     //   List listOfPlayr
        return null;
    }

    public Player updatePlayer(Player player) {
        return null;
    }


    public static void main(String[] args) {
        playerOperations playerOperations = new playerOperationImp();

        Player player1 = new Player();
        player1.setExperience(3);
        player1.setSurName("sadadsawe65r78");

        playerOperations.insertNewPlayer(player1);

      /*   Player player2 = new Player();
        player2.setExperience(3);
        player2.setSurName("sadadsawe65r78");
        playerOperations playerOperations2 = new playerOperationImp();
        playerOperations2.insertNewPlayer(player);

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        playerList.add(player2);
        playerOperations playerOperations3 = new playerOperationImp();



        Team team = new Team();
        team.setName("Aneta");
        team.setPlayerList(playerList);
        */
        Player player = new Player();
        player.setPlayerId(4L);

        playerOperations.deletePlayerInTeam(player);
    }
}