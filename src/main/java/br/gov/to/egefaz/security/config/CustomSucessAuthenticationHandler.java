package br.gov.to.egefaz.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe utilizada para tratar a solicitacoes com sucesso de login.
 *
 * @author Bruno Ribeiro de Freitas Machado.
 * @since 26/08/2015.
 */
public class CustomSucessAuthenticationHandler implements AuthenticationSuccessHandler {
  /**
   * Pagina principal redirecionada apos o login.
   */
  public static final String PAGINA_PRINCIPAL = "../protected/index.xhtml";

  /**
   * Realiza a acao apos a autenticacao do usuario com sucesso.
   *
   * @param httpServletRequest  request.
   * @param httpServletResponse response.
   * @param authentication      autenticacao.
   * @throws IOException      falha de conexao.
   * @throws ServletException falha no servlet.
   */
  @Override
  public void onAuthenticationSuccess(final HttpServletRequest httpServletRequest,
      final HttpServletResponse httpServletResponse, final Authentication authentication)
      throws IOException, ServletException {

    httpServletResponse.sendRedirect(PAGINA_PRINCIPAL);
  }
}
