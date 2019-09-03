import processing.core.PApplet;
import processing.core.PVector;

public class Camera {
    PApplet parent;
    PVector position;
    float rotation;
    float scale;

    Camera(PApplet parent, PVector position) {
        this.parent = parent;
        this.position = position;
        this.rotation = 0;
        this.scale = 1;
    }

    void set() {
        parent.pushMatrix();
        parent.translate(this.position.x, this.position.y);
        parent.rotate(rotation);
        //parent.scale(scale);
    }

    void unset() {
        parent.popMatrix();
    }

    PVector getWorldMousePosition() {
        return new PVector(parent.mouseX-position.x, parent.mouseY-position.y);
    }
}
