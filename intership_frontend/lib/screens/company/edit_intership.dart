import 'package:flutter/material.dart';
import 'package:intership_frontend/screens/company/principal/wraper_post_intership.dart';

class EditIntership extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [
          Padding(
              padding: EdgeInsets.only(top: 45),
              child: Align(
                alignment: Alignment.topCenter,
                child: Text(
                  "Editar pasantía",
                  style: TextStyle(fontSize: 25, color: Colors.grey.shade600),
                ),
              )),
          SizedBox(
            height: 20,
          ),
          Expanded(
            child: WraperPostIntership(),
          )
        ],
      ),
    );
  }
}
