package Service.Operations.Interfaces.CRUD;

import Models.Player;

import java.util.List;

public interface PlayerCRUD {

    Player insertNewPlayer(Player player);

    Player updatePlayer(Player player);

    Player getPlayerById(Long id);

    List<Player> getPlayerBySurName(String name);

    Boolean deletePlayerInTeam(/*Team team,*/ Player player);


}
