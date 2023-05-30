import 'package:flutter/material.dart';
import 'package:intership_frontend/components/header.dart';
import 'package:intership_frontend/components/header_principal.dart';
import 'package:intership_frontend/screens/company/register_company/wraper_message.dart';

class Message extends StatelessWidget {
  const Message({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: HeaderPrincipal(
      header: Header(
        title: "Portal de pasantías UCB",
        subtitle: "Registro de estudiante",
        subtitle2: "Ingrese los datos del estudiante",
      ),
      content: WrapperMessage(
          message:
              "Gracias por registrarte en el portal de pasantías UCB, tu solicitud será revisada por un administrador y se te notificará por correo electrónico cuando tu cuenta sea activada."),
    ));
  }
}
