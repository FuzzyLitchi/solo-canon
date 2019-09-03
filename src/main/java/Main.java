import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Main extends PApplet{
    ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    Cannon cannon;
    Camera camera;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings(){
        size(800,600);
    }

    public void setup(){
        this.camera = new Camera(this, new PVector(0, 0));

        this.cannon = new Cannon(
            this,
            new PVector(0,0)
        );
    }

    public void draw(){
        // Update game objects
        for (int i = projectiles.size(); i-- > 0; ) {
            if (projectiles.get(i).update()) {
                projectiles.remove(i);
            }
        }
        cannon.update(camera);

        // Use camera
        camera.set();
        // Clear screen
        background(200);

        // Draw game objects
        for (Projectile projectile: projectiles) {
            projectile.draw();
        }
        cannon.draw();

        camera.unset();
    }

    public void mouseClicked() {
        cannon.shoot(this.projectiles);
    }
}