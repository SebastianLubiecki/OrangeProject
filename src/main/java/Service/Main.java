package Service;

import Models.Player;
import Models.Team;
import Service.Operations.Implementation.CRUD.PlayerCRUDImplementation;
import Service.Operations.Implementation.CRUD.TeamCRUDImplementation;
import Service.Operations.Implementation.Operation.playerOperationImp;
import Service.Operations.Interfaces.CRUD.TeamCRUD;
import Service.Operations.Interfaces.Operation.PlayerOperations;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TeamCRUDImplementation teamCRUDImplementation = new TeamCRUDImplementation();
        PlayerOperations playerOperations = new playerOperationImp();
        Player player = new Player();
        Team team = new Team();
        team.setName("Cracow");
        //teamCRUDImplementation.insertNewTeam(team);
        team = teamCRUDImplementation.findTeamByName(team.getName());
        player.setFirstName("Aneta");
        player.setSurName("Wrobel");
        player.setAge(28);
        player.setExperience(20);
        player.setInjured(false);
        player.setRating(100);
        player.setTeam(team);
        Player player1 = new Player();
        team.setName("Cracow");
        player1.setFirstName("Anetaa");
        player1.setSurName("Wrobel");
        player1.setAge(28);
        player1.setExperience(20);
        player1.setInjured(false);
        player1.setRating(100);
        player1.setTeam(team);
        PlayerCRUDImplementation playerCRUDImplementation = new PlayerCRUDImplementation();
        playerCRUDImplementation.insertNewPlayer(player1);

       List<Player> list = playerOperations.getListOfPlayersInTeam(teamCRUDImplementation.findTeamByName("Cracow"));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
//             EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orangeproject");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
//        player1.setTeam(TeamOperations.getTeam("Heat"));
//        player1.setExperience(6);
//
//        player2.setFirstName("Igor");
//        player2.setSurName("Żebrowski");
//        player2.setAge(29);
//        player2.setTeam(TeamOperations.getTeam("Magic"));
//        player2.setExperience(1);
//
//        Game game = new Game();
//        game.setTeamAway(TeamOperations.getTeam("Magic").getName());
//        game.setTeamAwayScore(140);
//        game.setTeamHomeScore(120);
//        game.setTeamHome(TeamOperations.getTeam("Celtics").getName());
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


        //  Team team = TeamOperations.getTeam("Heat");
        //Player player = new Player();
//        player.setSurName("Adi");
//        player.setTeam(team);
//        player.setAge(23);
//        player.setFirstName("asdasd");
        //    System.out.println("Team number " + team.getTeamId());
        // TeamOperations.deleteTeam(team);


        // game operation imp do poprawy i sprawdzenia
    }
}
