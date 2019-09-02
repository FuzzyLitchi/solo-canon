import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Projectile {
    PApplet parent;
    PVector position;
    PVector velocity;
    static PVector gravity = new PVector(0, 250);
    // percent of velocity regained after one second;
    static float friction = 0.80f;

    float rotation;
    float rotationSpeed;

    // Deadzone is a zone outside of the screen where projectiles die
    static float deadZone = 100;

    Projectile(PApplet parent, PVector position, PVector velocity, float rotation, float rotationSpeed) {
        this.parent = parent;
        this.position = position;
        this.velocity = velocity;
        this.rotation = rotation;
        this.rotationSpeed = rotationSpeed;
    }

    boolean update() {
        float dt = 1f/60f;
        // Duration of one frame.
        // We use this constant to compute physics

        // We add the velocity to the position
        position.add(velocity.copy().mult(dt));

        // Acceleration to the position
        velocity.add(gravity.copy().mult(dt));
        // Friction
        velocity.mult(parent.pow(friction, dt));

        // Rotation speed to rotation
        rotation += rotationSpeed * dt;

        // Deadzone on every side except the top so projectiles can fall back down
        if (position.x < 0-deadZone || position.x > parent.width+deadZone || /*position.y < 0-deadZone ||*/ position.y > parent.height+deadZone ) {
            // We return true when are ready for deletion
            return true;
        }

        return false;
    }

    void draw() {
        parent.pushMatrix();
        parent.rectMode(PConstants.CENTER);
        parent.translate(this.position.x, this.position.y);
        parent.rotate(rotation);
        parent.rect(0, 0, 30, 30);
        parent.popMatrix();
    }
}
