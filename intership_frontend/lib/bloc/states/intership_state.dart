import 'package:equatable/equatable.dart';
import 'package:flutter/cupertino.dart';

class IntershipState extends Equatable {
  final int idInternship;
  final String titulo;
  final String departamento;
  final DateTime fechaLimite;
  final String dias;
  final int horas;
  final DateTime horaInicio;
  final DateTime horaFin;
  final String urlPDF;
  final String urlwORD;
  final String requisitos;
  final bool status;
  final String carrera;
  final List<String> listacarreras;
  final String descripcion;
  IntershipState({
    this.idInternship = 0,
    this.titulo = '',
    this.departamento = '',
    DateTime? fechaLimite,
    this.dias = '',
    this.horas = 0,
    DateTime? horaInicio,
    DateTime? horaFin,
    this.urlPDF = '',
    this.urlwORD = '',
    this.requisitos = '',
    this.status = true,
    this.carrera = '',
    this.listacarreras = const [],
    this.descripcion = '',
  })  : this.fechaLimite = fechaLimite ?? DateTime.now(),
        this.horaInicio = horaInicio ?? DateTime.now(),
        this.horaFin = horaFin ?? DateTime.now();
  IntershipState copyWith({
    int? idInternship,
    String? titulo,
    String? departamento,
    DateTime? fechaLimite,
    String? dias,
    int? horas,
    DateTime? horaInicio,
    DateTime? horaFin,
    String? descripcion,
    String? urlPDF,
    String? urlwORD,
    String? requisitos,
    bool? status,
    String? carrera,
    List<String>? listacarreras,
  }) {
    return IntershipState(
      idInternship: idInternship ?? this.idInternship,
      titulo: titulo ?? this.titulo,
      departamento: departamento ?? this.departamento,
      fechaLimite: fechaLimite ?? this.fechaLimite,
      dias: dias ?? this.dias,
      horas: horas ?? this.horas,
      horaInicio: horaInicio ?? this.horaInicio,
      horaFin: horaFin ?? this.horaFin,
      urlPDF: urlPDF ?? this.urlPDF,
      urlwORD: urlwORD ?? this.urlwORD,
      requisitos: requisitos ?? this.requisitos,
      status: status ?? this.status,
      carrera: carrera ?? this.carrera,
      listacarreras: listacarreras ?? this.listacarreras,
      descripcion: descripcion ?? this.descripcion,
    );
  }

  @override
  List<Object?> get props => [
        idInternship,
        titulo,
        departamento,
        fechaLimite,
        dias,
        horas,
        horaInicio,
        horaFin,
        urlPDF,
        urlwORD,
        requisitos,
        status,
        carrera,
        listacarreras,
        descripcion,
      ];
}
