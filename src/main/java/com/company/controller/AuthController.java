package com.company.controller;

import com.company.RestTemplate;
import com.company.config.CustomUserDetail;
import com.company.servise.AuthService;
import com.company.dto.AuthorizationDTO;
import com.company.dto.ProfileDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.management.BadAttributeValueExpException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auth")
@Api(tags = "Auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @ApiOperation(value = "Login method", notes = "Sekinroq ishlamay qolishi mumkin", nickname = "NickName")
    public ResponseEntity<ProfileDTO> create(@Valid @RequestBody AuthorizationDTO dto) throws BadAttributeValueExpException {
        ProfileDTO response = authService.authorization(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/registration")
    @ApiOperation(value = "Registration method", notes = "Registrtion method", nickname = "NickName")
    public ResponseEntity<?> registration(@Valid @RequestBody ProfileDTO dto) throws BadAttributeValueExpException {
        ProfileDTO response = authService.registration(dto);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/info")
    public String getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();
        return customUserDetail.getUsername();
    }

    @GetMapping()
    public ResponseEntity<?> getAllUzcard() throws ClassNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        List dto1 = restTemplate.getForObject("http://localhost:8080/card/getAllCard", List.class);
        if (dto1 == null) {
            throw new ClassNotFoundException("Class Not found");
        }
        return ResponseEntity.ok(dto1);
    }

    @GetMapping("/rest")
    public ResponseEntity<?> rest() throws ClassNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/Profile", String.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        return ResponseEntity.ok(response);
    }
}
