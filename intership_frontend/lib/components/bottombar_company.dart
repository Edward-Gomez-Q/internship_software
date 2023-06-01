import 'package:flutter/material.dart';
import 'package:intership_frontend/screens/company/intership_company.dart';
import 'package:intership_frontend/screens/company/post_intership.dart';

class BottomBarCompany extends StatelessWidget {
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
                    MaterialPageRoute(builder: (context) => HomeCompany()));
              },
              icon: Icon(
                Icons.home,
                color: Colors.white,
              ),
              tooltip: 'Inicio',
            ),
            IconButton(
              onPressed: () {
                Navigator.push(context,
                    MaterialPageRoute(builder: (context) => PostIntership()));
              },
              icon: Icon(
                Icons.add_circle,
                color: Colors.white,
              ),
              tooltip: 'Publicar',
            ),
          ],
        ),
      ),
    );
  }
}
