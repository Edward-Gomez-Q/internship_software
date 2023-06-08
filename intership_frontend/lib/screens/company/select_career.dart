import 'package:flutter/material.dart';
import 'package:intership_frontend/components/bottombar_company.dart';
import 'package:intership_frontend/components/calendar_button.dart';
import 'package:intership_frontend/screens/company/principal/wraper_careers.dart';
import 'package:intership_frontend/screens/company/principal/wraper_post2_intership.dart';
import 'package:intership_frontend/screens/company/principal/wraper_post_intership.dart';

class SelectCareer extends StatelessWidget {
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
                "Carreras",
                style: TextStyle(fontSize: 25, color: Colors.grey.shade600),
              ),
            ),
          ),
          SizedBox(
            height: 20,
          ),
          Expanded(
            child: WraperCareers(),
          )
        ],
      ),
    );
  }
}
