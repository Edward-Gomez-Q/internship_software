import 'package:flutter/material.dart';
import 'package:intership_frontend/components/header.dart';
import 'package:intership_frontend/components/header_principal.dart';
import 'package:intership_frontend/screens/student/register_student/register_form.dart';
import 'package:intership_frontend/screens/student/register_student/wrapper_register_student.dart';

class RegisterStudentFinal extends StatelessWidget {
  const RegisterStudentFinal({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: HeaderPrincipal(
        header: Header(
          title: "Portal de pasantías UCB",
          subtitle: "Registro de estudiante",
          subtitle2: "Ingrese los datos del estudiante",
        ),
        content: FormRegister(startYear: 2000, endYear: 2050),
      ),
    );
  }
}
