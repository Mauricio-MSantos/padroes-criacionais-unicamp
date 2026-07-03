package br.unicamp.padroescriacionais.legacy;

import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;
import br.unicamp.padroescriacionais.legacy.factory.RelatorioGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.factory.RelatorioGeneratorFactoryProvider;
import br.unicamp.padroescriacionais.legacy.generator.CsvRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.HtmlRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.JsonRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.PdfRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.XmlRelatorioGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelatorioGeneratorFactoryTest {

    @Test
    void deveRetornarFactoryParaTodosOsFormatos() {
        for (FormatoRelatorio formato : FormatoRelatorio.values()) {
            RelatorioGeneratorFactory factory = RelatorioGeneratorFactoryProvider.obterFactory(formato);
            assertNotNull(factory, "Factory nao encontrada para: " + formato);
            assertNotNull(factory.criarGenerator(), "Generator nao criado para: " + formato);
        }
    }

    @Test
    void deveCriarGeneratorCorretoParaCadaFormato() {
        assertInstanceOf(PdfRelatorioGenerator.class,
                RelatorioGeneratorFactoryProvider.obterFactory(FormatoRelatorio.PDF).criarGenerator());
        assertInstanceOf(CsvRelatorioGenerator.class,
                RelatorioGeneratorFactoryProvider.obterFactory(FormatoRelatorio.CSV).criarGenerator());
        assertInstanceOf(JsonRelatorioGenerator.class,
                RelatorioGeneratorFactoryProvider.obterFactory(FormatoRelatorio.JSON).criarGenerator());
        assertInstanceOf(XmlRelatorioGenerator.class,
                RelatorioGeneratorFactoryProvider.obterFactory(FormatoRelatorio.XML).criarGenerator());
        assertInstanceOf(HtmlRelatorioGenerator.class,
                RelatorioGeneratorFactoryProvider.obterFactory(FormatoRelatorio.HTML).criarGenerator());
    }

    @Test
    void deveRejeitarFormatoNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> RelatorioGeneratorFactoryProvider.obterFactory(null));
    }
}
