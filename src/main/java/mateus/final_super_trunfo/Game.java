package mateus.final_super_trunfo;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Game extends GridPane {
    private static List<BattleBackground> backgrounds = new ArrayList<>();
    private static List<Card> fullDeck = new ArrayList<>();
    private static List<Card> npcDeck = new ArrayList<>();
    private static List<Card> playerDeck = new ArrayList<>();
    private static int turn = 0;
    private static int playing;
    private boolean playersTurn;
    private HBox backGround = new HBox();
    private VBox playerCardNumber = new VBox();
    private VBox npcCardNumber = new VBox();
    private ImageView playerCard = new ImageView();
    private Image cardBack = new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_BACK.png"));
    private ImageView npcCard = new ImageView(cardBack);
    private HBox turnNumber = new HBox();
    private HBox whosTurn = new HBox();
    private HBox shuffle = new HBox(new Label("Embaralhando"));
    private HBox winner = new HBox();
    private HBox restart = new HBox();
    private static String winningCondition;
    private static int turnsInRow;
    private static int npcChoice;
    private static int playersChoice;
    private static int npcValue;
    private static int playerValue;
    private static AtomicBoolean npcBehavior = new AtomicBoolean(true);
    private static ImageView npcImage = new ImageView();
    private Image npcLost = new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\NPCLOST.png"));
    private Image npcBase = new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\NPCBASE.png"));
    private Image npcBase2 = new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\NPCBASE2.png"));
    public Game() throws Exception{
        getStyleClass().add("background");
        getColumnConstraints().addAll(cc(),cc(),cc(),cc(),cc());
        getRowConstraints().addAll(rc(),rc(),rc(),rc(),rc());

        Card s1 = new Card("Commander",9,4,8,new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_S1.png")));
        Card s2 = new Card("Shilder Man",8,9,4,new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_S2.png")));
        Card s3 = new Card("Ultra Witch",4,8,9,new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_S3.png")));

        Card a1 = new Card("Void Duelist",8,3,5,new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_A1.png")));
        Card a2 = new Card("Cake Hero",5,8,3,new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_A2.png")));
        Card a3 = new Card("Water Witch",3,5,8,new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_A3.png")));

        Card w1 = new Card("Lil' Battery",4,1,2,new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_W1.png")));
        Card w2 = new Card("Bubble Frog",2,4,1,new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_W2.png")));
        Card w3 = new Card("Lil' Prince",1,2,4,new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_W3.png")));

        Card j1 = new Card("BABA",7,0,0,new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_J1.png")));
        Card j2 = new Card("BIBI",0,7,0,new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_J2.png")));
        Card j3 = new Card("BOBO",0,0,7,new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_J3.png")));

        Card m1 = new Card("Mediocre",4,4,4,new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_M.png")));
        Card m2 = new Card("Mediocre+",5,5,5,new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\CARD_M+.png")));


        BattleBackground b1 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Castle.png")));
        BattleBackground b2 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Clouds.png")));
        BattleBackground b3 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Cobblestones1.png")));
        BattleBackground b4 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Cobblestones2.png")));
        BattleBackground b5 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Cobblestones3.png")));
        BattleBackground b6 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Cobblestones4.png")));
        BattleBackground b7 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Crystal1.png")));
        BattleBackground b8 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Crystal2.png")));
        BattleBackground b9 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\DarkSpace.png")));
        BattleBackground b10 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\DecorativeTile.png")));
        BattleBackground b11 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\DemonCastle.png")));
        BattleBackground b12 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\DemonicWorld1.png")));
        BattleBackground b13 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\DemonicWorld2.png")));
        BattleBackground b14 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Desert.png")));
        BattleBackground b15 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Dirt1.png")));
        BattleBackground b16 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Dirt2.png")));
        BattleBackground b17 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\DirtCave.png")));
        BattleBackground b18 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\DirtField.png")));
        BattleBackground b19 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Factory1.png")));
        BattleBackground b20 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Factory2.png")));
        BattleBackground b21 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Fort.png")));
        BattleBackground b22 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Grassland.png")));
        BattleBackground b23 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\GrassMaze.png")));
        BattleBackground b24 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\IceCave.png")));
        BattleBackground b25 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\IceMaze.png")));
        BattleBackground b26 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\InBody.png")));
        BattleBackground b27 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Lava1.png")));
        BattleBackground b28 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Lava2.png")));
        BattleBackground b29 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\LavaCave.png")));
        BattleBackground b30 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Meadow.png")));
        BattleBackground b31 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Paved.png")));
        BattleBackground b32 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\PoisonSwamp.png")));
        BattleBackground b33 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Road1.png")));
        BattleBackground b34 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Road2.png")));
        BattleBackground b35 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Road3.png")));
        BattleBackground b36 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\RockCave1.png")));
        BattleBackground b37 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\RockCave2.png")));
        BattleBackground b38 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Ruins1.png")));
        BattleBackground b39 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Ruins2.png")));
        BattleBackground b40 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Ruins3.png")));
        BattleBackground b41 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Sand.png")));
        BattleBackground b42 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Ship.png")));
        BattleBackground b43 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Sky.png")));
        BattleBackground b44 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Snow.png")));
        BattleBackground b45 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Snowfield.png")));
        BattleBackground b46 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Stone1.png")));
        BattleBackground b47 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Stone2.png")));
        BattleBackground b48 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Stone3.png")));
        BattleBackground b49 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Tent.png")));
        BattleBackground b50 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Translucent.png")));
        BattleBackground b51 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Wasteland.png")));
        BattleBackground b52 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\WireMesh.png")));
        BattleBackground b53 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Wood1.png")));
        BattleBackground b54 = new BattleBackground(new Image(new FileInputStream("C:\\Users\\Mateus\\PORTIFOLIO BACKEND\\final_super_trunfo\\src\\main\\resources\\mateus\\final_super_trunfo\\BACKGROUNDS\\Wood2.png")));

        add(backGround,0,0,5,5);
        add(playerCardNumber,0,1,1,1);
        add(npcCardNumber,4,1,1,1);

        playerCardNumber.getStyleClass().add("deck");
        playerCardNumber.setAlignment(Pos.BASELINE_LEFT);
        npcCardNumber.getStyleClass().add("deck");
        npcCardNumber.setAlignment(Pos.BASELINE_RIGHT);

        HBox imagePlacement1 = new HBox();
        imagePlacement1.setAlignment(Pos.CENTER);
        imagePlacement1.setPadding(new Insets(0,0,-130,-170));

        playerCard.setImage(cardBack);
        playerCard.setFitWidth(475);
        playerCard.setPreserveRatio(true);

        imagePlacement1.getChildren().add(playerCard);

        HBox imagePlacement2 = new HBox();
        imagePlacement2.setAlignment(Pos.CENTER);
        imagePlacement2.setPadding(new Insets(0,0,-130,-150));

        npcCard.setFitWidth(475);
        npcCard.setPreserveRatio(true);

        imagePlacement2.getChildren().add(npcCard);

        HBox imagePlacement3 = new HBox();
        imagePlacement3.setAlignment(Pos.CENTER);
        imagePlacement3.setPadding(new Insets(0,0,-185,-75));

        npcImage.setFitWidth(300);
        npcImage.setPreserveRatio(true);

        imagePlacement3.getChildren().add(npcImage);

        BackgroundFill bf = new BackgroundFill(Color.LIGHTGRAY,
                CornerRadii.EMPTY, new Insets(0,0,100,0));

        turnNumber.getStyleClass().add("turn");
        turnNumber.setAlignment(Pos.TOP_CENTER);
        turnNumber.setBackground(new Background(bf));

        VBox choice = new VBox();

        choice.setSpacing(23);
        choice.setAlignment(Pos.TOP_RIGHT);

        Button atck = new Button("■");
        atck.setOnAction(e->{
            if(playersTurn && winningCondition.equals("")){
                turnsInRow += 1;
                playersTurn = false;
                playersChoice = 0;
                player();
            }
        });
        Button def = new Button("■");
        def.setOnAction(e->{
            if(playersTurn && winningCondition.equals("")){
                turnsInRow += 1;
                playersTurn = false;
                playersChoice = 1;
                player();
            }
        });
        Button mag = new Button("■");
        mag.setOnAction(e->{
            if(playersTurn && winningCondition.equals("")){
                turnsInRow += 1;
                playersTurn = false;
                playersChoice = 2;
                player();
            }
        });

        choice.getChildren().addAll(atck,def,mag);

        whosTurn.getStyleClass().add("turn");
        whosTurn.setAlignment(Pos.TOP_CENTER);
        whosTurn.setBackground(new Background(bf));

        npcImage.setImage(npcBase);

        add(imagePlacement1,1,1);
        add(imagePlacement2,3,1);
        add(imagePlacement3,2,3);
        add(choice,1,2);
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
    public static void addCard(Card card){
        fullDeck.add(card);
    }
    public static void addBack(BattleBackground background){
        backgrounds.add(background);
    }
    public void begin() {
        npcBehavior.set(true);
        Thread npcGif = new Thread(() -> {
            while(npcBehavior.get()){
                try {
                    Thread.sleep(1000);
                    Platform.runLater(() -> npcImage.setImage(npcBase));
                    Thread.sleep(1000);
                    Platform.runLater(() -> npcImage.setImage(npcBase2));
                } catch (Exception e){}
            }
            Platform.runLater(() -> npcImage.setImage(npcLost));
        });

        npcGif.setDaemon(true);
        npcGif.start();

        winningCondition = "";
        turn = 0;
        turnsInRow = 0;
        playerCardNumber.getChildren().clear();
        playerCardNumber.setBackground(Background.EMPTY);
        npcCardNumber.getChildren().clear();
        npcCardNumber.setBackground(Background.EMPTY);
        backGround.setBackground(Background.EMPTY);
        shuffle.getChildren().clear();
        restart.getChildren().clear();
        winner.getChildren().clear();
        getChildren().remove(restart);
        getChildren().removeAll(winner);
        getChildren().remove(turnNumber);
        getChildren().remove(whosTurn);
        getChildren().removeAll(shuffle);
        playerCard.setImage(cardBack);
        npcCard.setImage(cardBack);
        Random rnd = new Random();
        //0 -> NPC / 1 -> PLAYER
        int playsFirst = rnd.nextInt(0,2);
        playing = playsFirst;
        if(fullDeck.isEmpty()){
            while(!npcDeck.isEmpty()){
                int r = rnd.nextInt(0,npcDeck.size());
                fullDeck.add(npcDeck.get(r));
                npcDeck.remove(r);
            }
            while(!playerDeck.isEmpty()){
                int r = rnd.nextInt(0,playerDeck.size());
                fullDeck.add(playerDeck.get(r));
                playerDeck.remove(r);
            }
        }
        while(fullDeck.size()>npcDeck.size()){
            int r = rnd.nextInt(0,fullDeck.size());
            npcDeck.add(fullDeck.get(r));
            fullDeck.remove(r);
        }
        while(!fullDeck.isEmpty()){
            int r = rnd.nextInt(0,fullDeck.size());
            playerDeck.add(fullDeck.get(r));
            fullDeck.remove(r);
        }

        shuffle.setAlignment(Pos.CENTER);
        shuffle.getStyleClass().add("shuffle");

        Thread z = new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(500);
                    Platform.runLater(() ->{
                        shuffle.getChildren().clear();
                        shuffle.getChildren().add(new Label("Embaralhando ."));
                    });
                    Thread.sleep(500);
                    Platform.runLater(() ->{
                        shuffle.getChildren().clear();
                        shuffle.getChildren().add(new Label("Embaralhando . ."));
                    });
                    Thread.sleep(500);
                    Platform.runLater(() ->{
                        shuffle.getChildren().clear();
                        shuffle.getChildren().add(new Label("Embaralhando . . ."));
                    });
                    Thread.sleep(500);
                    Platform.runLater(() ->{
                        shuffle.getChildren().clear();
                        shuffle.getChildren().add(new Label("Definindo quem começa . . ."));
                    });
                    Thread.sleep(1500);
                    Platform.runLater(() ->{
                        shuffle.getChildren().clear();
                        if(playsFirst == 0){
                            shuffle.getChildren().add(new Label("NPC COMEÇA!"));
                        } if (playsFirst == 1){
                            shuffle.getChildren().add(new Label("PLAYER COMEÇA!"));
                        }
                    });
                    Thread.sleep(1000);
                    Platform.runLater(() ->{
                        shuffle.getChildren().clear();
                        getChildren().removeAll(shuffle);
                        playerCard.setImage(playerDeck.get(0).getImage());
                        add(turnNumber,2,0);
                        add(whosTurn,0,0,2,1);

                        BackgroundFill bf = new BackgroundFill(Color.LIGHTGRAY,
                                CornerRadii.EMPTY, new Insets(0,50,60,0));
                        BackgroundFill bf2 = new BackgroundFill(Color.LIGHTGRAY,
                                CornerRadii.EMPTY, new Insets(0,0,60,45));

                        playerCardNumber.setBackground(new Background(bf));
                        npcCardNumber.setBackground(new Background(bf2));

                        playerCardNumber.getChildren().add(new Label("Baralho:"));
                        playerCardNumber.getChildren().add(new Label(playerDeck.size() +" Cartas"));
                        npcCardNumber.getChildren().add(new Label("Baralho:"));
                        npcCardNumber.getChildren().add(new Label(npcDeck.size() +" Cartas"));
                    });
                    break;
                } catch (Exception e){}
            }
            round();
        });
        z.setDaemon(true);
        z.start();

        add(shuffle,1,2,3,1);
    }
    public void round() {
        Random rnd = new Random();
        backGround.setBackground(Background.EMPTY);
        int r = rnd.nextInt(0,backgrounds.size());
        BackgroundSize bs = new BackgroundSize(800,800,false,false,false,false);
        BackgroundImage bi = new BackgroundImage(backgrounds.get(r).getImage(),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,bs);
        backGround.setBackground(new Background(bi));

        if(winningCondition.equals("")){
            turn += 1;
            Platform.runLater(() ->{
                turnNumber.getChildren().clear();
                turnNumber.getChildren().add(new Label("Turno "+turn));
            });
        }

        if(!winningCondition.equals("")){
            BackgroundFill bf = new BackgroundFill(Color.LIGHTGRAY,
                    CornerRadii.EMPTY, new Insets(0,0,100,0));

            winner.getStyleClass().add("turn");
            winner.setAlignment(Pos.TOP_CENTER);
            winner.setBackground(new Background(bf));

            Button restartButton = new Button("Recomeçar?");
            restartButton.setOnAction(e-> begin());

            restart.getStyleClass().add("botoes");
            restart.setAlignment(Pos.CENTER);
            restart.getChildren().add(restartButton);

            Platform.runLater(() -> add(restart,0,4,2,1));

            if(winningCondition.equals("npc")){
                Platform.runLater(() ->{
                    add(winner,0,0,5,1);
                    winner.getChildren().add(new Label("NPC GANHOU EM "+turn+" TURNOS!"));
                });
            }
            else if(winningCondition.equals("player")){
                npcBehavior.set(false);
                Platform.runLater(() ->{
                    add(winner,0,0,5,1);
                    winner.getChildren().add(new Label("PLAYER GANHOU EM "+turn+" TURNOS!"));
                });
            }
        } else if(playing == 0){
            Platform.runLater(() ->{
                whosTurn.getChildren().clear();
                whosTurn.getChildren().add(new Label("TURNO DO NPC"));
            });
            npc();
        } else if(playing == 1){
            Platform.runLater(() ->{
                whosTurn.getChildren().clear();
                whosTurn.getChildren().add(new Label("TURNO DO PLAYER"));
            });
            playersTurn = true;
        }
    }
    private void npc() {
        turnsInRow += 1;
        Random rnd = new Random();
        List<Integer> valuesNpc = new ArrayList<>();
        List<Integer> valuesPlayer = new ArrayList<>();
        valuesNpc.add(npcDeck.get(0).getAtck());
        valuesNpc.add(npcDeck.get(0).getDef());
        valuesNpc.add(npcDeck.get(0).getMag());
        valuesPlayer.add(playerDeck.get(0).getAtck());
        valuesPlayer.add(playerDeck.get(0).getDef());
        valuesPlayer.add(playerDeck.get(0).getMag());

        if (npcDeck.get(0).getNome().equals("Mediocre")||npcDeck.get(0).getNome().equals("Mediocre+")){
            npcChoice = rnd.nextInt(0,valuesNpc.size());
        } else {
            Comparator<Integer> maior = Integer::compareTo;
            npcChoice = valuesNpc.indexOf(valuesNpc.stream().max(maior).get());
        }

        npcValue = valuesNpc.get(npcChoice);
        playerValue = valuesPlayer.get(npcChoice);

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1500);
                Platform.runLater(() ->{
                    getChildren().removeAll(shuffle);
                    shuffle.getChildren().clear();
                    add(shuffle,1,2,3,1);
                    shuffle.getChildren().add(new Label("NPC ESCOLHEU "+type(npcChoice)));
                    npcCard.setImage(npcDeck.get(0).getImage());
                });
                Thread.sleep(1500);
                Platform.runLater(() ->{
                    getChildren().removeAll(shuffle);
                    shuffle.getChildren().clear();
                });
                Thread.sleep(1500);
            } catch (Exception e){}
            whoWon();
        });
        t.setDaemon(true);
        t.start();
    }
    private String type(int i){
        if(i == 0){
            return "ATAQUE!";
        }
        else if(i == 1){
            return "DEFESA!";
        }
        else if(i == 2){
            return "MAGIA!";
        }
        return "ERROR!";
    }
    private void player(){
        List<Integer> valuesPlayer = new ArrayList<>();
        List<Integer> valuesNpc = new ArrayList<>();

        valuesPlayer.add(playerDeck.get(0).getAtck());
        valuesPlayer.add(playerDeck.get(0).getDef());
        valuesPlayer.add(playerDeck.get(0).getMag());
        valuesNpc.add(npcDeck.get(0).getAtck());
        valuesNpc.add(npcDeck.get(0).getDef());
        valuesNpc.add(npcDeck.get(0).getMag());

        playerValue = valuesPlayer.get(playersChoice);
        npcValue = valuesNpc.get(playersChoice);

        npcCard.setImage(npcDeck.get(0).getImage());

        whoWon();
    }
    private void whoWon() {
        if(playerValue < npcValue){

            npcDeck.add(playerDeck.get(0));
            playerDeck.remove(0);
            npcDeck.add(npcDeck.get(0));
            npcDeck.remove(0);

            if(playerDeck.isEmpty()){
                winningCondition = "npc";
            }

            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    Platform.runLater(() ->{
                        getChildren().removeAll(shuffle);
                        shuffle.getChildren().clear();
                        add(shuffle,1,2,3,1);
                        shuffle.getChildren().add(new Label("NPC GANHOU!"));
                    });
                    Thread.sleep(1500);
                    Platform.runLater(() ->{
                        playerCardNumber.getChildren().clear();
                        npcCardNumber.getChildren().clear();

                        playerCardNumber.getChildren().add(new Label("Baralho:"));
                        playerCardNumber.getChildren().add(new Label(playerDeck.size() +" Cartas"));
                        npcCardNumber.getChildren().add(new Label("Baralho:"));
                        npcCardNumber.getChildren().add(new Label(npcDeck.size() +" Cartas"));

                        getChildren().removeAll(shuffle);
                        shuffle.getChildren().clear();

                        if(winningCondition.equals("")){
                            playerCard.setImage(playerDeck.get(0).getImage());
                            npcCard.setImage(cardBack);
                        }
                    });
                } catch (Exception e){}

                if(turnsInRow == 3 && playing == 0 && winningCondition.equals("")){
                    turnsInRow = 0;
                    playing = 1;
                    Platform.runLater(() ->{
                        getChildren().removeAll(shuffle);
                        shuffle.getChildren().clear();
                        add(shuffle,0,2,5,1);
                        shuffle.getChildren().add(new Label("GANHOU 3x SEGUIDAS! VEZ DO PLAYER!"));
                    });
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e){}
                    Platform.runLater(() ->{
                        getChildren().removeAll(shuffle);
                        shuffle.getChildren().clear();
                    });
                } else if(playing == 1 && winningCondition.equals("")){
                    turnsInRow = 0;
                    playing = 0;
                }
                round();
            });
            t.setDaemon(true);
            t.start();
        } else if(playerValue > npcValue){

            playerDeck.add(npcDeck.get(0));
            npcDeck.remove(0);
            playerDeck.add(playerDeck.get(0));
            playerDeck.remove(0);

            if(npcDeck.isEmpty()){
                winningCondition = "player";
            }

            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    Platform.runLater(() ->{
                        getChildren().removeAll(shuffle);
                        shuffle.getChildren().clear();
                        add(shuffle,1,2,3,1);
                        shuffle.getChildren().add(new Label("PLAYER GANHOU!"));
                    });
                    Thread.sleep(1500);
                    Platform.runLater(() ->{
                        playerCardNumber.getChildren().clear();
                        npcCardNumber.getChildren().clear();

                        playerCardNumber.getChildren().add(new Label("Baralho:"));
                        playerCardNumber.getChildren().add(new Label(playerDeck.size() +" Cartas"));
                        npcCardNumber.getChildren().add(new Label("Baralho:"));
                        npcCardNumber.getChildren().add(new Label(npcDeck.size() +" Cartas"));

                        getChildren().removeAll(shuffle);
                        shuffle.getChildren().clear();

                        if(winningCondition.equals("")){
                            playerCard.setImage(playerDeck.get(0).getImage());
                            npcCard.setImage(cardBack);
                        }
                    });
                } catch (Exception e){}

                if(turnsInRow == 3 && playing == 1 && winningCondition.equals("")){
                    turnsInRow = 0;
                    playing = 0;
                    Platform.runLater(() ->{
                        getChildren().removeAll(shuffle);
                        shuffle.getChildren().clear();
                        add(shuffle,0,2,5,1);
                        shuffle.getChildren().add(new Label("GANHOU 3x SEGUIDAS! VEZ DO NPC!"));
                    });
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e){}
                    Platform.runLater(() ->{
                        getChildren().removeAll(shuffle);
                        shuffle.getChildren().clear();
                    });
                } else if(playing == 0 && winningCondition.equals("")){
                    turnsInRow = 0;
                    playing = 1;
                }
                round();
            });
            t.setDaemon(true);
            t.start();
        } else if(playerValue == npcValue){

            npcDeck.add(npcDeck.get(0));
            npcDeck.remove(0);
            playerDeck.add(playerDeck.get(0));
            playerDeck.remove(0);

            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    Platform.runLater(() ->{
                        getChildren().removeAll(shuffle);
                        shuffle.getChildren().clear();
                        add(shuffle,1,2,3,1);
                        shuffle.getChildren().add(new Label("EMPATOU!"));
                    });
                    Thread.sleep(1500);
                    Platform.runLater(() ->{
                        getChildren().removeAll(shuffle);
                        shuffle.getChildren().clear();

                        playerCard.setImage(playerDeck.get(0).getImage());
                        npcCard.setImage(cardBack);
                    });
                } catch (Exception e){}
                if (playing == 0){playing = 1;turnsInRow = 0;}
                else if (playing == 1){playing = 0;turnsInRow = 0;}
                round();
            });
            t.setDaemon(true);
            t.start();
        }
    }
}