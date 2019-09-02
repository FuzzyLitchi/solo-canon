import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet{
    Projectile projectile;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings(){
        size(800,600);
    }

    public void setup(){
        this.projectile = new Projectile(
            this,
            new PVector(0, height),
            new PVector(200, -200)
        );
    }

    public void draw(){
        // Update game objects
        this.projectile.update();

        // Clear screen
        background(200);

        // Draw game objects
        this.projectile.draw();
    }

}