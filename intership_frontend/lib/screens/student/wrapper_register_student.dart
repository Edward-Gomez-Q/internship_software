import 'package:flutter/material.dart';
import 'package:intership_frontend/screens/student/register_form.dart';
import 'package:intership_frontend/screens/student/register_student_final.dart';

class WrapperRegisterStudent extends StatelessWidget {
  const WrapperRegisterStudent({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(30),
      child: Column(children: <Widget>[
        SizedBox(
          height: 40,
        ),
        TextFormField(
          decoration: InputDecoration(
            hintText: 'Ingrese su correo estudiantil',
            hintStyle: TextStyle(color: Colors.grey),
            icon: Icon(Icons.email),
            border: OutlineInputBorder(
              borderRadius: BorderRadius.circular(20),
            ),
          ),
        ),
        SizedBox(
          height: 20,
        ),
        ElevatedButton(
          onPressed: () {},
          child: Text("Solictar codigo"),
          style: ElevatedButton.styleFrom(
            primary: Colors.blue.shade900,
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(10),
            ),
          ),
        ),
        SizedBox(
          height: 20,
        ),
        TextFormField(
          decoration: InputDecoration(
            hintText: 'Ingrese su codigo de verificacion',
            hintStyle: TextStyle(color: Colors.grey),
            icon: Icon(Icons.remove_red_eye),
            border: OutlineInputBorder(
              borderRadius: BorderRadius.circular(20),
            ),
          ),
        ),
        SizedBox(
          height: 20,
        ),
        ElevatedButton(
          onPressed: () {
            Navigator.push(context, MaterialPageRoute(builder: (context) {
              return RegisterStudentFinal();
            }));
          },
          child: Text("Verificar"),
          style: ElevatedButton.styleFrom(
            primary: Colors.blue.shade900,
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(10),
            ),
          ),
        ),
      ]),
    );
  }
}
