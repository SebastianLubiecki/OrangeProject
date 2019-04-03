package Service.Operations.Interfaces.Operation;

import Models.Game;
import Models.Team;

import java.util.List;

public interface gameOperations {

    List<Game> listOfGameWhereTeamScoreMoreThen(int numberOfPoint, Team team);

    public List<Game> getListOfGames(/*Long team_id*/);


}
