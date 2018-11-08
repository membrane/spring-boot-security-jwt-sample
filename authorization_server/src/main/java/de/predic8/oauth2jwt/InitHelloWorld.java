package de.predic8.oauth2jwt;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import java.util.Hashtable;

@Service
public class InitHelloWorld implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {

        if (!(bean instanceof DefaultSpringSecurityContextSource))
            return bean;


        DefaultSpringSecurityContextSource orig = (DefaultSpringSecurityContextSource) bean;

        DefaultSpringSecurityContextSource r = new DefaultSpringSecurityContextSource("ldap://localhost:8389/dc=springframework,dc=org") {// hardcoded url
            @Override
            protected DirContext getDirContextInstance(Hashtable<String, Object> environment) throws NamingException {
                environment.put("java.naming.ldap.factory.socket", CustomSocketFactory.class.getName());
                return super.getDirContextInstance(environment);
            }
        };


        System.out.println("BeforeInitialization : " + beanName);
        return r;  // you can return any other object as well
    }

    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {


        //System.out.println("AfterInitialization : " + beanName);
        return bean;  // you can return any other object as well
    }
}