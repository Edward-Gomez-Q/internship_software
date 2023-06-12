import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/models/company_model.dart';
import 'package:intership_frontend/services/admin_services.dart';

import '../states/company_state.dart';
import '../states/list_company_state.dart';

class ListCompanyCubit extends Cubit<ListCompanyState> {
  ListCompanyCubit() : super(ListCompanyState([]));
  //Obtener todas las compañías esperando aprobación
  Future<void> getAllCompanyWaiting(String token, int id) async {
    List<CompanyModel> listCompanyState = await AdminServices.getAllCompanyWaiting(token, id);
    //Convertir la lista de compañías a una lista de estados
    List<CompanyState> intershipState = [];
    for (var intership in listCompanyState) {
      intershipState.add(
        CompanyState(
          idCompany: intership.idCompany,
          nombreEmpresa: intership.nameCompany,
          correoElectronicoContacto: intership.email,
          nit: intership.nit,
          sitioWeb: intership.webSide,
          confirmarContrasena: intership.password,
          contrasena: intership.password,
          listaSectores: intership.sectors,
          logo: null,
          nombresContacto: intership.Names,
          primerApellidoContacto: intership.firstLastName,
          segundoApellidoContacto: intership.secondLastName,
          resena: intership.review,
          telefonoContacto: intership.phone,
        )
      );
    }
    print(intershipState.toString());
    emit(ListCompanyState(intershipState));
  }
  //Limpiar la lista de compañías
  Future<void> clear() async {
    emit(ListCompanyState([]));
  }
}