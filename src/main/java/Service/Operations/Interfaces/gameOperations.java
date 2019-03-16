package Service.Operations.Interfaces;

import Models.Game;

public interface gameOperations {

    Game insertNewGame (Game game);

    Game deleteGame ( Game game);

    Game updateGame (Game game);
// też do zastanowienia sie czy nie rozbic na osobną klase?
}
