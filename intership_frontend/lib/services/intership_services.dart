import 'dart:convert';
import 'package:crypto/crypto.dart';
import 'package:http/http.dart' as http;
import '../models/intership_model.dart';
import 'globals.dart';

class IntershipServices {
  static Future<String> addIntership(IntershipModel intership) async {
    print("entro al servicio");
    Map data = {
      'titleIntership': intership.titleIntership,
      'department': intership.department,
      'deadline': intership.deadline,
      'days': intership.days,
      'durations': intership.durations,
      'startTime': intership.startTime,
      'endTime': intership.endTime,
      'urlPDF': intership.urlPDF,
      'urlWord': intership.urlWord,
      'requirements': intership.requirements,
      'careers': intership.careers,
      'knowledge': intership.knowledge,
    };
    var body = json.encode(data);
    var url = Uri.parse('$baseUrl/company/$intership.companyId/intership');
    http.Response response = await http.post(
      url,
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      },
      body: body,
    );
    print('Response Agregar pasantia: ${response.body}');

    if (response.statusCode == 200) {
      Map responseMap = json.decode(response.body);
      if (responseMap["code"] == "200") {
        return 'Intership added';
      } else {
        return 'Error 404';
      }
    } else {
      return 'Error 404';
    }
  }

  static Future<List<IntershipModel>> getInterships(int studentId) async {
    var url = Uri.parse('$baseUrl/student/$studentId/intership');
    http.Response response = await http.get(url);
    print('Response Obtener pasantias: ${response.body}');
    if (response.statusCode == 200) {
      List<dynamic> jsonResponse = json.decode(response.body);
      List<IntershipModel> interships =
          jsonResponse.map((json) => IntershipModel.fromJson(json)).toList();
      return interships;
    } else {
      throw Exception('Failed to get internships');
    }
  }
}
