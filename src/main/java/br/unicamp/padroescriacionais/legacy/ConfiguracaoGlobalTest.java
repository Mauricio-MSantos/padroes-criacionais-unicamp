package br.unicamp.padroescriacionais.legacy;

import br.unicamp.padroescriacionais.legacy.config.ConfiguracaoGlobal;
import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;
import br.unicamp.padroescriacionais.legacy.service.ConfiguracaoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfiguracaoGlobalTest {

    @Test
    void deveRetornarSempreAMesmaInstanciaSingleton() {
        ConfiguracaoGlobal primeira = ConfiguracaoGlobal.getInstancia();
        ConfiguracaoGlobal segunda = ConfiguracaoGlobal.getInstancia();

        assertSame(primeira, segunda);
    }

    @Test
    void configuracaoDeveSerCompartilhadaEntreAcessos() {
        ConfiguracaoSistema config1 = ConfiguracaoGlobal.getInstancia().getConfiguracao();
        ConfiguracaoSistema config2 = ConfiguracaoGlobal.getInstancia().getConfiguracao();

        String ambienteOriginal = config1.getAmbiente();
        try {
            config1.setAmbiente("HOMOLOG");
            assertEquals("HOMOLOG", config2.getAmbiente());
        } finally {
            config1.setAmbiente(ambienteOriginal);
        }
    }

    @Test
    void configuracaoServiceDeveUsarConfiguracaoGlobal() {
        ConfiguracaoService service = new ConfiguracaoService();

        assertSame(ConfiguracaoGlobal.getInstancia().getConfiguracao(), service.getConfiguracao());
    }
}
