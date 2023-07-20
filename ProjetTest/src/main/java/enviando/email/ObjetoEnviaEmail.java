package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ObjetoEnviaEmail {
	
	private String userName = "willamesimal@gmail.com";
	private String senha = "WPLima19072021lizzie";
	
	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String textoEmail = "";
	
	public ObjetoEnviaEmail(String listaDestinatario, String nomeRemetente, String assuntoEmail, String textoEmail) {
		this.listaDestinatarios = listaDestinatario;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}
	
	public void enviarEmail() throws Exception {		
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true"); /* Ativa a autenticação */
		properties.put("mail.smtp.starttls.enable", "true"); /* Ativa o uso de TLS */
		properties.put("mail.smtp.host", "smtp.gmail.com"); /* Servidor SMTP do Gmail */
		properties.put("mail.smtp.port", "587"); /* Porta do servidor SMTP do Gmail */
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, senha);
			}
		});
		
		Address[] toUser = InternetAddress.parse(listaDestinatarios);
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente)); /* Quem está enviando */
		message.setRecipients(Message.RecipientType.TO, toUser); /* Email de destino */
		message.setSubject(assuntoEmail); /* Assunto do e-mail */
		message.setText(textoEmail); /* Conteúdo do e-mail */
		
		Transport.send(message);
		
		System.out.println("E-mail enviado com sucesso");
	}
}
