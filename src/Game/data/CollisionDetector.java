package Game.data;

import GUI.Game;
import Game.Attack;
import Game.Dragon;
import Logic.Lists.BulletsList;
import Logic.Lists.BulletsNodes;
import Logic.Lists.TemporalList;
import Logic.Lists.TemporalNode;

public class CollisionDetector extends Thread {

    public CollisionDetector(){}

    public void run(){
        while (true){
            BulletsList tmp = BulletsList.getInstance();
            TemporalList tmp2 = TemporalList.getInstance();
            //HAY QUE DEJAR ESTE PRINT AQUI, PORQUE SI SE QUITA POR ALGUNA RAZON EL DETECTOR DE COLISIONES DEJA DE FUNCIONAR!!!
            System.out.print("");
            if (tmp.getLarge() != 0 && tmp2.getLarge() != 0){
                BulletsNodes sub_tmp = tmp.head;
                while (sub_tmp != null){
                    Attack sub_sub_tmp = sub_tmp.getAttack();
                    if (sub_sub_tmp.getWho().equals("playerbullet")){
                        int i = 0;
                        TemporalNode sub_temp2 = tmp2.head;
                        while (i != Game.onScreenEnemies){
                            Dragon sub_sub_tmp2 = sub_temp2.getDragon();
                            if (sub_sub_tmp.getBoundsInParent().intersects(sub_sub_tmp2.getBoundsInParent())){
                                sub_sub_tmp.setDead(true);
                                sub_sub_tmp2.hit();
                                this.sleep();
                                break;
                            }else{
                                sub_temp2 = sub_temp2.next;
                                i++;
                            }
                        }
                        sub_tmp = sub_tmp.next;
                    }
                    else{
                        if (sub_sub_tmp.getBoundsInParent().intersects((Game.player.getBoundsInParent()))){
                            sub_sub_tmp.setDead(true);
                            Game.player.hit();
                            this.sleep();
                            break;
                        }else{
                            sub_tmp = sub_tmp.next;
                        }
                    }
                }
            }
        }
    }

    public void sleep(){
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}
