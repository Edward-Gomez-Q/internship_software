import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/intership_cubit.dart';
import 'package:intership_frontend/bloc/cubit/list_internship_cubit.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';
import 'package:intership_frontend/bloc/states/list_internship_state.dart';
import 'package:intership_frontend/screens/company/principal/wraper_aplicants.dart';

import '../aplicants_intership.dart';
import '../edit_intership.dart';

class WraperViewIntership extends StatelessWidget {
  final List<IntershipState> intershipState;

  WraperViewIntership({Key? key, required this.intershipState})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount: intershipState.length,
      itemBuilder: (context, index) {
        return Card(
          child: ListTile(
            title: Text(intershipState[index].titulo,
                style: TextStyle(
                    fontSize: 17,
                    fontWeight: FontWeight.bold,
                    color: Colors.blue.shade900)),
            subtitle: Column(
              children: [
                SizedBox(
                  height: 8,
                ),
                Text(
                  intershipState[index].carreras,
                  style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey.shade600,
                  ),
                ),
                Text(
                  intershipState[index].requisitos,
                  style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey.shade600,
                  ),
                ),
                Text(
                  intershipState[index].fechaLimite.toString(),
                  style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey.shade600,
                  ),
                ),
                Row(
                  children: [
                    Container(
                      width: 130, // Ancho del primer botón
                      child: ElevatedButton.icon(
                        onPressed: () {
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => Aplicants(),
                            ),
                          );
                        },
                        icon: Icon(Icons.people),
                        label: Text("Aplicantes"),
                        style: ElevatedButton.styleFrom(
                          primary: Colors.blue.shade900,
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(20),
                          ),
                        ),
                      ),
                    ),
                    SizedBox(width: 10),
                    Container(
                      width: 130, // Ancho del segundo botón
                      child: ElevatedButton.icon(
                        onPressed: () {
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => EditIntership(),
                            ),
                          );
                        },
                        icon: Icon(Icons.edit),
                        label: Text("Editar"),
                        style: ElevatedButton.styleFrom(
                          primary: Colors.blue.shade900,
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(20),
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
