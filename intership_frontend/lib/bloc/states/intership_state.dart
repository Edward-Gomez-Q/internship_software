import 'package:equatable/equatable.dart';
import 'package:flutter/material.dart';

class IntershipState extends Equatable {
  final String titulo;
  final String carrera;
  final String departamento;
  final DateTime fechaLimite;
  final TimeOfDay horaInicio;
  final TimeOfDay horaFin;
  final String descripcion;
  final String urlDescripcion;
  final String urlSilabo;
  final String requisitos;
  final String facultad;

  IntershipState({
    this.titulo = '',
    this.carrera = '',
    this.departamento = '',
    DateTime? fechaLimite,
    TimeOfDay? horaInicio,
    TimeOfDay? horaFin,
    this.descripcion = '',
    this.urlDescripcion = '',
    this.urlSilabo = '',
    this.requisitos = '',
    this.facultad = '',
  })  : fechaLimite = fechaLimite ?? DateTime.now(),
        horaInicio = horaInicio ?? TimeOfDay.now(),
        horaFin = horaFin ?? TimeOfDay.now();

  IntershipState copyWith({
    String? titulo,
    String? carrera,
    String? departamento,
    DateTime? fechaLimite,
    TimeOfDay? horaInicio,
    TimeOfDay? horaFin,
    String? descripcion,
    String? urlDescripcion,
    String? urlSilabo,
    String? requisitos,
    String? facultad,
  }) {
    return IntershipState(
      titulo: titulo ?? this.titulo,
      carrera: carrera ?? this.carrera,
      departamento: departamento ?? this.departamento,
      fechaLimite: fechaLimite ?? this.fechaLimite,
      horaInicio: horaInicio ?? this.horaInicio,
      horaFin: horaFin ?? this.horaFin,
      descripcion: descripcion ?? this.descripcion,
      urlDescripcion: urlDescripcion ?? this.urlDescripcion,
      urlSilabo: urlSilabo ?? this.urlSilabo,
      requisitos: requisitos ?? this.requisitos,
      facultad: facultad ?? this.facultad,
    );
  }

  @override
  List<Object?> get props => [
        titulo,
        carrera,
        departamento,
        fechaLimite,
        horaInicio,
        horaFin,
        descripcion,
        urlDescripcion,
        urlSilabo,
        requisitos,
        facultad,
      ];
}
