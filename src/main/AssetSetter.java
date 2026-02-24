package main;

import object.OBJ_Healthbar;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        gp.obj[0] = new OBJ_Healthbar(gp, gp.p1);
        gp.obj[0].worldX = 1 * gp.tileSize;
        gp.obj[0].worldY = 1 * gp.tileSize;

        gp.obj[1] = new OBJ_Healthbar(gp, gp.p2);
        gp.obj[1].worldX = (gp.maxScreenRow-1) * gp.tileSize;
        gp.obj[1].worldY = 1 * gp.tileSize;
    }
}
