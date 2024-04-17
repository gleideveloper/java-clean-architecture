package br.com.alura.codechella.domain;

public class Address {
    private String zidCode;
    private Integer number;
    private String complement;

    public Address(String zidCode, Integer number, String complement) {
        this.zidCode = zidCode;
        this.number = number;
        this.complement = complement;
    }

    public String getZidCode() {
        return zidCode;
    }

    public void setZidCode(String zidCode) {
        this.zidCode = zidCode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
