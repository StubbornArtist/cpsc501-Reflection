import java.util.ArrayList;

public class Tree<E> {
	
	private ArrayList<E> members;
	private ArrayList<Tree<E>> branches;
	private E value;
	private int depth;
	
	
	public Tree(E val) {
		members = new ArrayList<E>();
		branches = new ArrayList<Tree<E>>();
		value = val;
		depth = 0;
	}
	
	public void setValue(E val) {
		value = val;
	}
	
	public E getValue() {
		return value;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public void addBranch(Tree<E> branch) {
		branch.setDepth(depth + 1);
		branches.add(branch);
	}
	
	private String indent() {
		String indent = "";
		for(int i = 0; i < depth; i++) {
			indent += "\t";
		}
		return indent;
	}
	
	@Override
	public String toString() {
		String result = "";
		result += value.toString().replaceAll("(?m)^", indent()); 
		for(Tree<E> branch : branches) {
			result +="\n" + branch.toString();
		}
		return result;
	}
	
}
