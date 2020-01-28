package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.RegistrationOffice;
@Repository
public interface RegistrationOfficeRepository extends JpaRepository<RegistrationOffice,Integer> {
}
