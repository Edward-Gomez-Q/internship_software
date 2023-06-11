import 'dart:convert';
import 'package:crypto/crypto.dart';
import 'package:http/http.dart' as http;
import 'package:intl/intl.dart';
import '../models/intership_model.dart';
import 'globals.dart';

class IntershipServices {
  static Future<String> addIntership(String token,int id,IntershipModel intership) async {
    print("entro al servicio");
    String formattedDateTime = DateFormat(("yyyy-MM-ddTHH:mm:ss")).format(intership.deadline);
    String formattedDateTime2 = DateFormat(("HH:mm:ss")).format(intership.startDate);
    String formattedDateTime3 = DateFormat(("HH:mm:ss")).format(intership.endDate);
    Map data = {
      'title': intership.title,
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
    print(data);
    var body = json.encode(data);
    var url = Uri.parse('$baseUrl/company/$id/internship');
    http.Response response = await http.post(
      url,
      headers: {
        "Content-Type": "application/json",
        'Authorization': 'Bearer $token',
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
  //Obtener todas las pasantias por compañia
  static Future<List<IntershipModel>> getAllInternshipByIdCompany(String token,int idCompany) async{
    var url = Uri.parse('$baseUrl/company/$idCompany/internship');
    http.Response response = await http.get(
      url,
      headers: {
        "Content-Type": "application/json",
        'Authorization': 'Bearer $token'
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
