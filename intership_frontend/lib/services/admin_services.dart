import 'dart:convert';

import 'package:intership_frontend/models/company_model.dart';

import '../models/intership_model.dart';
import 'globals.dart';
import 'package:http/http.dart' as http;

class AdminServices{
  //Obtener todas las pasantías esperando aprobación
    static Future<List<IntershipModel>> getAllInternshipWaiting(String token, int id) async {
    var url = Uri.parse('$baseUrl/usei/$id/internship/approve');
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
  //Obtener todas las compañias esperando aprobación
  static Future<List<CompanyModel>> getAllCompanyWaiting(String token, int id) async {
    var url = Uri.parse('$baseUrl/usei/$id/company/approve');
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
      List<CompanyModel> interships = [];
      for(var intershipMap in responseMap['response'])
      {
        CompanyModel intership = CompanyModel.fromMapBudle(intershipMap);
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