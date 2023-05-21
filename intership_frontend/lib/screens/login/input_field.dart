import 'package:flutter/material.dart';

class InputField extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Column(
      children: <Widget>[
        Container(
          padding: EdgeInsets.all(10),
          child: TextField(
            decoration: InputDecoration(
                hintText: "Ingresa tu correo electrónico",
                hintStyle: TextStyle(color: Colors.grey),
                icon: Icon(Icons.email),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                )),
          ),
        ),
        Container(
          padding: EdgeInsets.all(10),
          child: TextField(
              decoration: InputDecoration(
            hintText: "Ingresa tu contraseña",
            hintStyle: TextStyle(color: Colors.grey),
            icon: Icon(Icons.lock),
            border: OutlineInputBorder(
              borderRadius: BorderRadius.circular(10),
            ),
          )),
        ),
      ],
    );
  }
}
