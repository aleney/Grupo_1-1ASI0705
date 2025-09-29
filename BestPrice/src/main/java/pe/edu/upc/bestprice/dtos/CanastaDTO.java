package pe.edu.upc.bestprice.dtos;

import java.sql.Timestamp;

public class CanastaDTO {
    private int idCanasta;
    private String nombreCanasta;
    private Timestamp createdACanasta;
    private Timestamp updateACanasta;
    private String usuarioCanasta;

    public int getIdCanasta() {
        return idCanasta;
    }

    public void setIdCanasta(int idCanasta) {
        this.idCanasta = idCanasta;
    }

    public String getNombreCanasta() {
        return nombreCanasta;
    }

    public void setNombreCanasta(String nombreCanasta) {
        this.nombreCanasta = nombreCanasta;
    }

    public Timestamp getCreatedACanasta() {
        return createdACanasta;
    }

    public void setCreatedACanasta(Timestamp createdACanasta) {
        this.createdACanasta = createdACanasta;
    }

    public Timestamp getUpdateACanasta() {
        return updateACanasta;
    }

    public void setUpdateACanasta(Timestamp updateACanasta) {
        this.updateACanasta = updateACanasta;
    }

    public String getUsuarioCanasta() {
        return usuarioCanasta;
    }

    public void setUsuarioCanasta(String usuarioCanasta) {
        this.usuarioCanasta = usuarioCanasta;
    }
}
