package com.company.controller;

import com.company.dto.CardDTO;
import com.company.servise.CardService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/card")
public class CardController {

//    final Logger log = LoggerFactory.getLogger(CardController.class);

    @Autowired
    private CardService cardService;

    @PostMapping("/create")
    @ApiOperation(value = "create method", notes = "Bunda Card create qilinadi", nickname = "NickName")
    public ResponseEntity<?> create(@Valid @RequestBody CardDTO dto) throws ClassNotFoundException {
        cardService.log(dto);
        CardDTO dto1 = cardService.create(dto);
        return ResponseEntity.ok(dto1);
    }

    @GetMapping("/getAllCard")
    @ApiOperation(value = "Get method", notes = "Bunda Barcha cardlar olinadi", nickname = "NickName")
    public ResponseEntity<?> getAllCard() {
        cardService.log();
        List<CardDTO> getAllCard = cardService.getAllCard();
        return ResponseEntity.ok(getAllCard);
    }

    @PutMapping("/update/{cardId}")
    @ApiOperation(value = "update method", notes = "Bunda Card update qilinadi", nickname = "NickName")
    public ResponseEntity<?> update(@PathVariable("cardId") Integer cardId, @Valid @RequestBody CardDTO dto) {
        cardService.log(dto);
        CardDTO cardDTO = cardService.updateCard(dto, cardId);
        return ResponseEntity.ok(cardDTO);
    }

    @DeleteMapping("deleteCard/{cardId}")
    @ApiOperation(value = "delete method", notes = "Bunda Card delete qilinadi", nickname = "NickName")
    public ResponseEntity<?> delete(@PathVariable("cardId") Integer cardId) {
        cardService.log();
        String response = cardService.deleteCard(cardId);
        return ResponseEntity.ok(response);
    }


}
