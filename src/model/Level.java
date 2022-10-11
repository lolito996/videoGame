package model;

public class Level {
    public static final int SIZE_OF_ENEMIES=25;
    private int id;
    private int needPoint;
    private TypeLevel type;
    private Enemies[] enemies;
    public Level(int aid,int aneedPoint){
        id=aid;
        needPoint=aneedPoint;
        enemies=new Enemies[SIZE_OF_ENEMIES];
    }
    public int getId(){
        return id;
    }
    public void setIds(int newId){
        id=newId;
    }
    public Enemies [] getEnemies(){
        return enemies;
    }
    public int getneedPoints(){
        return needPoint;
    }
    public void setNeddPoints(int newNeddPoints){
        needPoint=newNeddPoints;
    }
    public void addEnemiesLevel(int pos,String name, int type,int pointsDelete,int pointsWin){
        boolean isFound=false;
        for (int i=0;i<SIZE_OF_ENEMIES && !isFound;i++){
            if(enemies[i]==null){
                enemies[i]= new Enemies(name, type, pointsDelete, pointsWin);
                isFound=true;
            }
        }
    }
    public int SearchEmptyPositionEnemie(){
        int pos=-1;
        boolean isFound=false;
        for(int i=0;i<SIZE_OF_ENEMIES & ! isFound ;i++){
            if(enemies[i]==null){
                pos=i;
                isFound=true;
            }
        }return pos;
    }


    
}

    

 