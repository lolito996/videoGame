package model;

public class Level {
    public static final int SIZE_OF_ENEMIES=25;
    public static final int SIZE_OF_TREASURES=50;
    private int id;
    private int needPoint;
    private TypeLevel type;
    private Enemies[] enemies;
    private Treasure[] treasures;
    public Level(int aid,int aneedPoint){
        id=aid;
        needPoint=aneedPoint;
        enemies=new Enemies[SIZE_OF_ENEMIES];
        treasures=new Treasure[SIZE_OF_TREASURES];
    }
    public boolean checkIfNameExists(String name){
        boolean exists = false;
        for(int i = 0; i < SIZE_OF_ENEMIES && !exists; i++){
            if(enemies[i]!=null){
                if(enemies[i].getName().equals(name)){
                    exists = true;
                }
            }
        }
        return exists;
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
    public void addEnemiesLevel(String name, int type,int pointsDelete,int pointsWin){
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

    /**
     * @return
     */
    public Treasure[] geTreasures(){
        return treasures;
    }
    /**
     * @param name
     * @param url
     * @param pointswin
     */
    public void addTreasure(String name, String url,int pointswin){
        boolean isFound=false;
        for(int i=0;i<SIZE_OF_TREASURES & !isFound;i++){
            if(treasures[i]==null){
                treasures[i]=new Treasure(name, url, pointswin);
                isFound=true;
            }
        }
    }
    public int searchEmptyPositionTreasure(){
        int pos=-1;
        boolean isFound=false;
        for(int i=0;i<SIZE_OF_TREASURES & ! isFound;i++){
            if(treasures[i]==null){
                pos=i;
                isFound=true;
            }
        }return pos;
    }

    
}

    

 