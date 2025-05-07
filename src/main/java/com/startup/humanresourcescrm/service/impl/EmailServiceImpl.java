package com.startup.humanresourcescrm.service.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailServiceImpl {
    private final JavaMailSender mailSender;

    public void sendPasswordToClient(String to, String password) {
        MimeMessage mensaje = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true, "UTF-8");
            helper.setTo(to);
            helper.setSubject("Bienvenido a Smart Talent");
            helper.setFrom("Smart Talent <alexandersaul2604@gmail.com>");

            String htmlContent = """
            <html>
                <body style="font-family: Arial, sans-serif; line-height: 1.6;">
                    <h2 style="color: #2E86C1;">¡Bienvenido a Smart Talent!</h2>
                    <p>Hola,</p>
                    <p>Te damos la bienvenida a <strong>Smart Talent</strong>. Tu contraseña temporal para iniciar sesión es:</p>
                    <p style="font-size: 18px; font-weight: bold; color: #D35400;">%s</p>
                    <p>Por razones de seguridad, te recomendamos cambiar esta contraseña al ingresar por primera vez.</p>
                    <p>¡Gracias por confiar en nosotros!</p>
                    <br>
                    <p>Atentamente,<br>El equipo de Smart Talent</p>
                </body>
            </html>
        """.formatted(password);

            helper.setText(htmlContent, true); // true indica que es HTML

            mailSender.send(mensaje);
        } catch (MessagingException e) {
            // Manejo de errores
            e.printStackTrace();
        }
    }

}
