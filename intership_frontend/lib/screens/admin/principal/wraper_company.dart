import 'dart:ffi';

import 'package:flutter/material.dart';
import 'package:intership_frontend/bloc/states/company_state.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';

class WraperAdminCompany extends StatelessWidget {
  final List<CompanyState> company;
  WraperAdminCompany({Key? key, required this.company}) : super(key: key);
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount: company.length,
      itemBuilder: (context, index) {
        return Card(
          child: ListTile(
            title: Text(
              company[index].nombreEmpresa,
              style: TextStyle(
                fontSize: 17,
                fontWeight: FontWeight.bold,
                color: Colors.blue.shade900,
              ),
            ),
            subtitle: Column(
              children: [
                SizedBox(
                  height: 8,
                ),
                Text(
                  company[index].sitioWeb,
                  style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey.shade600,
                  ),
                ),
                Text(
                  company[index].telefonoContacto,
                  style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey.shade600,
                  ),
                ),
                Text(
                  company[index].nombresContacto +
                      company[index].primerApellidoContacto +
                      company[index].segundoApellidoContacto,
                  style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey.shade600,
                  ),
                ),
                Text(
                  company[index].correoElectronicoContacto,
                  style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey.shade600,
                  ),
                ),
                Text(
                  company[index].resena,
                  style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey.shade600,
                  ),
                ),
                Row(
                  children: [
                    Container(
                      width: 130, // Ancho del segundo botón
                      child: ElevatedButton.icon(
                        onPressed: () {},
                        icon: Icon(Icons.check),
                        label: Text('Aceptar'),
                        style: ElevatedButton.styleFrom(
                          primary: Colors.green.shade900,
                        ),
                      ),
                    ),
                    SizedBox(
                      width: 10,
                    ),
                    Container(
                      width: 130, // Ancho del tercer botón
                      child: ElevatedButton.icon(
                        onPressed: () {},
                        icon: Icon(Icons.close),
                        label: Text('Rechazar'),
                        style: ElevatedButton.styleFrom(
                          primary: Colors.red.shade900,
                        ),
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
        );
      },
    );
  }
}
