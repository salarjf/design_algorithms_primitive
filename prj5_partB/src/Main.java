import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	final static long MOD = 1000000007;
	static ArrayList<ArrayList<Integer> > adj;
	static int[] vis=new int[100005];
	static int[] col=new int[100005];
	static long[][] dp=new long[100005][2];
	static int N;
	static void DynamicFunction(int u){
	    vis[u] = 1;
	    dp[u][0] = 1 - col[u];
	    dp[u][1] = col[u];
	    long zero, one;
	    for(int i=0;i<adj.get(u).size();++i){
	        int v = adj.get(u).get(i);
	        if(vis[v]==1) continue;
	        DynamicFunction(v);
	        zero = dp[u][0];
	        one = dp[u][1];
	        dp[u][0] = 0;
	        dp[u][1] = 0;
	        
	        dp[u][0] = zero * dp[v][1];
	        dp[u][0] %= MOD;
	        dp[u][1] = one * dp[v][1];
	        dp[u][1] %= MOD;
	        
	        dp[u][0] += zero * dp[v][0];
	        dp[u][0] %= MOD;
	        dp[u][1] += one * dp[v][0] + zero * dp[v][1];
	        dp[u][1] %= MOD;
	        
	    }
	}

	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
	    //scanf("%d", &N);
	    N=scanner.nextInt();
		adj =new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N+3;i++)
		{
			ArrayList<Integer> arr=new ArrayList<Integer>();
			adj.add(arr);
		}
	    int v;
	    for(int i=0;i<N-1;++i){
	        //scanf("%d", &v);
	        v=scanner.nextInt();
	    	adj.get(i+1).add(v);//push_back(v);
	        adj.get(v).add(i+1);
	    }
	    for(int i=0;i<N;++i){
	        //scanf("%d", &col[i]);
	    	col[i]=scanner.nextInt();
	    }
	    for(int i=0;i<N;++i){
	        vis[i] = 0;
	    }
	    DynamicFunction(0);
	    //printf("%d\n", (int) dp[0][1]);		
		System.out.println(dp[0][1]);
	}
}
