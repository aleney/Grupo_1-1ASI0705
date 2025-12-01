import { Component } from '@angular/core';
import { Ubicaciontienda } from '../../../models/ubicaciontienda';

@Component({
  selector: 'app-ubicaciontiendalistar',
  imports: [
    MatTableModule,
    CommonModule,
    RouterLink,
    MatButtonModule,
    MatIconModule,
    MatPaginatorModule,
    ReactiveFormsModule,
    MatInputModule,
    MatLabel,
    MatMenuModule,
    MatToolbarModule,
  ],
  templateUrl: './ubicaciontiendalistar.html',
  styleUrl: './ubicaciontiendalistar.css',
})
export class Ubicaciontiendalistar {
  dataSource: MatTableDataSource<Ubicaciontienda> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6', 'c7', 'c8'];
  nombrebusqueda: string = '';
  mensaje: string = '';
  form: FormGroup;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private dS: DistritoService,
    private fb: FormBuilder,
    private snackBar: MatSnackBar,
    private loginService: Loginservice
  ) {
    this.form = this.fb.group({
      nombrebusqueda: [''],
    });
    this.role = this.loginService.showRole();
  }

  ngOnInit(): void {
    this.dS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });

    this.form.get('nombrebusqueda')?.valueChanges.subscribe((value) => {
      this.nombrebusqueda = value;
      this.buscar();
    });

    this.dS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
  }

  eliminar(id: number) {
    this.dS.delete(id).subscribe(() => {
      this.dS.list().subscribe((data) => {
        this.dS.setList(data);
        this.showSnackBar('Distrito eliminado con éxito');
      });
    });
  }

  buscar() {
    const termino = this.nombrebusqueda.trim();

    if (termino === '') {
      // Si el campo está vacío → listar todos los registros
      this.dS.list().subscribe((data) => {
        this.dataSource = new MatTableDataSource(data);
      });
      return;
    }

    // Si hay texto → buscar coincidencias
    this.dS.searchName(termino).subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.mensaje = data.length === 0 ? 'No se encontraron registros.' : '';
    });
  }

  showSnackBar(message: string) {
    this.snackBar.open(message, 'Cerrar', {
      duration: 3000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
    });
  }

  role: string = '';
  usuario: string = '';

  cerrar() {
    sessionStorage.clear();
  }

  verificar() {
    this.role = this.loginService.showRole();
    return this.loginService.verificar();
  }

  isAdmin() {
    return this.role === 'ADMIN';
  }

  isSeller() {
    return this.role === 'SELLER';
  }

  isClient() {
    return this.role === 'CLIENT';
  }
}
