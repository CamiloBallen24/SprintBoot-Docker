package ms_account.models;


import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaccion {
    @Id
    private String id;

    private String idUserOrigen;
    private String idUserDestino;
    private Integer valor;
    private Date fecha;


    public Transaccion(String id, String idUserOrigen, String idUserDestino, Integer valor, Date fecha) {
        this.id = id;
        this.idUserOrigen = idUserOrigen;
        this.idUserDestino = idUserDestino;
        this.valor = valor;
        this.fecha = fecha;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUserOrigen() {
        return idUserOrigen;
    }

    public void setIdUserOrigen(String idUserOrigen) {
        this.idUserOrigen = idUserOrigen;
    }

    public String getIdUserDestino() {
        return idUserDestino;
    }

    public void setIdUserDestino(String idUserDestino) {
        this.idUserDestino = idUserDestino;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
