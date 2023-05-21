import 'package:flutter/material.dart';

class WrapperRegistration extends StatelessWidget {
  const WrapperRegistration({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(30),
      child: Row(
        children: <Widget>[
          Expanded(
            child: ElevatedButton(
              onPressed: () {},
              child: Text("Estudiantes UCB"),
              style: ElevatedButton.styleFrom(
                primary: Colors.blue.shade900,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
            ),
          ),
          SizedBox(
            width: 20,
          ),
          Expanded(
            child: ElevatedButton(
              onPressed: () {},
              child: Text("Empresa"),
              style: ElevatedButton.styleFrom(
                primary: Colors.blue.shade900,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
