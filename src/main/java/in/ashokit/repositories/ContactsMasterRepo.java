package in.ashokit.repositories;
import org.springframework.data.repository.CrudRepository;
import in.ashokit.entities.ContactsMasterEntity;
import java.io.Serializable;


public interface ContactsMasterRepo  extends CrudRepository<ContactsMasterEntity,Serializable> {

}
