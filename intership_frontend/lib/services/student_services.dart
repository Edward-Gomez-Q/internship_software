import 'dart:convert';

import 'package:http/http.dart' as http;
import '../bloc/states/student_state.dart';
import 'globals.dart';
class StudentServices{
  //Agrega un estudiante
  static Future<String> addStudent(StudentState student) async{
    Map data= {
      'nombres': student.nombres,
      'primerApellido': student.primerApellido,
      'segundoApellido': student.segundoApellido,
      'tipoDocumento': student.tipoDocumento,
      'numeroDocumento': student.numeroDocumento,
      'departamento': student.departamento,
      'validacionUCB': student.validacionUCB,
      'sede': student.sede,
      'carrera': student.carrera,
      'anioIngreso': student.anioIngreso,
      'correoElectronico': student.correoElectronico,
      'contrasena': student.contrasena,
      'confirmarContrasena': student.confirmarContrasena,
    };
    var body = json.encode(data);
    var url = Uri.parse('$baseUrl/student');
    http.Response response = await http.post(
      url,
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      },
      body: body,
    );
    print('Response Agregar Estudiante: ${response.body}');
    if (response.statusCode == 200) {
      Map responseMap = json.decode(response.body);
      if (responseMap["code"] == "0000") {
        return 'Task added';
      } else {
        return 'Error 404';
      }
    } else {
      return 'Error 404';
    }
  }
}