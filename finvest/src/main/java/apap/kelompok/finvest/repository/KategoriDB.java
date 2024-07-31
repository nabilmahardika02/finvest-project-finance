package apap.kelompok.finvest.repository;

import apap.kelompok.finvest.model.KategoriModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriDB extends JpaRepository<KategoriModel, Integer> {
}
