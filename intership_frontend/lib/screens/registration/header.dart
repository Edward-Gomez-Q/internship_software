import 'package:flutter/material.dart';

class HeaderRegistration extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(20),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          Center(
            child: Text(
              "Portal de pasantias UCB",
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
              "Registro de usuario",
              style: TextStyle(color: Colors.white, fontSize: 18),
            ),
          ),
          SizedBox(
            height: 5,
          ),
          Center(
            child: Text(
              "Que tipos de cuenta desea registrar?",
              style: TextStyle(color: Colors.white, fontSize: 18),
            ),
          )
        ],
      ),
    );
  }
}
