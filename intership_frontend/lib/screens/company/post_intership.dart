import 'package:flutter/material.dart';
import 'package:intership_frontend/components/bottombar_company.dart';
import 'package:intership_frontend/components/calendar_button.dart';
import 'package:intership_frontend/screens/company/principal/wraper_post_intership.dart';

class PostIntership extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Publicar pasantía"),
      ),
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
      bottomNavigationBar: BottomBarCompany(),
    );
  }
}
