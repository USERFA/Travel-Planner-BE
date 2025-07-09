package JwtSecurity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private final String secret;
	
    public JwtUtil(@Value("${jwt.secret}") String secret) {
        this.secret = secret;
    }
	
	public String generateToken(String userName) {
		return Jwts.builder().setSubject(userName).setIssuedAt(new Date())
	            .setExpiration(new Date(System.currentTimeMillis() + 864_000_00)) // life =1 day
	            .signWith(SignatureAlgorithm.HS512, secret)
	            .compact();	
	}
	
	public String exctractUserName(String token) {
		return Jwts.parser().setSigningKey(secret)
	            .parseClaimsJws(token)
	            .getBody()
	            .getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
