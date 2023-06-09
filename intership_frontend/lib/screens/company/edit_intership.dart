import 'package:flutter/material.dart';
import 'package:intership_frontend/components/appbar.dart';
import 'package:intership_frontend/screens/company/principal/wraper_post_intership.dart';

class EditIntership extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: MyAppBar(title: "Editar pasantía"),
      body: Column(
        children: [
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
