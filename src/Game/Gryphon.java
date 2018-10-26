package Game;

public class Gryphon extends Beast {

    /**
     * Constructor of the Gryphon class (the player).
     * @param resistence integer with the resistence of the player.
     * @param posx integer with the x position of the player.
     * @param posy integer with the y position of the player.
     * @param width integer with width of the player.
     * @param height integer with the height of the player.
     * @param imgPath string with the path of the image.
     */
    public Gryphon(int resistence, int posx, int posy, int width, int height, String imgPath){
        super(resistence, posx, posy, width, height, imgPath);
    }

}
