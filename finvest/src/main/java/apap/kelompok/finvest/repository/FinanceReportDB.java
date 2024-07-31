package apap.kelompok.finvest.repository;

import apap.kelompok.finvest.model.FinanceReportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceReportDB extends JpaRepository<FinanceReportModel, Integer> {

}
