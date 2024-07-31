package com.api.restful.classes;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "contas")
public class ContaBancaria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 9)
    private String numero;

    @Column(nullable = false)
    private Tipo tipo;

    @OneToOne
    @JoinColumn(name = "titular_id", referencedColumnName = "id")
    private Cliente titular;

    private double saldo;

    @Getter
    enum Tipo {
        CORRENTE("Conta Corrente"),
        POUPANCA("Conta Poupança"),
        PAGAMENTO("Conta de Pagamento"),
        SALARIO("Conta Salário");

        private final String nome;

        Tipo(String nome) {
            this.nome = nome;
        }
    }
}
