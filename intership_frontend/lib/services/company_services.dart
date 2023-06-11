import 'dart:convert';
import 'package:crypto/crypto.dart';
import 'package:http/http.dart' as http;
import 'package:intership_frontend/models/company_model.dart';
import '../bloc/states/company_state.dart';
import 'globals.dart';

class CompanyServices {
  //Agregar una compañia
  static Future<String> addCompany(CompanyModel company) async {
    //Encripta la contraseña
    var bytes = utf8.encode(company.password); // Convierte la cadena a bytes
    var digest = sha256
        .convert(bytes); // Aplica el algoritmo de hash (en este caso, SHA-256)
    Map data = {
      'nameCompany': company.nameCompany,
      'sectors': company.sectors,
      'review': company.review,
      'urlLogo': "",
      'webSide': company.webSide,
      'nit': company.nit,
      'names': company.Names,
      'firstLastName': company.firstLastName,
      'secondLastName': company.secondLastName,
      'email': company.email,
      'password': digest.toString(),
      'phone': company.phone,
    };
    var body = json.encode(data);
    var url = Uri.parse('$baseUrl/company');
    http.Response response = await http.post(
      url,
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      },
      body: body,
    );
    print('Response Agregar Compañia: ${response.body}');
    if (response.statusCode == 200) {
      Map responseMap = json.decode(response.body);
      if (responseMap["code"] == "200") {
        return 'Company added';
      } else {
        return 'Error 404';
      }
    } else {
      return 'Error 404';
    }
  }

  static Future<List<CompanyModel>> getAllCompanyByUsei(String token) async {
    var url = Uri.parse('$baseUrl/usei/company/approve');
    http.Response response = await http.get(url, headers: {
      "Content-Type": "application/json",
      "Authorization": "Bearer $token"
    });
    if (response.statusCode == 200) {
      print(response.body);
      Map responseMap = json.decode(response.body);
      if (responseMap["code"] != "200") {
        return [];
      }
      List<CompanyModel> companies = [];
      for (var companyMap in responseMap['response']) {
        CompanyModel company = CompanyModel.fromMap(companyMap);
        companies.add(company);
      }
      return companies;
    } else {
      return [];
    }
  }
}
