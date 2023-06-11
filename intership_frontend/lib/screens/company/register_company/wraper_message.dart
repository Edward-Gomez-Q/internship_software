import 'package:flutter/material.dart';
import 'package:intership_frontend/screens/company/intership_company.dart';
import 'package:intership_frontend/screens/login/login_principal.dart';

class WrapperMessage extends StatelessWidget {
  final String message;
  const WrapperMessage({Key? key, required this.message}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(30),
      child: Container(
        child: SingleChildScrollView(
          child: Column(children: <Widget>[
            SizedBox(
              height: 40,
            ),
            Text(
              message,
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold,
              ),
            ),
            SizedBox(
              height: 20,
            ),
            ElevatedButton(
              onPressed: () {
                Navigator.push(context, MaterialPageRoute(builder: (context) {
                  return LoginPrincipal();
                }));
              },
              child: Text("Volver"),
              style: ElevatedButton.styleFrom(
                primary: Colors.blue.shade900,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
            ),
          ]),
        ),
      ),
    );
  }
}
