package br.gov.to.egefaz.security.config;

import br.gov.to.egefaz.security.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.Assert;

/**
 * @author Bruno Ribeiro de Freitas Machado.
 * @since 25/08/2015.
 */
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Configura o gerenciador de autenticacoes.
     *
     * @param auth gerenciado de autenticacao.
     * @throws Exception falha ao configurar.
     */
    @Autowired
    public final void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
/*
        final UserDetailsService service = new UsuarioService();
        final PasswordEncoder encoder = passwordEncoder();

        auth.userDetailsService(service).passwordEncoder(encoder);*/
    }

    /**
     * configura o filtro.
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        final AuthenticationSuccessHandler sucessHandler = new CustomSucessAuthenticationHandler();

       /* http.authorizeRequests()
                .antMatchers("/register", "/javax.faces.resource/**").permitAll().anyRequest().authenticated()
                .and().formLogin().loginPage("/pages/public/login.xhtml").successHandler(sucessHandler)
                .permitAll().and().logout().logoutSuccessUrl("/pages/public/login.xhtml").permitAll().and()
                .csrf().disable();
   */
    }

    /**
     * Encoder para senha no banco. Atualmente MD5.
     *
     * @return retorna o encoder.
     */
    public PasswordEncoder passwordEncoder() {

        return new PasswordEncoder() {

            /**
             * verifica se a senha informada e igual a mesma cifrada.
             *
             * @param rawPassword senha sem estar cifrada.
             * @param encodedPassword senha cifrada.
             * @return retorna true caso sejam iguais.
             */
            @Override
            public boolean matches(final CharSequence rawPassword, final String encodedPassword) {

                Assert.notNull(rawPassword);
                Assert.notNull(encodedPassword);

                return encodedPassword.equals(encode(rawPassword));
            }

            /**
             * Cifra uma sequencia de caracteres.
             *
             * @param rawPassword sequencia de caracteres que sera cifrada.
             * @return retorna a cadeia de caracteres cifrada.
             */
            @Override
            public String encode(final CharSequence rawPassword) {

                Assert.notNull(rawPassword);

//        return CriptoUtils.cryptWithMD5(String.valueOf(rawPassword));
                return String.valueOf(rawPassword);
            }
        };
    }
}
