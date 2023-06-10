import 'package:flutter/material.dart';
import 'package:intership_frontend/components/appbar.dart';
import 'package:intership_frontend/components/bottombar_company.dart';
import 'package:intership_frontend/components/calendar_button.dart';
import 'package:intership_frontend/screens/company/principal/wraper_careers.dart';
import 'package:intership_frontend/screens/company/principal/wraper_post2_intership.dart';
import 'package:intership_frontend/screens/company/principal/wraper_post_intership.dart';

class SelectCareer extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: MyAppBar(title: "Carreras"),
      body: Column(
        children: [
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
