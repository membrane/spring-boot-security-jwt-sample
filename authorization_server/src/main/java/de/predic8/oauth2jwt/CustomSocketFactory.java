package de.predic8.oauth2jwt;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class CustomSocketFactory {

    public static int connectTimeout = 60000;

    private static CustomSocketFactory instance;

    public static CustomSocketFactory getDefault() {
        synchronized (CustomSocketFactory.class) {
            if (instance == null)
                instance = new CustomSocketFactory();
        }
        return instance;
    }

    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        try {

            SSLContext sslc;

            TrustManager[] tms = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    //TODO
                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    //TODO
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};

            sslc = javax.net.ssl.SSLContext.getInstance("TLS");
            sslc.init(null, tms, null);


            return sslc.getSocketFactory().createSocket(host, port);
        } catch (Exception e) {
            throw new RuntimeException(e); // TODO
        }
    }
}