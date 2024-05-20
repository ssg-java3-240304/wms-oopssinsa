package com.oopssinsa.model.dto;

public class AccountDto {
    private String id;
    private String password;
    private long brandId;
    private String name;
    private String role;

    public AccountDto() {
    }

    public AccountDto(String id, String password, long brandId, String name, String role) {
        this.id = id;
        this.password = password;
        this.brandId = brandId;
        this.name = name;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", brandId=" + brandId +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
