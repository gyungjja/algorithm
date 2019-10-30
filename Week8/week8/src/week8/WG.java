package week8;


public class WG {
	private int numOfVertex; 	//정점 개수
	private int[][] weight;		//정점의 가중치
	
	public WG(int numOfVertex) {
		this.numOfVertex = numOfVertex;		//정점의 개수 인자값으로 
		weight = new int[numOfVertex][numOfVertex];			//가중치 초기화
		//자기 자신의 위치는 0 연결 되지 않는 간선의 가중치는 999로 지정
		for(int i = 0; i<numOfVertex; i++){	//해당정점
			for(int j = 0; j<numOfVertex; j++) {	//타겟정점
				if(i == j)	//연결이 되있으면
					weight[i][j] = 0;	//가중치 0
				else	//그렇지 않으면
					weight[i][j] = 999;	//가중치 999
			}
		}
	}
	
	//간선 삽입
	public void insertEdge(int v, int w , int t) {
		int temp = v;	//임시 값을 저장할 변수 생성
		weight[v][t] = w;
		v = t;	//t의값을 v에 넣고
		weight[v][temp]=w;	//무방향 그래프이므로 간선인 똑같은 가중치
	}
	
	//prim algorithm
	
	public Edge[] prim_MST(int vertex) {
		//최소비용 신장트리
		
		Edge prim[] = new Edge[vertex];
		boolean check[];	//해당 정점을 방문을 하였는지 판별하는 변수
		check = new boolean[vertex];	//연결되어 있는지 확인 변수
		//vertex = 0; // 새로 선택된 노드의 번호
		//check[vertex] = false;
		for(int i = 1; i <vertex; i++) {
			for(int j = 1; j < vertex; j++) {
				check[i] = true;
				weight[i][j] = 0;
			}
		}
		
		for(int i = 0; i < vertex - 1; i++) {
			for(int j = 0; i < vertex - 1; j++) {
				weight[i][j]=999;
			}
		}
			
			
		
		return prim;
		
		/*
		this.numOfVertex = vertex;
		boolean check[] = new boolean[vertex];
		weight = new int[vertex][vertex];
		UnionFind u[] = new UnionFind[vertex];
		int temp = 0; //새로 선택된 노드의 번호의 임시저장소
		check[temp] = false;
		for(int i = 0; i < vertex-1; i++) {
			check[i] = true;
		}
		*/
		
		
		
	}
	
	
	//배열 출력문
	public void print() {
		for(int i = 0; i < weight.length; i++) {
			for(int j = 0; j < weight.length; j++) {
				System.out.printf("|%3d|", weight[i][j]);
			}
			System.out.println();
		}
		
	}

}
