import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import '../bloc/cubit/intership_cubit.dart';

class DaySelectionList extends StatefulWidget {
  final List<String> selectedDays;

  const DaySelectionList({Key? key, required this.selectedDays})
      : super(key: key);
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
                      setState() {
                        if (widget.selectedDays.contains(day)) {
                          widget.selectedDays.remove(day);
                        } else {
                          widget.selectedDays.add(day);
                        }
                      }

                      ;
                    })));
      }).toList(),
      hint: Text('Seleccionar dias'),
      onChanged: (value) {},
    );
  }
}
