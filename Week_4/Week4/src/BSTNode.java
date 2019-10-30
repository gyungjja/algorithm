
public class BSTNode {
	private BSTNode left;	//����� ����
	private int key;	//Ű��
	private BSTNode right;	//����� ������
	
	public BSTNode() {	//������ �ʱⰪ
		this.left = null;
		this.key = 0;
		this.right = null;
	}
	
	public BSTNode(int key)	//������
	{
		this.left = null;
		this.key = key;
		this.right = null;
	}
	
	public BSTNode getLeft(){	//getter
		return left;
	}
	public void setLeft(BSTNode left){	//setter
		this.left = left;
	}
	public int getKey(){	//getter
		return key;
	}
	public void setKey(int key){	//setter
		this.key = key;
	}
	public BSTNode getRight(){	//getter
		return right;
	}
	public void setRight(BSTNode right) {	//setter
		this.right = right;
	}

}