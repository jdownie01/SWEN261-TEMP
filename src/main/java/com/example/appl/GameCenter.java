package com.example.appl;

import com.example.model.CheckersGame;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * The object to coordinate the state of the Web Application and keep sitewide statistics.
 * <p>
 * This class is an example of the Pure Fabrication principle.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 * @author <a href='mailto:jrv@se.rit.edu'>Jim Vallino</a>
 */
public class GameCenter {
    // Output strings made public for unit test access
    public final static String NO_GAMES_MESSAGE = "No games have been started so far.";


    //
    // Constants
    //
    public final static String ONE_GAME_MESSAGE = "One game has been started so far.";
    public final static String GAMES_PLAYED_FORMAT = "There have been %d games started.";
    public final static String GAME_STARTED_TEMPLATE = "<li><a href=\"http://localhost:4567/game?name=TITLE\"class=\"fancy\">TITLE</a></li>";
    private static final Logger LOG = Logger.getLogger(GameCenter.class.getName());


    public ArrayList<CheckersGame> gamesArrayList;

    //
    // Attributes
    //
    private int totalGames = 0;

    //
    // Constructors
    //

    //
    // Public methods
    //

    /**
     * Get a new {@Linkplain PlayerServices} object to provide client-specific services to
     * the client who just connected to this application.
     *
     * @return A new {@Link PlayerServices}
     */
    public PlayerServices newPlayerServices() {
        LOG.fine("New player services instance created.");
        return new PlayerServices(this);
    }

    /**
     * Create a new {@Linkplain GuessGame} game.
     *
     * @return A new {@link CheckersGame}
     */
    public CheckersGame getGame() {
        return new CheckersGame();
    }

    /**
     * Collect sitewide statistics when a game is finished.
     */
    public void gameFinished() {
        // do some application-wide book-keeping
        synchronized (this) {  // protect the critical code
            totalGames++;
        }
    }

    public void addGame(String title){
        gamesArrayList.add(new CheckersGame(title));
    }

    /**
     * Get a user message about the sitewide statistics.
     *
     * @return The message to the user about global game statistics.
     */
    public synchronized String getGameStatsMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append("<ul>");
        if (gamesArrayList.size() >= 1) {
            for (CheckersGame game:gamesArrayList) {
                builder.append(GAME_STARTED_TEMPLATE.replace("TITLE",game.getName()));
            }
            builder.append("</ul>");
            return builder.toString();
        } else {
            return NO_GAMES_MESSAGE;
        }
    }
}
