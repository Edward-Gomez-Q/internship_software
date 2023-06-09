import 'package:flutter/material.dart';
import 'package:intership_frontend/components/appbar.dart';
import 'package:intership_frontend/screens/company/principal/wraper_aplicants.dart';

import '../../bloc/states/student_state.dart';
import '../../components/search.dart';

class Aplicants extends StatelessWidget {
  void handleSearch(String value) {
    print(value);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: MyAppBar(title: "Postulantes"),
        body: Column(
          children: [
            /*Padding(
              padding: EdgeInsets.only(top: 40),
              child: Container(
                padding: EdgeInsets.symmetric(horizontal: 20),
                child: SearchBar(
                  hinttext: 'Buscar por nombre',
                  onSearch: handleSearch,
                ),
              ),
            ),*/
            SizedBox(
              height: 20,
            ),
            Expanded(
              child: WraperViewAplicants(
                studentState: [
                  StudentState(
                      nombres: "Juan",
                      primerApellido: "Perez",
                      segundoApellido: "Perez",
                      carrera: "Ingeniería de sistemas",
                      correoElectronico: "juan.perez@ucb.edu.bo"),
                ],
              ),
            )
          ],
        ));
  }
}
