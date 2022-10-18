package model;
import java.lang.Math;

public class Enemies {

    
    private String name;
    private int type;
    private int pointsDelete;
    private int pointsWin;
    private double posX;
    private double posY;
    private TypeEnemies deftype;


    /**
     * @param aname
     * @param atipo
     * @param aPointsDelete
     * @param aPointsWin
     */
    public Enemies(String aname,int atipo, int aPointsDelete,int aPointsWin){
        name=aname;
        type=atipo;
        pointsDelete=aPointsDelete;
        pointsWin=aPointsWin;
        posX=Math.floor(Math.random()*1289+1);
        posY=Math.floor(Math.random() *719+1);
    }
    public String getName(){
        return name;
    }
    public int getPointsDelete(){
        return pointsDelete;
    }
    public int getPintsWin(){
        return pointsWin;
    }
    public double getPosx(){
        return posX;
    }
    public double getPosy(){
        return posY;
    }
    public int getType(){
        return type;
    }
    
    /**
     * @return msj
     */
    public String getTypeEnemie(){
        String msj="";
        if(type==1){
            deftype=TypeEnemies.OGROS;
            msj="OGROS";
        }
        else if(type==2){
            deftype=TypeEnemies.ABSTRACTOS;
            msj="ABSTRACTO";
        }
        else if(type==3){
            deftype=TypeEnemies.JEFES;
            msj="JEFES";
        }
        else if(type==4){
            deftype=TypeEnemies.MAGICOS;
            msj="MAGICOS";
        }
        return msj;
    }

}
