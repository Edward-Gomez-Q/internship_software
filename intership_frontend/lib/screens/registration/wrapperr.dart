import 'package:flutter/material.dart';
import 'package:intership_frontend/screens/company/company_register.dart';
import 'package:intership_frontend/screens/student/student_register.dart';

class WrapperRegistration extends StatelessWidget {
  const WrapperRegistration({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(30),
      child: Row(
        children: <Widget>[
          Expanded(
            child: ElevatedButton(
              onPressed: () {
                Navigator.push(context, MaterialPageRoute(builder: (context) {
                  return RegisterStudent();
                }));
              },
              child: Text("Estudiantes UCB"),
              style: ElevatedButton.styleFrom(
                primary: Colors.blue.shade900,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
            ),
          ),
          SizedBox(
            width: 20,
          ),
          Expanded(
            child: ElevatedButton(
              onPressed: () {
                Navigator.push(context, MaterialPageRoute(builder: (context) {
                  return RegisterCompany();
                }));
              },
              child: Text("Empresa"),
              style: ElevatedButton.styleFrom(
                primary: Colors.blue.shade900,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
