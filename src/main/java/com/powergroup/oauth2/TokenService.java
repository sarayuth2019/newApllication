package com.powergroup.oauth2;

import com.powergroup.model.service.UserDetailServiceImpl;
import com.powergroup.model.table.Market;
import com.powergroup.model.table.UserEntity;
import com.powergroup.util.EncoderUtil;
import com.powergroup.util.TokenUtil;
import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;

@Log4j2
@Component
public class TokenService {
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.monthValidity}")
    private int monthValidity;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private EncoderUtil encoderUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private TokenUtil tokenUtil;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createShop(UserEntity userEntity) {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime sixMonthDay = today.plusMonths(monthValidity);
        Date validity = Date.from(sixMonthDay.atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder().setSubject("1" + userEntity.getEmail())
                .claim("NAME", "1" + userEntity.getEmail()).signWith(SignatureAlgorithm.HS512, secretKey).setExpiration(validity)
                .setIssuer("nsc").compact();
    }

    public String createTokenMarket(Market customer) {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime sixMonthDay = today.plusMonths(monthValidity);
        Date validity = Date.from(sixMonthDay.atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder().setSubject("2" + customer.getEmail())
                .claim("NAME", "2" + customer.getEmail()).signWith(SignatureAlgorithm.HS512, secretKey).setExpiration(validity)
                .setIssuer("nsc").compact();
    }

    public Authentication getAuthentication(String token) {
        String plainText = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
        UserDetails userDetails = userDetailsService.loadUserByUsername(plainText);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return (claims.getBody().getExpiration().before(new Date())) ? false : true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getTokenValue(String authHeaderValue) {
        return (StringUtils.hasText(authHeaderValue) && authHeaderValue.startsWith("Bearer ")) ? authHeaderValue.substring(7, authHeaderValue.length()) : null;
    }

}

