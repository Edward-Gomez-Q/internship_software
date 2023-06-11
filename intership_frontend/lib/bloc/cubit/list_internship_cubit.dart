import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';
import 'package:intership_frontend/bloc/states/list_internship_state.dart';
import 'package:intership_frontend/services/student_services.dart';

import '../../models/intership_model.dart';
import '../../services/admin_services.dart';
import '../../services/company_services.dart';

class ListInternshipCubit extends Cubit<ListInternshipState> {
  ListInternshipCubit() : super(ListInternshipState([]));
  //Obtener todas las pasantías
  Future<void> getAllInternships(String token, int idCompany) async {
    List<IntershipModel> internships =
        await CompanyServices.getAllInternshipByIdCompany(token, idCompany);
    //Convertir la lista de pasantías a una lista de estados
    List<IntershipState> intershipState = [];
    for (var intership in internships) {
      intershipState.add(IntershipState(
        idInternship: intership.idInternship,
        urlPDF: intership.urlPDF,
        departamento: intership.department,
        titulo: intership.title,
        fechaLimite: intership.deadline,
        descripcion: intership.description,
        dias: intership.days,
        carreras: intership.careers,
        urlwORD: intership.urlWord,
        requisitos: intership.knowledge,
        horas: intership.duration,
        horaInicio: intership.startDate,
        horaFin: intership.endDate,
      ));
    }
    print(intershipState.toString());
    emit(ListInternshipState(intershipState));
  }
  //Limpiar la lista de pasantías
  Future<void> clearList() async {
    emit(ListInternshipState([]));
  }
  //Obtener todas las pasantías disponibles
  Future<void> getAllInternshipsAvailable(String token,int id) async {
    List<IntershipModel> internships =
        await StudentServices.getAllInternship(token, id);
    //Convertir la lista de pasantías a una lista de estados
    List<IntershipState> intershipState = [];
    for (var intership in internships) {
      intershipState.add(IntershipState(
        idInternship: intership.idInternship,
        urlPDF: intership.urlPDF,
        departamento: intership.department,
        titulo: intership.title,
        fechaLimite: intership.deadline,
        descripcion: intership.description,
        dias: intership.days,
        carreras: intership.careers,
        urlwORD: intership.urlWord,
        requisitos: intership.knowledge,
        horas: intership.duration,
        horaInicio: intership.startDate,
        horaFin: intership.endDate,
      ));
    }
    print(intershipState.toString());
    emit(ListInternshipState(intershipState));
  }
  //Obtener todas las pasantías esperando aprobación
  Future<void> getAllInternshipsWaiting(String token,int id) async {
    List<IntershipModel> internships =
        await AdminServices.getAllInternshipWaiting(token, id);
    //Convertir la lista de pasantías a una lista de estados
    List<IntershipState> intershipState = [];
    for (var intership in internships) {
      intershipState.add(IntershipState(
        idInternship: intership.idInternship,
        urlPDF: intership.urlPDF,
        departamento: intership.department,
        titulo: intership.title,
        fechaLimite: intership.deadline,
        descripcion: intership.description,
        dias: intership.days,
        carreras: intership.careers,
        urlwORD: intership.urlWord,
        requisitos: intership.knowledge,
        horas: intership.duration,
        horaInicio: intership.startDate,
        horaFin: intership.endDate,
      ));
    }
    print(intershipState.toString());
    emit(ListInternshipState(intershipState));
  }
}
