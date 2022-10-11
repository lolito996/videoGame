package model;

public class Game {
    private Player [] players;
    private Level [] levels;
    private Treasure [] treasures;
    private Enemies [] enemies;
    public static final int SIZE_OF_PLAYERS=20;
    public static final int SIZE_OF_TREASURES=50;
    public static final int SIZE_OF_ENEMIES=25;
    public static final int SIZE_OF_lEVELS=10;
    public static final int POINTS_INIT=10;
    public static final int LIVES_INITS=5;



    public Game (){
        players = new Player[SIZE_OF_PLAYERS];
        levels=new Level[SIZE_OF_lEVELS];
        enemies=new Enemies[SIZE_OF_ENEMIES];
        levels[0]=new Level(1,10);
        levels[1]=new Level(2,20);
        levels[2]=new Level(3,40);
        levels[3]=new Level(4,80);
        levels[4]=new Level(5,160);
        levels[5]=new Level(6,320);
        levels[6]=new Level(7,640);
        levels[4]=new Level(8,1280);
        levels[4]=new Level(5,2460);
    }
    

    public Player[] getPlayers(){
        return players;
    }
    public Level[] getLevels(){
        return levels;
    }

    public int SearchPositionForPlayer(){
        int pos=-1;
        boolean isFound=false;
        for(int i=0;i<SIZE_OF_PLAYERS && ! isFound;i++){
            if(players[i]==null){
                isFound=true;
                pos=i;
            }
        }return pos;
    }



    public int  validateNickName(String newNickname){
        int isFound=0;
        for (int i=0;i<SIZE_OF_PLAYERS;i++){
            if(players[i]!= null && players[i].getNickName().equals(newNickname)){
                isFound=-1;
            }
        }return isFound;
    }

    public String addEnemiesLevel(int level,String name, int tipo,int pointsDelete,int pointsWin){
        String msj="";
        int pos =-1;
        pos=levels[level].SearchEmptyPositionEnemie();
        if(pos==-1){
            msj="No se pudo agregar el enemigo";
        }
        levels[level].addEnemiesLevel(pos,name, tipo, pointsDelete, pointsWin); 
        msj="Se agrego el enemigo correctamente";
        return msj;
    }
    
    public String addPlayerTheGame(String name, String nickName){
       String  msj="No se pudo agregar el jugagdor losiento :( ";
       boolean isFound=false;
       for (int i =0;i<SIZE_OF_PLAYERS & !isFound;i++){
            if(players[i]==null){
                players[i]= new Player(name, nickName);
                players[i].setScore(POINTS_INIT);
                players[i].setLives(LIVES_INITS);
                msj="El jugador se creo exitosamente";
                isFound=true;
            }
       }return msj;
    }
    public String listEnemies(){
        return "Typos de enemigos \n"+
        "1) ogros \n"+
        "2) abstractos\n"+
        "3) jefes\n"+
        "4) magicos";
    }



}
