package com.startup.humanresourcescrm.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.startup.humanresourcescrm.entity.BaseEntity;
import com.startup.humanresourcescrm.entity.UserSec;
import com.startup.humanresourcescrm.repository.BaseEntityRepository;
import com.startup.humanresourcescrm.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtUtil {
    private final String privateKey;
    private final String userGenerator;
    private final UserRepository userRepository;
    private final BaseEntityRepository baseEntityRepository;

    public JwtUtil(
            @Value("${security.jwt.private.key}") String privateKey,
            @Value("${security.jwt.user.generator}") String userGenerator,
            UserRepository userRepository,
            BaseEntityRepository baseEntityRepository) {
        this.privateKey = privateKey;
        this.userGenerator = userGenerator;
        this.userRepository = userRepository;
        this.baseEntityRepository = baseEntityRepository;
    }
    public String createToken (Authentication authentication){

        Algorithm algorithm = Algorithm.HMAC256(privateKey);
        String raw = authentication.getPrincipal().toString();
        String email = raw.substring(raw.indexOf("Username=") + 9, raw.indexOf(", Password="));

        UserSec userSec = userRepository.getByEmail(email);
        BaseEntity baseEntity = baseEntityRepository.getByUserSec(userSec);
        Long entityId = (baseEntity != null) ? baseEntity.getIdBaseEntity() : 0L;

        String authorities = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return JWT.create()
                .withIssuer(this.userGenerator)
                .withSubject(raw)
                .withClaim("entityId", entityId)
                .withClaim("authorities" , authorities)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + (30*60000)))
                .withJWTId(UUID.randomUUID().toString())
                .withNotBefore(new Date(System.currentTimeMillis() + (30*60000)))
                .sign(algorithm);
    }

    public DecodedJWT validateToken (String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(privateKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(this.userGenerator)
                    .build();
            return verifier.verify(token);
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException("Invalid token, Not authorized");
        }

    }

    public String extractUserName (DecodedJWT decodedJWT){
        return decodedJWT.getSubject();
    }

    public Claim getSpecificClaim (DecodedJWT decodedJWT , String claimName){
        return decodedJWT.getClaim(claimName);
    }

    public Map<String , Claim> returnAllClaims (DecodedJWT decodedJWT) {
        return decodedJWT.getClaims();
    }

}
