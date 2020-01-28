package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Analysis;

@Repository
public interface AnalysisRepository extends JpaRepository<Analysis,Integer> {
}
