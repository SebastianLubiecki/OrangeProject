package Service.Operations.Interfaces.Operation;

import Models.Player;
import Models.Team;

import java.util.List;

public interface playerOperations {


    List<Player> getListOfPlayersInTeam(Team team);

    List<Player> getListOfInjuredPlayer();

    List<Player> getListPlayerWithExperienceMoreThen(int numberOfYer);
}
