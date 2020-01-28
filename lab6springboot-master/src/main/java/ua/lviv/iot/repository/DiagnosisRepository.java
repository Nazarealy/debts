package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Diagnosis;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis,Integer> {
}
