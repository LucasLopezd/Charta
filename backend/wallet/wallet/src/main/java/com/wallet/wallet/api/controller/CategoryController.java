package com.wallet.wallet.api.controller;

import com.wallet.wallet.api.service.ICategoryService;
import com.wallet.wallet.domain.dto.request.CategoryRequestDto;
import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;

import com.wallet.wallet.domain.dto.request.CategoryUpdateDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@Api(tags = "Category", description = " ")
public record CategoryController(ICategoryService service) {

    @ApiOperation(value = "Register a new category")
    // @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CategoryRequestDto dto,
                                  @RequestHeader("Authorization") String token) {

        return responseBuilder(CREATED, service.save(dto, token));
    }

    @ApiOperation(value = "Update a category by Id")
    // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody CategoryUpdateDto dto,
                                    @PathVariable Long id,
                                    @RequestHeader("Authorization") String token) {
        
        return responseBuilder(OK, service.update(dto, id, token));
    }

    @ApiOperation(value = "Find Category by Id by User", hidden = true)
    @GetMapping("/user/findById/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public  ResponseEntity<?> getById(@PathVariable Long id, @RequestHeader("Authorization") String token){
        return responseBuilder(OK, service.getById(id, token));
    }

    @ApiOperation(value = "Find all categories by User id")
    @GetMapping("/user/findAll")
    //@PreAuthorize("hasAuthority('USER')")
    public  ResponseEntity<?> getAllByUserId(@RequestHeader("Authorization") String token){
        return responseBuilder(OK, service.getAllByUserId(token));
    }

    @ApiOperation(value = "Find all categories")
    // @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/findAll")
    public ResponseEntity<?> getAll() {
        return responseBuilder(OK, service.getAll());
    }


    @ApiOperation(value = "Delete a category by Id")
    // @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
