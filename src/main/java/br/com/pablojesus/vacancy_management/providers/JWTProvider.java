package br.com.pablojesus.vacancy_management.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class JWTProvider {

    @Value("${security.token.secret}")
    private String secretKey;

    public DecodedJWT validateToken(String token) {
        
        // remove o prefixo "Bearer "
        token = token.replace("Bearer ", "");

        // usa o algoritimo HMAC256 para validar a chave secreta
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        try {
            var tokenDecoded = JWT.require(algorithm)
                    .build()
                    .verify(token);
           
            return tokenDecoded;
        } catch (JWTVerificationException ex) {
            ex.printStackTrace();
            System.out.println("🔐 Chave usada para validação: " + secretKey);
            System.out.println("📦 Token recebido: " + token);
            System.out.println("🔑 [" + secretKey + "] (length=" + secretKey.length() + ")");

            return null;
        }
    }
}
