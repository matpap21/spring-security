package pl.sda.springproject2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springproject2.entity.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}
