package com.wallet.wallet.api.service;

import com.wallet.wallet.domain.dto.PageDto;

public interface IPagination <E> {

    PageDto<E> getPaginated(int pageNumber, int amountPerPage);
    
    
    /*     
        POSIBLE LÓGICA DEL MÉTODO:

        if (pageNum < 1 && amountPerPage < 1)
            throw new BadRequestException(messenger.getMessage(CODE, new Object[]{ pageNum, amountPerPage }, Locale));
        if (pageNum < 1)
            throw new BadRequestException(messenger.getMessage(CODE, new Object[]{ pageNum }, Locale));
        if (amountPerPage < 1)
            throw new BadRequestException(messenger.getMessage(CODE, new Object[]{ amountPerPage }, Locale));

        Pageable pageable = PageRequest.of(pageNum - 1, amountPerPage);
        Page<E> page = repository.findAll(pageable);

        if (page.isEmpty())
            throw new NotFoundException(messenger.getMessage(CODE, new Object[]{ page.getTotalPages() }, Locale));

        return mapper.mapPageToDto(page);



        CONTROLADOR:

        @GetMapping
        public ResponseEntity<?> getPaginated(@RequestParam int pageNumber, @RequestParam int amountPerPage) {
        return responseBuilder(service.getPaginated(pageNumber, amountPerPage));



        -->    faltaria la lógica del mapper

    */
}
