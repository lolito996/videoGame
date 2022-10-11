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
		"2. Agregar un enemigo a un jugador \n"+
	    "0. Salir del programa.\n"; 
	}

	public void executeOption(int option){
        String msj="";
        String name="";
        String nickName="";
		int typeEnemie=0;
		int pointsDelete=0;
		int pointsWin=0;
		int sw=0;
		int levelSelect=0;

		switch(option){
            
			case 1: 
				System.out.println("Cual es tu nombre:");
                name=reader.next();
                System.out.println("Elige tu nickName");
                nickName=reader.next();
				sw=game.validateNickName(nickName);
				if(sw==-1){
					System.out.println("Este nickname ya existe");
					break;
				}
                msj=game.addPlayerTheGame(name, nickName);
                System.out.println(msj);
			    break; 

		    case 2: 
				System.out.println("En que nivel se agregara");
				levelSelect=reader.nextInt();
				if(levelSelect<1 || levelSelect>10){
						System.out.println("Este nivel no existe:");
					break;
				}
				System.out.println("Cual es el nombre del enemigo:");
				name=reader.next();
				msj=game.listEnemies();
				System.out.println(msj);
				typeEnemie=reader.nextInt();
				System.out.println("Puntaje que elimina:");
				pointsDelete=reader.nextInt();
				System.out.println("Puntaje en caso de que sea derrotado");
				pointsWin=reader.nextInt();
				msj=game.addEnemiesLevel(levelSelect,name,typeEnemie,pointsDelete,pointsWin);
				System.out.println(msj);

				break; 

			case 3: 
				System.out.println("En que nivel se agregara");
				levelSelect=reader.nextInt();
				if(levelSelect<1 || levelSelect>10){
					System.out.println("Este nivel no existe:");
					break;
				}
				System.out.println("Nombre del tesoro");
				name=reader.next();
				
			
						

				break;

			case 4: 

				break;

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
