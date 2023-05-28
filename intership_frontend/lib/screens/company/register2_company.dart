import 'package:flutter/material.dart';
import 'package:intership_frontend/screens/company/header_register_company.dart';
import 'package:intership_frontend/screens/company/wraper_company_register.dart';

class Register2Company extends StatelessWidget {
  const Register2Company({Key? key}) : super(key: key);
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
            HeaderRegisterCompany(),
            Expanded(
              child: Container(
                decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.only(
                        topLeft: Radius.circular(60),
                        topRight: Radius.circular(60))),
                child: WraperCompanyRegister2(),
              ),
            )
          ],
        ),
      ),
    );
  }
}
