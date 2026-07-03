package br.unicamp.padroescriacionais.legacy.service;

import br.unicamp.padroescriacionais.legacy.config.ConfiguracaoGlobal;
import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;

public class ConfiguracaoService {

    public ConfiguracaoSistema getConfiguracao() {
        return ConfiguracaoGlobal.getInstancia().getConfiguracao();
    }

    public void exibirConfiguracao() {
        ConfiguracaoSistema configuracao = getConfiguracao();
        System.out.println("=== Configuracao do Sistema ===");
        System.out.println("Empresa    : " + configuracao.getNomeEmpresa());
        System.out.println("Ambiente   : " + configuracao.getAmbiente());
        System.out.println("Diretorio  : " + configuracao.getDiretorioExportacao());
        System.out.println("Debug ativo: " + configuracao.isDebugAtivo());
        System.out.println("================================");
    }
}
