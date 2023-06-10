import 'package:bloc/bloc.dart';
import 'package:flutter/material.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';

class IntershipCubit extends Cubit<IntershipState> {
  IntershipCubit() : super(IntershipState());
  void updateNombrePasantia(String titulo) {
    emit(state.copyWith(titulo: titulo));
  }

  void updateDepartamento(String departamento) {
    emit(state.copyWith(departamento: departamento));
  }

  void updateFechaLimite(DateTime fechaLimite) {
    emit(state.copyWith(fechaLimite: fechaLimite));
  }

  void updateDias(int dias) {
    emit(state.copyWith(dias: dias));
  }

  void updateHoras(int horas) {
    emit(state.copyWith(horas: horas));
  }

  void updateHoraInicio(DateTime horaInicio) {
    emit(state.copyWith(horaInicio: horaInicio));
  }

  void updateHoraFin(DateTime horaFin) {
    emit(state.copyWith(horaFin: horaFin));
  }

  void updateDescripcion(String descripcion) {
    emit(state.copyWith(descripcion: descripcion));
  }

  void updateUrlPDF(String urlPDF) {
    emit(state.copyWith(urlPDF: urlPDF));
  }

  void updateUrlWORD(String urlWORD) {
    emit(state.copyWith(urlwORD: urlWORD));
  }

  void updateRequisitos(String requisitos) {
    emit(state.copyWith(requisitos: requisitos));
  }

  void updateFacultad(String facultad) {
    emit(state.copyWith(facultad: facultad));
  }

  void updateListaCarreras(List<String> listaCarreras) {
    emit(state.copyWith(listaCarreras: listaCarreras));
  }
}
