package models;

public class AvlTree {

	private Node root;

	public void add(Node node) {
		if (root != null) {
			add(root, node);
		}else {
			root = node;
		}
	}

	private void add(Node base, Node node) {
		if (node.getInfo() < base.getInfo()) {
			if (base.getLeft() != null) {
				add(base.getLeft(), node);
			}else {
				base.setLeft(node);
				leftRotation(node);
				rightRotation(node);
			}
		}else {
			if (base.getRight() != null) {
				add(base.getRight(), node);
			}else {
				base.setRight(node);
			}
		}
	}
	
	public void leftRotation(Node node){
		Node baseAux;
		if (node.getHeight() < -1) {
			baseAux = node.getRight();
			baseAux.setLeft(node);
			baseAux.setRight(baseAux.getRight());
		}
	}
	
	public void rightRotation(Node node){
		Node baseAux;
		if (node.getHeight() > 1) {
			baseAux = node.getLeft();
			baseAux.setLeft(baseAux.getLeft());
			baseAux.setRight(node);
		}
	}
	
	public int calculateHeight(Node node){
		int altura = 0;
		while(node.getLeft() != null){
			System.out.println("neneneneen" + altura);
			node.setHeight(altura++);
			node.setLeft(node.getLeft());
		}
		return altura;
	}
}