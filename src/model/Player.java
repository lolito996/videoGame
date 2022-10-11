package model;

public class Player {
    private String name;
    private String nickName;
    private int score;
    private int live; 

    public Player(String aname,String aNickName){
        name=aname;
        nickName=aNickName;
    }
    public String getname(){
        return name;
    }
    public String getNickName(){
        return nickName;
    }
    public int getScore(){
        return score;
    }
    public int getLives(){
        return live;
    }
    public void setLives(int newlives){
        live=newlives;
    }
    public void setScore(int newScore){
        score=newScore;
    }
}
