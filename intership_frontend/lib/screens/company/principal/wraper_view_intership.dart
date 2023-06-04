import 'package:flutter/material.dart';
import 'package:intership_frontend/bloc/cubit/intership_cubit.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';
import 'package:intership_frontend/screens/company/principal/wraper_aplicants.dart';

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
                  intershipState[index].carrera,
                  style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey.shade600,
                  ),
                ),
                Text(
                  intershipState[index].descripcion,
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
              ],
            ),
            trailing: ElevatedButton.icon(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => WraperViewAplicants(),
                  ),
                );
              },
              icon: Icon(Icons.people),
              label: Text("Ver Aplicantes"),
            ),
          ),
        );
      },
    );
  }
}
