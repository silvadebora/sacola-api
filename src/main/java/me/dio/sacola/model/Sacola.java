package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.sacola.enumeration.FormaPagamento;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor  // tem um construtor com todos os argumentos
@Builder             // traz o componente sacolaBuilder, que ajuda a criar um objeto
@Data                // traz todos os getters e setters
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // ignorar erros
@NoArgsConstructor   // construtor com nenhum argumento, o hibernate exige
@Entity  // sacola é uma tabela
public class Sacola {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)  //um cliente pode ter varias sacolas
    @JsonIgnore                                           // ignora erros
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itens;
    private Double valorTotal;

    @Enumerated
    private FormaPagamento FormaPagamento;
    private boolean fechada;

}
