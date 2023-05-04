package mateus.final_super_trunfo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.List;

public class Help extends GridPane {
    private static List<Scene> scenes = Title.scenes;
    private static int page = 0;
    private Button foward = new Button("→");
    private Button backward = new Button("←");
    private HBox arrowBox = new HBox();
    private ImageView imageView = new ImageView();
    private Image r1 = new Image(getClass().getResourceAsStream("RULES1.png"));
    private Image r2 = new Image(getClass().getResourceAsStream("RULES2.png"));
    private Image r3 = new Image(getClass().getResourceAsStream("RULES3.png"));
    public Help(Stage stage) throws Exception {

        imageView.setImage(r1);
        imageView.setFitWidth(475);
        imageView.setPreserveRatio(true);

        getStyleClass().add("background");
        getColumnConstraints().addAll(cc(),cc(),cc(),cc(),cc());
        getRowConstraints().addAll(rc(),rc(),rc(),rc(),rc());

        foward.setOnAction(e->{
            page += 1;
            pageChange();
        });
        foward.getStyleClass().add("arrows");

        backward.setOnAction(e->{
            page -= 1;
            pageChange();
        });
        backward.getStyleClass().add("arrows");

        Button back = new Button("Voltar");
        back.setOnAction(e->{
            stage.setScene(scenes.get(0));
            imageView.setImage(r1);
            arrowBox.getChildren().clear();
            arrowBox.getChildren().add(foward);
            page = 0;
        });
        back.getStyleClass().add("botoes");

        HBox imagePlacement = new HBox();
        imagePlacement.setPadding(new Insets(0,0,-50,0));
        imagePlacement.getChildren().add(imageView);

        VBox backBox = new VBox();

        arrowBox.setSpacing(50);
        arrowBox.getChildren().add(foward);
        arrowBox.setAlignment(Pos.CENTER);

        backBox.setSpacing(50);
        backBox.getChildren().add(back);
        backBox.setAlignment(Pos.CENTER);

        add(imagePlacement,1,1,3,1);
        add(arrowBox,2,3,1,1);
        add(backBox,2,4,1,1);
    }

    private void pageChange() {
        if(page == 1){
            imageView.setImage(r2);
            arrowBox.getChildren().clear();
            arrowBox.getChildren().add(backward);
            arrowBox.getChildren().add(foward);
        } else if(page == 2){
            imageView.setImage(r3);
            arrowBox.getChildren().clear();
            arrowBox.getChildren().add(backward);
        } else if(page == 0){
            imageView.setImage(r1);
            arrowBox.getChildren().clear();
            arrowBox.getChildren().add(foward);
        }
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
}