import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Tile {
    PApplet parent;
    PVector position;
    PImage texture;

    static float width = 50;
    static float height = 50;
    boolean dead = false;

    Tile(PApplet parent, PVector position, PImage texture) {
        this.parent = parent;
        this.position = position;
        this.texture = texture;
    }

    boolean update() {
        return dead;
    }

    void draw() {
        parent.image(texture, position.x, position.y);
    }
}
