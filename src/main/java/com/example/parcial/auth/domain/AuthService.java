package com.example.parcial.auth.domain;

import com.example.parcial.auth.infraestructure.JwtService;
import com.example.parcial.config.ModelMapper;
import com.example.parcial.exceptions.UserAlreadyExists;
import com.example.parcial.route.dto.RouteRequest;
import com.example.parcial.user.domain.Role;
import com.example.parcial.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final User userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    public TokenResponse register(RouteRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExists("Email already registered");
        }
        User user = modelMapper.map(request, User.class);
        user.setPassword(passwordEncoder.encode(request.getPassword())); // nunca guardar la password en texto plano
        if (user.getRole() == null) {
            user.setRole(Role.USER);
        }
        userRepository.save(user);
        return new TokenResponse(jwtService.generateToken(user));
    }

    public TokenResponse login(RouteRequest request) {
        // Si el email o la password estan mal, lanza un error y Spring responde 401
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        return new TokenResponse(jwtService.generateToken(user));
    }
}
