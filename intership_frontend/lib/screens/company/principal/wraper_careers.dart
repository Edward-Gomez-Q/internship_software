import 'package:flutter/material.dart';
import 'package:intership_frontend/services/globals.dart';

class WraperCareers extends StatelessWidget {
  String? selectCarrera;
  String? selectFacu;
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        children: <Widget>[
          DropdownButtonFormField(
            items: facultad.map((String value) {
              return DropdownMenuItem<String>(
                value: value,
                child: Text(value),
              );
            }).toList(),
            hint: Text("Facultad", style: TextStyle(color: Colors.grey)),
            icon: Icon(Icons.arrow_drop_down),
            onChanged: (String? value) {
              selectFacu = value;
            },
          ),
          SizedBox(
            height: 20,
          ),
          DropdownButtonFormField(
            items: ucbCareers.map((String value) {
              return DropdownMenuItem<String>(
                value: value,
                child: Text(value),
              );
            }).toList(),
            hint: Text("Carrera", style: TextStyle(color: Colors.grey)),
            icon: Icon(Icons.arrow_drop_down),
            onChanged: (String? value) {
              selectCarrera = value;
            },
          ),
          SizedBox(
            height: 20,
          ),
          ElevatedButton(
              onPressed: () {},
              child: Text("Agregar"),
              style: ElevatedButton.styleFrom(
                primary: Colors.blue.shade900,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              )),
          SizedBox(
            height: 20,
          ),
        ],
      ),
    );
  }
}
