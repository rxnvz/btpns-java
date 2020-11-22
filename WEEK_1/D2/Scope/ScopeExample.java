public class ScopeExample {
	private int i=1; //9 //15
	public void firstMethod() {
		int i=4, j=5; // 1
		this.i = i + j; // 9
		secondMethod(7);
	}
	public void secondMethod(int i) {
		int j=8; // 9
		this.i = i + j; // 15
	}
}
