package com.wallet.wallet.api.service.generic;

import com.wallet.wallet.domain.mapper.IMapper;
import com.wallet.wallet.domain.model.User;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Locale;

import static com.wallet.wallet.domain.enums.EMessageCode.*;

@Service
public abstract class GenericServiceImpl <ENT, RES, REQ, ID> implements GenericServiceAPI<ENT, RES, REQ, ID>{

    @Override
    public RES save(REQ request) {
        return getMapper().entityToResponseDto(getRepository().save(getMapper().requestDtoToEntity(request)));
    }

    @Override
    public RES getById(ID id) {
        return getMapper().entityToResponseDto(getRepository().findById(id).orElseThrow(()
                ->  new EntityNotFoundException(getMessenger().getMessage(RESOURCE_NOT_FIND_BY_ID.name(), new Object[] { id }, Locale.getDefault()))));
    }

    @Override
    public void delete(ID id){
        getById(id);
        getRepository().deleteById(id);
    }

    @Override
    public abstract JpaRepository<ENT, ID> getRepository();

    @Override
    public abstract IMapper<ENT, RES, REQ> getMapper();

    @Override
    public abstract MessageSource getMessenger();
}
