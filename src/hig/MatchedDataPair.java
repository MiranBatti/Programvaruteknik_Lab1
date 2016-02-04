package hig;

public class MatchedDataPair {
	private double xValue, yValue;
	
	public MatchedDataPair(Double x, Double y) {
		this.xValue = x;
		this.yValue = y;
	}
	
	public Double getXValue() {
		return xValue;
	}
	
	public Double getYValue() {
		return yValue;
	}
	
	@Override
	public String toString() {
		return "x: " + this.xValue + ", y: " + this.yValue;
	}
}
