import 'package:bloc/bloc.dart';
import 'package:flutter/material.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';
import 'package:intership_frontend/models/intership_model.dart';
import 'package:intership_frontend/services/company_services.dart';

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

  void updateDias(List<String> dias) {
    emit(state.copyWith(dias: ""));
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

  void updateUrlPDF(String urlPDF) {
    emit(state.copyWith(urlPDF: urlPDF));
  }

  void updateUrlWORD(String urlWORD) {
    emit(state.copyWith(urlwORD: urlWORD));
  }

  void updateRequisitos(String requisitos) {
    emit(state.copyWith(requisitos: requisitos));
  }

  void updateCarreras(List<String> listacarreras) {
    emit(state.copyWith(listacarreras: listacarreras));
  }

  void updateDescripcion(String descripcion) {
    emit(state.copyWith(descripcion: descripcion));
  }

  void updateCarrera(String carrera) {
    emit(state.copyWith(carrera: carrera));
  }

  // registerIntership
  Future<String> registerIntership(
      String token, int id, IntershipModel intership) async {
    String response =
        await CompanyServices.addIntership(token, id, intership);
    if (response == 'Intership added') {
      return 'Ok';
    } else {
      return response;
    }
  }

  /*// leerIntership
  Future<String> getIntership(int id) async {
    List<IntershipModel> response =
        await IntershipServices.getIntershipsStatus(id);
    if (response.isNotEmpty) {
      return 'ok';
    } else {
      return 'lista vacia';
    }
  }*/
}
