import 'package:flutter/material.dart';
import 'package:intership_frontend/components/appbar.dart';
import 'package:intership_frontend/components/bottombar_admincom.dart';
import 'package:intership_frontend/screens/admin/principal/wraper_intership.dart';

import '../../bloc/states/intership_state.dart';

class AdminIntership extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: MyAppBar(title: 'Aprobación Pasantías'),
      body: Container(
        child: WraperAdminIntership(
          interships: [
            IntershipState(
              titulo: "Pasantia 1",
              requisitos: "Descripcion 1",
              fechaLimite: DateTime.now(),
            ),
          ],
        ),
      ),
      bottomNavigationBar: BottomBarAdmin(),
    );
  }
}
