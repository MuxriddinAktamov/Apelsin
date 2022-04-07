package com.company;

import com.company.dto.CardDTO;
import com.company.dto.CardDTOO;
import com.company.servise.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
class ApelsinApplicationTests {
    @Autowired
    private AuthService authService;

    @Test
    void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:9090/card/test", String.class);
        System.out.println(result);


//        ProfileDTO profileDTO = new ProfileDTO();
//        profileDTO.setLogin("valish1234");
//        profileDTO.setPswd("valish1234");
//        profileDTO.setSurname("Valiyev");
//        profileDTO.setName("Valish");
//        profileDTO.setPhone("+998990000000");
//        profileDTO.setStatus(ProfileStatus.ACTIVE);
//        profileDTO.setRole(ProfileRole.User);
//        authService.registration(profileDTO);
    }

    @Test
    void GetByNumber() {
        RestTemplate restTemplate = new RestTemplate();
        List<CardDTO> result = restTemplate.getForObject("http://localhost:9090/card/getAllCard", List.class);
        System.out.println(result);

    }

    @Test
    void GetByParam() {
        int p = 1;
        int s = 10;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:9090/card/" +
                "param?size={s}&page={p}", String.class, s, p);
        System.out.println(result);

    }

    @Test
    void GetByResponseEntity() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity("http://localhost:9090/card/test", String.class);
        System.out.println(result);

        System.out.println(result.getBody());
        System.out.println(result.getStatusCode());
        System.out.println(result.getStatusCodeValue());
        System.out.println(result.getHeaders());

    }

    @Test
    void create_card() {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setName("asdasda");
        cardDTO.setNumber("8600120411222589");
        cardDTO.setProfileId(1);
        cardDTO.setExcDate("09/26");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CardDTO> result = restTemplate.postForEntity("http://localhost:9090/card/create", cardDTO, CardDTO.class);
        System.out.println(result);
    }

    @Test
    void GetByHeader() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:9090/card/test/header", HttpMethod.GET,
                entity,
                String.class);
        System.out.println(result);
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

    }

    @Test
    void requestParam() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        int p = 1;
        int s = 10;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:9090/card/" +
                "param?size={s}&page={p}", HttpMethod.GET, entity, String.class, s, p);
        System.out.println(result);

    }

}
