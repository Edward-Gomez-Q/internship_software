import 'package:flutter/material.dart';
import 'package:intership_frontend/screens/registration/header.dart';
import 'package:intership_frontend/screens/registration/wrapperr.dart';

class Registration extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        width: double.infinity, // 100%
        decoration: BoxDecoration(
          gradient: LinearGradient(
            begin: Alignment.topCenter,
            colors: [
              Colors.blue.shade900,
              Colors.blue.shade800,
              Colors.blue.shade400,
            ],
          ),
        ),
        child: Column(
          children: <Widget>[
            SizedBox(
              height: 80,
            ),
            HeaderRegistration(),
            Expanded(
              child: Container(
                decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.only(
                        topLeft: Radius.circular(60),
                        topRight: Radius.circular(60))),
                child: WrapperRegistration(),
              ),
            )
          ],
        ),
      ),
    );
  }
}
