package mateus.final_super_trunfo;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Title extends GridPane {
    public static List<Scene> scenes = new ArrayList<>();
    public Title(Stage stage, Game game) throws Exception {
        getStyleClass().add("background");

        HBox imagePlacement = new HBox();
        VBox buttonPlacement = new VBox();

        Image t1 = new Image(getClass().getResourceAsStream("TITLE1.png"));
        Image t2 = new Image(getClass().getResourceAsStream("TITLE2.png"));
        Image t3 = new Image(getClass().getResourceAsStream("TITLE3.png"));
        Image t4 = new Image(getClass().getResourceAsStream("TITLE4.png"));

        ImageView imageView = new ImageView();
        imageView.setImage(t1);
        imageView.setFitWidth(475);
        imageView.setPreserveRatio(true);

        imagePlacement.getChildren().add(imageView);
        imagePlacement.setAlignment(Pos.CENTER);

        Button b1 = new Button("Iniciar");
        b1.getStyleClass().add("botoes");
        b1.setOnAction(e->{
            stage.setScene(scenes.get(2));
            game.begin();
        });

        Button b2 = new Button("Ajuda");
        b2.getStyleClass().add("botoes");
        b2.setOnAction(e->stage.setScene(scenes.get(1)));

        Button b3 = new Button("Sair");
        b3.getStyleClass().add("botoes");
        b3.setOnAction(e->System.exit(0));

        buttonPlacement.setSpacing(50);
        buttonPlacement.setAlignment(Pos.CENTER);

        getColumnConstraints().addAll(cc(),cc(),cc(),cc(),cc());
        getRowConstraints().addAll(rc(),rc(),rc(),rc(),rc());

        add(imagePlacement,1,1,3,1);
        add(buttonPlacement,2,3,1,2);

        AtomicBoolean running = new AtomicBoolean(true);
        Thread t = new Thread(() -> {
            while(running.get()){
                try {
                    Thread.sleep(1000);
                    Platform.runLater(() ->{
                        if(running.get()){imageView.setImage(t2);}
                    });
                    Thread.sleep(1000);
                    Platform.runLater(() ->{
                        if(running.get()){imageView.setImage(t3);}
                    });
                    Thread.sleep(1000);
                    Platform.runLater(() ->{
                        if(running.get()){imageView.setImage(t4);buttonPlacement.getChildren().addAll(b1,b2,b3);}
                        running.set(false);
                    });
                } catch (Exception e){}
            }
        });
        setOnMouseClicked(e->{
            imageView.setImage(t4);
            if(buttonPlacement.getChildren().isEmpty()){
                buttonPlacement.getChildren().addAll(b1,b2,b3);
            }
            running.set(false);
        });
        t.setDaemon(true);
        t.start();
    }
    private ColumnConstraints cc() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPercentWidth(25);
        return cc;
    }
    private RowConstraints rc() {
        RowConstraints rc = new RowConstraints();
        rc.setPercentHeight(25);
        return rc;
    }
    public void addsc(Scene scene) {
        scenes.add(scene);
    }
}