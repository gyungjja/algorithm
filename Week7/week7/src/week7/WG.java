package week7;


public class WG {
	private int numOfVertex;	//������ ����
	private int numOfEdge;		//������ ����
	private int[][] weight;		//������ ����ġ
	
	//������
	public WG(int numOfVertex){
		this.numOfVertex = numOfVertex;	//������ ���� ���ڰ����� �ް�
		this.numOfEdge = numOfVertex-1;				// ���� �ʱ�ȭ(����Ʈ���� n-1�� ����)
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
	public void insertEdge(int v, int w, int t){
		//�ش������� target ������ ��ġ�� ���� ���ڰ����� ���� ����ġ�� ����
		int temp = v;	//�ӽ� ���� ������ ���� ����
		weight[v][t] = w;
		v = t;	//t�ǰ��� v�� �ְ�
		weight[v][temp]=w;	//������ �׷����̹Ƿ� ������ �Ȱ��� ����ġ
		/*
		if(weight[v][t] == 999)
			numOfEdge++;
		weight[v][t] = w;
		*/
		
	}
	
	//Kruskal algorithm
	public Edge[] Kruskal_MST(){
		MinHeap m= new MinHeap(); //�׷����� ����ġ�� ���� ������������ �����ϱ����� ���
	       Edge p; //���� ��ü ����
	       //Minheap�� Edge�迭 ä���
	       for(int i=0; i<numOfVertex; i++) {
	           for(int j=i; j<numOfVertex; j++) {
	              if(weight[i][j]!=0 && weight[i][j]!=999) { //�ڱ� �ڽ���ġ,����Ǿ����� ���� ����,�ߺ������� ������ ������
	                p=new Edge(i,weight[i][j],j); //������ ���� ��ü�� ����
	                m.insert(p); //���� ������������ ����
	              }
	           }
	        }
	       
	       //�ּҺ�� ����Ʈ�� ä���
	       Edge kru[]=new Edge[numOfEdge]; //�ּҺ�����Ʈ���� ������ �迭, ����������ŭ ũ������
	       UnionFind u =new UnionFind(m.numberElements()); //���� ����� ������ŭ �����������  
	       int count=0; //������ ī��Ʈ�� ����
	       Edge q; //�ӽ� ������
	       while(count<numOfEdge) { //������ ������ŭ �ݺ��Ѵ�
	          q=m.delete(); //���� ���������ִ� ���Ҹ� ��ȯ�޴´�(����ġ�� ���� ���� ����)
	          if(u.find(q.vertex, q.target)) { //���� ���� ���տ� �����ִٸ� ����Ŭ�� �̷� �� �ֱ� ������ ���Ҹ� �������� �ʰ� �ٸ� ���Ҹ� ã�´�
	             continue;
	          }
	          kru[count]=q; //�ּҺ�����Ʈ�� �迭�� ����
	          u.union(q.vertex, q.target); //����� �ΰ����� ���� �������� �����ش�
	          count++; //�������� ����
	       }
	       
	       return kru; //�ϼ��� �ּҺ�����Ʈ�� ����
		
	}
	
	//Edge print
	public void printEdge(){
		for(int i = 0; i < numOfVertex; i++) {
			for(int j = i; j < numOfVertex; j++) {	//j==i �����ؼ� �ߺ��� ���� ����
				if(weight[i][j] != 999 && weight[i][j] != 0) {//������� ���� ����,�ڽ��� ��ġ�� ������ ������ ���� ���
					System.out.printf("[ %d-- %d--> %d]\n",i,weight[i][j],j);
				}
			}
		}
		
	}
	
	//Graph print
	public void print(){
		for(int i = 0; i < weight.length; i++) {
			for(int j =0; j < weight.length; j++) {
				System.out.printf("|%3d|",weight[i][j]);;
			}
			System.out.println();
		}
		
	}
}
