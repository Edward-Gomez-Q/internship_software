import 'package:flutter/material.dart';
import 'package:intership_frontend/components/header_principal.dart';
import 'package:intership_frontend/screens/registration/wrapperr.dart';

import '../../components/header.dart';

class Registration extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: HeaderPrincipal(
          header: Header(
            title: "Universidad Católica",
            subtitle: "Portal de Pasantias",
            subtitle2: "Registro de Usuarios",
          ),
          content: WrapperRegistration(),
        ),
      ),
    );
  }
}
