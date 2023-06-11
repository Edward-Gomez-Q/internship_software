import 'package:equatable/equatable.dart';
import 'package:flutter/cupertino.dart';

class IntershipState extends Equatable {
  final String titulo;
  final String departamento;
  final DateTime fechaLimite;
  final List<String> dias;
  final int horas;
  final DateTime horaInicio;
  final DateTime horaFin;
  final String urlPDF;
  final String urlwORD;
  final String requisitos;
  final String facultad;
  final bool status;
  final List<String> listaCarreras;
  final String descripcion;
  IntershipState({
    this.titulo = '',
    this.departamento = '',
    DateTime? fechaLimite,
    this.dias = const [],
    this.horas = 0,
    DateTime? horaInicio,
    DateTime? horaFin,
    this.urlPDF = '',
    this.urlwORD = '',
    this.requisitos = '',
    this.facultad = '',
    this.status = true,
    this.listaCarreras = const [],
    this.descripcion = '',
  })  : this.fechaLimite = fechaLimite ?? DateTime.now(),
        this.horaInicio = horaInicio ?? DateTime.now(),
        this.horaFin = horaFin ?? DateTime.now();
  IntershipState copyWith({
    String? titulo,
    String? departamento,
    DateTime? fechaLimite,
    List<String>? dias,
    int? horas,
    DateTime? horaInicio,
    DateTime? horaFin,
    String? descripcion,
    String? urlPDF,
    String? urlwORD,
    String? requisitos,
    String? facultad,
    bool? status,
    List<String>? listaCarreras,
  }) {
    return IntershipState(
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
      facultad: facultad ?? this.facultad,
      status: status ?? this.status,
      listaCarreras: listaCarreras ?? this.listaCarreras,
      descripcion: descripcion ?? this.descripcion,
    );
  }

  @override
  List<Object?> get props => [
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
        facultad,
        status,
        listaCarreras,
        descripcion,
      ];
}
