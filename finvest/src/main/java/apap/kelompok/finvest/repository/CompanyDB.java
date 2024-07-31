package apap.kelompok.finvest.repository;

import apap.kelompok.finvest.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDB extends JpaRepository<CompanyModel, Integer> {
    @Query("select c from #{CompanyModel} c " +
            "where c.status_perusahaan = 'ACTIVE' or " +
            "c.status_perusahaan = 'MERGED'")
    List<CompanyModel> findActiveCompany();
}
