package apap.kelompok.finvest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama_proyek", nullable = false)
    private String nama_proyek;

    // FOREIGN KEY ke id Kategori Model ...(3)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kategori_id", referencedColumnName = "id",
            nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private KategoriModel kategori;

    // FOREIGN KEY ke id Subkategori Model ...(4)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "subkategori_id", referencedColumnName = "id",
            nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<SubkategoriModel> subkategori;

    @NotNull
    @Column(name = "tanggal_mulai", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm")
    private LocalDateTime tanggal_mulai;

    @Column(name = "tanggal_selesai", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm")
    private LocalDateTime tanggal_selesai;

    // FOREIGN KEY ke id Company Model (2)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CompanyModel subsidiary_in_charge;

    @NotNull
    @Column(name = "estimated_profit", nullable = false)
    private int estimated_profit;

    @NotNull
    @Size(max = 200)
    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    @NotNull
    @Column(name = "is_finished", nullable = false)
    private boolean is_finished;

    // FOREIGN KEY ke id Finance Model ...(1)
    @OneToOne(mappedBy = "proyek", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private FinanceReportModel finance_report;
}
