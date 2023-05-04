package mateus.final_super_trunfo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class APP extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Help help = new Help(stage);
        Game game = new Game();
        Title title = new Title(stage,game);

        Scene mainTitle = new Scene(title,800,800);
        Scene mainHelp = new Scene(help,800,800);
        Scene mainGame = new Scene(game,800,800);

        title.addsc(mainTitle);
        title.addsc(mainHelp);
        title.addsc(mainGame);

        String titleCSS = Objects.requireNonNull(getClass()
                        .getResource("Title.css"))
                .toExternalForm();
        mainTitle.getStylesheets().add(titleCSS);
        help.getStylesheets().add(titleCSS);
        game.getStylesheets().add(titleCSS);

        stage.setResizable(false);
        stage.setScene(mainTitle);
        stage.setTitle("SuperTrunfo");

        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}