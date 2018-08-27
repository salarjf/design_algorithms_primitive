package ca4bonus;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;
import java.math.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> array=new ArrayList<Integer>();
		Scanner scanner=new Scanner(System.in);
		int arraysize=scanner.nextInt();
		for(int i=0;i<arraysize;i++)
			array.add(scanner.nextInt());
		scanner.close();
		int numberOfDones=0;
		for(int i=0;i<2;i++){
			ArrayList<Integer> temparray=new ArrayList<Integer>();
			makeNextArray(temparray, array);
			array.clear();
			array.addAll(temparray);
			numberOfDones++;
			if(checkArray(temparray)==-1)
				break;
		}
		int checkresult=checkArray(array);
		if(checkresult==-1){
			System.out.println(numberOfDones);
			return;
		}
		else{
			System.out.println("infinity");
		}
		
	}

	private static int checkArray(ArrayList<Integer> array) {
		boolean allOne=true;
		for(int i=0;i<array.size();i++)
			if(!array.get(i).equals(1)){
				allOne=false;
				break;
			}
		if(allOne)
			return -1;
		return 0;
	}
	private static void makeNextArray(ArrayList<Integer> temparray,
			ArrayList<Integer> array) {
		
		for(int i=0;i<array.size()-1;i++){
			for(int j=i+1;j<array.size()-1;j++){
				BigInteger first=new BigInteger(array.get(i).toString());
				BigInteger second=new BigInteger(array.get(i).toString());
				BigInteger gcd;
				gcd=first.gcd(second);
				temparray.add(gcd.intValue());
		}
	}

}
}