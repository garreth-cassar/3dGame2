package graphics;

import display.Game;

/**
 * Created by User on 01/09/15.
 */
public class Render3D extends Render {
    public Render3D(int width, int height){
        super(width, height);
    }

     /**
     * Renders our floors ad ceilings
     * xx convert the depth into an integer and using a bitwise operator to convert the bits into something that visible.
     * yDepth controls where the horizon is.
     *
     * y = 43, yDepth = -280, z = -0.42
     * x = 800, depth = -501,
     * xx = -501 & 5 - the bitwise operator changes how dark the colours are. 15 is almost the same as 7
     * pixels[x + y * width] = xx * 100 - this number changes how scattered the lines are.
      * Moves forward with game.times counter, which increments on each tick of the game.
     */
    public void floor(Game game){

        double rotation = game.time / 100.0;
        double cosine = Math.cos(rotation);
        double sine = Math.sin(rotation);

        for(int y = 0; y < height; y++){
            double ceiling = (y - height / 2.0) / height;

            if(ceiling < 0){
                ceiling = -ceiling;
            }

            double z = 8 / ceiling;

            for(int x = 0; x < width; x++){
                double depth = (x - width / 2.0) / height;
                depth *= z;
                // & is a bitwise operator.
                double xx = (depth * cosine + z * sine);
                double yy = (z * cosine + depth * sine);
                int xPix = (int) xx;
                int yPix = (int) yy;

                pixels[x + y * width] = ((xPix & 15) * 16) | ((yPix & 15) * 16) << 8;
            }
        }
    }
}
