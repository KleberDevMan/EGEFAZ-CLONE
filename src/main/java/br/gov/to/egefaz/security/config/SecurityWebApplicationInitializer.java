package br.gov.to.egefaz.security.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Classe para iniciar os servicos relacionados ao Spring Security.
 *
 * @author Bruno Ribeiro de Freitas Machado.
 * @since 25/08/2015.
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {


  /**
   * Iniciar o servico e configura o Spring Security.
   */
  public SecurityWebApplicationInitializer() {
    super(WebSecurityConfiguration.class);
  }
}
