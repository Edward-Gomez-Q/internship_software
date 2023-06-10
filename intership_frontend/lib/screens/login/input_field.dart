import 'package:flutter/material.dart';
import 'package:intership_frontend/components/password.dart';

class InputField extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        children: <Widget>[
          Container(
            padding: EdgeInsets.all(10),
            child: TextField(
              decoration: InputDecoration(
                hintText: 'Ingresa tu correo electrónico',
                hintStyle: TextStyle(color: Colors.grey),
                icon: Icon(Icons.email),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
                contentPadding: EdgeInsets.symmetric(vertical: 15),
              ),
            ),
          ),
          Container(
            padding: EdgeInsets.all(10),
            child: PasswordTextField(),
          ),
        ],
      ),
    );
  }
}
