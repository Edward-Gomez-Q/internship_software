import 'package:flutter/material.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';
import 'package:intership_frontend/components/appbar.dart';
import 'package:intership_frontend/screens/student/principal_student/wraper_postulation_status.dart';

class PostulationStatus extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: MyAppBar(title: "Estado de postulaciones"),
        body: Column(children: [
          SizedBox(
            height: 20,
          ),
          Expanded(
            child: WraperPostulationStatus(
              interships: [
                IntershipState(
                  titulo: "Pasantía en el área de sistemas",
                  requisitos: "Empresa 1",
                  fechaLimite: DateTime.now(),
                )
              ],
            ),
          )
        ]));
  }
}
