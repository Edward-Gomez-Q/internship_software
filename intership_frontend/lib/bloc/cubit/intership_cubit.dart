import 'package:bloc/bloc.dart';
import 'package:flutter/material.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';

class IntershipCubit extends Cubit<IntershipState> {
  IntershipCubit() : super(IntershipState());

  void updateTitulo(String titulo) {
    emit(state.copyWith(titulo: titulo));
  }

  void updateFacultad(String facultad) {
    emit(state.copyWith(facultad: facultad));
  }

  void updateDepartamento(String departamento) {
    emit(state.copyWith(departamento: departamento));
  }

  void updateFechaLimite(DateTime fechaLimite) {
    emit(state.copyWith(fechaLimite: fechaLimite));
  }

  void updateHoraInicio(TimeOfDay horaInicio) {
    emit(state.copyWith(horaInicio: horaInicio));
  }

  void updateHoraFin(TimeOfDay horaFin) {
    emit(state.copyWith(horaFin: horaFin));
  }

  void updateDescripcion(String descripcion) {
    emit(state.copyWith(descripcion: descripcion));
  }

  void updateUrlDescripcion(String urlDescripcion) {
    emit(state.copyWith(urlDescripcion: urlDescripcion));
  }

  void updateUrlSilabo(String urlSilabo) {
    emit(state.copyWith(urlSilabo: urlSilabo));
  }

  void updateRequisitos(String requisitos) {
    emit(state.copyWith(requisitos: requisitos));
  }

  void updateListaCarreras(List<String> listaCarreras) {
    emit(state.copyWith(listaCarreras: listaCarreras));
  }
}
