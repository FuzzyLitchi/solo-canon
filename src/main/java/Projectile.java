import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Projectile {
    PApplet parent;
    PVector position;
    PVector velocity;
    static PVector gravity = new PVector(0, 150);

    float rotation;
    float rotationSpeed;

    Projectile(PApplet parent, PVector position, PVector velocity, float rotation, float rotationSpeed) {
        this.parent = parent;
        this.position = position;
        this.velocity = velocity;
        this.rotation = rotation;
        this.rotationSpeed = rotationSpeed;
    }

    void update() {
        float dt = 1f/60f;
        // Duration of one frame.
        // We use this constant to compute physics

        // We add the velocity to the position
        this.position.add(this.velocity.copy().mult(dt));

        // Acceleration to the position
        this.velocity.add(gravity.copy().mult(dt));

        // Rotation speed to rotation
        this.rotation += rotationSpeed * dt;
    }

    void draw() {
        parent.rectMode(PConstants.CENTER);
        parent.pushMatrix();
        parent.translate(this.position.x, this.position.y);
        parent.rotate(rotation);
        parent.rect(0, 0, 30, 30);
        parent.popMatrix();
    }
}
