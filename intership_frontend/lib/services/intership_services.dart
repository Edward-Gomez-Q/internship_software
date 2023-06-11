import 'dart:convert';

import 'package:intership_frontend/models/intership_model.dart';
import 'package:intership_frontend/services/globals.dart';
import 'package:intl/intl.dart';
import 'package:crypto/crypto.dart';
import 'package:http/http.dart' as http;
import 'package:intership_frontend/models/company_model.dart';

class IntershipServices {
  static Future<String> updateIntershipByCompany(
      IntershipModel intership, String token, int id, int idCompany) async {
    String formattedDateTime =
        DateFormat(("yyyy-MM-ddTHH:mm:ss")).format(intership.deadline);
    String formattedDateTime2 =
        DateFormat(("HH:mm:ss")).format(intership.startDate);
    String formattedDateTime3 =
        DateFormat(("HH:mm:ss")).format(intership.endDate);
    Map data = {
      'idInternship': intership.idInternship,
      'department': intership.department,
      'deadline': formattedDateTime,
      'days': intership.days,
      'duration': intership.duration,
      'startDate': formattedDateTime2,
      'endDate': formattedDateTime3,
      'description': intership.description,
      'urlPDF': intership.urlPDF,
      'urlWORD': intership.urlWord,
      'careers': intership.careers,
      'knowledge': intership.knowledge,
    };
    var body = json.encode(data);
    var url = Uri.parse('$baseUrl/company/$idCompany/internship/$id');
    http.Response response = await http.put(
      url,
      headers: {
        "Content-Type": "application/json",
        "Authorization": "Bearer $token",
      },
      body: body,
    );
    if (response.statusCode == 200) {
      Map responseMap = json.decode(response.body);
      if (responseMap["code"] == "200") {
        return 'Intership updated';
      } else {
        return 'Error 404';
      }
    } else {
      return 'Error 404';
    }
  }
}
