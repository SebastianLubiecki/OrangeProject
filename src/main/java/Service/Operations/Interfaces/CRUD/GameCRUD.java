package Service.Operations.Interfaces.CRUD;

import Models.Game;

public interface GameCRUD {

    Game insertNewGame(Game game);

    Boolean deleteGame(Game game);

    Game updateGame(Game game);
}
