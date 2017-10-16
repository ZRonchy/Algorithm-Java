package datastructure.graph;

public class DiGraphAL {
	protected class Vertex{
		protected String label;
		protected Vertex next;
		protected Edge edges;
		
		public Vertex(String label, Vertex next){
			this.label = label;
			this.next = next;
		}
	}
	
	protected class Edge{
		protected Vertex successor;
		protected Edge next;
		protected double weight;
		
		public Edge(Vertex successor, Edge next, double weight){
			this.successor = successor;
			this.next = next;
			this.weight = weight;
		}
	}
	
	protected Vertex vList;
	public DiGraphAL(){
		vList = null;
	}
	
	public void insetEdge(String pred, String succ, double weight){
		Vertex vPred = vList;
		while(!vPred.label.equals(pred)){
			vPred = vPred.next;
		}
		
		Vertex vSucc = vList;
		while (!vSucc.label.equals(succ)){
			vSucc = vSucc.next;
		}
		
		vPred.edges = new Edge(vSucc, vPred.edges, weight);
	}
	
}
