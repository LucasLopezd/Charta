package com.wallet.wallet.api.controller;

import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;
import com.wallet.wallet.api.service.IIncomeService;
import com.wallet.wallet.domain.dto.request.IncomeRequestDto;

import com.wallet.wallet.domain.dto.request.IncomeUpdateDto;
import com.wallet.wallet.domain.enums.EIncome;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import static org.springframework.http.HttpStatus.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/incomes")
@Api(tags = "Income", description = " " )
public record IncomeController(IIncomeService service) {

    @ApiOperation(value = "Register a new income")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody IncomeRequestDto dto, @RequestHeader("Authorization") String token){
        return responseBuilder(CREATED, service.save(dto, token));
    }

    @ApiOperation(value = "Update an income by Id")
    // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody IncomeUpdateDto incomeUpdateDto,
                                    @PathVariable Long id,
                                    @RequestHeader("Authorization") String token) {
        return responseBuilder(OK, service.update(incomeUpdateDto, id, token));
    }

    @ApiOperation(value = "Find an income by id")
    @GetMapping("/findOne/{id}")
    public ResponseEntity<?> findByID(@PathVariable Long id) {
        return responseBuilder(OK, service.findById(id));
    }

    @ApiOperation(value = "Find incomes by User", hidden = true)
    @GetMapping("/findAll")
    public  ResponseEntity<?> findAllByUserId(@RequestHeader("Authorization") String token){
        return responseBuilder(OK, service.getAllByUserId(token));
    }

    @ApiOperation(value = "Find by Filter and Order by User", hidden = true)
    @GetMapping("/filter")
    //@PreAuthorize("hasAuthority('USER')")
    public  ResponseEntity<?> filter(@RequestParam(required = false) EIncome type,
                                     @RequestParam(required = false) Double amountMin,
                                     @RequestParam(required = false) Double amountMax,
                                     @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate start,
                                     @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate end,
                                     @RequestParam( defaultValue = "date") String orderBy,
                                     @RequestParam( defaultValue = "DESC") String order,
                                     @RequestHeader("Authorization") String token){

        return responseBuilder(OK, service.filter(token, type, amountMin, amountMax, start, end, orderBy, order));
    }


    @ApiOperation(value = "Find all incomes")
    @GetMapping("/getAll")
    public ResponseEntity<?> findAll() {
        return responseBuilder(OK, service.findAll());
    }


    @ApiOperation(value = "Delete an income by Id")
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id, @RequestHeader("Authorization") String token){
        service.delete(id, token);
        return ResponseEntity.status(NO_CONTENT).build();
    }


}
