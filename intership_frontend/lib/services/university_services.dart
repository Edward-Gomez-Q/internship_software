import 'dart:convert';

import 'package:intership_frontend/models/career_model.dart';

import '../models/campus_model.dart';
import 'globals.dart';
import 'package:http/http.dart' as http;

class UniversityServices{
  //Obtener todas las universidades
  static Future<List<CampusModel>> getCampus() async{
    var url = Uri.parse('$baseUrl/university/campus');
    http.Response response = await http.get(
      url,
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      },
    );
    if (response.statusCode == 200) {
      Map responseMap = json.decode(response.body);
      List<CampusModel> campus = [];
      for (var item in responseMap["response"]) {
        campus.add(CampusModel.fromJson(item));
      }
      return campus;
    } else {
      return [];
    }
  }
  //Obtener todas las carreras por universidad
  static Future<List<CareerModel>> getCareers(int idCampus) async{
    var url = Uri.parse('$baseUrl/university/$idCampus');
    print(url);
    http.Response response = await http.get(
      url,
      headers: {
        "Content-Type": "application/json"
      },
    );
    if (response.statusCode == 200) {
      print(response.body);
      String decodedResponse = utf8.decode(response.bodyBytes);
      Map responseMap = json.decode(decodedResponse);
      List<CareerModel> careers = [];
      for (var item in responseMap["response"]) {
        careers.add(CareerModel.fromJson(item));
      }
      return careers;
    } else {
      return [];
    }
  }
}