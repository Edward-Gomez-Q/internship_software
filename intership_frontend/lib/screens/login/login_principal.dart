import 'package:flutter/material.dart';
import 'package:intership_frontend/components/header_principal.dart';
import 'package:intership_frontend/screens/login/wrapper.dart';

import '../../components/header.dart';

class LoginPrincipal extends StatelessWidget {
  const LoginPrincipal({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: HeaderPrincipal(
          header: Header(
            title: "Universidad Católica",
            subtitle: "Portal de Pasantias",
            subtitle2: "Inicio de sesión",
          ),
          content: Wrapper(),
        ),
      ),
    );
  }
}
