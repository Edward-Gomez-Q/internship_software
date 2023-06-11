import 'dart:convert';

import 'package:http/http.dart' as http;
import '../bloc/states/student_state.dart';
import '../models/intership_model.dart';
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
      if (responseMap["code"] == "200") {
        return 'Task added';
      } else {
        return 'Error 404';
      }
    } else {
      return 'Error 404';
    }
  }
  //Obtener todas las pasantias disponibles
  static Future<List<IntershipModel>> getAllInternship(String token, int id) async{
    var url = Uri.parse('$baseUrl/student/$id/internship');
    http.Response response = await http.get(
        url,
        headers: {
          "Content-Type": "application/json",
          'Authorization': 'Bearer $token',
        }
    );
    if(response.statusCode==200)
    {
      print(response.body);
      Map responseMap = json.decode(response.body);
      if(responseMap["code"]!="200")
      {
        return [];
      }
      List<IntershipModel> interships = [];
      for(var intershipMap in responseMap['response'])
      {
        IntershipModel intership = IntershipModel.fromMap(intershipMap);
        interships.add(intership);
      }
      return interships;
    }
    else
    {
      return [];
    }
  }
}