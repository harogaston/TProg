package tprog.logica.dt;

import java.util.Objects;

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
	public boolean equals(Object o) {
		DTMinProveedor dt = (DTMinProveedor) o;
		return ((this.email.equals(dt.getEmail())) && (this.nickname.equals(dt.getNickname())) && (this.empresa.equals(dt.getEmpresa())));
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nickname);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.empresa);
        return hash;
    }
}
