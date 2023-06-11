import 'package:flutter/material.dart';
import 'package:intership_frontend/screens/admin/admin_company.dart';
import 'package:intership_frontend/screens/admin/admin_intership.dart';
import 'package:intership_frontend/screens/company/intership_company.dart';
import 'package:intership_frontend/screens/company/post_intership.dart';

class BottomBarAdmin extends StatelessWidget {
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
                    MaterialPageRoute(builder: (context) => AdminCompany()));
              },
              icon: Icon(
                Icons.work,
                color: Colors.white,
              ),
              tooltip: 'Adminitrar Empresa',
            ),
            IconButton(
              onPressed: () {
                Navigator.push(context,
                    MaterialPageRoute(builder: (context) => AdminIntership()));
              },
              icon: Icon(
                Icons.description,
                color: Colors.white,
              ),
              tooltip: 'Administrar Pasantías',
            ),
          ],
        ),
      ),
    );
  }
}
