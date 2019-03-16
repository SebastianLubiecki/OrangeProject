package Service.Operations.Interfaces;

import Models.Game;
import Models.Team;

import java.util.List;

public interface teamOperations {

    Team insertNewTeam(Team team);

    Boolean deleteTeam(Team team);

    Team updateTeamName (Team team);

    List<Team> getListOfTeams();

    List<Game> listOfTeamGames(Team team);

}
