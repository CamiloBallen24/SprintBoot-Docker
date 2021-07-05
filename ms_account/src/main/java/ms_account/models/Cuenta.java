package ms_account.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Cuenta {

    @Id
    private String id_user;

    private Integer saldo;
    private Date ultimoCambio;

    public Cuenta(String id_user, Integer saldo, Date ultimoCambio) {
        this.id_user = id_user;
        this.saldo = saldo;
        this.ultimoCambio = ultimoCambio;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Date getUltimoCambio() {
        return ultimoCambio;
    }

    public void setUltimoCambio(Date ultimoCambio) {
        this.ultimoCambio = ultimoCambio;
    }
}
