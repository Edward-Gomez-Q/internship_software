import 'package:flutter/material.dart';
import 'package:intership_frontend/screens/company/intership_company.dart';
import 'package:intership_frontend/screens/company/post_intership.dart';
import 'package:intership_frontend/screens/student/postulation_status.dart';
import 'package:intership_frontend/screens/student/student_intership.dart';

class BottomBarStudent extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return BottomAppBar(
      color: Colors.blue.shade900,
      child: Container(
        height: 50,
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            IconButton(
              onPressed: () {
                Navigator.push(context,
                    MaterialPageRoute(builder: (context) => HomeStudent()));
              },
              icon: Icon(
                Icons.home,
                color: Colors.white,
              ),
              tooltip: 'Inicio',
            ),
            IconButton(
              onPressed: () {
                Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => PostulationStatus()));
              },
              icon: Icon(
                Icons.post_add,
                color: Colors.white,
              ),
              tooltip: 'Postulaciones',
            ),
          ],
        ),
      ),
    );
  }
}
