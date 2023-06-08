import 'package:flutter/cupertino.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/models/company_model.dart';
import 'package:intership_frontend/services/company_services.dart';
import '../states/company_state.dart';

class CompanyCubit extends Cubit<CompanyState> {
  CompanyCubit() : super(CompanyState());

  void updateNombreEmpresa(String nombreEmpresa) {
    emit(state.copyWith(nombreEmpresa: nombreEmpresa));
  }

  void updateNombresContacto(String nombresContacto) {
    emit(state.copyWith(nombresContacto: nombresContacto));
  }

  void updatePrimerApellidoContacto(String primerApellidoContacto) {
    emit(state.copyWith(primerApellidoContacto: primerApellidoContacto));
  }

  void updateSegundoApellidoContacto(String segundoApellidoContacto) {
    emit(state.copyWith(segundoApellidoContacto: segundoApellidoContacto));
  }


  void updateResena(String resena) {
    emit(state.copyWith(resena: resena));
  }

  void updateLogo(Image logo) {
    emit(state.copyWith(logo: logo));
  }

  void updateSitioWeb(String sitioWeb) {
    emit(state.copyWith(sitioWeb: sitioWeb));
  }

  void updateValidacionUCB(int validacionUCB) {
    emit(state.copyWith(validacionUCB: validacionUCB));
  }

  void updateNit(String nit) {
    emit(state.copyWith(nit: nit));
  }

  void updateCorreoElectronicoContacto(String correoElectronicoContacto) {
    emit(state.copyWith(correoElectronicoContacto: correoElectronicoContacto));
  }

  void updateTelefonoContacto(String telefonoContacto) {
    emit(state.copyWith(telefonoContacto: telefonoContacto));
  }

  void updateContrasena(String contrasena) {
    emit(state.copyWith(contrasena: contrasena));
  }

  void updateConfirmarContrasena(String confirmarContrasena) {
    emit(state.copyWith(confirmarContrasena: confirmarContrasena));
  }

  void updateListaSectores(List<String> listaSectores) {
    emit(state.copyWith(listaSectores: listaSectores));
  }
  //registerCompany
  Future<String> registerCompany(CompanyModel company) async {
    String response = await CompanyServices.addCompany(company);
    if (response == 'Company added') {
      return 'Ok';
    } else {
      return response;
    }
  }
}
