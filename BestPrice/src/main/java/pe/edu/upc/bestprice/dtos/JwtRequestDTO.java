package pe.edu.upc.bestprice.dtos;

import java.io.Serializable;


public class JwtRequestDTO implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	private String nombre;
	private String password;
	public JwtRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JwtRequestDTO(String username, String password) {
		super();
		this.nombre = username;
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUsername() {
		return nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.nombre = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}