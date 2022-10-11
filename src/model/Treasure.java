package model;

public class Treasure {
    private String name;
    private String url;
    private int givePoints;
    private double posX;
    private double posY;

    public Treasure(String aname,String aurl,int agivePoints,double aPosX, double aPosY){
        name=aname;
        url=aurl;
        givePoints=agivePoints;
        posX=aPosX;
        posY=aPosY;
    }
    

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name=newName;
    }

    public int newGivePoints(){
        return givePoints;

    }
    public void setGivePoints(int newPoints){
        givePoints=newPoints;
    }
    public String getUrl(){
        return url;
    }
    public double getPosx(){
        return posX;
    }
    public double getPosy(){
        return posY;
    }

}
