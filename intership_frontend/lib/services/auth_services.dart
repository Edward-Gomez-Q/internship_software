import 'dart:convert';

import 'package:crypto/crypto.dart';
import 'package:intership_frontend/bloc/states/auth_state.dart';
import 'package:http/http.dart' as http;
import '../bloc/states/token_state.dart';
import 'globals.dart';

class AuthServices {
  //Login
  static Future<TokenState> login(AuthState login) async {
    try {
      var url = Uri.parse('$baseUrl/auth/login');
      final msg = jsonEncode({
        'email': login.email,
        'password': login.password,
      });
      http.Response response = await http.post(url,
          headers: {"Content-Type": "application/json"}, body: msg);
      if (response.statusCode == 200) {
        print(response.body);
        Map responseMap = json.decode(response.body);
        if (responseMap["code"] != "200") {
          return const TokenState(
              authToken: "Error de autenticación",
              refreshToken: "Error de Autenticación");
        } else {
          TokenState token = TokenState.fromMap(responseMap);
          return token;
        }
      } else {
        return const TokenState(
            authToken: "error 404", refreshToken: "error 404");
      }
    } catch (e) {
      return const TokenState(
          authToken: "error 404", refreshToken: "error 404");
    }
  }
}