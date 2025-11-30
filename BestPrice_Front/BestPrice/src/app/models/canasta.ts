export class Canasta {
  idCanasta: number = 0        // El ID debe ser un string para compatibilidad con la API
  nombreCanasta: string = ""  
  createdACanasta: Date=new Date()
  updatedACanasta: Date=new Date()
  usuarioCanasta: string = ""// Usuario puede ser null en el caso que no esté definido
}
