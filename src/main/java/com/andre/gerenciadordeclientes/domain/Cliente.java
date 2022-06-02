package com.andre.gerenciadordeclientes.domain;

import java.util.Objects;

public class Cliente {
	private String cpfOuCnpj;
	private String nome;
	private String endereco;
	private String numero;
	private String bairro;
	private String cep;
	private Cidade cidade;
	private String telefone;
	private String email;
	private boolean isAtivo;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String cpfOuCnpj, String nome, boolean isAtivo) {
		super();
		this.cpfOuCnpj = cpfOuCnpj;
		this.nome = nome;
		this.isAtivo = isAtivo;
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
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
		return Objects.hash(cpfOuCnpj);
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
		return Objects.equals(cpfOuCnpj, other.cpfOuCnpj);
	}


}
