package com.example.CampusDeVerano.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.example.CampusDeVerano.dto.AuthenticationReques;
import com.example.CampusDeVerano.dto.AuthenticationResponce;
import com.example.CampusDeVerano.model.Usuario;
import com.example.CampusDeVerano.repositorio.UsuarioRepository;

public class AuthenticacionService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private jwtService jwtService;
    
    public AuthenticationResponce login(AuthenticationReques authRequest) {
        
        UsernamePasswordAuthenticationToken authenToken = new UsernamePasswordAuthenticationToken(
            authRequest.getNombre(), authRequest.getPassword()

        ); 
        
        authenticationManager.authenticate(authenToken);

        Usuario  usuario = usuarioRepository.findByCorreo(authRequest.getNombre()).orElseThrow(()-> new RuntimeException("El usuario no funciona"));
        
        String jwt = jwtService.generateToken(usuario, generaExtraClainms(usuario));
                
                return new AuthenticationResponce(jwt);
        
        
            }
        
            private Map<String , Object> generaExtraClainms(Usuario usuario) {
                Map<String, Object> extraClain = new HashMap<>();
                extraClain.put("nombre", usuario.getUsername());
                extraClain.put("role" , usuario.getAuthorities());

                return extraClain;
            }
    
}
