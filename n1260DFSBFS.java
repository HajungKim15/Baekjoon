import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n1260DFSBFS {

	public static void dfs(int v, int n, int[][] edges, boolean[] visited) {
		
		visited[v] = true;
		System.out.print(v+" ");
		
		for(int i=1; i<=n; i++) {
			
			if(edges[v][i] == 1 && !visited[i]) {
				dfs(i, n, edges, visited);
			}
		}			
	}
	
	public static void bfs(int v, int n, int[][] edges, boolean[] visited) {
		Queue<Integer> que = new LinkedList<>();
		
		que.offer(v);
		visited[v] = true;
		
		while(!que.isEmpty()) {
		
			int tmp = que.poll();
			System.out.print(tmp+" ");
		
			for(int i=1; i<=n; i++) {
				if(edges[tmp][i] == 1 && !visited[i]) {
					que.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int start = sc.nextInt();
		int vert1, vert2;
		int edges[][] = new int[N+1][N+1];
		boolean[] visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			vert1 = sc.nextInt();
			vert2 = sc.nextInt();
			
			edges[vert1][vert2] = 1;
			edges[vert2][vert1] = 1;
		}
		
		dfs(start, N, edges, visited);
		
		visited = new boolean[N+1];
		System.out.println();
		
		bfs(start, N, edges, visited);
		

	}

}
