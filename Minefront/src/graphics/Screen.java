package graphics;

import display.Game;

import java.util.Random;

/**
 * Created by User on 23/08/15.
 */
public class Screen extends Render {

    private Render test;

    public Screen(int width, int height) {
        super(width, height);
        Random randy = new Random();
        test = new Render(256, 256);
        for(int i = 0; i < 256 * 256; i++){
            test.pixels[i] = randy.nextInt();
        }
    }

    public void render(Game game){
        for(int i = 0; i < width * height; i++){
            pixels[i] = 0;
        }

        int i;

        for(i = 0; i < 10; i++) {
            int anim0 = (int) (Math.sin(System.currentTimeMillis() % 1000.0 / 1000 * Math.PI * 2) * 100);
            int anim = (int) (Math.sin((game.time + i) % 1000.0 / 100) * 100);
            int anim2 = (int) (Math.cos((game.time + i ) % 1000.0 / 100) * 100);
            draw(test, (width - 256) / 2 + anim, (height - 256) / 2 + anim2);
        }
    }
}
