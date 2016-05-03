package es.uniovi.asw.VoteCounting.dto;

public class ResultDto {

	private String x;
	private long y;
	
	public ResultDto(String x, long y) {
		this.x = x;
		this.y = y;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}
	
	
}
