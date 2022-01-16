package org.studio.funcionario;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;


@Path("/funcionarios")
public class FuncionarioResource {

	@Inject
	public FuncionarioRepository funcionarioRepository;

	@GET
	public Response list(){
		return Response.ok(funcionarioRepository.listAll()).build(); 
	}	

	@GET
	@Path("/search/{nome}")
	public Funcionario findByNome(@PathParam("nome") String nome) {
		return funcionarioRepository.findByNome(nome);
	}

	@GET
	@Path("/init")
	@Transactional
	//TODO Remover apos criacao da stack de testes
	public void init() {
		Funcionario funcionario1 = new Funcionario("Karina");
		funcionarioRepository.persist(funcionario1);	
	}

}
