import 'package:flutter/material.dart';
import 'package:intership_frontend/components/calendar_button.dart';
import 'package:intership_frontend/components/list_week.dart';
import 'package:intership_frontend/screens/company/post_intership.dart';
import 'package:intership_frontend/services/globals.dart';

import '../post2_intership_company.dart';

class WraperPostIntership extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(20),
      child: SingleChildScrollView(
        child: Column(
          children: <Widget>[
            TextFormField(
              decoration: InputDecoration(
                hintText: "Titulo pasantia",
                hintStyle: TextStyle(color: Colors.grey),
                icon: Icon(Icons.work),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
            ),
            SizedBox(
              height: 20,
            ),
            DropdownButton(
              items: departments.map((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: Text(value),
                );
              }).toList(),
              hint: Text("Departamento", style: TextStyle(color: Colors.grey)),
              icon: Icon(Icons.arrow_drop_down),
              onChanged: (String? value) {},
            ),
            SizedBox(
              height: 20,
            ),
            Container(
              child: CalendarButton(),
            ),
            SizedBox(
              height: 20,
            ),
            Container(
              child: DaySelectionList(),
            ),
            SizedBox(
              height: 20,
            ),
            TextFormField(
                decoration: InputDecoration(
              hintText: "Duración (Días)",
              icon: Icon(Icons.today),
              hintStyle: TextStyle(color: Colors.grey),
              border: OutlineInputBorder(
                borderRadius: BorderRadius.circular(10),
              ),
            )),
            SizedBox(
              height: 20,
            ),
            TextFormField(
              decoration: InputDecoration(
                hintText: 'Hora inicio',
                icon: Icon(Icons.timer),
                hintStyle: TextStyle(color: Colors.grey),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
            ),
            SizedBox(
              height: 20,
            ),
            TextFormField(
              decoration: InputDecoration(
                hintText: 'Hora final',
                icon: Icon(Icons.timer),
                hintStyle: TextStyle(color: Colors.grey),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
            ),
            SizedBox(
              height: 20,
            ),
            TextFormField(
              decoration: InputDecoration(
                hintText: 'Descripcion',
                icon: Icon(Icons.description),
                hintStyle: TextStyle(color: Colors.grey),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
            ),
            SizedBox(
              height: 30,
            ),
            ElevatedButton(
              onPressed: () {
                Navigator.push(context,
                    MaterialPageRoute(builder: (context) => PostIntership2()));
              },
              child: Text("Continuar"),
              style: ElevatedButton.styleFrom(
                primary: Colors.blue.shade900,
                onPrimary: Colors.white,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
