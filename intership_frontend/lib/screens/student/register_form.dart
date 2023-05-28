import 'package:flutter/material.dart';

class FormRegister extends StatelessWidget {
  final int startYear;
  final int endYear;
  const FormRegister({Key? key, required this.startYear, required this.endYear})
      : super(key: key);
  @override
  Widget build(BuildContext context) {
    List<String> years = [];
    for (int i = startYear; i <= endYear; i++) {
      years.add(i.toString());
    }
    return Padding(
      padding: EdgeInsets.all(10),
      child: Padding(
        padding: EdgeInsets.all(10),
        child: Form(
          child: Column(
            children: [
              TextFormField(
                decoration: InputDecoration(
                  hintText: "Nombres",
                  hintStyle: TextStyle(color: Colors.grey),
                  icon: Icon(Icons.person),
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10),
                  ),
                ),
              ),
              SizedBox(
                height: 10,
              ),
              TextFormField(
                decoration: InputDecoration(
                  hintText: "Primer Apellido",
                  hintStyle: TextStyle(color: Colors.grey),
                  icon: Icon(Icons.person),
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10),
                  ),
                ),
              ),
              SizedBox(
                height: 10,
              ),
              TextFormField(
                decoration: InputDecoration(
                  hintText: "Segundo Apellido",
                  hintStyle: TextStyle(color: Colors.grey),
                  icon: Icon(Icons.person),
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10),
                  ),
                ),
              ),
              SizedBox(
                height: 10,
              ),
              Row(
                children: <Widget>[
                  Expanded(
                    child: TextFormField(
                      decoration: InputDecoration(
                        hintText: "Documento de Identidad",
                        hintStyle: TextStyle(color: Colors.grey),
                        icon: Icon(Icons.book),
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(10),
                        ),
                      ),
                    ),
                  ),
                  SizedBox(
                    width: 10,
                  ),
                  Expanded(
                    child: DropdownButton<String>(
                      items: <String>[
                        'LP',
                        'SCZ',
                        'PT',
                        'PN',
                        'OR',
                        'CH',
                        'CBB',
                        'TJ',
                        'BN'
                      ].map((String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                      hint: Text("Departamento",
                          style: TextStyle(color: Colors.grey)),
                      icon: Icon(Icons.arrow_drop_down),
                      onChanged: (String? value) {},
                    ),
                  )
                ],
              ),
              SizedBox(
                height: 10,
              ),
              Row(
                children: <Widget>[
                  Text(
                    "Validación con la UCB: ",
                    style: TextStyle(fontSize: 16),
                  ),
                  Expanded(
                    child: RadioListTile(
                      title: Text("Estudiante"),
                      value: 1,
                      groupValue: 1,
                      onChanged: (value) {},
                    ),
                  ),
                  Expanded(
                    child: RadioListTile(
                      title: Text("Graduado"),
                      value: 2,
                      groupValue: 1,
                      onChanged: (value) {},
                    ),
                  ),
                ],
              ),
              SizedBox(
                height: 10,
              ),
              Row(
                children: <Widget>[
                  Expanded(
                    child: DropdownButton(
                      items: <String>[
                        'La Paz',
                        'Cochabamba',
                        'Santa Cruz',
                        'Tarija'
                      ].map((String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                      hint: Text("Sede", style: TextStyle(color: Colors.grey)),
                      icon: Icon(Icons.arrow_drop_down),
                      onChanged: (String? value) {},
                    ),
                  ),
                  SizedBox(
                    width: 10,
                  ),
                  Expanded(
                    child: DropdownButton(
                      items: <String>[
                        'Ingenieria de Sistemas',
                        'Ingenieria Civil',
                        'Ingenieria Industrial',
                        'Ingenieria Mecatronica',
                        'Diseño Grafico'
                      ].map((String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                      hint:
                          Text("Carrera", style: TextStyle(color: Colors.grey)),
                      icon: Icon(Icons.arrow_drop_down),
                      onChanged: (String? value) {},
                    ),
                  ),
                  SizedBox(
                    width: 10,
                  ),
                  Expanded(
                    child: DropdownButton(
                      items: years.map((String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                      hint: Text("Año de Ingreso",
                          style: TextStyle(color: Colors.grey)),
                      icon: Icon(Icons.arrow_drop_down),
                      onChanged: (String? value) {},
                    ),
                  ),
                ],
              ),
              SizedBox(
                height: 10,
              ),
              ElevatedButton(
                onPressed: () {},
                child: Text("Registrate"),
                style: ElevatedButton.styleFrom(
                  primary: Colors.blue.shade900,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(10),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
