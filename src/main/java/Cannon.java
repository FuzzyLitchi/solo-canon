import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

import java.util.ArrayList;

public class Cannon {
    PApplet parent;
    PVector position;

    float rotation;
    static float width = 100;
    static float height = 50;

    Cannon(PApplet parent, PVector position) {
        this.parent = parent;
        this.position = position;
    }

    void update() {
        position.set(parent.mouseX, parent.mouseY);

        rotation += 0.03f;
    }

    void draw() {
        parent.pushMatrix();
        parent.rectMode(PConstants.CENTER);
        parent.translate(this.position.x, this.position.y);
        parent.rotate(rotation);
        parent.rect(0, 0, width, height);
        parent.popMatrix();
    }

    void shoot(ArrayList<Projectile> projectiles) {
        // This vector points to the end of the cannon
        PVector offset = new PVector(width/2, 0).rotate(rotation);

        projectiles.add(new Projectile(
            parent,
            position.copy().add(offset),
            new PVector(500,0).rotate(rotation),
            rotation,
            parent.random(-6f, 6f)
        ));
    }
}

