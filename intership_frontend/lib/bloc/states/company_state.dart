import 'package:equatable/equatable.dart';
import 'package:flutter/cupertino.dart';

class CompanyState extends Equatable {
  final String nombreEmpresa;
  final String nombresContacto;
  final String primerApellidoContacto;
  final String segundoApellidoContacto;
  final String departamento;
  final String resena;
  final Image logo;
  final String sitioWeb;
  final int validacionUCB;
  final String nit;
  final String correoElectronicoContacto;
  final String telefonoContacto;
  final String contrasena;
  final String confirmarContrasena;
  final List<String> listaSectores;

  CompanyState({
    this.nombreEmpresa = '',
    this.nombresContacto = '',
    this.primerApellidoContacto = '',
    this.segundoApellidoContacto = '',
    this.departamento = '',
    this.resena = '',
    Image? logo,
    this.sitioWeb = '',
    this.validacionUCB = 0,
    this.nit = '',
    this.correoElectronicoContacto = '',
    this.telefonoContacto = '',
    this.contrasena = '',
    this.confirmarContrasena = '',
    this.listaSectores = const [],
  }) : this.logo = logo ?? Image.asset('assets/images/...');

  CompanyState copyWith({
    String? nombreEmpresa,
    String? nombresContacto,
    String? primerApellidoContacto,
    String? segundoApellidoContacto,
    String? departamento,
    String? resena,
    Image? logo,
    String? sitioWeb,
    int? validacionUCB,
    String? nit,
    String? correoElectronicoContacto,
    String? telefonoContacto,
    String? contrasena,
    String? confirmarContrasena,
    List<String>? listaSectores,
  }) {
    return CompanyState(
      nombreEmpresa: nombreEmpresa ?? this.nombreEmpresa,
      nombresContacto: nombresContacto ?? this.nombresContacto,
      primerApellidoContacto:
          primerApellidoContacto ?? this.primerApellidoContacto,
      segundoApellidoContacto:
          segundoApellidoContacto ?? this.segundoApellidoContacto,
      departamento: departamento ?? this.departamento,
      resena: resena ?? this.resena,
      logo: logo ?? this.logo,
      sitioWeb: sitioWeb ?? this.sitioWeb,
      validacionUCB: validacionUCB ?? this.validacionUCB,
      nit: nit ?? this.nit,
      correoElectronicoContacto:
          correoElectronicoContacto ?? this.correoElectronicoContacto,
      telefonoContacto: telefonoContacto ?? this.telefonoContacto,
      contrasena: contrasena ?? this.contrasena,
      confirmarContrasena: confirmarContrasena ?? this.confirmarContrasena,
      listaSectores: listaSectores ?? this.listaSectores,
    );
  }

  @override
  List<Object> get props => [
        nombreEmpresa,
        nombresContacto,
        primerApellidoContacto,
        segundoApellidoContacto,
        departamento,
        resena,
        logo,
        sitioWeb,
        validacionUCB,
        nit,
        correoElectronicoContacto,
        telefonoContacto,
        contrasena,
        confirmarContrasena,
        listaSectores,
      ];
}
