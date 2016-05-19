package logic;

import java.util.Vector;

public class UserInfo {
	
	String port;
	String ip;
	Vector<String> files;
	
	public UserInfo(String port, String ip) {
		this.ip = ip;
		this.port = port;
		this.files = new Vector<String>();
	}

	public UserInfo getUserInfo() {
		return this;
	}
	
}
