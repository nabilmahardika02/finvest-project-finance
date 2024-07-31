package apap.kelompok.finvest.repository;

import apap.kelompok.finvest.model.SubkategoriModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubkategoriDB extends JpaRepository<SubkategoriModel, Integer> {
}
