package Service;

import Models.Game;
import Service.Operations.Implementation.gameOperationImp;
import Service.Operations.Implementation.teamOperationImp;
import Service.Operations.Interfaces.gameOperations;
import Service.Operations.Interfaces.teamOperations;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        teamOperations teamOperations = new teamOperationImp();
        gameOperations gameOperations = new gameOperationImp();

//             EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        Team team1 = new Team();
//        team1.setName("Celtics");
//        Team team2 = new Team();
//        team2.setName("Magic");
//        List<Team> teams = new ArrayList<>();
//        teams.add(team1);
//        teams.add(team2);
//
//        Player player1 = new Player();
//        Player player2 = new Player();
//        player1.setFirstName("Aneta");
//        player1.setSurName("Wrobel");
//        player1.setAge(28);
//        player1.setTeam(teamOperations.getTeam("Heat"));
//        player1.setExperience(6);
//
//        player2.setFirstName("Igor");
//        player2.setSurName("Żebrowski");
//        player2.setAge(29);
//        player2.setTeam(teamOperations.getTeam("Magic"));
//        player2.setExperience(1);
//
//        Game game = new Game();
//        game.setTeamAway(teamOperations.getTeam("Magic").getName());
//        game.setTeamAwayScore(140);
//        game.setTeamHomeScore(120);
//        game.setTeamHome(teamOperations.getTeam("Celtics").getName());
//       // game.setTeam(teams);
//        game.setTeamAwayWine(true);
//        game.setTeamHomeWine(false);
//
//        entityManager.getTransaction().begin();
////        entityManager.persist(team1);
////        entityManager.persist(team2);
////        entityManager.persist(player1);
////        entityManager.persist(player2);
//       entityManager.persist(game);
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();

        List<Game> list = teamOperations.listOfTeamGames(teamOperations.getTeam("Celtics"));
        //  Team team = teamOperations.getTeam("Heat");
        //Player player = new Player();
//        player.setSurName("Adi");
//        player.setTeam(team);
//        player.setAge(23);
//        player.setFirstName("asdasd");
        //    System.out.println("Team number " + team.getTeamId());
        // teamOperations.deleteTeam(team);


        for (Object o : list) {
            System.out.println(o);
        }

        // game operation imp do poprawy i sprawdzenia

    }
}
