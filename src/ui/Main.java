package ui;
import model.Game;
import java.util.Scanner;

public class Main{

    private Scanner reader;
    private Game game;
	


	public Main(){
		reader = new Scanner(System.in); 
		game=new Game();
	}	
    public static void main(String[] args){
		Main main = new Main(); 

        int option = -1; 
		do{
			option = main.getOptionShowMenu(); 
			main.executeOption(option);

		}while(option != 0);

    }

	public Scanner getReader(){
		return this.reader;
	}

	public void setReader(Scanner reader){
		this.reader = reader;
	}

	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println(printMenu());

		option = validateIntegerOption(); 

		return option; 
	}

	public String printMenu(){
		return 
		"\n" +
		"<< --------------------------------------------------------------------- >>\n" +
		"<<                       welcome to your favorite game                   >>\n" +
		"<< --------------------------------------------------------------------- >>\n" +
		"1. Agregar jugador\n" +
		"2. Agregar un enemigo a un nivel \n"+
		"3. Agregar tesoro a un nivel\n"+
		"4. Modificar el puntaje de un jugador\n"+
		"5. Incrementar nivel de un jugador\n"+
		"6. Mostrar tesoros y enemigos de un nivel\n"+
		"7. Mostrar cantidad de veces que se encuentra un tesoro por nivel\n"+
		"8. Mostrar cuantos enemigos de un tipo hay en el juego\n"+
		"9. Cual es el tesoro mas repetido de el juego\n"+
		"10. Cual es el enemigo que otroga mas puntos\n"+
		"11. Cuantas consonantes tiene el nombre de un enemigo\n"+
		"12. Top 5 de los jugadores con mas puntaje "+
	    "0. Salir del programa.\n"; 
	}

	/**
	 * @param option
	 */
	public void executeOption(int option){
        String msj="";
        String name="";
        String nickName="";
		int typeEnemie=0;
		int pointsDelete=0;
		int pointsWin=0;
		boolean exist=false;
		int sw =-1;
		int levelSelect=0;
		String url="";

		switch(option){
            
			case 1: 
				System.out.println("Cual es tu nombre:");
                name=reader.next();
                System.out.println("Elige tu nickName");
                nickName=reader.next();
				exist=game.validateNickName(nickName);
				if(exist==true){
					System.out.println("Este nickname ya existe");
				}else{
                msj=game.addPlayerTheGame(name, nickName);
                System.out.println(msj);
				}
			    break; 

		    case 2: 
				System.out.println("En que nivel se agregara");
				levelSelect=reader.nextInt();
				if(levelSelect<1 || levelSelect>10){
						System.out.println("Este nivel no existe:");
					break;
				}else{
				System.out.println("Cual es el nombre del enemigo:");
				name=reader.next();
				sw=game.validateEnemies(levelSelect,name);
				if (sw==-1){
					System.out.println("Ya existe el enemigo");
				}
					else{
						msj=game.listEnemies();
						System.out.println(msj);
						typeEnemie=reader.nextInt();
						System.out.println("Puntaje que elimina:");
						pointsDelete=reader.nextInt();
						System.out.println("Puntaje en caso de que sea derrotado");
						pointsWin=reader.nextInt();
						msj=game.addEnemiesLevel(levelSelect,name,typeEnemie,pointsDelete,pointsWin);
					System.out.println(msj);
				}
				}	
				break; 

			case 3: 
				System.out.println("En que nivel se agregara");
				levelSelect=reader.nextInt();
				if(levelSelect<1 || levelSelect>10){
				System.out.println("Este nivel no existe:");
				}
				else{
					System.out.println("Nombre del tesoro");
					name=reader.next();
					System.out.println("Cual es la url");
					url=reader.next();
					System.out.println("Cuantos puntos otorga Cuando es encontrado");
					pointsWin=reader.nextInt();
					msj=game.addTreasureforLevel(levelSelect,name,url,pointsWin);
					System.out.println(msj);
				}
				break;

			case 4: 
				System.out.println("Cual es el nick name del jugador");
				nickName=reader.next();
				exist=game.validateNickName(nickName);
				if(exist==false){
					System.out.println("Este jugador no existe ");
				}else{
					System.out.println("Cuantos puntos va a tener ahora el jugador");
					pointsWin=reader.nextInt();
					msj=game.changePointsPlayer(nickName,pointsWin);
					System.out.println(msj);
				}
				break;
			case 5:
				System.out.println("Cual es el nick name del jugador");
				nickName=reader.next();
				exist=game.validateNickName(nickName);
				if(exist==false){
					System.out.println("Este jugador no existe ");
				}else{
					msj=game.chageLevelPlayer(nickName);
					System.out.println(msj);
				}
				break;
			case 6:
				System.out.println("En que nivel deseas mirar:");
				levelSelect=reader.nextInt();
				if(levelSelect<1 || levelSelect>10){
				System.out.println("Este nivel no existe:");
				}
				else{
					System.out.println("En el nivel "+ levelSelect  + " existe esta cantidad de enemigos \n");
					msj=game.enemiesForLevel(levelSelect);
					System.out.println(msj);
					System.out.println("En el nivel "+ levelSelect  + " existe esta cantidad de tesoros \n");
					msj=game.treasureForLevel(levelSelect);
					System.out.println(msj);
				}
			case 7:
				System.out.println("Cual es el nombre del tesoro que buscas:");
				name=reader.next();
				msj=game.countTreasureForlevel(name);
				System.out.print(msj);
				break;
			case 8: 
				msj=game.listEnemies();
				System.out.println(msj);
				typeEnemie=reader.nextInt();
				if(typeEnemie>4 ||typeEnemie<1){
					System.out.println("Ese tipo no existe en el juego");
				}
				else{
					msj=game.countEnemiesForLevel(typeEnemie);
					System.out.println(msj);
				}
			break;
			case 9:
				msj=game.countRepetitiveTreasure();
				System.out.println(msj);
			break;

			case 10:
				msj=game.searchEnemiesHighther();
				System.out.println(msj);
				break;
			case 11: 
				System.out.println("Cual es el nombre del enemigo");
				name=reader.next();
				sw=game.existEnemies(name);
				if(sw==-1){
					System.out.println("Ese enemigo no existe ");

				}else{
					msj=game.countConsonantName(name);
					System.out.println(msj);
				}
				break;

			case 12:

			case 0: 
				System.out.println("Exit program.");
			    break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}

	public int validateIntegerOption(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}
		return option; 
	}

}   
