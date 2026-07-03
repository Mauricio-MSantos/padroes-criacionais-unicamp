package br.unicamp.padroescriacionais.legacy;

import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;
import br.unicamp.padroescriacionais.legacy.domain.TipoRelatorio;
import br.unicamp.padroescriacionais.legacy.service.RelatorioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NovosFormatosRelatorioTest {

    private RelatorioService service;

    @BeforeEach
    void setUp() {
        service = new RelatorioService();
    }

    @Test
    void deveGerarRelatorioXmlValido() {
        String resultado = service.gerarRelatorio(TipoRelatorio.VENDAS, FormatoRelatorio.XML);

        assertNotNull(resultado);
        assertTrue(resultado.contains("<?xml"));
        assertTrue(resultado.contains("<relatorio>"));
        assertTrue(resultado.contains("</relatorio>"));
        assertTrue(resultado.contains("Relatorio de Vendas"));
    }

    @Test
    void deveGerarRelatorioHtmlValido() {
        String resultado = service.gerarRelatorio(TipoRelatorio.CLIENTES, FormatoRelatorio.HTML);

        assertNotNull(resultado);
        assertTrue(resultado.contains("<!DOCTYPE html>"));
        assertTrue(resultado.contains("<html"));
        assertTrue(resultado.contains("</html>"));
        assertTrue(resultado.contains("Relatorio de Clientes"));
    }
}
