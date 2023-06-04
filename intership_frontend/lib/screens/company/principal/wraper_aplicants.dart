import 'package:flutter/material.dart';
import 'package:intership_frontend/bloc/states/student_state.dart';

class WraperViewAplicants extends StatelessWidget {
  final List<StudentState> studentState;

  WraperViewAplicants({Key? key, required this.studentState}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount: studentState.length,
      itemBuilder: (context, index) {
        return Card(
            child: ListTile(
          title: Text(
            studentState[index].nombres +
                " " +
                studentState[index].primerApellido +
                " " +
                studentState[index].segundoApellido,
            style: TextStyle(
              fontSize: 15,
              fontWeight: FontWeight.bold,
              color: Colors.grey.shade600,
            ),
          ),
          subtitle: Column(
            children: [
              SizedBox(
                height: 8,
              ),
              Text(
                studentState[index].carrera,
                style: TextStyle(
                  fontSize: 15,
                  fontWeight: FontWeight.bold,
                  color: Colors.grey.shade600,
                ),
              ),
              Text(
                studentState[index].correoElectronico,
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
                      onPressed: () {},
                      icon: Icon(Icons.check),
                      label: Text("Aceptar"),
                      style: ElevatedButton.styleFrom(
                        primary: Colors.green.shade400,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(20),
                        ),
                      ),
                    ),
                  ),
                  SizedBox(
                    width: 10,
                  ),
                  Container(
                    width: 140, // Ancho del primer botón
                    child: ElevatedButton.icon(
                      onPressed: () {},
                      icon: Icon(Icons.add),
                      label: Text("Información"),
                      style: ElevatedButton.styleFrom(
                        primary: Colors.blue.shade900,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(20),
                        ),
                      ),
                    ),
                  ),
                ],
              )
            ],
          ),
        ));
      },
    );
  }
}
