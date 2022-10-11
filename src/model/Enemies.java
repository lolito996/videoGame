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
    
    public void getTypeEnemie(){
        if(type==1){
            deftype=TypeEnemies.OGROS;
        }
        else if(type==2){
            deftype=TypeEnemies.ABSTRACTOS;
        }
        else if(type==3){
            deftype=TypeEnemies.JEFES;
        }
        else if(type==4){
            deftype=TypeEnemies.MAGICOS;
        }
    }

}
