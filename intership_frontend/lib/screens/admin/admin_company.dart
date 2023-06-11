import 'package:flutter/material.dart';
import 'package:intership_frontend/components/appbar.dart';
import 'package:intership_frontend/components/bottombar_admincom.dart';
import 'package:intership_frontend/screens/admin/principal/wraper_company.dart';

import '../../bloc/states/company_state.dart';

class AdminCompany extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: MyAppBar(title: 'Aprobación Empresas'),
      body: Container(
        child: WraperAdminCompany(
          company: [
            CompanyState(
              nombreEmpresa: "Empresa 1",
              nit: "123456789",
              nombresContacto: "Juan",
              primerApellidoContacto: "Perez",
              sitioWeb: "www.empresa1.com",
              telefonoContacto: "123456789",
            ),
          ],
        ),
      ),
      bottomNavigationBar: BottomBarAdmin(),
    );
  }
}
