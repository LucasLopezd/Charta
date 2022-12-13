package com.wallet.wallet.api.controller;

import com.wallet.wallet.api.service.ILanguageService;
import com.wallet.wallet.domain.dto.request.LanguageRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;

@RestController
@RequestMapping("/languages")
@Api(tags = "Languages", description = " " )
public record LanguageController(ILanguageService service) {

    @ApiOperation(value = "Add a new language")
    @PostMapping("/save")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> save(@RequestBody LanguageRequestDto dto){
        return responseBuilder(CREATED, service.save(dto));
    }

    @ApiOperation(value = "Find a language by Id")
    // @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return responseBuilder(OK, service.getById(id));
    }

    @ApiOperation(value = "Delete a language by id")
    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
