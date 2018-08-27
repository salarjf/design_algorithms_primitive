import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
	static int [][] cap;	
	static int [][] fnet;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int EdgeSize=scanner.nextInt();
		int NodeSize=scanner.nextInt();
		cap=new int[NodeSize][NodeSize];
		fnet=new int[NodeSize][NodeSize];
		for(int[] row:cap)
			Arrays.fill(row,0);
		for(int[] row:cap)
			Arrays.fill(row,0);
		for(int i=0;i<EdgeSize;i++){
			int sourceNode=scanner.nextInt();
			int destNode=scanner.nextInt();
			int capacity=scanner.nextInt();
			cap[sourceNode-1][destNode-1]=capacity;
		}
		scanner.close();
		System.out.println(fordFulkerson(NodeSize,0,NodeSize-1));
	}
static int fordFulkerson(int n, int s, int t) {
	 //ASSUMES: cap[u][v] stores capacity of edge (u,v). cap[u][v] = 0 for no edge.
	//Initialise the flow network so that fnet[u][v] = 0 for all u,v
	int flow = 0; //no flow yet
	 
	while (true) {
	//Find an augmenting path using BFS
	int[] prev = new int[n];
	Arrays.fill(prev, -1);
	LinkedList<Integer> queue = new LinkedList<Integer>();
	prev[s] = -2;
	queue.add(s);
	while (!queue.isEmpty() && prev[t] == -1) {
	int u = queue.poll();
	for (int v = 0; v < n; v++) {
	if (prev[v] == -1) { //not seen yet
	if (fnet[v][u] > 0 || fnet[u][v] < cap[u][v]) {
	prev[v] = u;
	queue.add(v);
	}
	}
	}
	}
	//See if we couldn't find any path to t (t has no parents)
	if (prev[t] == -1) break;
	 
	//Get the bottleneck capacity;
	int bot = Integer.MAX_VALUE;
	for (int v = t, u = prev[v]; u >= 0; v = u, u = prev[v]) {
	if (fnet[v][u] > 0) //prefer a backward edge over a forward
	bot = min(bot, fnet[v][u]);
	else //must be a forward edge otherwise
	bot = min(bot, cap[u][v] - fnet[u][v]);
	}
	 
	//update the flow network
	for (int v = t, u = prev[v]; u >= 0; v = u, u = prev[v]) {
	if (fnet[v][u] > 0) //backward edge -> subtract
	fnet[v][u] -= bot;
	else //forward edge -> add
	fnet[u][v] += bot;
	}
	 
	//Sent 'bot' amount of flow from s to v, so update the flow
	flow += bot;
	}
	return flow; 
}
private static int min(int bot, int i) {
	// TODO Auto-generated method stub
	return bot>i?i:bot;
}

}