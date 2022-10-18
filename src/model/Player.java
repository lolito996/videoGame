package model;

public class Player {
    private String name;
    private String nickName;
    private int level;
    private int score;
    private int live; 

    /**
     * @param aname
     * @param aNickName
     */
    public Player(String aname,String aNickName){
        name=aname;
        nickName=aNickName;
    }
    /**
     * @return
     */
    public String getname(){
        return name;
    }
    /**
     * @return
     */
    public String getNickName(){
        return nickName;
    }
    /**
     * @return
     */
    public int getScore(){
        return score;
    }
    /**
     * @return
     */
    public int getLevel(){
        return level;
    }
    /**
     * @param newLevel
     */
    public void setLevel(int newLevel){
        level=newLevel;
    }
    /**
     * @return
     */
    public int getLives(){
        return live;
    }
    /**
     * @param newlives
     */
    public void setLives(int newlives){
        live=newlives;
    }
    /**
     * @param newScore
     */
    public void setScore(int newScore){
        score=newScore;
    }
}
