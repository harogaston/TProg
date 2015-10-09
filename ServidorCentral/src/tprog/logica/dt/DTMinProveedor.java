package tprog.logica.dt;

public class DTMinProveedor {

	private final String nickname;
	private final String email;
	private final String empresa;

	public DTMinProveedor(String Nickname, String Email, String Empresa) {
		this.nickname = Nickname;
		this.email = Email;
		this.empresa = Empresa;
	}

	public String getNickname() {
		return this.nickname;
	}

	public String getEmail() {
		return this.email;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	@Override
	public String toString() {
		return "Nickname: " + nickname
				+ "\n" + "Email: " + email + "\n"
				+ "\n" + "Empresa: " + empresa + "\n";
	}

	@Override
	public boolean equals(Object objeto) {
		DTMinProveedor dataP = (DTMinProveedor) objeto;
		return ((this.email.equals(dataP.getEmail())) && (this.nickname.equals(dataP.getNickname())) && (this.empresa.equals(dataP.getEmpresa())));
	}
}
