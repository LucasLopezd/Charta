package com.wallet.wallet.api.controller;


import com.wallet.wallet.api.service.IAboutUsService;
import com.wallet.wallet.domain.dto.request.AboutUsRequestDto;
import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aboutUs")
@Api(tags = "AboutUs", description = " " )
public record AboutUsController(IAboutUsService service) {

    @ApiOperation(value = "Add a new card")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AboutUsRequestDto dto){
        return responseBuilder(CREATED, service.save(dto));
    }

    @ApiOperation(value = "Find all cards")
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return responseBuilder(OK, service.findAll());
    }

    @ApiOperation(value = "Delete a card by id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
