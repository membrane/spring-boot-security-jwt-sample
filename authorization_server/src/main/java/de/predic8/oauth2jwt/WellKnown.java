package de.predic8.oauth2jwt;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WellKnown {

    String issuer;

    @JsonProperty("authorization_endpoint")
    String authorizationEndpoint;
    @JsonProperty("token_endpoint")
    String tokenEndpoint;
    @JsonProperty("userinfo_endpoint")
    String userinfoEndpoint;
    @JsonProperty("revocation_endpoint")
    String revocationEndpoint;
    @JsonProperty("jwks_uri")
    String jwksUri;
    @JsonProperty("response_types_supported")
    List<String> responseTypesSupported;
    @JsonProperty("grant_types_supported")
    List<String> grantTypesSupported;
    @JsonProperty("subject_types_supported")
    List<String> subjectTypesSupported;
    @JsonProperty("id_token_signing_alg_values_supported")
    List<String> idTokenSigningAlgValuesSupported;
    @JsonProperty("scopes_supported")
    List<String> scopesSupported;
    @JsonProperty("token_endpoint_auth_methods_supported")
    List<String> tokenEndpointAuthMethodsSupported;
    @JsonProperty("claims_supported")
    List<String> claimsSupported;
    @JsonProperty("code_challenge_methods_supported")
    List<String> codeChallengeMethodsSupported;

    public WellKnown(String issuer, String authorizationEndpoint, String tokenEndpoint,
                     String userinfoEndpoint, String revocationEndpoint, String jwksUri,
                     List<String> responseTypesSupported, List<String> grantTypesSupported, List<String> subjectTypesSupported, List<String> idTokenSigningAlgValuesSupported,
                     List<String> scopesSupported, List<String> tokenEndpointAuthMethodsSupported, List<String> claimsSupported,
                     List<String> codeChallengeMethodsSupported) {
        this.issuer = issuer;
        this.authorizationEndpoint = authorizationEndpoint;
        this.tokenEndpoint = tokenEndpoint;
        this.userinfoEndpoint = userinfoEndpoint;
        this.revocationEndpoint = revocationEndpoint;
        this.jwksUri = jwksUri;
        this.responseTypesSupported = responseTypesSupported;
        this.grantTypesSupported = grantTypesSupported;
        this.subjectTypesSupported = subjectTypesSupported;
        this.idTokenSigningAlgValuesSupported = idTokenSigningAlgValuesSupported;
        this.scopesSupported = scopesSupported;
        this.tokenEndpointAuthMethodsSupported = tokenEndpointAuthMethodsSupported;
        this.claimsSupported = claimsSupported;
        this.codeChallengeMethodsSupported = codeChallengeMethodsSupported;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getAuthorizationEndpoint() {
        return authorizationEndpoint;
    }

    public void setAuthorizationEndpoint(String authorizationEndpoint) {
        this.authorizationEndpoint = authorizationEndpoint;
    }

    public String getTokenEndpoint() {
        return tokenEndpoint;
    }

    public void setTokenEndpoint(String tokenEndpoint) {
        this.tokenEndpoint = tokenEndpoint;
    }

    public String getUserinfoEndpoint() {
        return userinfoEndpoint;
    }

    public void setUserinfoEndpoint(String userinfoEndpoint) {
        this.userinfoEndpoint = userinfoEndpoint;
    }

    public String getRevocationEndpoint() {
        return revocationEndpoint;
    }

    public void setRevocationEndpoint(String revocationEndpoint) {
        this.revocationEndpoint = revocationEndpoint;
    }

    public String getJwksUri() {
        return jwksUri;
    }

    public void setJwksUri(String jwksUri) {
        this.jwksUri = jwksUri;
    }

    public List<String> getResponseTypesSupported() {
        return responseTypesSupported;
    }

    public void setResponseTypesSupported(List<String> responseTypesSupported) {
        this.responseTypesSupported = responseTypesSupported;
    }

    public List<String> getSubjectTypesSupported() {
        return subjectTypesSupported;
    }

    public void setSubjectTypesSupported(List<String> subjectTypesSupported) {
        this.subjectTypesSupported = subjectTypesSupported;
    }

    public List<String> getIdTokenSigningAlgValuesSupported() {
        return idTokenSigningAlgValuesSupported;
    }

    public void setIdTokenSigningAlgValuesSupported(List<String> idTokenSigningAlgValuesSupported) {
        this.idTokenSigningAlgValuesSupported = idTokenSigningAlgValuesSupported;
    }

    public List<String> getScopesSupported() {
        return scopesSupported;
    }

    public void setScopesSupported(List<String> scopesSupported) {
        this.scopesSupported = scopesSupported;
    }

    public List<String> getTokenEndpointAuthMethodsSupported() {
        return tokenEndpointAuthMethodsSupported;
    }

    public void setTokenEndpointAuthMethodsSupported(List<String> tokenEndpointAuthMethodsSupported) {
        this.tokenEndpointAuthMethodsSupported = tokenEndpointAuthMethodsSupported;
    }

    public List<String> getClaimsSupported() {
        return claimsSupported;
    }

    public void setClaimsSupported(List<String> claimsSupported) {
        this.claimsSupported = claimsSupported;
    }

    public List<String> getCodeChallengeMethodsSupported() {
        return codeChallengeMethodsSupported;
    }

    public void setCodeChallengeMethodsSupported(List<String> codeChallengeMethodsSupported) {
        this.codeChallengeMethodsSupported = codeChallengeMethodsSupported;
    }

    public List<String> getGrantTypesSupported() {
        return grantTypesSupported;
    }

    public void setGrantTypesSupported(List<String> grantTypesSupported) {
        this.grantTypesSupported = grantTypesSupported;
    }
}
