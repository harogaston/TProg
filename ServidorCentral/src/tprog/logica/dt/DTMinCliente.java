package tprog.logica.dt;

import java.util.Objects;

public class DTMinCliente {

	private String nickname;
	private String email;

	public DTMinCliente(String Nickname, String Email) {
		this.nickname = Nickname;
		this.email = Email;
	}

	public String getNickname() {
		return this.nickname;
	}

	public String getEmail() {
		return this.email;
	}

	@Override
	public String toString() {
		return "Nickname: " + nickname
				+ "\n" + "Email: " + email + "\n";
	}

	@Override
	public boolean equals(Object o) {
		DTMinCliente dt = (DTMinCliente) o;
		return (this.email.equals(dt.email)) && (this.nickname.equals(dt.nickname));
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.nickname);
        hash = 89 * hash + Objects.hashCode(this.email);
        return hash;
    }

}
