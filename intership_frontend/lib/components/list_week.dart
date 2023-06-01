import 'package:flutter/material.dart';

class DaySelectionList extends StatefulWidget {
  @override
  _DaySelectionListState createState() => _DaySelectionListState();
}

class _DaySelectionListState extends State<DaySelectionList> {
  List<String> days = [
    'Lunes',
    'Martes',
    'Miercoles',
    'Jueves',
    'Viernes',
    'Sabado',
    'Domingo'
  ];
  List<String> selectedDays = [];

  @override
  Widget build(BuildContext context) {
    return DropdownButtonFormField(
      items: days.map((String day) {
        return DropdownMenuItem<String>(
            value: day,
            child: SizedBox(
                width: 200,
                child: ListTile(
                    title: Text(day),
                    trailing:
                        selectedDays.contains(day) ? Icon(Icons.check) : null,
                    onTap: () {
                      setState(() {
                        if (selectedDays.contains(day)) {
                          selectedDays.remove(day);
                        } else {
                          selectedDays.add(day);
                        }
                      });
                    })));
      }).toList(),
      hint: Text('Seleccionar dias'),
      onChanged: (String? value) {},
    );
  }
}
