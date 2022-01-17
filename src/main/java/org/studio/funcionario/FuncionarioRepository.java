package org.studio.funcionario;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario> {

	public Funcionario findByNome(String nome) {
		return find("nome", nome).firstResult();
	}

}
