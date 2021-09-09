package com.example.ui;

import com.example.appl.PlayerServices;
import com.example.model.CheckersGame;
import jdk.jfr.internal.Logger;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.halt;

/**
 * The {@code GET /game} route handler.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 * @author <a href='mailto:jrv@se.rit.edu'>Jim Vallino</a>
 */
public class GetGameRoute implements Route {

    // Values used in the view-model map for rendering the game view.
    static final String GAME_BEGINS_ATTR = "isFirstGuess";
    static final String GUESSES_LEFT_ATTR = "guessesLeft";
    static final String TITLE = "Checkers TITLE";
    static final String TITLE_ATTR = "title";
    static final String VIEW_NAME = "game_form.ftl";
    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(WebServer.class.getName());
    private final TemplateEngine templateEngine;

    /**
     * The constructor for the {@code GET /game} route handler.
     *
     * @param templateEngine The {@link TemplateEngine} used for rendering page HTML.
     */
    GetGameRoute(final TemplateEngine templateEngine) {
        // validation
        Objects.requireNonNull(templateEngine, "templateEngine must not be null");
        //
        this.templateEngine = templateEngine;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String handle(Request request, Response response) {
        final Map<String, Object> vm = new HashMap<>();
        vm.put(TITLE_ATTR, TITLE);
        LOG.config(request.queryParams("name"));
        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
}
