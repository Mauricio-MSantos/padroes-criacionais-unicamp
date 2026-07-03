package br.unicamp.padroescriacionais.legacy.config;

import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;

public final class ConfiguracaoGlobal {

    private static ConfiguracaoGlobal instancia;

    private final ConfiguracaoSistema configuracao;

    private ConfiguracaoGlobal() {
        this.configuracao = new ConfiguracaoSistema(
                "Empresa XPTO Ltda.",
                "DEV",
                "/tmp/relatorios",
                false
        );
    }

    public static synchronized ConfiguracaoGlobal getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracaoGlobal();
        }
        return instancia;
    }

    public ConfiguracaoSistema getConfiguracao() {
        return configuracao;
    }
}
