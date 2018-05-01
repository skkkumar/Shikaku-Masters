package rectangles;

public class Result {
	@Override
	public String toString() {
		return "Result [found=" + found + ", nodesExpanded=" + nodesExpanded
				+ "]";
	}

	public Result(boolean found, int nodesExpanded) {
		super();
		this.found = found;
		this.nodesExpanded = nodesExpanded;
	}

	private boolean found;
	private int nodesExpanded;

	public void incrementNumberOfNodesExpaned() {
		nodesExpanded++;
	}

	public void setFound(boolean found) {
		this.found = found;
	}

	public boolean isFound() {
		return found;
	}

	public void setNodesExpanded(int nodesExpanded) {
		this.nodesExpanded = nodesExpanded;
	}

	public int getNodesExpanded() {
		return nodesExpanded;
	}

}
