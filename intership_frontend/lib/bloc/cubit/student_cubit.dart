import 'package:bloc/bloc.dart';
import 'package:intership_frontend/bloc/states/student_state.dart';

import '../../services/student_services.dart';

class StudentCubit extends Cubit<StudentState> {
  StudentCubit() : super(StudentState());
  // Métodos para actualizar los campos del formulario
  void updateNombres(String nombres) {
    emit(state.copyWith(nombres: nombres));
  }

  void updatePrimerApellido(String primerApellido) {
    emit(state.copyWith(primerApellido: primerApellido));
  }

  void updateSegundoApellido(String segundoApellido) {
    emit(state.copyWith(segundoApellido: segundoApellido));
  }

  // Métodos para manejar el tipo de documento
  void updateTipoDocumento(String tipoDocumento) {
    emit(state.copyWith(tipoDocumento: tipoDocumento));
  }

  void updateNumeroDocumento(String numeroDocumento) {
    emit(state.copyWith(numeroDocumento: numeroDocumento));
  }

  void updateDepartamento(String departamento) {
    emit(state.copyWith(departamento: departamento));
  }

  // Métodos para manejar la validación con la UCB
  void updateValidacionUCB(int validacionUCB) {
    emit(state.copyWith(validacionUCB: validacionUCB));
  }

  // Métodos para manejar la sede y carrera
  void updateSede(String sede) {
    emit(state.copyWith(sede: sede));
  }

  void updateCarrera(String carrera) {
    emit(state.copyWith(carrera: carrera));
  }

  void updateAnioIngreso(String anioIngreso) {
    emit(state.copyWith(anioIngreso: anioIngreso));
  }

  // Métodos para manejar el correo electrónico y contraseña
  void updateCorreoElectronico(String correoElectronico) {
    emit(state.copyWith(correoElectronico: correoElectronico));
  }

  void updateContrasena(String contrasena) {
    emit(state.copyWith(contrasena: contrasena));
  }

  void updateConfirmarContrasena(String confirmarContrasena) {
    emit(state.copyWith(confirmarContrasena: confirmarContrasena));
  }
  // Métodos para manejar la lista de carreras
  void updateListaCarreras(List<String> listaCarreras) {
    emit(state.copyWith(listaCarreras: listaCarreras));
  }

  // Agregar estudiante
  Future<String> addStudent(StudentState student) async{
    String response = await StudentServices.addStudent(student);
    if (response == 'Student added') {
      return 'Ok';
    } else {
      return response;
    }
  }

}