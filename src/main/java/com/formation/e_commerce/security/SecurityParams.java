package com.formation.e_commerce.security;

public interface SecurityParams {
    String JWT_HEADER_NAME="Authorization";
    String SECRET="mariem.polytec@gmail.com";
    long EXPIRATION=3600000;//1h le temps d'expiration
    String HEADER_PREFIX="Bearer ";
}
