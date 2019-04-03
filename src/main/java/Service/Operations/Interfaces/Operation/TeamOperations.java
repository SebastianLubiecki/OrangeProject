package Service.Operations.Interfaces.Operation;

import Models.Game;
import Models.Player;
import Models.Team;

import java.util.List;

public interface TeamOperations {

    List<Team> getListOfTeams();

    List<Game> listOfTeamGames(Team team);

    List<Game> listOfWingingGamesGivenTeam(Team team);

    List<Game> listOfLosingGamesGivenTeam(Team team);

    List<Game> listOfTeamGamesAgainstGivenTeam(Team team, Team enemy);

    List<Player> listOfInjuredPlayerInTeam(Team team);
}
