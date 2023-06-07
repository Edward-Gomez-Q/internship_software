import 'package:flutter/material.dart';
import 'package:intership_frontend/components/bottombar_company.dart';
import 'package:intership_frontend/components/search.dart';
import 'package:intership_frontend/screens/company/principal/wraper_view_intership.dart';

import '../../bloc/states/intership_state.dart';

class HomeCompany extends StatelessWidget {
  void handleSearch(String value) {
    print(value);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [
          Padding(
            padding: EdgeInsets.only(top: 40),
            child: Container(
              padding: EdgeInsets.symmetric(horizontal: 20),
              child: SearchBar(
                hinttext: 'Buscar por nombre',
                onSearch: handleSearch,
              ),
            ),
          ),
          SizedBox(
            height: 20,
          ),
          Text("Pasantías Activas",
              style: TextStyle(fontSize: 30, color: Colors.blue.shade900)),
          SizedBox(
            height: 20,
          ),
          Expanded(
            child: WraperViewIntership(
              intershipState: [
                IntershipState(
                    titulo: "Pasantía en desarrollo de software",
                    listaCarreras: [
                      'Ingeniería de sistemas',
                      'Ingeniería de software'
                    ],
                    descripcion:
                        "Se busca estudiante de ingeniería de sistemas para desarrollar software",
                    fechaLimite: DateTime.now()),
                IntershipState(
                    titulo: "Pasantía en desarrollo de software",
                    listaCarreras: [
                      'Ingeniería de sistemas',
                      'Ingeniería de software'
                    ],
                    descripcion:
                        "Se busca estudiante de ingeniería de sistemas para desarrollar software",
                    fechaLimite: DateTime.now()),
              ],
            ),
          ),
        ],
      ),
      bottomNavigationBar: BottomBarCompany(),
    );
  }
}
