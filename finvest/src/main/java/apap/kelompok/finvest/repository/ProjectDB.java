package apap.kelompok.finvest.repository;

import apap.kelompok.finvest.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface ProjectDB extends JpaRepository<ProjectModel, Integer> {
    @Query("select p from #{ProjectModel} p WHERE p.is_finished = true")
    List<ProjectModel> findFinishedProject();

    @Query("select p from #{ProjectModel} p WHERE p.is_finished = false")
    Optional<ProjectModel> findOngoingProject();
}
