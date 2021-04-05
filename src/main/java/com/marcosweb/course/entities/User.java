package com.marcosweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
// aqui ficarão as entidades (objetos)

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_user") //nome da tabela a ser criada no bd
public class User implements Serializable{ /** User é nosso objeto, uma tabela do bd
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//tem que ter numero de serie

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // da certo pra muitos bd funciona mysql
	private Long id;
	private String name;
	private String email;
	private String password;
	
	//começo sempre pelo lado em que estou criando o codigo
	// 1 cliente poded ter muitos pedidos
	@JsonIgnore //na hora de puxar os pedidos, puxa os dados do client, e não da loop no lado do client (classe)
	@OneToMany(mappedBy = "client") // falo pro spring que há uma conexão com a tabela ordens chamada cliente
	private List<Order> orders = new ArrayList<>();
	
	public List<Order> getOrders() {
		return orders;
	}

	public User() {
		
	}
	
	public User(Long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
