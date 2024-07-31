package apap.kelompok.finvest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 10)
    @Column(name = "tahun_berdiri", nullable = false)
    private String tahun_berdiri;

    // (5)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kategori_bisnis", referencedColumnName = "id",
            nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private KategoriModel kategori_bisnis;

    // (6)
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<SubkategoriModel> subkategori_bisnis;

    @NotNull
    @Column(name = "perusahaan_induk")
    private int perusahaan_induk;

    @NotNull
    @Column(name = "saldo_perusahaan")
    private int saldo_perusahaan;

    @NotNull
    @Column(name = "status_perusahaan")
    private int status_perusahaan;

    // (2)
    @OneToMany(mappedBy = "subsidiary_in_charge", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ProjectModel> listProjectModel;
}
