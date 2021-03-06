package com.example.ui;

import com.example.appl.GameCenter;
import com.example.appl.PlayerServices;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

import static spark.Spark.halt;

/**
 * The {@code POST /guess} route handler.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 * @author <a href='mailto:jrv@se.rit.edu'>Jim Vallino</a>
 */
public class PostGuessRoute implements Route {

    //
    // Constants
    //

    // Values used in the view-model map for rendering the game view after a guess.
    static final String GUESS_PARAM = "myGuess";
    static final String MESSAGE_ATTR = "message";
    static final String MESSAGE_TYPE_ATTR = "messageType";
    static final String YOU_WON_ATTR = "youWon";

    static final String ERROR_TYPE = "error";
    static final String BAD_GUESS = "Nope, try again...";
    static final String VIEW_NAME = "game_form.ftl";

    //
    // Static methods
    //
    private final GameCenter gameCenter;
    private final TemplateEngine templateEngine;

    //
    // Attributes
    //

    /**
     * The constructor for the {@code POST /guess} route handler.
     *
     * @param gameCenter     {@Link GameCenter} that holds over statistics
     * @param templateEngine template engine to use for rendering HTML page
     * @throws NullPointerException when the {@code gameCenter} or {@code templateEngine} parameter is null
     */
    PostGuessRoute(GameCenter gameCenter, TemplateEngine templateEngine) {
        // validation
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        Objects.requireNonNull(templateEngine, "templateEngine must not be null");
        //
        this.gameCenter = gameCenter;
        this.templateEngine = templateEngine;
    }

    /**
     * Make an error message when the guess is not a number.
     */
    static String makeBadArgMessage(final String guessStr) {
        return String.format("You entered '%s' but that's not a number.", guessStr);
    }

    //
    // Constructor
    //

    /**
     * Make an error message when the guess is not in the guessing range.
     */
    static String makeInvalidArgMessage(final String guessStr) {
        return String.format("You entered %s; make a guess between zero and nine.", guessStr);
    }

    //
    // TemplateViewRoute method
    //

    /**
     * {@inheritDoc}
     *
     * @throws NoSuchElementException when an invalid result is returned after making a guess
     */
    @Override
    public String handle(Request request, Response response) {
        // start building the View-Model
        final Map<String, Object> vm = new HashMap<>();
        vm.put(GetHomeRoute.TITLE_ATTR, GetGameRoute.TITLE);
        vm.put(GetHomeRoute.NEW_PLAYER_ATTR, Boolean.FALSE);

        // retrieve the game object
        final Session session = request.session();
        final PlayerServices playerServices = session.attribute(GetHomeRoute.PLAYERSERVICES_KEY);

        /* A null playerServices indicates a timed out session or an illegal request on this URL.
         * In either case, we will redirect back to home.
         */
        if (playerServices != null) {
            vm.put(GetGameRoute.GAME_BEGINS_ATTR, playerServices.isStartingGame());
            //vm.put(GetGameRoute.GUESSES_LEFT_ATTR, playerServices.guessesLeft());

            // retrieve request parameter
            final String guessStr = request.queryParams(GUESS_PARAM);


            // make the guess and create the appropriate ModelAndView for rendering
            ModelAndView mv;
            boolean b = playerServices.makeMove(guessStr);
            if (b) {
                mv = error(vm, makeInvalidArgMessage(guessStr));
            } else {
                mv = youWon(vm, playerServices);
            }

            return templateEngine.render(mv);
        } else {
            response.redirect(WebServer.HOME_URL);
            halt();
            return null;
        }
    }

    //
    // Private methods
    //

    private ModelAndView error(final Map<String, Object> vm, final String message) {
        vm.put(MESSAGE_ATTR, message);
        vm.put(MESSAGE_TYPE_ATTR, ERROR_TYPE);
        return new ModelAndView(vm, VIEW_NAME);
    }

    private ModelAndView youWon(final Map<String, Object> vm, final PlayerServices playerServices) {
        return endGame(true, vm, playerServices);
    }

    private ModelAndView youLost(final Map<String, Object> vm, final PlayerServices playerServices) {
        return endGame(false, vm, playerServices);
    }

    private ModelAndView endGame(final boolean youWonLost, final Map<String, Object> vm,
                                 final PlayerServices playerServices) {
        playerServices.finishedGame();
        // report application-wide game statistics
        vm.put(GetHomeRoute.GAME_STATS_MSG_ATTR, gameCenter.getGameStatsMessage());
        vm.put(YOU_WON_ATTR, youWonLost);
        return new ModelAndView(vm, GetHomeRoute.VIEW_NAME);
    }
}
