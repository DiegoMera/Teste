import java.util.Random;
import java.lang.Math;
import java.util.Scanner;
public class DungeonLooter {
		static int[][] Dungeon = new int[4][4];
		static int Victory =0;
	

	//Gera o "Mapa", colocando o tesouro aleatoriamente na matriz atravez do uso do Random
	 static void DungeonBuilder() 
	{
		int linha;
  	    int coluna;
		for(int i=0; i < Dungeon.length; i++) 
		{
      		for(int j=0; j < Dungeon[i].length; j++) 
      		{
      			Dungeon[i][j] = 0;
			}
		}
		Random r = new Random ();
      	linha=r.nextInt (DungeonLooter.Dungeon.length);
      	coluna=r.nextInt (DungeonLooter.Dungeon[0].length);
      	DungeonLooter.Dungeon[linha][coluna]=2;
	}

	//Vai apresentar o mapa para o jogador, com 0 sendo campos inexplorados e 1 sendo os ja explorados
	static void DungeonExplorer()
	{
		System.out.print("    ");
		for(int i=0; i < Dungeon.length; i++) 
		{
		System.out.print("_"+i+"_");
		}
		System.out.println();
		for(int i=0; i < Dungeon.length; i++) 
		{
		System.out.print("  "+i+"|");
      		for(int j=0; j < Dungeon[i].length; j++) 
      		{
        		if(Dungeon[i][j]==1)
        		{
				System.out.print(" 1 ");
        		}
        		else
        		{
        		System.out.print(" 0 ");
        		}
			}
		System.out.println("|");
		}
	}

	//vai mostrar o local em que o tesouro estava quando o jogador achar ele
	static void TreasureMap()
	{
		System.out.print("    ");
		for(int i=0; i < Dungeon.length; i++) 
		{
		System.out.print("_"+i+"_");
		}
		System.out.println();

		for(int i=0; i < Dungeon.length; i++) 
		{
		System.out.print("  "+i+"|");
      		for(int j=0; j < Dungeon[i].length; j++) 
      		{
        		if(Dungeon[i][j]==5)
        		{
				System.out.print(" 5 ");
        		}
        		else
        		{
        		System.out.print("   ");
        		}
			}
		System.out.println("|");
		}
	}	


	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int R,L,C;
		

		System.out.println("Welcome to the Dungeon ... little explorer...");
		System.out.println("Are you ready to begin? (press 1 to begin)");
		R = sc.nextInt();
		if(R==1)
			{
			DungeonBuilder();
				while (Victory!=5)
				{
					
					DungeonExplorer();
					System.out.println("Press 22 to Exit at any time");
					System.out.println();
					System.out.println("Choose the line you will search");
					L = sc.nextInt();
					if (L==22) 
					{
						System.out.println("Ahh... leaving so soon?");
						System.exit(0);
					}
					System.out.println("Now the Column...");
					C = sc.nextInt();

					if (L==22) {System.exit(0);}
					//try catch para quando o jogador tentar digitar fora da matriz, evitando que o programa crashe
					try{
						if(Dungeon[L][C]==2)
						{
							System.out.println();
							System.out.println("---------------------------------------------");
							System.out.println();
							Dungeon[L][C]=5;
							Victory=5;
							System.out.println("Looks like youve got yourself a treasure... lucky one ");
							TreasureMap();
						}
						else
						{
							System.out.println();
							System.out.println("---------------------------------------------");
							System.out.println();
							Dungeon[L][C]=1;
							System.out.println("Looks like you missed... Muahahahaha");
							System.out.println("Try Again!");
						}
					}
					catch(Exception e)
					{
						System.out.println("The treasure is inside here... try to search in this dungeon, not outside it!");
					}

				}
		}
		else
		{
		System.out.println("Dont worry, we will be waiting for you... Muahahahaha");
		}
    }    
}