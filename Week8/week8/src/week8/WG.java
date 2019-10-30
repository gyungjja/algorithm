package week8;


public class WG {
	private int numOfVertex; 	//���� ����
	private int[][] weight;		//������ ����ġ
	
	public WG(int numOfVertex) {
		this.numOfVertex = numOfVertex;		//������ ���� ���ڰ����� 
		weight = new int[numOfVertex][numOfVertex];			//����ġ �ʱ�ȭ
		//�ڱ� �ڽ��� ��ġ�� 0 ���� ���� �ʴ� ������ ����ġ�� 999�� ����
		for(int i = 0; i<numOfVertex; i++){	//�ش�����
			for(int j = 0; j<numOfVertex; j++) {	//Ÿ������
				if(i == j)	//������ ��������
					weight[i][j] = 0;	//����ġ 0
				else	//�׷��� ������
					weight[i][j] = 999;	//����ġ 999
			}
		}
	}
	
	//���� ����
	public void insertEdge(int v, int w , int t) {
		int temp = v;	//�ӽ� ���� ������ ���� ����
		weight[v][t] = w;
		v = t;	//t�ǰ��� v�� �ְ�
		weight[v][temp]=w;	//������ �׷����̹Ƿ� ������ �Ȱ��� ����ġ
	}
	
	//prim algorithm
	
	public Edge[] prim_MST(int vertex) {
		//�ּҺ�� ����Ʈ��
		
		Edge prim[] = new Edge[vertex];
		boolean check[];	//�ش� ������ �湮�� �Ͽ����� �Ǻ��ϴ� ����
		check = new boolean[vertex];	//����Ǿ� �ִ��� Ȯ�� ����
		//vertex = 0; // ���� ���õ� ����� ��ȣ
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
		int temp = 0; //���� ���õ� ����� ��ȣ�� �ӽ������
		check[temp] = false;
		for(int i = 0; i < vertex-1; i++) {
			check[i] = true;
		}
		*/
		
		
		
	}
	
	
	//�迭 ��¹�
	public void print() {
		for(int i = 0; i < weight.length; i++) {
			for(int j = 0; j < weight.length; j++) {
				System.out.printf("|%3d|", weight[i][j]);
			}
			System.out.println();
		}
		
	}

}