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



    /**
     * 
     */
    public Game (){
        
        players = new Player[SIZE_OF_PLAYERS];
        enemies=new Enemies[SIZE_OF_ENEMIES];
        treasures=new Treasure[SIZE_OF_TREASURES];
        levels=new Level[SIZE_OF_lEVELS];
        levels[0]=new Level(1,10);
        levels[1]=new Level(2,20);
        levels[2]=new Level(3,40);
        levels[3]=new Level(4,80);
        levels[4]=new Level(5,160);
        levels[5]=new Level(6,320);
        levels[6]=new Level(7,640);
        levels[7]=new Level(8,1280);
        levels[8]=new Level(9,2460);
        levels[9]=new Level(10,4920);
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



    public boolean  validateNickName(String newNickname){
        boolean isFound=false;
        for (int i=0;i<SIZE_OF_PLAYERS;i++){
            if(players[i]!=null && players[i].getNickName().equals(newNickname)){
                isFound=true;
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
        if(pos!=-1){
            levels[level-1].addEnemiesLevel(name, tipo, pointsDelete, pointsWin); 
            msj="Se agrego el enemigo correctamente";
        }
        return msj;
    }

    public int validateEnemies(int level,String name){
        int found=0;
        boolean exists = levels[level-1].checkIfNameExists(name);
        if(exists==true){
            found = -1;
        }
        return found;
    }
    
    public String addPlayerTheGame(String name, String nickName){
       String  msj="No se pudo agregar el jugagdor losiento :( ";
       boolean isFound=false;
       for (int i =0;i<SIZE_OF_PLAYERS & !isFound;i++){
            if(players[i]==null){
                players[i]= new Player(name, nickName);
                players[i].setScore(POINTS_INIT);
                players[i].setLives(LIVES_INITS);
                players[i].setLevel(0);
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
    public int searchNameForTreasure(String name){
        int found=0;
        for (int i=0;i<SIZE_OF_TREASURES;i++){
            if(levels[i].geTreasures()[i].getName().equals(name));
            found=-1;
        }return found;
    }
    /**
     * @param level
     * @param name
     * @param url
     * @param pointsWin
     * @return msj;
     */
    public String addTreasureforLevel(int level,String name,String url,int pointsWin){
        String msj="";
        int pos =-1;
        pos=levels[level-1].searchEmptyPositionTreasure();
            if(pos==-1){
                msj="No se pudo agregar el tesoro";
            }else{
                levels[level-1].addTreasure(name,url, pointsWin); 
                msj="Se agrego el tesoro correctamente";
            }   
        
        return msj;
    }
    public int posNickane(String nickname){
        int pos=-1;
        boolean isFound=false;
        for (int i=0;i<SIZE_OF_PLAYERS & !isFound;i++){
            if(players[i] !=null && players[i].getNickName().equals(nickname)){
                pos=i;
                isFound=true;
            }
        }return pos;
    }
    public String changePointsPlayer(String nickName,int newPoints){
        String msj="";
        int pos=-1;
        pos=posNickane(nickName);
        if(pos==-1){
            msj="No se encontro el jugador";
        }else{
            players[pos].setScore(newPoints);
            msj="Puntaje actualizado ";
        }
        return msj;
    }

    public String chageLevelPlayer(String nickname){
        String msj="";
        int pos;
        int pointsLevel=0;
        int nevelStay=0;
        pos=posNickane(nickname);
        nevelStay=players[pos].getLevel();
        pointsLevel=levels[nevelStay+1].getneedPoints();
        msj="El jugador no pudo subir de nivel, necesita "+pointsLevel;
        for(int i=0;i<SIZE_OF_lEVELS;i++){
            if(players[pos].getScore()>= pointsLevel){
                players[pos].setLevel(nevelStay+1);
                nevelStay=nevelStay+1;
                pointsLevel=levels[nevelStay].getneedPoints();
                msj=" subio a el  nivel "+(nevelStay);
            }
        }
        return msj;
    }

    /**
     * @param level
     * @return
     */
    public String enemiesForLevel(int level){
        String msj="";
        String name="";
        String type="";
        for (int i=0;i<SIZE_OF_ENEMIES;i++){
            if(levels[level-1].getEnemies()[i]!=null){
                name=levels[level-1].getEnemies()[i].getName();
                type=levels[level-1].getEnemies()[i].getTypeEnemie();
                msj+="Nombre "+ name +" tipo "+ type+"\n";

            }
        }return msj;
    }
    public String treasureForLevel(int level){
        String msj="";
        int pointsWin=0;
        String name="";
        for (int i=0;i<SIZE_OF_TREASURES;i++){
            if(levels[level-1].geTreasures()[i]!=null){
                name=levels[level-1].geTreasures()[i].getName();
                pointsWin=levels[level-1].geTreasures()[i].getGivePoints();
                msj+="Nombre "+ name +" tipo "+ pointsWin+"\n";

            }
        }
        return msj;
    }
    /**
     * @param name
     * @return msj
     */
    public String countTreasureForlevel(String name){
        String msj="No se encontro el tesoro ";
        int totalForLevel=0;
        for(int i=0 ;i<SIZE_OF_lEVELS;i++){
                for (int j=0;j<SIZE_OF_TREASURES;j++){
                    if(levels[i].geTreasures()[j]!=null){
                        if(levels[i].geTreasures()[j].getName().equals(name)){
                            totalForLevel=totalForLevel+1;
                            msj="La cantidad de tesoros encontrada en todos los niveles del juego son "+ totalForLevel;
                        }
                    }
                }
                
        }       
        return msj;
    }
    public String countEnemiesForLevel(int typeEnemie){
        String msj="No se encontro ese tipo de enemigos en ningun nivel";
        int countTotal=0;
        for(int i=0;i<SIZE_OF_lEVELS;i++){
            for(int j=0;j<SIZE_OF_ENEMIES;j++){
                if(levels[i].getEnemies()[j]!=null){
                    if(levels[i].getEnemies()[j].getType()==typeEnemie){
                        countTotal=countTotal+1;
                        msj="La cantidad encontrada de ese tipo de enemigos son "+countTotal;
                    }
                }
            }
        }
        return msj;
    }
    /**
     * @return
     */
    public String countRepetitiveTreasure(){
        String msj="";
        boolean isFound = false;
        String name = "";
        int countArray=0;
        int count=0;
        int countMax=0;
        String[] names=new String[SIZE_OF_TREASURES];
        for(int i=0;i<SIZE_OF_lEVELS;i++){
            treasures = levels[i].geTreasures();
            for(int j=0;j<SIZE_OF_TREASURES; j++){
                name = treasures[j].getName();
                isFound = validateTreasureName(name, names);
                if(isFound==false){
                    names[countArray]=name;
                    countArray++;
                }
            }
        }
        for(int i=0;i<countArray;i++){
            count=0;
            for(int j=0;j<SIZE_OF_lEVELS;j++){
                treasures=levels[j].geTreasures();
                for (int k=0;k<SIZE_OF_TREASURES;k++)
                    if(treasures[k]!=null){
                        if (names[i].equals(treasures[k].getName())){
                            count ++;
                        }
                        
                }
            }
            if(count>countMax){
                countMax=count;
                name=names[i];
            }
            msj= "El tesoro mas repetivo de el juegos es "+ name+" \n"+" total "+countMax;


        }    
        return msj;           
    }
    /**
     * @param name[]
     * @param names
     * @return
     */
    public boolean validateTreasureName(String name, String[] names){
        boolean isFound = false;
        for(int i=0;i<SIZE_OF_TREASURES & ! isFound;i++){
            if(names[i]!=null & names[i].equals(name));
            isFound=true;
        }
        return isFound;
    }
        
    /**
     * @return
     */
    public String searchEnemiesHighther(){
        String msj="";
        int points=0;
        for(int i=0;i<SIZE_OF_lEVELS;i++){
            for(int j=0;j<SIZE_OF_ENEMIES;j++){
                if(levels[i].getEnemies()[j]!=null){
                    if(levels[i].getEnemies()[j].getPintsWin()>points){
                        points=levels[i].getEnemies()[j].getPintsWin();
                        msj=" El enemigo que otorga mas puntaje esta en el nivel "+(i+1)+" otroga "+points+" Puntos";
                    }
                }
            }
        }return msj;
            
    }
    /**
     * @param name
     * @return
     */
    public int existEnemies(String name){
        int sw=-1;
        boolean isFound =false;
        for(int i=0;i< SIZE_OF_lEVELS & ! isFound;i++){
            for(int j=0;j<SIZE_OF_ENEMIES;j++){
                if( levels[i]!=null && levels[i].geTreasures()[j]!=null && levels[i].geTreasures()[j].getName().equals(name)){
                    sw=0;
                    isFound=true;
                }
            }
        }
        return sw;
    }

    /**
     * @param name
     * @return msj
     */
    public String countConsonantName(String name){
        String msj="";
        int consonantes=0;
        for (int x = 0; x < name.length(); x++) {
			char letra = name.charAt(x);
			if (esConsonante(letra)) {
				consonantes++;
                msj=" La cantidad de consonantes encontradas en este nombre fueron "+consonantes;
			}
		}
        return msj;
    }
    public  boolean esConsonante(char letra) {
		return "bcdfghjklmnñpqrstvwxyz".contains(String.valueOf(letra).toLowerCase());
	}
}
