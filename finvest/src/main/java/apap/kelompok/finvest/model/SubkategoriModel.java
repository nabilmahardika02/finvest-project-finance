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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subkategori")
public class SubkategoriModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama", nullable = false)
    private String nama;

    // (6)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CompanyModel company;

    // FOREIGN KEY ke id Subkategori Model ...(4)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProjectModel project;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kategori", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private KategoriModel kategori;
}
