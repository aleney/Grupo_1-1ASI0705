package pe.edu.upc.bestprice.dtos;

public class CanastaDTOInsert {
   // SOLO LO QUE EL USUARIO VA A TENER QUE RELLENAR
   // NOMBRE CANASTA
        //USUARIO
   private int idCanasta;
   private String nombreCanasta;
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

    public String getUsuarioCanasta() {
        return usuarioCanasta;
    }

    public void setUsuarioCanasta(String usuarioCanasta) {
        this.usuarioCanasta = usuarioCanasta;
    }
}
