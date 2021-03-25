package Contato;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.generation.blogpessoal.model.ContatoModel;
import org.generation.blogpessoal.repository.ContatoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest 
public class ContatosRepositoryIntegrationTest {

private ContatoModel contato;
	
	@Autowired
	private ContatoRepository contatoRepository;

	@Before
	public void start() {
		contato = new ContatoModel("Gustavo", "11", "964434580");
	}
	
	@Test (expected = RuntimeException.class)
	public void salvarComTelNulo() throws Exception {

		contato.setTelefone(null);
		contatoRepository.save(contato);
	}
	
	@Test (expected = RuntimeException.class)
	public void salvarComDddNulo() throws Exception {
		
		contato.setDdd(null);
		contatoRepository.save(contato);
	}
	
	@Test (expected = RuntimeException.class)
	public void salvarComNomeNulo() throws Exception {
		
		contato.setNome(null);
		contatoRepository.save(contato);
	}
}