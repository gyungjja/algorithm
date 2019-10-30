package Week_3;


public class BTree {
	private TreeNode root;  // Ʈ������� root ����.
	
	public BTree(){
		this.root = null; // �����ڿ� ���԰��� ������� root�� null
	}
	public BTree(BTree left,Object data, BTree right){ // ���԰��� ��������� ������.
		root = new TreeNode(data);	//data ����
		root.setLeft(left.root);	//����
		root.setRight(right.root);	//����
	}
	public void setRoot(TreeNode root){	//root ����
		this.root = root;
	}
	public TreeNode getRoot(){	//root�� ����
		return this.root;
	}
	public boolean isEmpty(){   //����ִ��� Ȯ��
		return  root == null;	//this.root ��ȯ
	}
	public BTree leftSubTree(){
		BTree leftTree = new BTree(); //����Ʈ�� ����.
		leftTree.root = this.root.getLeft(); // ����Ʈ���� ��Ʈ�� �������Ʈ���� ����.
		return leftTree; // ��ȯ
		
	}
	public BTree rightSubTree(){	//������ ����Ʈ�� ��ȸ
		BTree rightTree = new BTree();	//������Ʈ�� ����
		rightTree.root = this.root.getRight();	//������Ʈ���� ��Ʈ�� ��������� Ʈ���� ����
		return rightTree;	//��ȯ
		
	}
	public Object getRootData(){	//root ��������
		return this.root;	//��ȯ��
	}
	public void inorder(){	//Ʈ�� ���� ��ȸ
		this.B_inorder(this.root);
	}
	private void B_inorder(TreeNode T){
		if(T != null) {
			this.B_inorder(T.getLeft()); // ���� ����Ʈ���� ���� ��ȸ
			System.out.print(T.getData() + " ");	//��Ʈ��带 �湮
			this.B_inorder(T.getRight());	//������ ����Ʈ�� ������ȸ
		}
	}
	public void preorder(){	//Ʈ�� ���� ��ȸ
		this.B_preorder(this.root);
		
	}
	private void B_preorder(TreeNode T){
		if(T != null) {
			System.out.print(T.getData()+" ");	//��Ʈ��� �湮
			B_preorder(T.getLeft());	//���� ����Ʈ�� ���� ��ȸ
			B_preorder(T.getRight());	//������ ����Ʈ�� ���� ��ȸ
		}
		
	}
	public void postorder(){	//Ʈ������ ��ȸ
		this.B_postorder(this.root);
		
	}
	private void B_postorder(TreeNode T){
		if(T != null) {
			B_postorder(T.getLeft());	//���� ����Ʈ���� ������ȸ
			B_postorder(T.getRight());	//������ ���� Ʈ���� ������ȸ
			System.out.print(T.getData() + " ");	//��Ʈ��� �湮
		}
		
	}
	
	public void levelOrder()	
	{
		B_levelOrder();
	}
	private void B_levelOrder(){	//���� Ʈ�� ���� ���� ��ȸ
		Queue queue = new Queue();
		TreeNode p = root;
		queue.enqueue(p);	//ó�� ��Ʈ���� �־���
		while(!queue.isEmpty()) {	//ť�� ������� ������ 
			p = queue.dequeue();	//ť �ȿ� ����ִ°� ���ְ�
			if(p != null){		
				System.out.print(p.getData() + " ");	//����
				queue.enqueue(p.getLeft());		//���ʺ��� ť ����
				queue.enqueue(p.getRight());	//�����ʺ��� ť ����
			}
			
		}
		
	}
	
	public BTree copy(){
		BTree newTree = new BTree();
		newTree.setRoot(treeCopy(this.root));
		return newTree;
	}
	
	private TreeNode treeCopy(TreeNode T){	//���� Ʈ�� Copy
		TreeNode S = null;	//���� ���� Ʈ�� �ʱ�ȭ
		if(T != null) {		//T �� ���� �ƴϸ�
			TreeNode L = treeCopy(T.getLeft());	//���� ����
			TreeNode R = treeCopy(T.getRight());	//������ ����
			S = T;	
			S.setLeft(T.getLeft());	//Ʈ����� S�� T�� ���� ���ʰ� ���� ����
			S.setRight(T.getRight());	//Ʈ����� S�� T�� ����� �����ʰ����� ����
			S.setData(T.getData());		//Ʈ����� S�� T�� ���� �����Ͱ����� ����
		}
	return S;	//��ȯ
}
	
	public boolean Equal(BTree A){
		return treeEqual(this.root,A.getRoot());
	}
	private boolean treeEqual(TreeNode root, TreeNode A){
		boolean ans = false;
		if(root == null && A == null) {	//�Ѵ� ��������� ����
			return true;	//��
		}
		else if(root !=null && A != null) {	//�Ѵ� ������� ������ ����
			if(root.getData() == A.getData())	//�� ��
				ans = treeEqual(root.getLeft(),A.getLeft());	//���� ��
			if(ans)
				ans = treeEqual(root.getRight(),A.getRight());	//������ ��
		}
		return ans;	//��ȯ��
	}
	
}