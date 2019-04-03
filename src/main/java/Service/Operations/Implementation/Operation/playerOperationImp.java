package Service.Operations.Implementation.Operation;

import Models.Player;
import Models.Team;
import Service.Operations.Interfaces.Operation.playerOperations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class playerOperationImp implements playerOperations {


    @Override
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

    @Override
    public List<Player> getListOfInjuredPlayer() {
        List<Player> listOfInjuredPlayer;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        listOfInjuredPlayer = entityManager.createQuery("from Player p where isInjured= true", Player.class)
                .getResultList();
        entityManager.getTransaction().commit();
        if (listOfInjuredPlayer.size() == 0) {
            System.out.println("There is not any injured player");
            return null;
        }
        return listOfInjuredPlayer;
    }

    @Override
    public List<Player> getListPlayerWithExperienceMoreThen(int numberOfYer) {
        List<Player> playerList;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orsngeproject");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        playerList = entityManager.createQuery("from Player where experience>:number", Player.class)
                .setParameter("number", numberOfYer)
                .getResultList();
        entityManager.getTransaction().commit();

        if (playerList.size() == 0) {
            System.out.println("There is no player with exp bigger then " + numberOfYer);
            return null;
        }
        return playerList;
    }

}