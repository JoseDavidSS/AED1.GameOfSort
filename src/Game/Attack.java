package Game;

public class Attack extends Beast {

    private String who;

    public Attack(int resistence, int posx, int posy, int width, int height, String imgPath, String who) {
        super(resistence, posx, posy, width, height, imgPath);

        this.who = who;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public void moveRight(){
        if (this.getPosx() >= 750){
            this.setDead(true);
        }else{
            setTranslateX(this.getPosx() + 5);
            this.setPosx(this.getPosx() + 5);
        }
    }

}
