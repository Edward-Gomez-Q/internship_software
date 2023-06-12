import 'package:equatable/equatable.dart';
import 'package:flutter/cupertino.dart';

class CompanyState extends Equatable {
  final int idCompany;
  final String nombreEmpresa;
  final List<String> listaSectores;
  final String resena;
  final Image logo;
  final String nit;
  final String sitioWeb;
  final String nombresContacto;
  final String primerApellidoContacto;
  final String segundoApellidoContacto;
  final String correoElectronicoContacto;
  final String telefonoContacto;
  final String contrasena;
  final String confirmarContrasena;

  CompanyState({
    this.idCompany = 0,
    this.nombreEmpresa = '',
    this.nombresContacto = '',
    this.primerApellidoContacto = '',
    this.segundoApellidoContacto = '',
    this.resena = '',
    Image? logo,
    this.sitioWeb = '',
    this.nit = '',
    this.correoElectronicoContacto = '',
    this.telefonoContacto = '',
    this.contrasena = '',
    this.confirmarContrasena = '',
    this.listaSectores = const [],
  }) : this.logo = logo ?? Image.asset('assets/images/...');

  CompanyState copyWith({
    int? idCompany,
    String? nombreEmpresa,
    String? nombresContacto,
    String? primerApellidoContacto,
    String? segundoApellidoContacto,
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
      idCompany: idCompany ?? this.idCompany,
      nombreEmpresa: nombreEmpresa ?? this.nombreEmpresa,
      nombresContacto: nombresContacto ?? this.nombresContacto,
      primerApellidoContacto:
          primerApellidoContacto ?? this.primerApellidoContacto,
      segundoApellidoContacto:
          segundoApellidoContacto ?? this.segundoApellidoContacto,
      resena: resena ?? this.resena,
      logo: logo ?? this.logo,
      sitioWeb: sitioWeb ?? this.sitioWeb,
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
        idCompany,
        nombreEmpresa,
        nombresContacto,
        primerApellidoContacto,
        segundoApellidoContacto,
        resena,
        logo,
        sitioWeb,
        nit,
        correoElectronicoContacto,
        telefonoContacto,
        contrasena,
        confirmarContrasena,
        listaSectores,
      ];
}
