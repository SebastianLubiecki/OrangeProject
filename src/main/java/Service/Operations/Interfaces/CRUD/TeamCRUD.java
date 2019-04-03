package Service.Operations.Interfaces.CRUD;

import Models.Team;

public interface TeamCRUD {

    Team insertNewTeam(Team team);

    Team findTeamByName(String name);

    Team updateTeamName(Team team);

    Boolean deleteTeam(Team team);
}
