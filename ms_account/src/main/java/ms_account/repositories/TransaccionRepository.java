package ms_account.repositories;

import ms_account.models.Transaccion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransaccionRepository extends MongoRepository<Transaccion, String>{
    List<Transaccion> findByIdUserOrigen (String idUserOrigen);
    List<Transaccion> findByIdUserDestino (String idUserDestino);
}
