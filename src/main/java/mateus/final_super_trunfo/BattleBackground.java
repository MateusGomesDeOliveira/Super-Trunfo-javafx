package mateus.final_super_trunfo;

import javafx.scene.image.Image;

public class BattleBackground {
    private Image image;
    BattleBackground(Image image){
        this.image = image;
        Game.addBack(this);
    }
    public Image getImage() {
        return image;
    }
}
