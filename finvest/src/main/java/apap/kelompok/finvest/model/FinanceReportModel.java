package apap.kelompok.finvest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "finance_report")
public class FinanceReportModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Foreign Key ke id Project Model ...(1)
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProjectModel proyek;

    @NotNull
    @Column(name = "periode_fiskal", nullable = false)
    private int periode_fiskal;

    @NotNull
    @Column(name = "tahun_fiskal", nullable = false)
    private int tahun_fiskal;

    @NotNull
    @Column(name = "total_revenue", nullable = false)
    private int total_revenue;

    @NotNull
    @Column(name = "operating_expense", nullable = false)
    private int operating_expense;

    @NotNull
    @Column(name = "tax", nullable = false)
    private float tax;

    @NotNull
    @Column(name = "net_profit", nullable = false)
    private int net_profit;
}
