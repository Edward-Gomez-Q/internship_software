import 'package:flutter/material.dart';
import 'package:intership_frontend/screens/student/header_register_student.dart';
import 'package:intership_frontend/screens/student/register_form.dart';
import 'package:intership_frontend/screens/student/wrapper_register_student.dart';

class RegisterStudentFinal extends StatelessWidget {
  const RegisterStudentFinal({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        width: double.infinity, // 100%
        decoration: BoxDecoration(
          gradient: LinearGradient(
            begin: Alignment.topCenter,
            colors: [
              Colors.blue.shade900,
              Colors.blue.shade800,
              Colors.blue.shade400,
            ],
          ),
        ),
        child: Column(
          children: <Widget>[
            SizedBox(
              height: 80,
            ),
            HeaderRegisterStudentFinal(),
            Expanded(
              child: Container(
                decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.only(
                        topLeft: Radius.circular(60),
                        topRight: Radius.circular(60))),
                child: FormRegister(),
              ),
            )
          ],
        ),
      ),
    );
  }
}
