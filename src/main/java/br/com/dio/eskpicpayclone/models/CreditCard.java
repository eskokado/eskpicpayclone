package br.com.dio.eskpicpayclone.models;

import br.com.dio.eskpicpayclone.enums.EnsignCard;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "Users")
public class CreditCard extends EntityBase {

    @Column(name = "CC_number", nullable = false)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "CC_ensign", nullable = false)
    private EnsignCard ensignCard;

    @Column(name = "CC_TOKEN")
    private String numberToken;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "CC_USER_ID", nullable = false)
    private User user;
}
