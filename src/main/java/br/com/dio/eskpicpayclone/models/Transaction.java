package br.com.dio.eskpicpayclone.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "Transactions")
public class Transaction extends EntityBase{

    @Column(name = "TR_CODE", nullable = false)
    private String code;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "TR_USER_SOURCE", nullable = false)
    private User source;

    @ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinColumn(name = "TR_USER_DESTINATION", nullable = false)
    private User destination;

    @Column(name = "TR_DATE_TIME", nullable = false)
    private LocalDateTime  dateTime;

    @Column(name = "TR_VALUE", nullable = false)
    private Double value;
}
