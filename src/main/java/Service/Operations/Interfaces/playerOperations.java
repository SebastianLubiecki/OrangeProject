package Service.Operations.Interfaces;

import Models.Player;
import Models.Team;

import java.util.List;

public interface playerOperations {

    Player insertNewPlayer(Player player);

    Boolean deletePlayerInTeam(/*Team team,*/ Player player);

    List<Player> getListOfPlayersInTeam(Team team);

    Player updatePlayer(Player player);
//update do zastanowienia

}
