import 'dart:convert';

import 'package:http/http.dart' as http;
import '../bloc/states/student_state.dart';
import 'globals.dart';
import 'package:crypto/crypto.dart';
class StudentServices{
  //Agrega un estudiante
  static Future<String> addStudent(StudentState student) async{
    //Encripta la contraseña
    var bytes = utf8.encode(student.contrasena); // Convierte la cadena a bytes
    var digest = sha256.convert(bytes); // Aplica el algoritmo de hash (en este caso, SHA-256)
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
      'contrasena': digest.toString(),
      'confirmarContrasena': "",
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