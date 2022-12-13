package com.wallet.wallet.api.controller;

import com.wallet.wallet.api.service.IExpenseService;
import com.wallet.wallet.domain.dto.request.ExpenseRequestDto;
import com.wallet.wallet.domain.dto.request.ExpenseUpdateDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import static org.springframework.http.HttpStatus.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;

@RestController
@RequestMapping("/expenses")
@Api(tags = "Expense", description = " " )
public record ExpenseController(IExpenseService service) {

    @ApiOperation(value = "Register a new Expense")
    @PostMapping("/save")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> save(@RequestBody ExpenseRequestDto dto, @RequestHeader("Authorization") String token) {
        return responseBuilder(CREATED, service.save(dto, token));
    }

    @ApiOperation(value = "Update a Expense by Id")
    //@PreAuthorize("hasAuthority('USER')")
    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody ExpenseUpdateDto expenseUpdateDto,
                                    @PathVariable Long id,
                                    @RequestHeader("Authorization") String token) {
        return responseBuilder(OK, service.update(expenseUpdateDto, id, token));
    }

    @ApiOperation(value = "Find Expenses by User", hidden = true)
    @GetMapping("/user/findAll")
    //@PreAuthorize("hasAuthority('USER')")
    public  ResponseEntity<?> getAll(@RequestHeader("Authorization") String token){
        return responseBuilder(OK, service.getAllByUserId(token));
    }

    @ApiOperation(value = "Find Expense by Id by User", hidden = true)
    @GetMapping("/user/findById/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public  ResponseEntity<?> getById(@PathVariable Long id, @RequestHeader("Authorization") String token){
        return responseBuilder(OK, service.getById(id, token));
    }

    @ApiOperation(value = "Find information by User for Home", hidden = true)
    @GetMapping("/user/home")
    //@PreAuthorize("hasAuthority('USER')")
    public  ResponseEntity<?> getForHome(@RequestHeader("Authorization") String token){
        return responseBuilder(OK, service.getForHome(token));
    }

    @ApiOperation(value = "Find balance by User for Category name", hidden = true)
    @GetMapping("/user/categoryGroup")
    //@PreAuthorize("hasAuthority('USER')")
    public  ResponseEntity<?> groupByCategoryByUserId(@RequestHeader("Authorization") String token){
        return responseBuilder(OK, service.groupByCategoryByUserId(token));
    }

    @ApiOperation(value = "Find by Filter and Order by User", hidden = true)
    @GetMapping("/user/filter")
    //@PreAuthorize("hasAuthority('USER')")
    public  ResponseEntity<?> filter(@RequestParam(required = false) List<Long> categoriesId,
                                     @RequestParam(required = false) Double amountMin,
                                     @RequestParam(required = false) Double amountMax,
                                     @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate start,
                                     @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate end,
                                     @RequestParam( defaultValue = "date") String orderBy,
                                     @RequestParam( defaultValue = "DESC") String order,
                                     @RequestHeader("Authorization") String token){

        return responseBuilder(OK, service.filter(token, categoriesId, amountMin, amountMax, start, end, orderBy, order));
    }

    @ApiOperation(value = "Find information by Statistics by User")
    @GetMapping("/user/statistics")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getStatistics(@RequestHeader("Authorization") String token){
        return responseBuilder(OK, service.getStatistics(token));
    }

    @ApiOperation(value = "Delete a expense by Id")
    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public  ResponseEntity<Void> delete(@PathVariable Long id, @RequestHeader("Authorization") String token){
        service.delete(id, token);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
