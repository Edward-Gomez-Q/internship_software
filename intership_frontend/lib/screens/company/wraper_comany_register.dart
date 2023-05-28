import 'package:flutter/material.dart';
import 'package:intership_frontend/screens/company/register2_company.dart';
import 'package:intership_frontend/screens/company/wraper_company_register.dart';
import 'package:intership_frontend/screens/student/register_form.dart';
import 'package:intership_frontend/screens/student/register_student_final.dart';

class WrapperRegisterCompany extends StatelessWidget {
  const WrapperRegisterCompany({Key? key}) : super(key: key);
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
            hintText: 'Nombre de la empresa',
            hintStyle: TextStyle(color: Colors.grey),
            icon: Icon(Icons.work),
            border: OutlineInputBorder(
              borderRadius: BorderRadius.circular(20),
            ),
          ),
        ),
        SizedBox(
          height: 20,
        ),
        Row(children: <Widget>[
          Expanded(
            child: Text("Sector al que pertenece",
                style: TextStyle(fontSize: 20, color: Colors.grey)),
          ),
          SizedBox(
            height: 20,
          ),
          Expanded(
            child: ElevatedButton(
              onPressed: () {},
              child: Text("Seleccionar"),
              style: ElevatedButton.styleFrom(
                primary: Colors.blue.shade900,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
            ),
          ),
        ]),
        Expanded(
          child: Align(
            alignment: Alignment.centerRight,
            child: Container(
              width: 300,
              height: 100,
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(10),
                border: Border.all(
                  color: Colors.grey,
                  width: 2,
                ),
              ),
            ),
          ),
        ),
        Expanded(
          child: Align(
            alignment: Alignment.centerRight,
            child: TextField(
              decoration: InputDecoration(
                hintText: 'Reseña de la compañia',
                hintStyle: TextStyle(color: Colors.grey),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(20),
                ),
              ),
            ),
          ),
        ),
        SizedBox(
          height: 20,
        ),
        Row(children: <Widget>[
          Expanded(
            child: Text("Logo de la empresa",
                style: TextStyle(fontSize: 20, color: Colors.grey)),
          ),
          SizedBox(
            height: 20,
          ),
          Expanded(
            child: ElevatedButton(
              onPressed: () {},
              child: Text("Cargar imagen"),
              style: ElevatedButton.styleFrom(
                primary: Colors.blue.shade900,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
            ),
          ),
        ]),
        Expanded(
          child: TextField(
            decoration: InputDecoration(
              hintText: 'Sitio web de la empresa',
              hintStyle: TextStyle(color: Colors.grey),
              border: OutlineInputBorder(
                borderRadius: BorderRadius.circular(20),
              ),
            ),
          ),
        ),
        SizedBox(
          height: 20,
        ),
        Expanded(
          child: TextField(
            decoration: InputDecoration(
              hintText: 'NIT',
              hintStyle: TextStyle(color: Colors.grey),
              border: OutlineInputBorder(
                borderRadius: BorderRadius.circular(20),
              ),
            ),
          ),
        ),
        SizedBox(
          height: 20,
        ),
        Row(
          children: [
            ElevatedButton(
              child: Text("Atras"),
              onPressed: () {},
              style: ElevatedButton.styleFrom(
                primary: Colors.red.shade900,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(20),
                ),
              ),
            ),
            SizedBox(
              width: 20,
            ),
            ElevatedButton(
              child: Text("Siguiente"),
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => Register2Company()),
                );
              },
              style: ElevatedButton.styleFrom(
                primary: Colors.blue.shade900,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(20),
                ),
              ),
            ),
          ],
        )
      ]),
    );
  }
}
