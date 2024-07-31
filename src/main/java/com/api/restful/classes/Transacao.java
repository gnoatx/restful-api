package com.api.restful.classes;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "contas")
public class Transacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 12)
    private String codigo;

    @Column(nullable = false)
    private Tipo tipo;

    @OneToOne
    @JoinColumn(nullable = false, name = "origem_id", referencedColumnName = "id")
    private ContaBancaria origem;

    @OneToOne
    @JoinColumn(nullable = false, name = "destino_id", referencedColumnName = "id")
    private ContaBancaria destino;

    @Column(nullable = false)
    private double valor;

    enum Tipo {
        PIX,
        TED,
        DOC
    }
}
