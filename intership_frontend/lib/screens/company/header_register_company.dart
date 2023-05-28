import 'package:flutter/material.dart';

class HeaderRegisterCompany extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(20),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          Center(
            child: Text(
              "Portal de pasantías UCB",
              style: TextStyle(
                  color: Colors.white,
                  fontSize: 30,
                  fontWeight: FontWeight.bold),
            ),
          ),
          SizedBox(
            height: 5,
          ),
          Center(
            child: Text(
              "Registro de nuevos usuarios",
              style: TextStyle(color: Colors.white, fontSize: 18),
            ),
          ),
          SizedBox(
            height: 5,
          ),
          Center(
            child: Text(
              "Registro de empresas",
              style: TextStyle(color: Colors.white, fontSize: 18),
            ),
          )
        ],
      ),
    );
  }
}