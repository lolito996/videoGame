package model;
import java.lang.Math;

public class Treasure {
    private String name;
    private String url;
    private int givePoints;
    private double posX;
    private double posY;

    public Treasure(String aname,String aurl,int agivePoints){
        name=aname;
        url=aurl;
        givePoints=agivePoints;
        posX=Math.floor(Math.random()*1289+1);
        posY=Math.floor(Math.random()*720+1);
    }
    

    /**
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * @param newName
     */
    public void setName(String newName){
        name=newName;
    }

    /**
     * @return
     */
    public int getGivePoints(){
        return givePoints;

    }
    /**
     * @param newPoints
     */
    public void setGivePoints(int newPoints){
        givePoints=newPoints;
    }
    /**
     * @return
     */
    public String getUrl(){
        return url;
    }
    /**
     * @return
     */
    public double getPosx(){
        return posX;
    }
    /**
     * @return
     */
    public double getPosy(){
        return posY;
    }

}
