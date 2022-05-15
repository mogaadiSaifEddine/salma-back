package com.ark.fileuploaddb.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private Long id;
    private String username;
    private String name;
    private String email;
    private List<String> roles;
    private Long role_id;
    private List arrayPermission;
    private String entrepriseClient;
    private  Boolean type ;

    public JwtResponse(String token, Long id, String username, String name, String email, List<String> roles, Long role_id, List arrayPermission , String entrepriseClient , Boolean type) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.role_id = role_id;
        this.arrayPermission = arrayPermission;
        this.entrepriseClient = entrepriseClient;
    }

    public JwtResponse(String token, Long id, String username, String name, String email, Boolean type) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.role_id = role_id;
        this.type = type;
    }

    public JwtResponse(String jwt, Long id, String username, String name, String email) {
    }

    public JwtResponse(Long id, String username, String name, String email) {
    }

    public JwtResponse() {

    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public List getArrayPermission() {
        return arrayPermission;
    }

    public void setArrayPermission(List arrayPermission) {
        this.arrayPermission = arrayPermission;
    }

    public String getEntrepriseClient() {
        return entrepriseClient;
    }

    public void setEntrepriseClient(String entrepriseClient) {
        this.entrepriseClient = entrepriseClient;
    }
}
