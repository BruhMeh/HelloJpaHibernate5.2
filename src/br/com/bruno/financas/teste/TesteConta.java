package br.com.bruno.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bruno.financas.model.Conta;

public class TesteConta {

	public static void main(String[] args) {
		Conta conta = new Conta();
		
		conta.setTitular("Bruno");
		conta.setAgencia("123");
		conta.setBanco("Banco Quixeramobim");
		conta.setNumero("12345678");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		EntityManager em = emf.createEntityManager();
		
		//Inicio Transação
		em.getTransaction().begin();
		
		em.persist(conta);
		
		//Fim Transação
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
