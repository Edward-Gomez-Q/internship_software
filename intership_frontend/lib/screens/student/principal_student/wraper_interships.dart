import 'package:flutter/material.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';
import 'package:intership_frontend/screens/student/postulation.dart';
import 'package:intership_frontend/screens/student/principal_student/wraper_postulation.dart';

class WrapperViewIntershipStudent extends StatelessWidget {
  final List<IntershipState> interships;

  WrapperViewIntershipStudent({Key? key, required this.interships})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        itemCount: interships.length,
        itemBuilder: (context, index) {
          return Card(
            child: ListTile(
                title: Text(interships[index].titulo,
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
                      interships[index].carrera,
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
                  ],
                ),
                trailing: ElevatedButton.icon(
                  onPressed: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) => Postulation(intership: interships[index],)),
                    );
                  },
                  icon: Icon(Icons.add),
                  label: Text('información'),
                  style: ElevatedButton.styleFrom(
                    primary: Colors.blue.shade900,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(20),
                    ),
                  ),
                )),
          );
        });
  }
}
