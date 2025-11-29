package pe.edu.upc.bestprice.dtos;

public class CanastaDTOInsert {
   // SOLO LO QUE EL USUARIO VA A TENER QUE RELLENAR
   // NOMBRE CANASTA
        //USUARIO
   private String nombreCanasta;
   private String usuarioCanasta;

    public CanastaDTOInsert(String nombreCanasta, String usuarioCanasta) {
        this.nombreCanasta = nombreCanasta;
        this.usuarioCanasta = usuarioCanasta;
    }

    public CanastaDTOInsert() {
    }

    public String getNombreCanasta() {
        return nombreCanasta;
    }

    public void setNombreCanasta(String nombreCanasta) {
        this.nombreCanasta = nombreCanasta;
    }

    public String getUsuarioCanasta() {
        return usuarioCanasta;
    }

    public void setUsuarioCanasta(String usuarioCanasta) {
        this.usuarioCanasta = usuarioCanasta;
    }
}
