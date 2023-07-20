package enviando.email;

public class AppTest {	
	
	@org.junit.Test
	public void testeEmail() throws Exception{
		
		ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("illaap@hotmail.com",
															"Willames Lima",
															"Testando e-mail com java",
															"Esse texto é a descrição do meu e-mail");
		
		enviaEmail.enviarEmail();
		
	}

}
