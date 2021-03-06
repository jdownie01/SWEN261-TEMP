package com.example;

import com.example.appl.GameCenter;
import com.example.ui.WebServer;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.InputStream;
import java.util.Objects;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * The entry point for the Guessing Game web application.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public final class Application {
    private static final Logger LOG = Logger.getLogger(Application.class.getName());

    //
    // Application Launch method
    //
    private final WebServer webServer;

    //
    // Attributes
    //

    private Application(final WebServer webServer) {
        // validation
        Objects.requireNonNull(webServer, "webServer must not be null");
        //
        this.webServer = webServer;
    }

    //
    // Constructor
    //

    /**
     * Entry point for the Guessing Game web application.
     *
     * <p>
     * It wires the application components together.  This is an example
     * of <a href='https://en.wikipedia.org/wiki/Dependency_injection'>Dependency Injection</a>
     * </p>
     *
     * @param args Command line arguments; none expected.
     */
    public static void main(String[] args) {
        // initialize Logging
        try {
            ClassLoader classLoader = Application.class.getClassLoader();
            final InputStream logConfig = classLoader.getResourceAsStream("log.properties");
            LogManager.getLogManager().readConfiguration(logConfig);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Could not initialize log manager because: " + e.getMessage());
        }

        // create the one and only game center
        final GameCenter gameCenter = new GameCenter();

        // The application uses FreeMarker templates to generate the HTML
        // responses sent back to the client. This will be the engine processing
        // the templates and associated data.
        final TemplateEngine templateEngine = new FreeMarkerEngine();

        // inject the game center and freemarker engine into web server
        // This is an example of the Dependency inversion principle where the
        // GameCenter and WebServer dependencies are injected into the object.
        final WebServer webServer = new WebServer(gameCenter, templateEngine);

        // inject web server into application
        // This is an example of the Dependency inversion principle where the
        // WebServer dependency is injected into the object.
        final Application app = new Application(webServer);

        // start the application up
        app.initialize();
    }

    //
    // Private methods
    //

    private void initialize() {
        LOG.config("Application is initializing.");

        // configure Spark and startup the Jetty web server
        webServer.initialize();

        // other applications might have additional services to configure
        LOG.config("Application initialization complete.");
    }

}
