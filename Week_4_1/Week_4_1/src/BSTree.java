

public class BSTree {
	
	private BSTNode root;
	//Ž��
	public BSTNode search(int key){
		BSTNode p = root;	//���ο� ��忡 �ű��
		while(p != null)
		{
			if(p.getKey() > key){	//�뵵�� �����Ͱ��� Ű���� ũ��
				p = p.getLeft();	//��������
			}
			else if(p.getKey() == key){	//����� �����ΰ��� Ű���� ��ġ�ϸ� 
				return p;	//����
			}
			else
				p = p.getRight();	//�����Ͱ��� Ű���� ������ ����������
		}
		return p;	//��ȯ
		
	}
	//����
	public void insert(int key){
		BSTNode p = root;	//���ο� ��忡 �ű��
		BSTNode q = new BSTNode();	//�θ���
		while(p != null){
			if(key == p.getKey())	//Ű�� �����Ͱ��� ������
				return;		//����
			q = p;	//�θ��忡 �ű��
			if(key < p.getKey())	//Ű���� �����Ͱ����� ������
				p = p.getLeft();	//����
			else 
				p = p.getRight();	//Ű���� �����Ͱ����� ũ�� ������
			}
		BSTNode newNode = new BSTNode();	//���ο� ��忡 Ž���� ��尪������ �ְ�
		newNode.setKey(key);	//�־��ٲ� ����
		newNode.setRight(null);	//�־��ٲ� ����
		newNode.setLeft(null);	//�־��ٲ� ����
		
		if(root == null)	//null�̸�
			root = newNode;	
		else if(key < q.getKey())	//Ű���� �θ��庸�� ������
			q.setLeft(newNode);		//���ʿ�
		else	//Ű���� �θ��庸�� ũ��
			q.setRight(newNode);	//�����ʿ�
		return;	//����
		
	}
	//����
	public void delete(int key)
	{
		deleteBST(this.root,key);
	}
	public void deleteBST(BSTNode root,int key)
	{
		BSTNode p = root;	//��Ʈ��带 p�� ����
		BSTNode q = p;		//�θ��� 
		
		while(p != null)	//���� ã��
		{
			if(key == p.getKey()) break;
			q = p;
			if(key < p.getKey()) p = p.getLeft();
			else p = p.getRight();
		}
		
		if(p == null) return;
		
		//������� ����
		if((p.getLeft() == null) && (p.getRight() == null)) 
		{
			if(q.getLeft() == p)	//�����Ϸ��� ���� �θ����� ���ʰ��� ������
				q.setLeft(null);	//�θ����� ���ʰ��� ����ְ�
			else					//�ƴϸ�
				q.setRight(null);	//�θ����� �����ʰ��� ����ش�.
		}
		//�ϳ��� �ڽ� == null
		else if((p.getLeft() == null) || (p.getRight() == null)) 
		{
			if(p == root)	//�����Ϸ��� ���� ������
			{
				root = null;	//����ش�.
			}
			//Left Child null
			else if(p.getLeft() != null)	//���ʰ��� ������� ������
			{
				if(p == root)
					root = p.getLeft();
				else if(q.getLeft() == p)	//�θ����� ���ʰ��� �����Ϸ��� ���� ������
					q.setLeft(p.getLeft());	//�θ����� ������ �����Ϸ��� ����� ���ʰ����� ����
				else						//�ƴϸ�
					q.setRight(p.getLeft());	//�θ����� �������� �����Ϸ��� ����� ���� ������ ����
			}
			
			//right child null
			else
			{
				if(p == root)
					root = p.getRight();
				else if(q.getLeft() == p)	//�θ����� ���ʰ��� �����Ϸ��� ���� ������
					q.setLeft(p.getRight());	//�θ����� ������ �����Ϸ��� ����� �����ʰ����� ����
				else
					q.setRight(p.getRight());	//�θ����� �������� �����Ϸ��� ����� �����ʰ����� ����
			}
		}
		//�ΰ��� �ڽ� right subtree minimum value
		else 
		{
			q = minNode(p.getRight());	//�θ��忡 �����Ϸ��� ����� �����ʰ��� �ּҰ� ����
			p.setKey(q.getKey());	//�����Ϸ��� Ű���� �θ��� Ű������ ����
			if(p.getRight() == q)	//�����Ϸ��� ���� �����ʰ��� �ּҰ��� ������
				p.setRight(q.getRight());	//�ּҰ����� ����
			deleteBST(p.getRight(),p.getKey());	//�����ʰ��� Ű���� ����
		}
		return; //��ȯ
	}
			
	
		
	

	private BSTNode minNode(BSTNode deleteBSTNode){	//�ּҰ� ã��
		BSTNode p =deleteBSTNode; //������ ���� p�� �־��ְ�
		if(p.getLeft() == null) return p;	//������ ������ ���ʰ��� ��������� ��ȯ
		else return minNode(p.getLeft());	//�ƴϸ� ���ʰ��� �ּҰ��� ��ȯ ���
	}
	
	public boolean split(int key, BSTree bBST, BSTree cBST)
	{
		BSTNode small = new BSTNode();	//small ��� ����
		BSTNode large = new BSTNode();	//large ��� ����
		BSTNode p = this.treeCopy(this.root);	//���� ���
		BSTNode s = small;	//small ���
		BSTNode l = large;	//large ���
		while(p != null)	//������� ������ ���� 
		{
			if(key == p.getKey())	//���� ���� ������
			{
				s.setRight(p.getLeft());	//���� �������� ���������ʿ� ����
				l.setLeft(p.getRight());	//������ ū���� �������ʿ� ���� 
				bBST.root = small.getRight();	//������� Ʈ���� �־��ֱ�
				cBST.root = large.getLeft();	//������� Ʈ���� �־��ֱ�
				return true;
			}
			else if(key < p.getKey()){	//ã�� ������ �� ũ��
				l.setLeft(p);	//���� ���ʿ� ã�°� ����
				l = p;	//p�� l�� ����
				p = p.getLeft();	//���ʰ� p����
			}
			else{
				s.setRight(p);	//���� �����ʰ��� ã�°����� ����
				s = p;	
				p = p.getRight();
			}
		}
		
		if(key > root.getKey())	//ã������ ���� ��Ʈ�� ������ ũ��
			s.setRight(null);	//������� ������ �� ����
		else if(key < root.getKey())//ã������ ���� ��Ʈ�� ������ ������
			l.setLeft(null);	//������� ���� �� ����
			
		
		bBST.root = small.getRight();
		cBST.root = large.getLeft();
		return false;
	}
	
	private BSTNode treeCopy(BSTNode T)
	{
		BSTNode S, L, R;
		if(T != null)	//������� ������
		{
			L = treeCopy(T.getLeft());	//���� ����
			R = treeCopy(T.getRight());	//�����ʺ���
			S = new BSTNode(T.getKey());	//��������
			S.setLeft(L);	//���ʼ���
			S.setRight(R);	//������ ����
		}
		else	//���������
			return null;	//��ȯ
		return S;	//��ȯ
	}
	public void print() {	//����Ʈ�Լ�
		printBST(root);
		System.out.println();
	}
	
	private void printBST(BSTNode root) {
		if(root != null) {	//������� ������
			System.out.print("<");
			printBST(root.getLeft());	//�������
			System.out.print(root.getKey());	//Ű�����
			printBST(root.getRight());	//���������
			System.out.print(">");
		}
	}

	
	
}