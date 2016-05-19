package logic;

public abstract class Message {
	
	private int type;
	private String origin;
	private String destination;
	
	public abstract int getType();
	public abstract String getOrigin();
	public abstract String getDestination();

}
