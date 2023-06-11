import 'dart:ffi';

import 'package:flutter/material.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';

class WraperAdminIntership extends StatelessWidget {
  final List<IntershipState> interships;
  WraperAdminIntership({Key? key, required this.interships}) : super(key: key);
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount: interships.length,
      itemBuilder: (context, index) {
        return Card(
          child: ListTile(
            title: Text(
              interships[index].titulo,
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
                  interships[index].listaCarreras.toString(),
                  style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey.shade600,
                  ),
                ),
                Text(
                  interships[index].requisitos,
                  style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey.shade600,
                  ),
                ),
                Text(
                  interships[index].fechaLimite.toString(),
                  style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey.shade600,
                  ),
                ),
                Row(
                  children: [
                    Expanded(
                      child: Container(
                        width: 130, // Ancho del primer botón
                        child: ElevatedButton.icon(
                          onPressed: () {},
                          icon: Icon(Icons.description),
                          label: Text('Descaragar'),
                          style: ElevatedButton.styleFrom(
                            primary: Colors.blue.shade900,
                          ),
                        ),
                      ),
                    ),
                    SizedBox(
                      width: 10,
                    ),
                    Expanded(
                      child: Container(
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
                    ),
                    SizedBox(
                      width: 10,
                    ),
                    Expanded(
                      child: Container(
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
