package com.thoughtworks.aceleradora.airline.visao;

import com.thoughtworks.aceleradora.airline.dominio.Aeroporto;
import com.thoughtworks.aceleradora.airline.dominio.Itinerario;
import com.thoughtworks.aceleradora.airline.dominio.Segmento;
import com.thoughtworks.aceleradora.airline.dominio.Voo;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FormatadorVooTest {

    private Voo voo = new Voo(
            new Itinerario(
                    new Aeroporto("POA", "Salgado Filho", "Porto Alegre"),
                    new Aeroporto("MIA", "Miami Airport", "Miami"),
                    LocalDateTime.now(),
                    LocalDateTime.now().plusHours(16)
            ),

            asList(
                    new Segmento(
                            new Itinerario(
                                    new Aeroporto("POA", "Salgado Filho", "Porto Alegre"),
                                    new Aeroporto("GRU", "Guarulhos", "Sao Paulo"),
                                    LocalDateTime.now(),
                                    LocalDateTime.now()
                            )
                    ),
                    new Segmento(
                            new Itinerario(
                                    new Aeroporto("GRU", "Guarulhos", "Sao Paulo"),
                                    new Aeroporto("MIA", "Miami Airport", "Miami"),
                                    LocalDateTime.now(),
                                    LocalDateTime.now()
                            )
                    )
            )
    );

    private FormatadorVoo formatadorVoo;

    @Before
    public void setUp() {
        formatadorVoo = new FormatadorVoo();
    }

    @Test
    public void montaPercursoComTodosOsAeroportosOrdenadosSemDuplicacoes() {
        assertThat(formatadorVoo.percurso(voo), equalTo(
                asList(
                        new Aeroporto("POA", "Salgado Filho", "Porto Alegre"),
                        new Aeroporto("GRU", "Guarulhos", "Sao Paulo"),
                        new Aeroporto("MIA", "Miami Airport", "Miami"))
                )
        );
    }

    @Test
    public void contaQuantidadeDeParadasCorretamenteDeAcordoComOsSegmentos() {
       assertThat(formatadorVoo.quantidadeParadas(voo), is(1));
    }

    @Test
    public void calculaDuracaoTotalDaViagemCorretamente() {
       assertThat(formatadorVoo.duracaoEmHoras(voo), is(16L));
    }
}