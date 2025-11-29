package pe.edu.upc.bestprice.dtos;

import java.time.LocalDateTime;

public class CanastaDTO {
    private int idCanasta;
    private String nombreCanasta;
    private LocalDateTime createdACanasta;  // Changed from Timestamp to LocalDateTime
    private LocalDateTime updateACanasta;   // Changed from Timestamp to LocalDateTime
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

    public LocalDateTime getCreatedACanasta() {
        return createdACanasta;
    }

    public void setCreatedACanasta(LocalDateTime createdACanasta) {
        this.createdACanasta = createdACanasta;
    }

    public LocalDateTime getUpdateACanasta() {
        return updateACanasta;
    }

    public void setUpdateACanasta(LocalDateTime updateACanasta) {
        this.updateACanasta = updateACanasta;
    }

    public String getUsuarioCanasta() {
        return usuarioCanasta;
    }

    public void setUsuarioCanasta(String usuarioCanasta) {
        this.usuarioCanasta = usuarioCanasta;
    }
}
