
public class Week4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BSTree bst = new BSTree();
		
		bst.insert(18); bst.insert(7); bst.insert(26);
		bst.insert(3); bst.insert(12); bst.insert(21);
		bst.insert(31); bst.insert(23); bst.insert(10);
		bst.print();
		
		
		bst.insert(30); bst.insert(20); bst.insert(40);
		bst.insert(15); bst.insert(25); bst.insert(35);
		bst.insert(80); bst.insert(23); bst.insert(27);
		System.out.print("base tree : ");
		bst.print();
		
		BSTree bBST = new BSTree();
		BSTree cBST = new BSTree();
		
		if(bst.split(25, bBST, cBST))
			System.out.println("\n25 is in the tree");
		else
			System.out.println("\n25 is not in the tree");
		bBST.print();
		cBST.print();
		
		if(bst.split(28, bBST, cBST))
			System.out.println("\n28 is in the tree");
		else
			System.out.println("\n28 is not in the tree");
		bBST.print();
		cBST.print();
		
		if(bst.split(33, bBST, cBST))
			System.out.println("\n33 is in the tree");
		else
			System.out.println("\n33 is not in the tree");
		bBST.print();
		cBST.print();
		
		if(bst.split(40, bBST, cBST))
			System.out.println("\n40 is in the tree");
		else
			System.out.println("\n40 is not in the tree");
		bBST.print();
		cBST.print();
		
		if(bst.split(15, bBST, cBST))
			System.out.println("\n15 is in the tree");
		else
			System.out.println("\n15 is not in the tree");
		bBST.print();
		cBST.print();
		
		System.out.print("\nbase tree : ");
		bst.print();
		
		
		bst.delete(10);
		bst.print();
		
		bst.delete(21);
		bst.print();
		
		bst.delete(26);
		bst.print();
		
		bst.delete(18);
		bst.print();
		
		bst.delete(23);
		bst.print();
		
		bst.delete(7);
		bst.print();
		
	}
}
