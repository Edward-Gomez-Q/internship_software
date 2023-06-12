import 'dart:convert';

import 'package:intership_frontend/models/company_model.dart';

import '../models/intership_model.dart';
import 'globals.dart';
import 'package:http/http.dart' as http;

class AdminServices {
  //Obtener todas las pasantías esperando aprobación
  static Future<List<IntershipModel>> getAllInternshipWaiting(
      String token, int id) async {
    var url = Uri.parse('$baseUrl/usei/$id/internship/approve');
    http.Response response = await http.get(url, headers: {
      "Content-Type": "application/json",
      'Authorization': 'Bearer $token',
    });
    if (response.statusCode == 200) {
      print(response.body);
      Map responseMap = json.decode(response.body);
      if (responseMap["code"] != "200") {
        return [];
      }
      List<IntershipModel> interships = [];
      for (var intershipMap in responseMap['response']) {
        IntershipModel intership = IntershipModel.fromMap(intershipMap);
        interships.add(intership);
      }
      return interships;
    } else {
      return [];
    }
  }

  //Obtener todas las compañias esperando aprobación
  static Future<List<CompanyModel>> getAllCompanyWaiting(
      String token, int id) async {
    var url = Uri.parse('$baseUrl/usei/$id/company/approve');
    http.Response response = await http.get(url, headers: {
      "Content-Type": "application/json",
      'Authorization': 'Bearer $token',
    });
    if (response.statusCode == 200) {
      print(response.body);
      Map responseMap = json.decode(response.body);
      if (responseMap["code"] != "200") {
        return [];
      }
      List<CompanyModel> interships = [];
      for (var intershipMap in responseMap['response']) {
        CompanyModel intership = CompanyModel.fromMapBudle(intershipMap);
        interships.add(intership);
      }
      return interships;
    } else {
      return [];
    }
  }
  //Saber si una company esta aprobada
  static Future<bool> approveCompany(String token, int id, int idCompany) async {
    var url = Uri.parse('$baseUrl/usei/$id/company/$idCompany/approve');
    http.Response response = await http.put(url, headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Bearer $token',
    });
    if (response.statusCode == 200) {
      Map responseMap = json.decode(response.body);
      if (responseMap['code'] == '200') {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
  //Aprobar una compañia
  static Future<String> addCompany( String token, int id, int idCompany) async {
    var url = Uri.parse('$baseUrl/usei/$id/company/$idCompany');
    http.Response response = await http.put(url,
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer $token',
        },
        body: json.encode({
          "id": idCompany,
        })
    );
    if (response.statusCode == 200) {
      Map responseMap = json.decode(response.body);
      if (responseMap['code'] == '200') {
        return 'Company added';
      } else {
        return 'Error 404';
      }
    } else {
      return 'Error 404';
    }
  }
  //Aprobar una pasantia
  static Future<String> addInternship(String token,int id, int idInternship)async{
    var url = Uri.parse('$baseUrl/usei/$id/internship/$idInternship');
    http.Response response = await http.put(url,
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer $token',
        },
        body: json.encode({
          "id": idInternship,
        })
    );
    if (response.statusCode == 200) {
      Map responseMap = json.decode(response.body);
      if (responseMap['code'] == '200') {
        return 'Internship added';
      } else {
        return 'Error 404';
      }
    } else {
      return 'Error 404';
    }
  }
  //Rechazar una compañia
 static Future<String> deleteCompany(String token, int id, int idCompany)async{
    var url = Uri.parse('$baseUrl/usei/$id/company/$idCompany/reject');
    http.Response response = await http.put(url,
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer $token',
        },
      body: json.encode({
        'id': idCompany,
      }),
    );
    if (response.statusCode == 200) {
      Map responseMap = json.decode(response.body);
      if (responseMap['code'] == '200') {
        return 'Company deleted';
      } else {
        return 'Error 404';
      }
    } else {
      return 'Error 404';
    }
 }
  //Rechazar una pasantia
  static Future<String> deleteInternship(String token,int id, int idInternship)async{
    var url = Uri.parse('$baseUrl/usei/$id/internship/$idInternship/reject');

    http.Response response = await http.put(url,
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer $token',
        },
      body: json.encode({
        'id': idInternship,
      }),
    );
    if (response.statusCode == 200) {
      Map responseMap = json.decode(response.body);
      if (responseMap['code'] == '200') {
        return 'Internship deleted';
      } else {
        return 'Error 404';
      }
    } else {
      return 'Error 404';
    }
  }




}
