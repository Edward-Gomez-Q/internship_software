import 'package:equatable/equatable.dart';
import 'package:flutter/material.dart';

class IntershipState extends Equatable {
  final String titulo;
  final String departamento;
  final DateTime fechaLimite;
  final TimeOfDay horaInicio;
  final TimeOfDay horaFin;
  final String descripcion;
  final String urlDescripcion;
  final String urlSilabo;
  final String requisitos;
  final String facultad;
  final List<String> listaCarreras;

  IntershipState({
    this.titulo = '',
    this.departamento = '',
    DateTime? fechaLimite,
    TimeOfDay? horaInicio,
    TimeOfDay? horaFin,
    this.descripcion = '',
    this.urlDescripcion = '',
    this.urlSilabo = '',
    this.requisitos = '',
    this.facultad = '',
    this.listaCarreras = const [],
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
    List<String>? listaCarreras,
  }) {
    return IntershipState(
      titulo: titulo ?? this.titulo,
      departamento: departamento ?? this.departamento,
      fechaLimite: fechaLimite ?? this.fechaLimite,
      horaInicio: horaInicio ?? this.horaInicio,
      horaFin: horaFin ?? this.horaFin,
      descripcion: descripcion ?? this.descripcion,
      urlDescripcion: urlDescripcion ?? this.urlDescripcion,
      urlSilabo: urlSilabo ?? this.urlSilabo,
      requisitos: requisitos ?? this.requisitos,
      facultad: facultad ?? this.facultad,
      listaCarreras: listaCarreras ?? this.listaCarreras,
    );
  }

  @override
  List<Object?> get props => [
        titulo,
        departamento,
        fechaLimite,
        horaInicio,
        horaFin,
        descripcion,
        urlDescripcion,
        urlSilabo,
        requisitos,
        facultad,
        listaCarreras,
      ];
  bool areAllFieldsFilled(IntershipState state) {
    return state.titulo.isNotEmpty &&
        state.departamento.isNotEmpty &&
        state.descripcion.isNotEmpty &&
        state.urlDescripcion.isNotEmpty &&
        state.urlSilabo.isNotEmpty &&
        state.requisitos.isNotEmpty &&
        state.facultad.isNotEmpty &&
        state.listaCarreras.isNotEmpty;
  }
}
