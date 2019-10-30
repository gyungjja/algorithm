package week10;

import java.util.Queue;	//ť ���̺귯��
import java.util.LinkedList;	//���Ḯ��Ʈ ���̺귯��

public class AOVGraph {
	private Queue<Integer>[] Q;	// ���� i�� ���� �ļ��ڸ� �����ϴ� ť
	private Queue<Integer> zeroPredQ;	// �����ڰ� ���� �������� �����ϴ� ť
	private LinkedList<Integer> sortedList;	//���� ���� ����� �����ϴ� ����Ʈ
	private int[] indegree;	//���� i �� ���� ����
	private int n;	//���� ��
	
	public AOVGraph(int numOfVertex){	//������
		n = numOfVertex;
		Q = new Queue[n];	//ť �迭 ����
		zeroPredQ = new LinkedList<Integer>();	//�����ڰ� ���� ������ �����ϴ� ť ����
		sortedList = new LinkedList<Integer>();	//���� ���� ����� �����ϴ� ����Ʈ ����
		for(int i = 0; i < n; i++){	//���������� �ݺ�
			Q[i] = new LinkedList<Integer>();	//�ʱ�ȭ
		}
		indegree = new int[n];	//���� ���� ����
		
	}
	
	public void topologicalSort(){
		int i,v,successor;	//successor = ������
		for(i = 0; i <n; i++){
			if(indegree[i]==0)	//������ ������
				zeroPredQ.offer(i);	//�����ڰ� ���� ����ť�� ����
		}
		if(zeroPredQ.isEmpty()){	//�����ڰ� ���� ť�� �������
			System.out.println("network has a cycle");	//���
			return;	//��ȯ
		}
		while(!zeroPredQ.isEmpty()){	//�����ڰ� ���� ������ �Ⱥ��� ����
			v = zeroPredQ.poll();	//v�� ������ �� ����
			sortedList.offer(v);	//���Ḯ��Ʈ�� ����
			if(Q[v].isEmpty()) continue;	//���� v�� �ļ��ڰ� ������ ���� while ������
			else successor = Q[v].poll();	//�ļ��ڰ� ������, ���ļ��ڸ� successor�� ����
			while(true){	
				indegree[successor]--;	//�ļ��� ������ �������� ����
				if(indegree[successor]==0)	//0�̵Ǹ�
					zeroPredQ.offer(successor);	//zeroPredQ�� ����
				if(!Q[v].isEmpty()) successor = Q[v].poll();	//����v�� �ļ��ڰ� �Ⱥ������ �����ڿ� ����v�� �����Ѱ� ����
				else break;	//�ƴϸ� break;
			}
		}
		System.out.println("Topological Order is : ");	//���
		while(!sortedList.isEmpty())	//���� ���� ����Ʈ�� ���� ����������
			System.out.print(sortedList.remove()+ " ");	//���
		System.out.println();
		System.out.println("End");
	}
	
	public void insertEdge(int i, int j){	
		Q[i].offer(j);	//���� i�� j����
		indegree[j]++;	//���� j�� �������� ����
		
		
	}

}