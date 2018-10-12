package com.thoughtworks.aceleradora.airline;

import com.thoughtworks.aceleradora.airline.dominio.Busca;
import com.thoughtworks.aceleradora.airline.dominio.Voo;
import com.thoughtworks.aceleradora.airline.dominio.VooRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BuscaControllerTest {

    @Mock
    private VooRepository repositorioVoo;

    @Mock
    private Model model;

    private BuscaController controller;

    @Before
    public void setUp() {
        controller = new BuscaController(repositorioVoo);
    }

    @Test
    public void renderizaCaixaDeBusca() {
        String paginaRenderizada = controller.caixaDeBusca();

        assertThat(paginaRenderizada, equalTo("airline/busca/caixaDeBusca"));
    }

    @Test
    public void mostraPaginaDeResultadoComVoosEDadosDaBuscaEfetuada() {
        List<Voo> voosEncontrados = singletonList(new Voo());
        when(repositorioVoo.findAll()).thenReturn(voosEncontrados);

        Busca buscaEfetuada = new Busca(
                "POA",
                "CWB",
                1,
                LocalDate.parse("2018-10-10"),
                LocalDate.parse("2018-10-11")
        );

        String paginaRenderizada = controller.busca(buscaEfetuada, model);

        verify(model).addAttribute("busca", buscaEfetuada);
        verify(model).addAttribute("voos", voosEncontrados);
        assertThat(paginaRenderizada,equalTo("airline/busca/resultado"));

    }
}