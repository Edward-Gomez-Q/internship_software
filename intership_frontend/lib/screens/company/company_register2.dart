import 'package:flutter/material.dart';
import 'package:intership_frontend/components/header_principal.dart';
import 'package:intership_frontend/screens/company/register_company/wraper_comany_register.dart';
import 'package:intership_frontend/screens/company/register_company/wraper_company_register.dart';
import '../../../components/header.dart';

class RegisterCompany2 extends StatelessWidget {
  const RegisterCompany2({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: HeaderPrincipal(
          header: Header(
            title: "Portal de pasantías UCB",
            subtitle: "Registro de empresa",
            subtitle2: "Ingrese los datos de la empresa",
          ),
          content: WraperCompanyRegister2(),
        ),
      ),
    );
  }
}
