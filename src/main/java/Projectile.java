import processing.core.PApplet;
import processing.core.PVector;

public class Projectile {
    PApplet parent;
    PVector position;
    PVector velocity;
    static PVector gravity = new PVector(0, 150);

    Projectile(PApplet parent, PVector position, PVector velocity) {
        this.parent = parent;
        this.position = position;
        this.velocity = velocity;
    }

    void update() {
        float dt = 1f/60f;
        // Duration of one frame.
        // We use this constant to compute physics

        // We add the velocity to the position
        this.position.add(this.velocity.copy().mult(dt));

        this.velocity.add(gravity.copy().mult(dt));
    }

    void draw() {
        parent.ellipse(this.position.x, this.position.y, 20, 20);
    }
}
