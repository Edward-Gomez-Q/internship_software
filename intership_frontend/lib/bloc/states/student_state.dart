import 'package:equatable/equatable.dart';

class StudentState extends Equatable {
  final String nombres;
  final String primerApellido;
  final String segundoApellido;
  final String tipoDocumento;
  final String numeroDocumento;
  final String departamento;
  final int validacionUCB;
  final String sede;
  final String carrera;
  final String anioIngreso;
  final String correoElectronico;
  final String contrasena;
  final String confirmarContrasena;
  final List<String> listaCarreras;

  StudentState({
    this.nombres = '',
    this.primerApellido = '',
    this.segundoApellido = '',
    this.tipoDocumento = '',
    this.numeroDocumento = '',
    this.departamento = '',
    this.validacionUCB = 0,
    this.sede = '',
    this.carrera = '',
    this.anioIngreso = '',
    this.correoElectronico = '',
    this.contrasena = '',
    this.confirmarContrasena = '',
    this.listaCarreras = const [],
  });
  StudentState copyWith({
    String? nombres,
    String? primerApellido,
    String? segundoApellido,
    String? tipoDocumento,
    String? numeroDocumento,
    String? departamento,
    int? validacionUCB,
    String? sede,
    String? carrera,
    String? anioIngreso,
    String? correoElectronico,
    String? contrasena,
    String? confirmarContrasena,
    List<String>? listaCarreras,
  }) {
    return StudentState(
      nombres: nombres ?? this.nombres,
      primerApellido: primerApellido ?? this.primerApellido,
      segundoApellido: segundoApellido ?? this.segundoApellido,
      tipoDocumento: tipoDocumento ?? this.tipoDocumento,
      numeroDocumento: numeroDocumento ?? this.numeroDocumento,
      departamento: departamento ?? this.departamento,
      validacionUCB: validacionUCB ?? this.validacionUCB,
      sede: sede ?? this.sede,
      carrera: carrera ?? this.carrera,
      anioIngreso: anioIngreso ?? this.anioIngreso,
      correoElectronico: correoElectronico ?? this.correoElectronico,
      contrasena: contrasena ?? this.contrasena,
      confirmarContrasena: confirmarContrasena ?? this.confirmarContrasena,
      listaCarreras: listaCarreras ?? this.listaCarreras,
    );
  }

  @override
  // TODO: implement props
  List<Object?> get props => [
        nombres,
        primerApellido,
        segundoApellido,
        tipoDocumento,
        numeroDocumento,
        departamento,
        validacionUCB,
        sede,
        carrera,
        anioIngreso,
        correoElectronico,
        contrasena,
        confirmarContrasena,
        listaCarreras,
      ];
}