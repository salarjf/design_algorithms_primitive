import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int boardsize=scanner.nextInt();
		int NumbersArray[]=new int[boardsize];
		for(int i=0;i<boardsize;i++)
			NumbersArray[i]=scanner.nextInt();
		
		int player1first=scanner.nextInt()-1;
		int player2first=scanner.nextInt()-1;
		int player1score=0;
		int player2score=0;
		if(!(player1first==player2first)){
			if(player1first>player2first){
				if((player1first-player2first)%2==0){
					for(int i=0;i<((player1first+player2first)/2);i++)
						player2score+=NumbersArray[i];
					for(int i=((player1first+player2first)/2);i<NumbersArray.length;i++)
						player1score+=NumbersArray[i];
				}
				else{
					for(int i=0;i<((player1first+player2first+1)/2);i++)
						player2score+=NumbersArray[i];
					for(int i=((player1first+player2first+1)/2);i<NumbersArray.length;i++)
						player1score+=NumbersArray[i];
				}
			}
			else{
				if((player1first-player2first)%2==0){
					for(int i=0;i<=((player1first+player2first)/2);i++)
						player1score+=NumbersArray[i];
					for(int i=((player1first+player2first)/2)+1;i<NumbersArray.length;i++)
						player2score+=NumbersArray[i];
				}
				else{
					for(int i=0;i<(player1first+player2first+1)/2;i++)
						player1score+=NumbersArray[i];
					for(int i=(player1first+player2first+1)/2;i<NumbersArray.length;i++)
						player2score+=NumbersArray[i];
				}
			}
		}
		else{
			int tempscore=0;
			int tempscore2=0;
			for(int i=0;i<player1first;i++)
				tempscore+=NumbersArray[i];
			for(int i=player1first+1;i<NumbersArray.length;i++)
				tempscore2+=NumbersArray[i];
			if(tempscore>tempscore2){
				player1score=tempscore+NumbersArray[player1first];
				player2score=tempscore2;
			}
			else{
				player1score=tempscore2+NumbersArray[player1first];
				player2score=tempscore;
			}

		}
		scanner.close();
		System.out.println(player1score+ " "+player2score);
		
	}
}
