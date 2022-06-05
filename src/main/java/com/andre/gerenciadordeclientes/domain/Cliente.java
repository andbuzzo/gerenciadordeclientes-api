package com.andre.gerenciadordeclientes.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Campo CPF/CNPJ é obrigatório!!!")
	@NotNull(message = "Campo CPF/CNPJ é obrigatório!!!")
	private String cpfOuCnpj;

	@NotEmpty(message = "Campo Nome é obrigatório!!!")
	@NotNull(message = "Campo Nome é obrigatório!!!")
	private String nome;
	
	private String endereco;
	private String numero;
	private String bairro;
	private String cep;

	@Column(name = "cidade_id")
	private Integer cidade;

	private String telefone;

	@Email
	private String email;
	private boolean isAtivo;

	public Cliente() {

	}

	public Cliente(Integer id, String cpfOuCnpj, String nome, String endereco, String numero, String bairro, String cep,
			Integer cidade, String telefone, @Email String email, boolean isAtivo) {
		super();
		this.id = id;
		this.cpfOuCnpj = cpfOuCnpj;
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.telefone = telefone;
		this.email = email;
		this.isAtivo = isAtivo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAtivo() {
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	@Override
	public String toString() {
		return "Cliente [cpfOuCnpj=" + cpfOuCnpj + ", nome=" + nome + ", endereco=" + endereco + ", numero=" + numero
				+ ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", telefone=" + telefone + ", email="
				+ email + ", isAtivo=" + isAtivo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpfOuCnpj, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpfOuCnpj, other.cpfOuCnpj) && Objects.equals(id, other.id);
	}

}
